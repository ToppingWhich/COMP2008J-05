package wwww;

import java.awt.*;

/**
 * @Author liwenyan
 * @Date 2023/5/23 20:39
 * @PackageName:wwww
 * @ClassName: LayoutProperty
 * @Description: TODO
 * @Version 1.0
 */
public class LayoutProperty extends CardGame{
    public static final int SCREEN_WIDTH = 1600;
    public static final int SCREEN_HEIGHT = 900;

    GameScreen gameScreen;
    Graphics g;
    LayoutProperty(GameScreen gameScreen){
        super(gameScreen);
        this.gameScreen = gameScreen;
    }

    @Override
    public void run() {
        System.out.println(GameListener.isPlayer1LayoutPropertyTo1);
        if (GameListener.isPlayer1LayoutPropertyTo1) {
            System.out.println("放置1");
            GameListener.isPlayer1LayoutPropertyTo1 = false;
            Card selectedCard = GameScreen.player1PublishedCard.get(0);
            GameScreen.LayoutProperty(g,1,selectedCard);
            gameScreen.button[2].setVisible(false);
            gameScreen.button[3].setVisible(false);
            gameScreen.button[4].setVisible(false);
            this.interrupt();
        }
    }
}
