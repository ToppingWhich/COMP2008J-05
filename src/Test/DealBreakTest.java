package Test;

import wwww.*;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class DealBreakTest {
    public static void main(String[] args) {
        GameScreen gameScreen = new GameScreen();

        // Creating a DealBreaker Instance
        DealBreaker dealBreaker = new DealBreaker(gameScreen, "Deal Breaker", true);

        // Set some properties of the DealBreaker
        dealBreaker.setUp(true);
        dealBreaker.setCanClick(true);

        // Call DealBreaker's method for testing
        dealBreaker.turnFront();
        dealBreaker.turnRear();
        dealBreaker.small();
        dealBreaker.showDiChan();
        dealBreaker.setName("New Name");
        dealBreaker.setClicked(true);
        dealBreaker.setGameScreen(gameScreen);

        // Create mouse events and trigger the corresponding methods of the DealBreaker
        MouseEvent mouseEvent = new MouseEvent(new JPanel(), MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        dealBreaker.mouseClicked(mouseEvent);
        dealBreaker.mousePressed(mouseEvent);
        dealBreaker.mouseReleased(mouseEvent);
        dealBreaker.mouseEntered(mouseEvent);
        dealBreaker.mouseExited(mouseEvent);


        // Print information about the DealBreaker object
        System.out.println(dealBreaker.toString());
    }
}
