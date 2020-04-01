package http;

public interface HTTPEventInterface {
	public void doHandle(String ip, String requestMethod, int result, int unknown, String requestURI, String browserVersion);
}
