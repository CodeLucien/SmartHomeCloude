package command;

public class LightCommand {
	private boolean state;

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	public LightCommand() {
		
	}
	public LightCommand(boolean state) {
		super();
		this.state = state;
	}

}
