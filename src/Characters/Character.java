package Characters;

import Core.FullObservation;
import Enum.EnumEvents;
import Enum.EnumCharacters;
import Enum.EnumRooms;
import java.util.LinkedList;
import java.util.Observable;

public abstract class Character extends Observable {
    public Character(int difficulty){
        this.Difficulty = difficulty;
        this.tickCount = 0;
        this.state = 0;
        // this.playerdeath=0
    }
    protected Integer state = 0;
    protected int Difficulty;
    protected int tickPeriod; //
    protected int tickCount; // character's tick within each period
    protected EnumCharacters name;
    protected LinkedList<EnumRooms> route; // for the case without randomness

    // public boolean playerdeath = false;

    //public int isInRoom() {
    //    return inRoom;
    //}

    public Integer getState(){
        return state;
    }
    public EnumRooms getCurrentRoom(){
        return route.get(state);
    }

    abstract public void tick(FullObservation obs, tools.Timer timer); //tick strategy
    protected void killPlayer(){
        notifyObservers(new Enum[]{EnumEvents.Kill, name}); //playerdeath = true;
    }

    public void forward(FullObservation obs, tools.Timer timer){
        if ( this.tickCount<this.tickPeriod ){
            this.tickCount++;
        }
        if ( this.tickCount==this.tickPeriod ){
            this.tick(obs, timer);
            this.tickCount = 0;
        }
    }

    public void setTickPeriod(int tickPeriod) {
        this.tickPeriod = tickPeriod;
    }

    public void clearTick(){
        this.tickCount = 0;
    }
}
