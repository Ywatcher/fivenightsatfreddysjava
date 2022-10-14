public class Foxy extends Character{

	static int stage = 0;
	private boolean seen;
	private double startTime;

	public Foxy(int difficulty) {
		super(difficulty);
		this.tickPeriod = 1900;
	}

	// does not have attribute inRoom;



	public void tick() {
		if (Office.monitorUp == true && Window.cameraLocation == "Pirate Cove") {
			return;
		} else {
			if (stage != 3) {
				stage = stage + 1;
			} else {
				if (Office.door1open == false) {
					stage = 1;
					Window.knock.play();
				} else {
					playerdeath = true;
				}
			}
		}
	}

	static int getStage() {
		return stage;
	}
}
