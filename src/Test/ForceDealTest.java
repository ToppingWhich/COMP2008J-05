package Test;

import wwww.*;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class ForceDealTest {
    public static void main(String[] args) {
        GameScreen gameScreen = new GameScreen();

        // Create a ForceDeal instance
        ForceDeal forceDeal = new ForceDeal(gameScreen, "Force Deal", true);

        // Set some properties of the ForceDeal
        forceDeal.setUp(true);
        forceDeal.setCanClick(true);

        // Call the ForceDeal method to test
        forceDeal.turnFront();
        forceDeal.turnRear();
        forceDeal.small();
        forceDeal.showDiChan();
        forceDeal.setName("New Name");
        forceDeal.setClicked(true);
        forceDeal.setGameScreen(gameScreen);

        // Create mouse events and trigger the corresponding methods of ForceDeal
        MouseEvent mouseEvent = new MouseEvent(new JPanel(), MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        forceDeal.mouseClicked(mouseEvent);
        forceDeal.mousePressed(mouseEvent);
        forceDeal.mouseReleased(mouseEvent);
        forceDeal.mouseEntered(mouseEvent);
        forceDeal.mouseExited(mouseEvent);


        // Print information about the ForceDeal object
        System.out.println(forceDeal.toString());
    }
}
