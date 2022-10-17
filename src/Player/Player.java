package Player;

import Core.Command;
import Core.PlayerAction;
import Core.PlayerObservation;
import Enum.EnumCameras;
import UserInterface.UserInterface;


public abstract class Player {
    /*
    Interface for player movement
    can be:
    player - GUI/CLI;
    AI
     */
    protected boolean isHuman;
    protected UserInterface userInterface;
    protected PlayerAction bestAction;

    // act(perception , tick) ->


    protected void pressDoorButton(Integer door){
        // action: open/close the door on the left or right
        assert (door==1||door==2);
        bestAction = new PlayerAction(PlayerAction.Type.PressDoorButton,door);
    }

    protected void pressLightButton(Integer light){
        // action: turn on/off the light on the left or right
        assert (light==1||light==2);
        bestAction = new PlayerAction(PlayerAction.Type.PressLightButton,light);
    }

    protected void monitorOn(){
        // turn on monitor
        bestAction = new PlayerAction(PlayerAction.Type.MonitorUp,null);
    }

    protected void monitorOff(){
        // turn off monitor
        bestAction = new PlayerAction(PlayerAction.Type.MonitorDown,null);
    }

    protected void switchMonitor(EnumCameras camera){
        //switch monitor to particular room
        bestAction = new PlayerAction(PlayerAction.Type.SwitchMonitor,camera);
    }

    public abstract PlayerAction act(PlayerObservation obs, tools.Timer timer);

    // Set user interface that displays the game.
    // If human plays (i.e. isHuman)
    // en the behaviour of Player instance will be controlled by human player
    // through user interface;
    // else the interface does nothing except displaying the current observation
    // (as the agent plays by itself)
    //
    // each time the game event triggered, interface updates and get obs
    // from Player
    public void setUserInterface(UserInterface userInterface){
        this.userInterface = userInterface;
        if (isHuman){
            userInterface.setSendingFunctions(
                    PlayerCommand.monitorOn(this),
                    PlayerCommand.monitorOff(this),
                    PlayerCommand.switchMonitor(this),
                    PlayerCommand.pressDoorButton(this),
                    PlayerCommand.pressLightButton(this)
            );
            // let userInterface observates the game
        } else {
            // TODO
        }
        // TODO
    }

    // inner class PlayerCommand:
    // ( in case you are not familiar with command pattern )
    // the instances of PlayerCommand initiated with an player can be passed
    // to other modules as args.
    // Then the other module can execute these command when correspond operation
    // will be performed by the player
    // The module henceforth need not know how this player performs it.
    //
    private abstract static class PlayerCommand implements Command {

        protected Player player;

        protected PlayerCommand(Player player){
            this.player = player;
        }

        public static PlayerCommand monitorOn(Player player){
            return new MonitorOn(player);
        }

        public static PlayerCommand monitorOff(Player player){
            return new MonitorOff(player);
        }

        public static PlayerCommand switchMonitor(Player player){
            return new SwitchMonitor(player);
        }

        public static PlayerCommand pressDoorButton(Player player){
            return new PressDoorButton(player);
        }

        public static PlayerCommand pressLightButton(Player player){
            return new PressLightButton(player);
        }

        private static class MonitorOn extends PlayerCommand {

            public MonitorOn(Player player) {
                super(player);
            }

            @Override
            public void execute(Object arg) {
                player.monitorOn();
            }
        }

        private static class MonitorOff extends PlayerCommand {
            public MonitorOff(Player player) {
                super(player);
            }

            @Override
            public void execute(Object arg) {
                player.monitorOff();
            }
        }

        private static class SwitchMonitor extends PlayerCommand {
            public SwitchMonitor(Player player) {
                super(player);
            }

            @Override
            public void execute(Object camera) {
                assert (camera instanceof EnumCameras);
                player.switchMonitor((EnumCameras) camera);
            }
        }

        private static class PressDoorButton extends PlayerCommand {
            public PressDoorButton(Player player) {
                super(player);
            }

            @Override
            public void execute(Object door) {
                assert (door instanceof Integer);
                player.pressDoorButton((Integer) door);
            }
        }

        private static class PressLightButton extends PlayerCommand {
            public PressLightButton(Player player) {
                super(player);
            }

            @Override
            public void execute(Object light) {
                assert  (light instanceof Integer);
                player.pressLightButton( (Integer) light);
            }
        }

    }
}
