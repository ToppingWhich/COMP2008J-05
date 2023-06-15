package wwww;

/**
 * @Author liwenyan
 * @Date 2023/5/22 19:26
 * @PackageName:wwww
 * @ClassName: GameManager
 * @Description: TODO
 * @Version 1.0
 */
import javax.swing.*;
import java.awt.*;

public final class GameManager {
    private JFrame mainWindow;
    private JPanel mainPanel;
    private JPanel gameScreen;
    private JPanel gameScreen2;
    private MenuListener listener;

    //TODO
    private GameListener gameListener;
    private CardLayout cardLayout;
    private boolean exit = false;
    private CardGame cardGame;
    private ScreenEnum screenEnum = ScreenEnum.MAIN_MENU_SCREEN;
    private static final double TARGET_TIME_BETWEEN_RENDERS = 1000000000.0 / 60;
    private static final double TIME_BETWEEN_UPDATES = 1000000000.0 / 60;
    private static final int MAX_UPDATES_BEFORE_RENDER = 5;

    public GameManager(CardGame cardGame, JFrame applicationWindow, MenuListener menuListener, GameListener gameListener, JPanel menuScr, JPanel aboutScr, JPanel gameScr, JPanel gameScr2) {
        this.mainWindow = applicationWindow;
        this.listener = menuListener;
        this.gameListener = gameListener;
        this.cardGame = cardGame;
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainWindow.getContentPane().add(mainPanel);
        mainPanel.add(aboutScr, "About");
        mainPanel.add(menuScr, "Main Menu");
        mainPanel.add(gameScr, "Game Screen");
        mainPanel.add(gameScr2, "Game Screen2");
        //this.gameScreen = gameScr;
        showMainMenuScreen();
    }

    private void showMainMenuScreen() {
        //listener.resetKeyPresses();
        cardLayout.show(mainPanel, "Main Menu");
        screenEnum = ScreenEnum.MAIN_MENU_SCREEN;
    }

   void showAboutScreen() {
        //listener.resetKeyPresses();
        cardLayout.show(mainPanel, "About");
        screenEnum = ScreenEnum.ABOUT_SCREEN;
    }

    private void showGameScreen() {
        //listener.resetKeyPresses();
        cardLayout.show(mainPanel, "Game Screen");
        screenEnum = ScreenEnum.GAME_SCREEN;
    }
    private void showGameScreen2() {
        //listener.resetKeyPresses();
        cardLayout.show(mainPanel, "Game Screen2");
        screenEnum = ScreenEnum.GAME_SCREEN;
    }

    public void run() {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        double now = System.nanoTime();
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;
        while (!exit) {
            switch (screenEnum) {
                case ABOUT_SCREEN:
                   if (listener.menu) {
                        showMainMenuScreen();
                        listener.menu = false;
                   } else if (listener.exit) {
                        exitGame();
                   }
                    break;
                case GAME_SCREEN:
                    if (listener.exit) {
                        exitGame();
                    }
                    break;
                case GAME_SCREEN2:
                    if (listener.exit) {
                        exitGame();
                    }
                    break;
                case MAIN_MENU_SCREEN:
                    if (listener.exit) {
                        exitGame();
                    } else if (listener.about) {
                        showAboutScreen();
                        listener.about = false;
                    } else if (listener.newGame) {
                        //cardGame.startNewGame();
                        showGameScreen();
                        listener.newGame = false;
                    }else if (listener.newGame2){
                        showGameScreen2();
                        listener.newGame2 = false;
                    }
                    break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        exit = false;
    }

    private void exitGame() {
        exit = true;
        System.exit(0);
    }
}