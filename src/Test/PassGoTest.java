package Test;

import wwww.GameScreen;
import wwww.PassGo;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class PassGoTest {
    public static void main(String... args) {

        GameScreen gameScreen = new GameScreen();


        PassGo passGo = new PassGo(gameScreen, "Pass Go", true);


        passGo.setUp(true);
        passGo.setCanClick(true);


        passGo.turnFront();
        passGo.turnRear();
        passGo.small();
        passGo.showDiChan();
        passGo.setName("New Name");
        passGo.setClicked(true);
        passGo.setGameScreen(gameScreen);


        MouseEvent mouseEvent = new MouseEvent(new JPanel(), MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        passGo.mouseClicked(mouseEvent);
        passGo.mousePressed(mouseEvent);
        passGo.mouseReleased(mouseEvent);
        passGo.mouseEntered(mouseEvent);
        passGo.mouseExited(mouseEvent);

        passGo.getGameScreen();
        passGo.used(gameScreen);


        System.out.println(passGo);
    }
}
