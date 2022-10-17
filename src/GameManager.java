import Core.PlayerAction;
import Core.PlayerObservation;
import Player.Player;
import UserInterface.UserInterface;
import UserInterface.GUI;
import tools.Timer;

public class GameManager{
    private String defaultAgent;
    private String defaultUseInterface;
    private Game game;
    private MainMenu mainMenu;
    private Player player;
    private UserInterface userInterface;
    private Timer timer; //TODO

    // private int gameover

    public void init(){
        Integer difficulty = null; //TODO
        userInterface = new GUI();

    }

    public void run(){
        //todo



        // init agent, game , userInterface
        player.setUserInterface(userInterface);

        // each loop: apply agent.act( obs, time )
        // new Game()
        // init gameover
        //
        // load and play news (if !skip)
        // game start
        // for each loop
        // if this.game over ..

        // if not this.game over, gametick()
    }

    public void gameTick(){

        // the obs is the state after events having been sent to interface
        // during last tick.
        PlayerObservation obs = game.getPlayerObservation();
        userInterface.update(obs,timer);
        PlayerAction action = player.act(obs,timer);
        game.applyPlayerAction(action);
        game.forward(); // the order?
        // if gameover, set state to game over;
        // send event-gameover to interface;
        //
    }

    private void mainMenu(){

    }

    private void gameOver(){

    }


    // method:
    // get full obs
    // get agent obs
}
