package Core;
import Enum.EnumCameras;
import Environent.Office;

public class FullObservation {
    /*
    informations that characters can get.
     */
    protected Office office;
    protected Integer bonnieState;
    protected Integer chickaState;
    protected Integer foxyState;
    protected Integer freddyState;

    protected EnumCameras currentCamera;


    public Integer getBonnieState() {
        return bonnieState;
    }

    public Integer getChickaState() {
        return chickaState;
    }

    public Integer getFoxyState() {
        return foxyState;
    }

    public Integer getFreddyState() {
        return freddyState;
    }

    public EnumCameras getCurrentCamera(){
        return currentCamera;
    }

    public Boolean isOfficeMonitorUp(){
        return office.isMonitorUp();
    }

    public Boolean isOfficeDoor1Open(){
        return office.isDoor1open();
    }

    public Boolean isOfficeDoor2Open(){
        return office.isDoor2open();
    }

    public Boolean isOfficeLight1On(){
        return office.isLight1on();
    }

    public Boolean isOfficeLight2On(){
        return office.isLight2on();
    }

    public Office getOffice(){
        return office.copy();
    }

    public FullObservation(
            Integer bonnieState,
            Integer chickaState,
            Integer foxyState,
            Integer freddyState,
            EnumCameras currentCamera,
            Office office
    ){
        this.bonnieState = bonnieState;
        this.chickaState = chickaState;
        this.foxyState = foxyState;
        this.freddyState = freddyState;
        this.currentCamera = currentCamera;
        this.office = office.copy();
    }
    public FullObservation copy(){
        return new FullObservation(
                bonnieState,
                chickaState,
                foxyState,
                freddyState,
                currentCamera,
                office
        );
    }

}
