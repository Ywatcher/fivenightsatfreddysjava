import java.util.Observable;
import java.util.Observer;
import java.util.LinkedList;

import Characters.Character;
import Characters.Bonnie;
import Characters.Chica;
import Characters.Foxy;
import Characters.Freddy;

import Core.PlayerObservation;
import Core.FullObservation;
import Core.PlayerAction;

import Enum.EnumCameras;
import Enum.EnumEvents;
import Enum.EnumRooms;
import Enum.EnumCharacters;
import Environment.Rooms;
import Environment.Office;
import tools.Timer;

public class Game implements Observer {

    private final int difficulty;
    private final Bonnie bonnie;
    private final Chica chica;
    private final Foxy foxy;
    private final Freddy freddy;

    private final Rooms map;
    private final Office office;
    private final tools.Timer timer;
    private EnumCameras currentCamera;

    private Integer powerOutTimer; // event triggered 4 ticks after powerout

    private final LinkedList<Character> characters;


    public Game(
            int difficulty
    ){
        this.difficulty = difficulty;

        // init characters
        bonnie = new Bonnie(difficulty);
        characters = new LinkedList<>();
        characters.add(bonnie);
        chica = new Chica(difficulty);
        characters.add(chica);
        foxy = new Foxy(difficulty);
        characters.add(foxy);
        freddy = new Freddy(difficulty);
        characters.add(freddy);
        // game observes each character
        // init office and other rooms
        office = new Office(); // power = 100
        map = new Rooms();
        currentCamera = EnumCameras.CAM1A; //
        // current camera cannot be Office
        timer = new Timer(); //TODO
    }


    public void forward(){ // response to player's behaviour; time inc.
        // todo
        //  if time == the morning,
        //  game win, return.
        // obs, timer
        FullObservation obs = this.getFullObservation(); //TODO: separate game state with game model in some day
        // tick each character
        for (Character character : characters){
            character.forward(
                    obs, timer//TODO?
            );
        }
        //power;
        office.forward();
        if (office.getPower() == 0){
            if (powerOutTimer<4)
                powerOutTimer ++;
            else if (office.getPower()==4){
                powerOutEvent();;
            }
        }
        //player.act() is called later outside this class
    }

    public void applyPlayerAction(PlayerAction action){
        switch (action.getType()) {
            case MonitorUp -> {
                office.setMonitorUp();
                eventMonitor(true);
            }
            case MonitorDown -> {
                office.setMonitorDown();
                eventMonitor(false);
            }
            case PressDoorButton -> {
                Integer door = (Integer) action.getArg();
                eventDoor(door);
                switch (door) {
                    case 1: office.pressDoor1();
                    case 2: office.pressDoor2();
                    default:{
                        assert (false);
                    }
                }
            }
            case PressLightButton -> {
                Integer light = (Integer) action.getArg();
                eventLight(light);
                switch (light) {
                    case 1: office.pressLight1();
                    case 2: office.pressLight2();
                    default: {
                        assert (false);
                    }
                }
            }
            case SwitchMonitor -> {
                assert (office.isMonitorUp());
                EnumCameras camera = (EnumCameras) action.getArg();
                assert (!camera.equals(EnumCameras.Office));
                currentCamera = camera;
            }
        }
    }


    @Override
    public void update(Observable o, Object arg) { // immediate response upon character behaviours
        //->sent  an event to interface
        Enum[] message = (Enum[]) arg;
        EnumEvents event = (EnumEvents) message[0];
        switch (event) {
            case Kill -> {
                EnumCharacters killer = (EnumCharacters) message[1];
                eventKill(killer);
            }
            case Knock -> eventKnock();
            case ChangeEnvironment -> {
                EnumRooms room = (EnumRooms) message[1];
                switch (room) {
                    case PirateCove -> map.incPirateCoveStage();
                    default -> {
                        assert(false);
                    }
                }
            }
            default -> {
                assert (false);
            }
        }
    }


    public void clearTick(){
        for (Character character : characters){
            character.clearTick();
        }
    }


    // camera <- office if current monitor is down
    public PlayerObservation getPlayerObservation(){
        EnumCameras camera = null;
        if (office.isMonitorUp())
            camera = currentCamera;
        else
            camera = EnumCameras.Office;
        return new PlayerObservation(
                camera,
                map.environmentState(camera),
                map.lookFrmCamera(camera,bonnie.getCurrentRoom()),
                map.lookFrmCamera(camera, chica.getCurrentRoom()),
                map.lookFrmCamera(camera,foxy.getCurrentRoom()),
                map.lookFrmCamera(camera,freddy.getCurrentRoom()),
                office
        );
    }

    public FullObservation getFullObservation(){
        return new FullObservation(
                bonnie.getState(),
                chica.getState(),
                foxy.getState(),
                freddy.getState(),
                currentCamera,
                office
        );
    }

    // an event reset the interface buffer, yet does not repaint the screen.
    // interface will repaint according to the new buffer on the beginning
    // of next game tick

    private void eventKill(EnumCharacters killer){
        //todo
    }
    private void eventKnock(){
        //todo
    }

    private void eventMonitor(Boolean up){
        //todo
    }

    private void eventDoor(Integer door){
        // 1 for left door button pressed, 2 for right.
        //todo
    }

    private void eventLight(Integer light){
        //todo
    }

    private void powerOutEvent(){

    }


}
