public abstract class Character {
    public Character(int difficulty){
        this.Difficulty = difficulty;
        this.time = 0;
    }
    static int inRoom = 0;

    protected int Difficulty;
    protected int tickPeriod;
    protected int tickCount;

    public static boolean playerdeath = false;

    public int isInRoom() {
        return inRoom;
    }

    abstract public void tick();

    public void timeIncreaseAndTick(){
        if ( this.tickCount<this.tickPeriod ){
            this.tickCount++;
        }
        if ( this.tickCount==this.tickPeriod ){
            this.tick();
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
