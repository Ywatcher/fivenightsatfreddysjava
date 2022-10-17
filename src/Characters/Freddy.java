package Characters;
import Characters.Character;
import Core.FullObservation;
import Enum.EnumCharacters;

public class Freddy extends Character {

    public Freddy(int difficulty) {
        super(difficulty);
        this.name = EnumCharacters.IDFreddy;
        this.tickPeriod = 1700;
    }

    public void tick(FullObservation obs, tools.Timer timer) {

        if (state == 0 && (obs.getBonnieState() == 0 || obs.getChickaState() == 0)) {
            return;
        }
        if (obs.isOfficeDoor1Open() && obs.isOfficeDoor2Open() && state == 4) {
            //if (Environent.Office.door2open == true) {
            //    killPlayer();
            //    state = 5;
            //}
            killPlayer();
            state = 5;
        } else {
            if (state != 4) {

                if (obs.getChickaState() == state + 1 || obs.getBonnieState() == state + 1) {
                    return;
                } else {
                    state = state + 1;
                    return;
                }
            } else {
                if (obs.getChickaState() == state + 1 || obs.getBonnieState() == state + 1) {
                    return;
                } else {
                    state = state - 1;
                    return;
                }
            }

        }
    }
}

