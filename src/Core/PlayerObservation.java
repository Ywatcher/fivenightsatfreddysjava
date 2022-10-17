package Core;

import Enum.EnumCameras;
import Enum.EnumDistance;
import Environment.Office;


public class PlayerObservation {
    /*
    everything player can percept
    TODO: encode the characters (so that you can add new characters for different episodes
    */
    public PlayerObservation(
            EnumCameras camera,
            Integer enviromentState,
            EnumDistance bonnie,
            EnumDistance chica,
            EnumDistance foxy,
            EnumDistance freddy,
            Office office
            ){
        this.cam = camera;
        this.enviromentState = enviromentState;
        this.bonnie = bonnie;
        this.chica = chica;
        this.foxy = foxy;
        this.freddy = freddy;
        this.office = office.copy();
    }
    private Integer enviromentState; // for some room(pirate room) there are different states
    private final EnumCameras cam; // the id of room
    // whether following character in room 0 for none, 1 for far, 2 for close
    private final EnumDistance bonnie;
    private final EnumDistance chica;
    private final EnumDistance foxy;
    private final EnumDistance freddy;
    private final Office office;

    public EnumDistance hasBonnie(){
        return bonnie;
    }
    public EnumDistance hasChica(){
        return chica;
    }
    public EnumDistance hasFoxy(){
        return foxy;
    }
    public EnumDistance hasFreddy(){
        return freddy;
    }

    public EnumCameras getCam() {
        return cam;
    }

    public Integer getState() {
        return enviromentState;
    }

    public Office getOffice() {
        return office;
    }
    public PlayerObservation copy(){
        return new PlayerObservation(
                cam,
                enviromentState,bonnie, chica,foxy,freddy,office
        );
    }
}
