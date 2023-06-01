package wwww;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @Author liwenyan
 * @Date 2023/5/24 9:59
 * @PackageName:wwww
 * @ClassName: PassGo
 * @Description: TODO
 * @Version 1.0
 */
public class PassGo extends Card{
    //面额
    int value = 3;
    public  static String cardType ="ActionCard";


    public PassGo(GameScreen gameScreen, String name, boolean up) {
        super(gameScreen, name, up);
    }

    public PassGo() {
        super();
    }

    public PassGo(GameScreen gameScreen, String name, boolean canClick, boolean clicked) {
        super(gameScreen, name, canClick, clicked);
    }

    @Override
    public void turnFront() {
        this.setIcon(new ImageIcon("src/images/passgo.png"));
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

    Graphics g;
    //运行方法
    void used(GameScreen gameScreen){
        for (int i = 0; i < GameScreen.player1PublishedCard.size(); i++) {
            GameScreen.player1PublishedCard.remove(i);
        }
        GameScreen.player1PublishedCard.remove(this);
        GameScreen.getTwoNewCard(g);
        for (int i = 0; i < GameScreen.player1CardSet.size(); i++) {
            GameScreen.player1CardSet.get(i).turnFront();
            GameScreen.player1CardSet.get(i).canClick = true;
        }

    }
}
