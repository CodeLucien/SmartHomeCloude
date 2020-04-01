package server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.SService.SFacilityService;
import com.example.SpringUtil;
import com.example.entity.FacilityInfo;
import java.io.*;
import java.util.Date;
import java.net.Socket;
public class FacilitySocket extends Thread{

	private SFacilityService sFacilityService = (SFacilityService) SpringUtil.getBean("SFacilityService");
	private Socket socket;
	private FacilityInfo facilityInfo;
	public FacilitySocket(Socket socket) {
		this.socket = socket;
	}
	public FacilityInfo getFacilityInfo() {
		return facilityInfo;
	}

	public void setFacilityInfo(FacilityInfo facilityInfo) {
		this.facilityInfo = facilityInfo;
	}
	public void out(String out) {
		try {
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println(out);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("断开连接");
//			disOnline();
			FacilitySocketManager.getManager().remove(this);
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		System.out.println("连接连接");
		try {
			doRun();
		} catch (IOException e) {
			System.out.println("断开连接");
			disOnline();
		}

	}

	private void doRun() throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						socket.getInputStream(), "UTF-8"));
		String message = null;
		System.out.println("接收的信息");
		while ((message = br.readLine()) != null) {
			doAnalysisMessage(message);
		}
		br.close();
		System.out.println("断开连接");
		disOnline();
	}
	private void disOnline(){
		if (facilityInfo.getStatus()){
			facilityInfo.setOnline(false);//设置为掉线
			sFacilityService.modifyFacilityInfo(facilityInfo); //新的信息更新到数据库
		}
		FacilitySocketManager.getManager().remove(this);
	}

	private void doAnalysisMessage(String message) {
		message = message.replaceAll("\0", "");
		System.out.println("message:"+message);
		JSONObject obj;
		try {
			obj= JSON.parseObject(message);
			if (obj==null)
				return;
		}catch (Exception e){
			System.out.println("Json字符串出错");
			return;
		}

		String facilityId = obj.getString("facilityId");
		String type = obj.getString("type");
		Date lastTime = new Date();
		String lastData = obj.getString("data");
		if (facilityId==null||type==null||lastData==null)
			return;
		if (facilityInfo == null){//第一次添加
			FacilitySocketManager.getManager().removeByFacilityId(facilityId);
			System.out.println("size:"+FacilitySocketManager.getManager().getFacilitySockets().size());
			facilityInfo = sFacilityService.findFacilityInfoByFacilityId(facilityId);
			if (facilityInfo == null){//数据库里没有
			    System.out.println(facilityId+"未添加");
			    return;
			}else{
                System.out.println(facilityInfo.getName()+"设备上线");
				facilityInfo.setOnline(true);//设置为在线
			}
		}
		facilityInfo.setLastTime(lastTime);
		facilityInfo.setLastData(lastData);
		if (facilityInfo.getStatus()){//被启用的设备
			sFacilityService.modifyFacilityData(facilityInfo);  //新的信息更新到数据库
		}
	}
}