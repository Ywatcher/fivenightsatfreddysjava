package Core;


public class PlayerAction {
    public PlayerAction(Type type, Object arg) {
        this.type = type;
        this.arg = arg;
    }

    public static enum Type{
        MonitorUp,
        MonitorDown,
        PressDoorButton,
        PressLightButton,
        SwitchMonitor
    }
    private final Type type;
    private final Object arg;

    public Type getType() {
        return type;
    }

    public Object getArg() {
        return arg;
    }

    public PlayerAction copy(){
        return new PlayerAction(type,arg);
    }

}
