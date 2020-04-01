package http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.Executors;

public class HTTPHoneyPot extends Thread implements HttpHandler{
    private int port;
    private HTTPEventInterface event;

    public HTTPHoneyPot(int port, HTTPEventInterface event) {
        this.port = port;
        this.event = event;
    }
    public static void main(String[] args){
        new HTTPHoneyPot(1234, new HTTPEventInterface() {
            @Override
            public void doHandle(String ip, String requestMethod, int result, int unknown, String requestURI, String browserVersion) {
                System.out.println("对方IP:"+ip);
                System.out.println("Request指令:"+requestMethod);
                System.out.println("不知道是什么:"+250);
                System.out.println("Request的URI:"+requestURI);
                System.out.println("对方的浏览器版本:"+browserVersion);
                System.out.println("------------------");
            }
        }).start();


    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String ip  = exchange.getRemoteAddress().getHostName();
        String requestMethod = exchange.getRequestMethod();
        String requestURI = exchange.getRequestURI().toString();
        String browserVersion = exchange.getRequestHeaders().get("UserInfo-Agent").get(0);
        String Host = exchange.getRequestHeaders().get("Host").get(0);

        HttpServer server = exchange.getHttpContext().getServer();


        int result = 404;
        int unknown =250;
        exchange.sendResponseHeaders(result, 0);
        event.doHandle( ip,  requestMethod,  result,  unknown,  requestURI, browserVersion);
        exchange.close();
    }


    @Override
    public void run() {
        try {
            dorun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void dorun() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", this);
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
    }
}