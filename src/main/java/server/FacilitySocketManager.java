package server;
import java.util.Vector;

public class FacilitySocketManager {

    private static final FacilitySocketManager M = new FacilitySocketManager();
	private Vector<FacilitySocket> facilitySockets = new Vector<>();

	public Vector<FacilitySocket> getFacilitySockets() {
		return facilitySockets;
	}

	public void setFacilitySockets(Vector<FacilitySocket> facilitySockets) {
		this.facilitySockets = facilitySockets;
	}

	/**
	 * Private constructor to march Singleton Pattern.
	 */
	private FacilitySocketManager() {}
	
	/**
	 * Get ChatManager outside.
	 * @return M FacilitySocketManager to outside
	 */
	public static FacilitySocketManager getManager() {
		return M;
	}
	
	/**
	 * Add c(FacilitySocket) to facilitySockets
	 * @param facilitySocket FacilitySocket
	 */
	public void add(FacilitySocket facilitySocket) {
		facilitySockets.add(facilitySocket);
	}
	
	/**
	 * Remove facilitySocket(FacilitySocket) from facilitySockets
	 * @param facilitySocket FacilitySocket
	 */
	public void remove(FacilitySocket facilitySocket) {
		facilitySockets.remove(facilitySocket);
	}
	
	/**
	 * Publish message to all clients
	 * @param out The output string
	 */
	public void publish(String out) {
		for (int i = 0; i < facilitySockets.size(); i++) {
			FacilitySocket facilitySocket = facilitySockets.get(i);
			System.out.println(out);
			facilitySocket.out(out);
		}
	}
	public void removeByFacilityId(String facilityId){
		for (FacilitySocket facilitySocket:facilitySockets) {
			if (facilitySocket.getFacilityInfo()==null)
				return;
			if (facilityId.equals(facilitySocket.getFacilityInfo().getFacilityId())){
				facilitySockets.remove(facilitySocket);
			}
		}

	}

	public void sendCommand(String facilityId,String command) {
		for (int i = 0; i < facilitySockets.size(); i++) {
			FacilitySocket facilitySocket = facilitySockets.get(i);
			if (facilitySocket.getFacilityInfo()==null)
				return;
			if (facilityId.equals(facilitySocket.getFacilityInfo().getFacilityId())){
				facilitySocket.out(command);
				System.out.println(command);
			}
		}
	}
}