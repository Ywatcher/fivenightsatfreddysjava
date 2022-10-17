package Player;

import Core.PlayerAction;
import Core.PlayerObservation;
import tools.Timer;


public class AgentPlayer extends Player{

    protected Agent agent;

    public AgentPlayer() {
        isHuman = false;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public PlayerAction act(PlayerObservation obs, Timer timer) {
        bestAction = agent.forward(obs,timer);
        return bestAction.copy();
    }
    protected static abstract class Agent{
        public abstract PlayerAction forward(PlayerObservation obs, Timer timer);

    }

}
