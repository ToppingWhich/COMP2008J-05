package wwww;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author liwenyan
 * @Date 2023/5/23 13:55
 * @PackageName:wwww
 * @ClassName: Head
 * @Description: TODO
 * @Version 1.0
 */
public class Head extends JLabel implements MouseListener {
    //Main game interface
    GameScreen gameScreen;

    //The name of the card
    String name;


    //Does the card say heads or tails
    boolean up;
    //If it can be clicked
    boolean canClick = true;

    //Current status, whether it has been clicked
    boolean clicked = false;

    public Head(GameScreen m, String name) {
        this.gameScreen = m;
        this.name = name;
        //Determine whether the current card shows front or back
        this.turnFront();
        //Set the width, height and size of the card
        this.setSize(50, 50);
        //Display the card
        this.setVisible(true);
        //Add mouse monitor to each card
        this.addMouseListener(this);
    }

    public Head(){

    }

    public Head(GameScreen gameScreen, String name, boolean canClick, boolean clicked) {
        this.gameScreen = gameScreen;
        this.name = name;
        this.canClick = canClick;
        this.clicked = clicked;
    }
    //Display front
    public void turnFront() {
        this.setIcon(new ImageIcon("src/images/熊.jpg"));
        this.up = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (canClick) {
            Point from = this.getLocation();
            int step;
            if (clicked){
                step = 20;
            }else {
                step = -20;
            }
            clicked = !clicked;
            Point to = new Point(from.x, from.y + step);
            this.setLocation(to);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * 获取
     * @return gameJFrame
     */
    public GameScreen getGameScreen() {
        return gameScreen;
    }

    /**
     * 设置
     * @param gameScreen
     */
    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return up
     */
    public boolean isUp() {
        return up;
    }



    /**
     * 设置
     * @param up
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * 获取
     * @return canClick
     */
    public boolean isCanClick() {
        return canClick;
    }

    /**
     * 设置
     * @param canClick
     */
    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    /**
     * 获取
     * @return clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * 设置
     * @param clicked
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

}
