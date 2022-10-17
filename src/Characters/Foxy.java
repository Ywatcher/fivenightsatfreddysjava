package Characters;

import Core.FullObservation;
import Enum.EnumEvents;
import Enum.EnumCharacters;
import Enum.EnumRooms;
import Enum.EnumCameras;
import tools.Timer;

import java.util.ArrayList;

public class Foxy extends Character {

	private boolean seen;
	private double startTime;

	public Foxy(int difficulty) {
		super(difficulty);
		this.name = EnumCharacters.IDFoxy;
		this.tickPeriod = 1900;
		foxyTime = false; //TODO
		foxyTimeTimer = 0;
		foxyTimer = 0;
		this.locations = new ArrayList<>() {{
			add(EnumRooms.PirateCove);
			add(EnumRooms.PirateCove);
			add(EnumRooms.PirateCove);
			add(EnumRooms.WestHallB);
		}};
	}


	// temp ---
	private Boolean foxyTime;
	private Integer foxyTimeTimer;
	private Integer foxyTimer;
	private Boolean running;
	private Integer foxyRunTimer; //TODO: to use tools.Timer
	// ----

	public void tick(FullObservation obs, tools.Timer timer) {
		if (obs.isOfficeMonitorUp() && obs.getCurrentCamera() == EnumCameras.CAM1C) {
			return;
		} else {
			if (state != 3) {
				state = state + 1;
				notifyObservers(new Enum[]{EnumEvents.ChangeEnvironment, EnumRooms.PirateCove}); // change the stage
			} else {
				if (!obs.isOfficeDoor1Open()) {
					state = 1;
					knockDoor();
				} else {
					killPlayer();
				}
			}
		}
	}

	@Override
	public void forward(FullObservation obs, Timer timer) {
		super.forward(obs, timer);
		if (running) { // todo : restyle
			if (foxyRunTimer<30){
				foxyRunTimer ++;
			}
			else if (foxyRunTimer == 30){
				foxyTime = true;
			}
		}
		if(obs.isOfficeMonitorUp() && obs.getCurrentCamera().equals(EnumCameras.CAMs2A) && ! running){
			// when camera looking at westhallA
			if (foxyTimer < 4)
				foxyTimer ++;
			else if (foxyTimer==4){
				run();
				running = true;
				foxyTimer = 0;
			}
		}
		if (foxyTime){
			if (foxyTimeTimer<50)
				foxyTimeTimer ++;
			else if (foxyTimeTimer==50) {
				if (obs.isOfficeDoor1Open()) {
					killPlayer();
				}
				else {
					knockDoor();;
					state = 1;
					foxyTime = false;
				}
			}
		}
	}

	protected void knockDoor(){
		notifyObservers(new Enum[]{EnumEvents.Knock}); //Window.knock.play();
	}

	protected void run(){
		// event: FoxyRun
	}
}

