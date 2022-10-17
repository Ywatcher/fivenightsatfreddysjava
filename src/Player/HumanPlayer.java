package Player;

import Core.PlayerObservation;
import tools.Timer;

import Core.PlayerAction;

public class HumanPlayer extends Player{
    public HumanPlayer(){
        isHuman = true;
    }
    @Override
    public PlayerAction act(PlayerObservation obs, Timer timer) {
        userInterface.update(obs,timer);
        return bestAction.copy();
    }
}
