package wwww;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author liwenyan
 * @Date 2023/5/23 10:33
 * @PackageName:wwww
 * @ClassName: Card
 * @Description: TODO
 * @Version 1.0
 */
public class Card extends JLabel implements MouseListener {
    int value= 0;
    boolean roteted;
    //Main game interface
    GameScreen gameScreen;
    public  static String cardType;
    //The name of the card
    String name;
    //Does the card say heads or tails
    boolean up;
    //If it can be clicked
    boolean canClick;

    //Current status, whether it has been clicked
    boolean clicked;

    public Card(GameScreen gameScreen, String name, boolean up) {
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
        //Show the cards
        this.setVisible(true);
        //Add mouse monitor to each card
        this.addMouseListener(this);
    }

    public Card(){

    }
    void used(GameScreen gameScreen){
    }

    public Card(GameScreen gameScreen, String name, boolean canClick, boolean clicked) {
        this.gameScreen = gameScreen;
        this.name = name;
        this.canClick = canClick;
        this.clicked = clicked;
    }
    //Display front
    public void turnFront() {
        this.setIcon(new ImageIcon("src/images/passgo.png"));

    }
    public void rotate(){

    }
//    public void rotate1(){
//
//    }
//    public void rotate2(){
//
//    }

    //显示背面
    public void turnRear() {
        this.setIcon(new ImageIcon("src/images/rear.png"));
        this.up = false;
    }

    public void small() {
        this.setIcon(new ImageIcon("src/images/suolue.png"));
        this.up = false;
    }

    public void showDiChan() {
        this.setIcon(new ImageIcon("src/images/dichan.png"));
        this.up = false;
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
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        return new Dimension(size.height, size.width);
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

    public String toString() {
        return "Poker{gameJFrame = " + gameScreen + ", name = " + name + ", up = " + up + ", canClick = " + canClick + ", clicked = " + clicked + "}";
    }
}