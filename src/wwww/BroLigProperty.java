package wwww;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * @Author liwenyan
 * @Date 2023/5/24 16:43
 * @PackageName:wwww
 * @ClassName: BroLigProperty
 * @Description: TODO
 * @Version 1.0
 */
public class BroLigProperty extends Property{
    int value;

    String color = "brownandlightblue";
    public  static String cardType ="Property";

    GameScreen gameScreen;
    public BroLigProperty(GameScreen gameScreen, String name, boolean up) {
        this.gameScreen = gameScreen;
        this.name = name;
        this.up = up;
        //判断当前的牌是显示正面还是背面
        if (this.up){
            this.turnFront();
        }else {
            this.turnRear();
        }
        //设置牌的宽高大小
        this.setSize(140, 240);
        //把牌显示出来
        this.setVisible(true);
        //给每一张牌添加鼠标监听
        this.addMouseListener(this);
    }
    public BroLigProperty(GameScreen gameScreen, String name, boolean canClick, boolean clicked) {
        this.gameScreen = gameScreen;
        this.name = name;
        this.canClick = canClick;
        this.clicked = clicked;
    }
    @Override
    void used(GameScreen gameScreen) {
        if(GameScreen.playerturn == 1) {
            //显示三个”放置“按钮
            gameScreen.button[2].setVisible(true);
            gameScreen.button[3].setVisible(true);
            gameScreen.button[4].setVisible(true);
            this.clicked = false;
        }else if(GameScreen.playerturn == 2) {
            //显示三个”放置“按钮
            gameScreen.button[11].setVisible(true);
            gameScreen.button[12].setVisible(true);
            gameScreen.button[13].setVisible(true);
            this.clicked = false;
        }
    }

    @Override
    public void turnFront() {
        this.setIcon(new ImageIcon("src/images/light-blue-and-brown-wildcard-card.png"));

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
