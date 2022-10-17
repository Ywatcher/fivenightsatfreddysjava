package Player;

import tools.Command;
import Core.PlayerAction;
import Core.PlayerObservation;
import Enum.EnumCameras;
import UserInterface.UserInterface;


public abstract class Player {
    /*
     * Interface for the bahaviour of the player.
     * The Player can be controlled by either human
     *  (through GUI / CLI)
     * or an AI.
     * Player applies its action by the function
     *  - public PlayerAction act(PlayerObservation obs, tools.Timer timer)
     * which is called each game loop by the game controller.
     * For a human player, this function transmit the game observation
     * to user interface to display, while reading the action buffer from
     * last game tick as return value; and the user interfaces will send
     * new actions here, which is then stored in the buffer for next tick.
     *
     * Whether the Player is controlled by human is decided by the attribute
     *  - Boolean isHuman
     * which is assigned at init;
     * If the controller is not human, this Player instance will not let
     * the user interface to send action when setting it (that means the interface
     * only displays the game)
     */
    protected Boolean isHuman;
    protected UserInterface userInterface;
    protected PlayerAction bestAction;

    public abstract PlayerAction act(PlayerObservation obs, tools.Timer timer);

    /* Set here user interface that displays the game.
     * The player does not have to update the interface
     * (the game controller will do it)
     * or to notify it of any events
     * (the game model will do it).
     */
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
