package wwww;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @Author liwenyan
 * @Date 2023/5/24 15:54
 * @PackageName:wwww
 * @ClassName: PurpleProperty
 * @Description: TODO
 * @Version 1.0
 */
public class PurpleProperty extends Property {
    int value;
    public static ArrayList<ColorEnum> colorArray;
    public  static String cardType ="Property";

    GameScreen gameScreen;
    public PurpleProperty(GameScreen gameScreen, String name, boolean up) {
        this.colorArray = new ArrayList<ColorEnum>();
        this.colorArray.add(ColorEnum.PURPLE);
        this.gameScreen = gameScreen;
        this.name = name;
        this.up = up;
        //Determine whether the current card shows front or back
        if (this.up){
            this.turnFront();
        }else {
            this.turnRear();
        }
        //Set the width and height of the card
        this.setSize(140, 240);
        //Display the card
        this.setVisible(true);
        //Add mouse monitor to each card
        this.addMouseListener(this);
    }
    public PurpleProperty(GameScreen gameScreen, String name, boolean canClick, boolean clicked) {
        this.gameScreen = gameScreen;
        this.name = name;
        this.canClick = canClick;
        this.clicked = clicked;
    }
    @Override
    void used(GameScreen gameScreen) {
        if(GameScreen.playerturn == 1) {
            //Three Place buttons are displayed
            gameScreen.button[2].setVisible(true);
            gameScreen.button[3].setVisible(true);
            gameScreen.button[4].setVisible(true);
            this.clicked = false;
        }else if(GameScreen.playerturn == 2) {
            //Three Place buttons are displayed
            gameScreen.button[11].setVisible(true);
            gameScreen.button[12].setVisible(true);
            gameScreen.button[13].setVisible(true);
            this.clicked = false;
        }
    }

    @Override
    public void turnFront() {
        this.setIcon(new ImageIcon("src/images/purpleproperty.png"));

    }

    @Override
    public void turnRear() {
        super.turnRear();
    }

    @Override
    public void small() {
        super.small();
    }

    @Override
    public void showDiChan() {
        super.showDiChan();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
    }

    @Override
    public GameScreen getGameScreen() {
        return super.getGameScreen();
    }

    @Override
    public void setGameScreen(GameScreen gameScreen) {
        super.setGameScreen(gameScreen);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public boolean isUp() {
        return super.isUp();
    }

    @Override
    public void setUp(boolean up) {
        super.setUp(up);
    }

    @Override
    public boolean isCanClick() {
        return super.isCanClick();
    }

    @Override
    public void setCanClick(boolean canClick) {
        super.setCanClick(canClick);
    }

    @Override
    public boolean isClicked() {
        return super.isClicked();
    }

    @Override
    public void setClicked(boolean clicked) {
        super.setClicked(clicked);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
