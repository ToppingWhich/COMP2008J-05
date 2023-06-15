package wwww;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author liwenyan
 * @Date 2023/5/23 10:40
 * @PackageName:wwww
 * @ClassName: GameListener
 * @Description: TODO
 * @Version 1.0
 */
public class GameListener implements ActionListener {
    public static boolean isInitCard;
    public static boolean isPlayer1AbandonCard;
    public static boolean isPlayer2AbandonCard;
    public static boolean isBeginPlayer1Turn;
    public static boolean isEndPlayer1Turn;
    public static boolean isBeginPlayer2Turn;
    public static boolean isEndPlayer2Turn;
    public static boolean isPlayer1PublishedCard;
    public static boolean isPlayer1LayoutPropertyTo1;
    public static boolean isPlayer1LayoutPropertyTo2;
    public static boolean isPlayer1LayoutPropertyTo3;
    public static boolean isPlayer2PublishedCard;
    public static boolean isPlayer2LayoutPropertyTo1;
    public static boolean isPlayer2LayoutPropertyTo2;
    public static boolean isPlayer2LayoutPropertyTo3;
    public static boolean isPlayer1ChangeProperty;
    public static boolean isPlayer1LayoutCashToBank;
    public static boolean isPlayer2LayoutCashToBank;

    public static boolean isPlayer1DealBreaker;
    public static boolean isPlayer2DealBreaker;

    GameScreen gameScreen;
    GameListener(GameScreen gameScreen){
        this.gameScreen=gameScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GameScreen.button[1] ){
            System.out.println("1");
            isInitCard = true;
            GameScreen.updateText("Please ask the first player to start the round");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if(e.getSource()==GameScreen.button[5]) {
            isBeginPlayer1Turn = true;
            GameScreen.updateText("Player 1's turn,Get two new hands");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        } else if(e.getSource()==GameScreen.button[17]) {
            isPlayer1DealBreaker= true;
            GameScreen.updateText("Player 1 used DealBreaker");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        } else if (e.getSource()==GameScreen.button[7]) {
            if(GameScreen.player1CardSet.size()<8) {
                isEndPlayer1Turn = true;
                GameScreen.updateText("Player 1's turn is over");
                CardGame cardGame = new CardGame(gameScreen);
                cardGame.start();
            }else{
                GameScreen.updateText("You have too many cards to finish");
                GameScreen.button[19].setVisible(true);
            }
        }else if (e.getSource()==GameScreen.button[19]) {
            isPlayer1AbandonCard = true;
            GameScreen.updateText("Player 1 has abandoned his card");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if(e.getSource()==GameScreen.button[8]) {
            isBeginPlayer2Turn = true;
            GameScreen.updateText("For Player 2's turn, you get two new hands");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if (e.getSource()==GameScreen.button[10]) {
            //if(GameScreen.player1CardSet.size()<6) {
            isEndPlayer2Turn = true;
            GameScreen.updateText("Player 2's turn is over");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        } else if (e.getSource() == GameScreen.button[6]) {
            isPlayer1PublishedCard = true;
            GameScreen.updateText("Player 1 has played his hand");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if (e.getSource() == GameScreen.button[2]) {
            isPlayer1LayoutPropertyTo1 = true;
            GameScreen.updateText("Player 1 placed the property in the 1 box");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }
        else if (e.getSource() == GameScreen.button[3]) {
            isPlayer1LayoutPropertyTo2 = true;
            GameScreen.updateText("Player 1 placed the property in box 2");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }
        else if (e.getSource() == GameScreen.button[4]) {
            isPlayer1LayoutPropertyTo3 = true;
            GameScreen.updateText("Player 1 placed the property in box 3");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if (e.getSource() == GameScreen.button[9]) {
            isPlayer2PublishedCard = true;
            GameScreen.updateText("Player 2 has played");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if (e.getSource() == GameScreen.button[11]) {
            isPlayer2LayoutPropertyTo1 = true;
            GameScreen.updateText("Player 2 placed the property in box 1");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if (e.getSource() == GameScreen.button[12]) {
            isPlayer2LayoutPropertyTo2 = true;
            GameScreen.updateText("Player 2 placed the property in box 2");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if (e.getSource() == GameScreen.button[13]) {
            isPlayer2LayoutPropertyTo3 = true;
            GameScreen.updateText("Player 2 placed the property in box 3");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if (e.getSource() == GameScreen.button[14]) {
            isPlayer1ChangeProperty = true;
            GameScreen.updateText("Player 1 used a forced deal");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
        }else if (e.getSource() == GameScreen.button[15]) {
            isPlayer1LayoutCashToBank = true;
            //GameScreen.updateText("玩家1把现金放入了银行"+"The sum of the cash:"+Cash.sum1);
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
            GameScreen.updateText("Player 1 puts cash in the bank "+"The sum of the cash:"+Cash.sum1+"+the amount of the last card");
        }else if (e.getSource() == GameScreen.button[16]) {
            isPlayer2LayoutCashToBank = true;
//            GameScreen.updateText("玩家2把现金放入了银行"+"The sum of the cash:"+Cash.sum2+"+the amount of the last card");
            CardGame cardGame = new CardGame(gameScreen);
            cardGame.start();
            GameScreen.updateText("Player 2 puts cash in the bank"+"The sum of the cash:"+Cash.sum2+"+the amount of the last card");
        }

    }
}
