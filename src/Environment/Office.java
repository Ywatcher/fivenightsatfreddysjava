package Environment;

import java.util.Observable;
import java.util.Observer;
import Enum.EnumDistance;
import Enum.EnumRooms;

public class Office {
	// The state of player
	private boolean light1on = false;
	private boolean light2on = false;
	private boolean door1open = true;
	private boolean door2open = true;
	private boolean monitorUp = false;
	private double powerRemaining = 100;
	public Integer devicedUsed;

	private Integer powerTick;

	public Office(){
		this.light1on = false;
		this.light2on = false;
		this.door1open = true;
		this.door2open = true;
		this.monitorUp = false;
		this.powerRemaining = 100;
		this.powerTick = 0;
		this.updateDeviceUsed();
	}
	private Office(
			Boolean light1on,
			Boolean light2on,
			Boolean door1open,
			Boolean door2open,
			Boolean monitorUp,
			Double powerRemaining,
			Integer devicedUsed
	){
		this.light1on = light1on;
		this.light2on = light2on;
		this.door1open = door1open;
		this.door2open = door2open;
		this.monitorUp = monitorUp;
		this.powerRemaining = powerRemaining;
		this.devicedUsed = devicedUsed;
	}
	public double getPower() {
		return powerRemaining;
	}

	public int getUsage() {
		int usage = 0;
		if (light1on) {
			usage = usage + 1;
		}
		if (light2on) {
			usage = usage + 1;
		}
		if (!door1open) {
			usage = usage + 1;
		}
		if (!door2open) {
			usage = usage + 1;
		}
		if (monitorUp) {
			usage = usage + 1;
		}
		return usage;
	}

	public void decreasepower() {
		if (devicedUsed == 0) {
			powerRemaining = powerRemaining - .5;
		}
		if (devicedUsed == 1) {
			powerRemaining = powerRemaining - 1;
		}
		if (devicedUsed == 2) {
			powerRemaining = powerRemaining - 2;
		}
		if (devicedUsed == 3) {
			powerRemaining = powerRemaining - 4;
		}
		if (devicedUsed == 4) {
			powerRemaining = powerRemaining - 5;
		}
		if (devicedUsed == 5) {
			powerRemaining = powerRemaining - 6;
		}
	}

	public void forward(){
		if (powerTick < 100) {
			powerTick++;
		}
		if (powerTick == 100) {
			this.decreasepower();
			powerTick = 0;
		}
	}


	public boolean isLight1on() {
		return light1on;
	}

	public boolean isLight2on() {
		return light2on;
	}

	public boolean isDoor1open() {
		return door1open;
	}

	public boolean isDoor2open() {
		return door2open;
	}

	public boolean isMonitorUp() {
		return monitorUp;
	}

	public int getDevicedUsed() {
		return devicedUsed;
	}

	private void updateDeviceUsed(){

	}

	public void setMonitorUp(){
		monitorUp = true;
	}

	public void setMonitorDown(){
		monitorUp = false;
	}

	public void pressDoor1(){
		door1open = !door1open;
	}

	public void pressDoor2(){
		door2open = ! door2open;
	}

	public void pressLight1(){
		light1on = !light1on;
	}

	public void pressLight2(){
		light2on = !light2on;
	}

	public Office copy(){
		return new Office(
				light1on,
				light2on,
				door1open,
				door2open,
				monitorUp,
				powerRemaining,
				devicedUsed
		);
	}




	// copy method
}

