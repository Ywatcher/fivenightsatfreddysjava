package UserInterface;

import Core.PlayerObservation;
import tools.Timer;

import javax.swing.*;

public class GUI extends UserInterface {
    @Override
    public void update(PlayerObservation obs, Timer timer) {

    }
    /*
    a new version of Window;
    sharing interface with CLI

    the function of a window should be limited.
     */

    /*
    the window should contain different states, i.e. showing different perspectives,
    this can be assigned by a member. (let it be string.)
    switching perspective is considered as an event triggered by game,
    handling which the window refreshes its state value and repaint.

    if no game event triggered, the window chooses its subroutine to paint particular
    perspective, and repaint repeatedly if animation needed.
     */




    /*
    the process of playing different animations should be abstract
     */

    private class GUIGraphic extends JPanel{

    }

    private class GraphicObject{

        GraphicObject(){

        }
    }


}
