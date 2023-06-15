package wwww;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @Author liwenyan
 * @Date 2023/5/23 17:43
 * @PackageName:wwww
 * @ClassName: ForceDeal
 * @Description: TODO
 * @Version 1.0
 */
public class ForceDeal extends Card{
    //denomination
    int value = 3;
    public  static String cardType ="ActionCard";


    public ForceDeal(GameScreen gameScreen, String name, boolean up) {
        super(gameScreen, name, up);
    }

    public ForceDeal() {
        super();
    }

    public ForceDeal(GameScreen gameScreen, String name, boolean canClick, boolean clicked) {
        super(gameScreen, name, canClick, clicked);
    }

    @Override
    public void turnFront() {

        this.setIcon(new ImageIcon("src/images/forcedeal.png"));
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
    public static Card exchangeCard1;
    public static Card exchangeCard2;
    //Operation method
    void used(GameScreen gameScreen){
        if(GameScreen.playerturn == 1){
            if (GameScreen.player1PropertySet.get(0).size()!=0||GameScreen.player1PropertySet.get(1).size()!=0||GameScreen.player1PropertySet.get(2).size()!=0){
                if(GameScreen.player2PropertySet.get(0).size()!=0||GameScreen.player2PropertySet.get(1).size()!=0||GameScreen.player2PropertySet.get(2).size()!=0){
                    GameScreen.moveCard(g,this,this.getLocation(),new Point(100,350));
                    this.setClicked(false);
                    GameScreen.player1PublishedCard.remove(this);
                    GameScreen.updateText("Click on the property that you and the other party want to exchange");
                    for (int i = 0; i < GameScreen.player1PropertySet.size(); i++) {
                        if(i==1){
                            for (int j = 0; j < GameScreen.player1PropertySet1.size(); j++) {
                                if (GameScreen.player1PropertySet1.get(j).isClicked()){
                                    exchangeCard1 = GameScreen.player1PropertySet1.get(j);
                                }
                            }
                        }else if(i==2){
                            for (int j = 0; j < GameScreen.player1PropertySet2.size(); j++) {
                                if (GameScreen.player1PropertySet2.get(j).isClicked()){
                                    exchangeCard1 = GameScreen.player1PropertySet2.get(j);
                                }
                            }
                        }else if(i==3){
                            for (int j = 0; j < GameScreen.player1PropertySet3.size(); j++) {
                                if (GameScreen.player1PropertySet3.get(j).isClicked()){
                                    exchangeCard1 = GameScreen.player1PropertySet3.get(j);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < GameScreen.player2PropertySet.size(); i++) {
                        if(i==1){
                            for (int j = 0; j < GameScreen.player2PropertySet1.size(); j++) {
                                if (GameScreen.player2PropertySet1.get(j).isClicked()){
                                    exchangeCard2 = GameScreen.player2PropertySet1.get(j);
                                }
                            }
                        }else if(i==2){
                            for (int j = 0; j < GameScreen.player2PropertySet2.size(); j++) {
                                if (GameScreen.player2PropertySet2.get(j).isClicked()){
                                    exchangeCard2 = GameScreen.player2PropertySet2.get(j);
                                }
                            }
                        }else if(i==3){
                            for (int j = 0; j < GameScreen.player2PropertySet3.size(); j++) {
                                if (GameScreen.player2PropertySet3.get(j).isClicked()){
                                    exchangeCard2 = GameScreen.player2PropertySet3.get(j);
                                }
                            }
                        }
                    }
                    if(exchangeCard2!=null&&exchangeCard1!=null){
                        GameScreen.button[14].setVisible(true);
                    }
                    Point exchangeCard1Location = exchangeCard1.getLocation();
                    GameScreen.moveCard(g,exchangeCard1,exchangeCard1.getLocation(),exchangeCard2.getLocation());
                    GameScreen.moveCard(g,exchangeCard2,exchangeCard2.getLocation(),exchangeCard1Location);
                }else {
                    GameScreen.updateText("The other side has no property to exchange");
                }
            }else {
                GameScreen.updateText("You have no property to exchange");
            }
            for (int i = 0; i < GameScreen.player1PublishedCard.size(); i++) {
                GameScreen.player1PublishedCard.remove(i);
            }
        }

    }
}
