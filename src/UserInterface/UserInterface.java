package UserInterface;

import tools.Command;
import Core.PlayerObservation;

public abstract class UserInterface {
    protected Command sendMonitorOn; // send action to agent
    protected Command sendMonitorOff;
    protected Command sendSwitchMonitor;
    protected Command sendPressDoorButton;
    protected Command sendPressLightButton;

    public abstract void update(PlayerObservation obs, tools.Timer timer);

    public void setSendingFunctions(
            Command sendMonitorOn,
            Command sendMonitorOff,
            Command sendSwitchMonitor,
            Command sendPressDoorButton,
            Command sendPressLightButton
    ){
        this.sendMonitorOn = sendMonitorOn;
        this.sendMonitorOff = sendMonitorOff;
        this.sendSwitchMonitor = sendSwitchMonitor;
        this.sendPressDoorButton = sendPressDoorButton;
        this.sendPressLightButton = sendPressLightButton;
    }
}
