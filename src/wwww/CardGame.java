package wwww;

import java.awt.*;
import java.util.ArrayList;

/**
 * @Author liwenyan
 * @Date 2023/5/22 19:59
 * @PackageName:wwww
 * @ClassName: CardGame
 * @Description: TODO
 * @Version 1.0
 */
public class CardGame extends Thread{
    public static final int SCREEN_WIDTH = 1600;
    public static final int SCREEN_HEIGHT = 900;

    GameScreen gameScreen;
    Graphics g;
    public void startNewGame() {

    }
    CardGame(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    @Override
    public void run() {
        if (GameListener.isInitCard) {
            GameScreen.button[1].setVisible(false);
            GameScreen.dealInitCard(g);
            GameListener.isInitCard=false;
            GameScreen.button[5].setVisible(true);
            this.interrupt();
        } else if (GameListener.isPlayer1DealBreaker) {
            GameListener.isPlayer1DealBreaker = false;
            for (int i = 0; i < GameScreen.player2PropertySet1.size(); i++) {
                if (GameScreen.player2PropertySet1.get(i).clicked){
                    GameScreen.player2PropertySet1.get(i).clicked=false;
                    for (int j = 0; j < GameScreen.player1PropertySet.size(); j++) {
                        if(GameScreen.player1PropertySet.get(i).size()==0){
                            for (int k = 0; k < GameScreen.player2PropertySet1.size(); k++) {
                                Card selectedCard = GameScreen.player2PropertySet1.get(k);
                                GameScreen.LayoutProperty(g,i,selectedCard);
                            }
                        }
                    }
                }else if (GameScreen.player2PropertySet2.get(i).clicked){
                    GameScreen.player2PropertySet2.get(i).clicked=false;
                    for (int j = 0; j < GameScreen.player1PropertySet.size(); j++) {
                        if(GameScreen.player1PropertySet.get(i).size()==0){
                            for (int k = 0; k < GameScreen.player2PropertySet1.size(); k++) {
                                Card selectedCard = GameScreen.player2PropertySet1.get(k);
                                GameScreen.LayoutProperty(g,i,selectedCard);
                            }
                        }
                    }
                }else if (GameScreen.player2PropertySet2.get(i).clicked){
                    GameScreen.player2PropertySet2.get(i).clicked=false;
                    for (int j = 0; j < GameScreen.player1PropertySet.size(); j++) {
                        if(GameScreen.player1PropertySet.get(i).size()==0){
                            for (int k = 0; k < GameScreen.player2PropertySet1.size(); k++) {
                                Card selectedCard = GameScreen.player2PropertySet1.get(k);
                                GameScreen.LayoutProperty(g,i,selectedCard);
                            }
                        }
                    }
                }
            }
            gameScreen.button[17].setVisible(false);
            GameScreen.player1PublishedCard.remove(0);
            this.interrupt();
        }else if (GameListener.isPlayer1LayoutCashToBank) {
            GameListener.isPlayer1LayoutCashToBank = false;

            //Cash selectedCard = GameScreen.player1PublishedCard.get(0);
            Card selectedCard = GameScreen.player1PublishedCard.get(0);
            Cash cash = (Cash)  selectedCard;
            GameScreen.player1Money+=cash.getValue();
            GameScreen.updateText("玩家1把现金放入了银行"+"The sum of the cash:"+GameScreen.player1Money);
            cash.roteted=true;
            cash.rotate();
            GameScreen.LayoutCash(g,cash);
            gameScreen.button[15].setVisible(false);
            GameScreen.player1PublishedCard.remove(0);
            this.interrupt();
        }else if (GameListener.isPlayer2LayoutCashToBank) {
            GameListener.isPlayer2LayoutCashToBank = false;
            Card selectedCard = GameScreen.player2PublishedCard.get(0);
            selectedCard.roteted=true;
            selectedCard.rotate();
            GameScreen.LayoutCash(g,selectedCard);
            gameScreen.button[16].setVisible(false);
            GameScreen.player2PublishedCard.remove(0);
            this.interrupt();
        }else if (GameListener.isPlayer1PublishedCard) {
            GameListener.isPlayer1PublishedCard =false;
            if(GameScreen.player1PublishedCardNumPerTurn<3) {
                GameScreen.player1PublishedCardNumPerTurn+=1;
                for (int i = 0; i < GameScreen.player1CardSet.size(); i++) {
                    if (GameScreen.player1CardSet.get(i).isClicked()) {
                        Card selectedCard = GameScreen.player1CardSet.get(i);
                        GameScreen.player1PublishedCard.add(selectedCard);
                        if (selectedCard.cardType != "Property") {
                            GameScreen.moveCard(g, selectedCard, selectedCard.getLocation(), new Point(100, 350));
                        }
                        GameScreen.player1CardSet.remove(selectedCard);
                        selectedCard.used(gameScreen);
                    }
                }
            }else if(GameScreen.player1PublishedCardNumPerTurn == 3){
                GameScreen.button[6].setVisible(false);
                for (int i = 0; i < GameScreen.player1CardSet.size(); i++) {
                    if (GameScreen.player1CardSet.get(i).isClicked()) {
                        Card selectedCard = GameScreen.player1CardSet.get(i);
                        GameScreen.player1PublishedCard.add(selectedCard);
                        if (selectedCard.cardType != "Property") {
                            GameScreen.moveCard(g, selectedCard, selectedCard.getLocation(), new Point(100, 350));
                        }
                        GameScreen.player1CardSet.remove(selectedCard);
                        selectedCard.used(gameScreen);
                    }
                }
            }
            this.interrupt();
        }else if (GameListener.isPlayer1ChangeProperty) {
            GameListener. isPlayer1ChangeProperty = false;
            Card card1 = ForceDeal.exchangeCard1;
            Card card2 = ForceDeal.exchangeCard2;
            Point exchangeCard1Location = card1.getLocation();
            GameScreen.moveCard(g,card1,card1.getLocation(),card2.getLocation());
            GameScreen.moveCard(g,card2,card2.getLocation(),exchangeCard1Location);
            gameScreen.button[14].setVisible(false);
            ForceDeal.exchangeCard1=null;
            ForceDeal.exchangeCard2=null;
            this.interrupt();
        } else if (GameListener.isPlayer1LayoutPropertyTo1) {
            GameListener.isPlayer1LayoutPropertyTo1 = false;
            System.out.println("shuliang:"+GameScreen.player1PropertySet1Color.size());
            if(GameScreen.player1PropertySet1Color.size()==0) {
                Property selectedCard = (Property) GameScreen.player1PublishedCard.get(0);
                GameScreen.LayoutProperty(g, 1, selectedCard);
                GameScreen.player1PropertySet1Color.addAll(judgeColor(selectedCard));
                gameScreen.button[2].setVisible(false);
                gameScreen.button[3].setVisible(false);
                gameScreen.button[4].setVisible(false);
                GameScreen.player1PublishedCard.remove(0);
                this.interrupt();
            }else{
                System.out.println("yansebutong");
                GameScreen.updateText("颜色不同，放不进去");
                Property selectedCard = (Property) GameScreen.player1PublishedCard.get(0);
                for (ColorEnum colorEnum1 : selectedCard.colorArray) {
                    for (ColorEnum colorEnum2 : GameScreen.player1PropertySet1Color) {
                        if(colorEnum1 == colorEnum2){
                            GameScreen.LayoutProperty(g, 1, selectedCard);
                            GameScreen.player1PublishedCard.remove(0);
                            this.interrupt();
                        }else {
                            GameScreen.updateText("no");
                            GameScreen.player1PublishedCard.remove(0);
                            this.interrupt();
                        }

                    }
                }
            }
        } else if (GameListener.isPlayer1LayoutPropertyTo2) {
            GameListener.isPlayer1LayoutPropertyTo2 = false;
            System.out.println("shuliang:"+GameScreen.player1PropertySet2Color.size());
            if(GameScreen.player1PropertySet2Color.size()==0) {
                Property selectedCard = (Property) GameScreen.player1PublishedCard.get(0);
                GameScreen.LayoutProperty(g, 2, selectedCard);
                GameScreen.player1PropertySet2Color.addAll(judgeColor(selectedCard));
                gameScreen.button[2].setVisible(false);
                gameScreen.button[3].setVisible(false);
                gameScreen.button[4].setVisible(false);
                GameScreen.player1PublishedCard.remove(0);
                this.interrupt();
            }else{
                System.out.println("yansebutong");
                GameScreen.updateText("颜色不同，放不进去");
                Property selectedCard = (Property) GameScreen.player1PublishedCard.get(0);
                for (ColorEnum colorEnum1 : selectedCard.colorArray) {
                    for (ColorEnum colorEnum2 : GameScreen.player1PropertySet2Color) {
                        if(colorEnum1 == colorEnum2){
                            GameScreen.LayoutProperty(g, 2, selectedCard);
                            this.interrupt();
                        }else {
                            GameScreen.updateText("no");
                            this.interrupt();
                        }

                    }
                }
            }
            this.interrupt();
        }else if (GameListener.isPlayer1LayoutPropertyTo3) {
            GameListener.isPlayer1LayoutPropertyTo3 = false;
            System.out.println("shuliang:"+GameScreen.player1PropertySet3Color.size());
            if(GameScreen.player1PropertySet3Color.size()==0) {
                Property selectedCard = (Property) GameScreen.player1PublishedCard.get(0);
                GameScreen.LayoutProperty(g, 3, selectedCard);
                GameScreen.player1PropertySet3Color.addAll(judgeColor(selectedCard));
                gameScreen.button[2].setVisible(false);
                gameScreen.button[3].setVisible(false);
                gameScreen.button[4].setVisible(false);
                GameScreen.player1PublishedCard.remove(0);
                this.interrupt();
            }else{
                System.out.println("yansebutong");
                GameScreen.updateText("颜色不同，放不进去");
                Property selectedCard = (Property) GameScreen.player1PublishedCard.get(0);
                for (ColorEnum colorEnum1 : selectedCard.colorArray) {
                    for (ColorEnum colorEnum2 : GameScreen.player1PropertySet3Color) {
                        if(colorEnum1 == colorEnum2){
                            GameScreen.LayoutProperty(g, 3, selectedCard);
                            GameScreen.player1PublishedCard.remove(0);
                            this.interrupt();
                        }else {
                            GameScreen.updateText("no");
                            GameScreen.player1PublishedCard.remove(0);
                            this.interrupt();
                        }

                    }
                }
            }
            GameListener.isPlayer1LayoutPropertyTo3 = false;
            Card selectedCard = GameScreen.player1PublishedCard.get(0);
            GameScreen.LayoutProperty(g,3,selectedCard);
            gameScreen.button[2].setVisible(false);
            gameScreen.button[3].setVisible(false);
            gameScreen.button[4].setVisible(false);
            GameScreen.player1PublishedCard.remove(0);
            this.interrupt();
        }else if (GameListener.isPlayer2PublishedCard) {

            GameListener.isPlayer2PublishedCard = false;
            if (GameScreen.player2PublishedCardNumPerTurn < 3) {
                GameScreen.player2PublishedCardNumPerTurn += 1;
                for (int i = 0; i < GameScreen.player2CardSet.size(); i++) {
                    if (GameScreen.player2CardSet.get(i).isClicked()) {
                        Card selectedCard = GameScreen.player2CardSet.get(i);
                        GameScreen.player2PublishedCard.add(selectedCard);
                        selectedCard.used(gameScreen);
                    }
                }
            }else if(GameScreen.player2PublishedCardNumPerTurn == 3){
                GameScreen.button[9].setVisible(false);
                for (int i = 0; i < GameScreen.player2CardSet.size(); i++) {
                    if (GameScreen.player2CardSet.get(i).isClicked()) {
                        Card selectedCard = GameScreen.player2CardSet.get(i);
                        GameScreen.player2PublishedCard.add(selectedCard);
                        if (selectedCard.cardType != "Property") {
                            GameScreen.moveCard(g, selectedCard, selectedCard.getLocation(), new Point(100, 350));
                        }
                        GameScreen.player2CardSet.remove(selectedCard);
                        selectedCard.used(gameScreen);
                    }
                }
            }

            this.interrupt();
        }else if (GameListener.isPlayer2LayoutPropertyTo1) {
            GameListener.isPlayer2LayoutPropertyTo1 = false;
            System.out.println("shuliang:"+GameScreen.player2PropertySet1Color.size());
            if(GameScreen.player2PropertySet1Color.size()==0) {
                Property selectedCard = (Property) GameScreen.player2PublishedCard.get(0);
                GameScreen.LayoutProperty(g, 1, selectedCard);
                GameScreen.player2PropertySet1Color.addAll(judgeColor(selectedCard));
                gameScreen.button[2].setVisible(false);
                gameScreen.button[3].setVisible(false);
                gameScreen.button[4].setVisible(false);
                GameScreen.player2PublishedCard.remove(0);
                this.interrupt();
            }else{
                System.out.println("yansebutong");
                GameScreen.updateText("颜色不同，放不进去");
                Property selectedCard = (Property) GameScreen.player2PublishedCard.get(0);
                for (ColorEnum colorEnum1 : selectedCard.colorArray) {
                    for (ColorEnum colorEnum2 : GameScreen.player2PropertySet1Color) {
                        if(colorEnum1 == colorEnum2){
                            GameScreen.LayoutProperty(g, 1, selectedCard);
                            GameScreen.player2PublishedCard.remove(0);
                            this.interrupt();
                        }else {
                            GameScreen.updateText("no");
                            GameScreen.player2PublishedCard.remove(0);
                            this.interrupt();
                        }

                    }
                }
            }
            this.interrupt();
        } else if (GameListener.isPlayer2LayoutPropertyTo2) {
            GameListener.isPlayer2LayoutPropertyTo2 = false;
            System.out.println("shuliang:"+GameScreen.player2PropertySet2Color.size());
            if(GameScreen.player2PropertySet2Color.size()==0) {
                Property selectedCard = (Property) GameScreen.player2PublishedCard.get(0);
                GameScreen.LayoutProperty(g, 2, selectedCard);
                GameScreen.player2PropertySet2Color.addAll(judgeColor(selectedCard));
                gameScreen.button[2].setVisible(false);
                gameScreen.button[3].setVisible(false);
                gameScreen.button[4].setVisible(false);
                GameScreen.player2PublishedCard.remove(0);
                this.interrupt();
            }else{
                System.out.println("yansebutong");
                GameScreen.updateText("颜色不同，放不进去");
                Property selectedCard = (Property) GameScreen.player2PublishedCard.get(0);
                for (ColorEnum colorEnum1 : selectedCard.colorArray) {
                    for (ColorEnum colorEnum2 : GameScreen.player2PropertySet2Color) {
                        if(colorEnum1 == colorEnum2){
                            GameScreen.LayoutProperty(g, 2, selectedCard);
                            GameScreen.player2PublishedCard.remove(0);
                            this.interrupt();
                        }else {
                            GameScreen.updateText("no");
                            GameScreen.player2PublishedCard.remove(0);
                            this.interrupt();
                        }
                    }
                }
            }
            this.interrupt();
        }else if (GameListener.isPlayer2LayoutPropertyTo3) {
            GameListener.isPlayer2LayoutPropertyTo3 = false;
            System.out.println("shuliang:"+GameScreen.player2PropertySet3Color.size());
            if(GameScreen.player2PropertySet3Color.size()==0) {
                Property selectedCard = (Property) GameScreen.player2PublishedCard.get(0);
                GameScreen.LayoutProperty(g, 3, selectedCard);
                GameScreen.player2PropertySet3Color.addAll(judgeColor(selectedCard));
                gameScreen.button[2].setVisible(false);
                gameScreen.button[3].setVisible(false);
                gameScreen.button[4].setVisible(false);
                GameScreen.player2PublishedCard.remove(0);
                this.interrupt();
            }else{
                System.out.println("yansebutong");
                GameScreen.updateText("颜色不同，放不进去");
                Property selectedCard = (Property) GameScreen.player2PublishedCard.get(0);
                for (ColorEnum colorEnum1 : selectedCard.colorArray) {
                    for (ColorEnum colorEnum2 : GameScreen.player2PropertySet3Color) {
                        if(colorEnum1 == colorEnum2){
                            GameScreen.LayoutProperty(g, 3, selectedCard);
                            GameScreen.player2PublishedCard.remove(0);
                            this.interrupt();
                        }else {
                            GameScreen.updateText("no");
                            GameScreen.player2PublishedCard.remove(0);
                            this.interrupt();
                        }
                    }
                }
            }
            this.interrupt();
        }else if (GameListener.isPlayer1AbandonCard) {
            GameListener.isPlayer1AbandonCard = false;
            for (int i = 0; i < GameScreen.player1CardSet.size(); i++) {
                if (GameScreen.player1CardSet.get(i).isClicked()) {
                    Card selectedCard = GameScreen.player1CardSet.get(i);
                    GameScreen.moveCard(g, selectedCard, selectedCard.getLocation(), new Point(100, 350));
                    GameScreen.player1CardSet.remove(selectedCard);
                    GameScreen.reLayCard(g,GameScreen.player1CardSet);
                }
            }
            this.interrupt();
        }else if (GameListener.isBeginPlayer1Turn) {
            GameListener.isBeginPlayer1Turn=false;
            GameScreen.player1PublishedCardNumPerTurn=1;
            GameScreen.button[5].setVisible(false);
            GameScreen.playerturn = 1;
            GameScreen.getTwoNewCard(g);
            for (int i = 0; i < GameScreen.player1CardSet.size(); i++) {
                GameScreen.player1CardSet.get(i).turnFront();
                GameScreen.player1CardSet.get(i).canClick = true;
            }
            for (int i = 0; i < GameScreen.player1PropertySet.size(); i++) {
                if(i == 1){
                    for (int j = 0; j < GameScreen.player1PropertySet1.size(); j++) {
                        GameScreen.player1PropertySet1.get(j).turnFront();
                    }
                } else if (i == 2) {
                    for (int j = 0; j < GameScreen.player1PropertySet2.size(); j++) {
                        GameScreen.player1PropertySet2.get(j).turnFront();
                    }
                }else if (i == 3) {
                    for (int j = 0; j < GameScreen.player1PropertySet3.size(); j++) {
                        GameScreen.player1PropertySet3.get(j).turnFront();
                    }
                }
            }
            GameScreen.button[6].setVisible(true);
            GameScreen.button[7].setVisible(true);
            this.interrupt();
        }else if (GameListener.isEndPlayer1Turn) {
            GameListener.isEndPlayer1Turn = false;

            GameScreen.button[5].setVisible(false);
            GameScreen.button[8].setVisible(true);
            for (int i = 0; i < GameScreen.player1CardSet.size(); i++) {
                GameScreen.player1CardSet.get(i).turnRear();
                GameScreen.player1CardSet.get(i).canClick = false;
            }
            for (int i = 0; i < GameScreen.player1PropertySet.size(); i++) {
                if(i == 1){
                    for (int j = 0; j < GameScreen.player1PropertySet1.size(); j++) {
                        GameScreen.player1PropertySet1.get(j).turnFront();
                    }
                } else if (i == 2) {
                    for (int j = 0; j < GameScreen.player1PropertySet2.size(); j++) {
                        GameScreen.player1PropertySet2.get(j).turnFront();
                    }
                }else if (i == 3) {
                    for (int j = 0; j < GameScreen.player1PropertySet3.size(); j++) {
                        GameScreen.player1PropertySet3.get(j).turnFront();
                    }
                }
            }
            GameScreen.button[6].setVisible(false);
            GameScreen.button[7].setVisible(false);
            this.interrupt();
        } else if (GameListener.isBeginPlayer2Turn) {
            GameListener.isBeginPlayer2Turn=false;
            GameScreen.button[8].setVisible(false);

            GameScreen.playerturn = 2;
            GameScreen.getTwoNewCard(g);
            for (int i = 0; i < GameScreen.player2CardSet.size(); i++) {
                GameScreen.player2CardSet.get(i).turnFront();
                GameScreen.player2CardSet.get(i).canClick = true;
            }
            for (int i = 0; i < GameScreen.player2PropertySet.size(); i++) {
                if(i == 1){
                    for (int j = 0; j < GameScreen.player2PropertySet1.size(); j++) {
                        GameScreen.player2PropertySet1.get(j).turnFront();
                    }
                } else if (i == 2) {
                    for (int j = 0; j < GameScreen.player2PropertySet2.size(); j++) {
                        GameScreen.player2PropertySet2.get(j).turnFront();
                    }
                }else if (i == 3) {
                    for (int j = 0; j < GameScreen.player2PropertySet3.size(); j++) {
                        GameScreen.player2PropertySet3.get(j).turnFront();
                    }
                }
            }
            GameScreen.button[9].setVisible(true);
            GameScreen.button[10].setVisible(true);
            this.interrupt();
        }else if (GameListener.isEndPlayer2Turn) {
            GameListener.isEndPlayer2Turn = false;
            GameScreen.button[8].setVisible(false);
            GameScreen.button[5].setVisible(true);
            for (int i = 0; i < GameScreen.player2CardSet.size(); i++) {
                GameScreen.player2CardSet.get(i).turnRear();
                GameScreen.player2CardSet.get(i).canClick = false;
            }
            for (int i = 0; i < GameScreen.player1PropertySet.size(); i++) {
                if(i == 1){
                    for (int j = 0; j < GameScreen.player1PropertySet1.size(); j++) {
                        GameScreen.player1PropertySet1.get(j).turnFront();
                    }
                } else if (i == 2) {
                    for (int j = 0; j < GameScreen.player1PropertySet2.size(); j++) {
                        GameScreen.player1PropertySet2.get(j).turnFront();
                    }
                }else if (i == 3) {
                    for (int j = 0; j < GameScreen.player1PropertySet3.size(); j++) {
                        GameScreen.player1PropertySet3.get(j).turnFront();
                    }
                }
            }
            GameScreen.button[9].setVisible(false);
            GameScreen.button[10].setVisible(false);
            this.interrupt();
        }
    }

    public static ArrayList<ColorEnum> judgeColor(Card card){
        ArrayList<ColorEnum> colorList= new ArrayList<ColorEnum>();
        if(card instanceof BlueProperty){
            colorList.add(ColorEnum.BLUE);
        }else if(card instanceof GreenProperty){
            colorList.add(ColorEnum.GREEN);
        }else if(card instanceof LightBlueProperty){
            colorList.add(ColorEnum.LIGHTBLUE);
        }else if(card instanceof RedProperty){
            colorList.add(ColorEnum.RED);
        }else if(card instanceof UtilityProperty){
            colorList.add(ColorEnum.UTILITY);
        }else if(card instanceof YellowProperty){
            colorList.add(ColorEnum.YELLOW);
        }else if(card instanceof OrangeProperty){
            colorList.add(ColorEnum.ORANGE);
        }else if(card instanceof BrownProperty){
            colorList.add(ColorEnum.BROWN);
        }else if(card instanceof PurpleProperty){
            colorList.add(ColorEnum.PURPLE);
        }else if(card instanceof PurOraProperty){
            colorList.add(ColorEnum.PURPLE);
            colorList.add(ColorEnum.ORANGE);
        }else if(card instanceof BroLigProperty){
            colorList.add(ColorEnum.LIGHTBLUE);
            colorList.add(ColorEnum.BROWN);
        }else if(card instanceof LigRaiProperty){
            colorList.add(ColorEnum.LIGHTBLUE);
            colorList.add(ColorEnum.RAILROAD);
        }else if(card instanceof GreBluProperty){
            colorList.add(ColorEnum.GREEN);
            colorList.add(ColorEnum.BLUE);
        }else if(card instanceof RaiGreProperty){
            colorList.add(ColorEnum.GREEN);
            colorList.add(ColorEnum.RAILROAD);
        }else if(card instanceof RedYelProperty){
            colorList.add(ColorEnum.RED);
            colorList.add(ColorEnum.YELLOW);
        }else if(card instanceof RaiUtiProperty){
            colorList.add(ColorEnum.UTILITY);
            colorList.add(ColorEnum.RAILROAD);
        }else if(card instanceof MultifyWildProperty){
            colorList.add(ColorEnum.LIGHTBLUE);
            colorList.add(ColorEnum.RAILROAD);
            colorList.add(ColorEnum.BLUE);
            colorList.add(ColorEnum.BROWN);
            colorList.add(ColorEnum.RED);
            colorList.add(ColorEnum.YELLOW);
            colorList.add(ColorEnum.ORANGE);
            colorList.add(ColorEnum.UTILITY);
            colorList.add(ColorEnum.PURPLE);
            colorList.add(ColorEnum.GREEN);
        }
        return colorList;
    }
}
