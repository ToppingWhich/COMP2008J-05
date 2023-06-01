package wwww;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @Author liwenyan
 * @Date 2023/5/25 21:57
 * @PackageName:wwww
 * @ClassName: DealBreaker
 * @Description: TODO
 * @Version 1.0
 */
public class DealBreaker extends Card{
    int value= 0;
    boolean roteted;
    //游戏主界面
    GameScreen gameScreen;
    public  static String cardType;
    //牌的名字
    String name;
    //牌显示正面还是反面
    boolean up;
    //是否可点击
    boolean canClick;
    Graphics g;

    //当前状态，是否已经被点击
    boolean clicked;

    public DealBreaker(GameScreen gameScreen, String name, boolean up) {
        super(gameScreen, name, up);
    }

    public DealBreaker() {
        super();
    }

    @Override
    void used(GameScreen gameScreen) {
        if(GameScreen.playerturn == 1) {
            GameScreen.button[17].setVisible(true);

        }else if(GameScreen.playerturn == 1) {
            GameScreen.button[18].setVisible(true);
        }
    }

    public DealBreaker(GameScreen gameScreen, String name, boolean canClick, boolean clicked) {
        super(gameScreen, name, canClick, clicked);
    }

    @Override
    public void turnFront() {
        this.setIcon(new ImageIcon("src/images/dealbreaker.png"));
    }

    @Override
    public void rotate() {
        super.rotate();
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
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
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
