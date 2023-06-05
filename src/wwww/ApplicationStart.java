package wwww;

/**
 * @Author liwenyan
 * @Date 2023/5/22 19:44
 * @PackageName:wwww
 * @ClassName: a
 * @Description: TODO
 * @Version 1.0
 */

import javax.swing.*;

public class ApplicationStart {
    public static void main(String[] args) {
        JFrame mainWindow = new JFrame();
        //mainWindow.setSize(CardGame.SCREEN_WIDTH, CardGame.SCREEN_HEIGHT);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainWindow.setUndecorated(true);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setTitle("Game");
        mainWindow.setLocationRelativeTo(null);
        MenuListener menuListener = new MenuListener();
        MenuScreen menuScreen = new MenuScreen();
        GameScreen gameScreen = new GameScreen();
        GameListener gameListener = new GameListener(gameScreen);
        CardGame cardGame = new CardGame(gameScreen);
        GameManager gameManager = new GameManager(cardGame, mainWindow, menuListener, gameListener,menuScreen, new AboutScreen(),gameScreen);
        mainWindow.setVisible(true);
        gameManager.run();
        //fafafafagsgsgg
    }
}