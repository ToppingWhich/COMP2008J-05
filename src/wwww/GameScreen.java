package wwww;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GameScreen extends JPanel implements ActionListener {

    public static ArrayList<ColorEnum> player1PropertySet1Color = new ArrayList<ColorEnum>();
    public static ArrayList<ColorEnum> player1PropertySet2Color= new ArrayList<ColorEnum>();;
    public static ArrayList<ColorEnum> player1PropertySet3Color= new ArrayList<ColorEnum>();;

    public static ArrayList<ColorEnum> player2PropertySet1Color= new ArrayList<ColorEnum>();;
    public static ArrayList<ColorEnum> player2PropertySet2Color= new ArrayList<ColorEnum>();;
    public static ArrayList<ColorEnum> player2PropertySet3Color= new ArrayList<ColorEnum>();;

    public static int player1PublishedCardNumPerTurn = 0;
    public static int player2PublishedCardNumPerTurn = 0;

    public static int playerturn = 0;
    public static int player1Money = 0;
    public static int player2Money = 0;

    public static JLabel label;
    static ArrayList<Card> cardBox = new ArrayList();
    static ArrayList<Card> player1CardSet = new ArrayList();
    static ArrayList<Card> player2CardSet = new ArrayList();
    static ArrayList<Card> player1PublishedCard = new ArrayList();
    static ArrayList<Card> player2PublishedCard = new ArrayList();

    static ArrayList<ArrayList<Card>> player1PropertySet = new ArrayList();
    static ArrayList<Card> player1PropertySet1 = new ArrayList();
    static ArrayList<Card> player1PropertySet2 = new ArrayList();
    static ArrayList<Card> player1PropertySet3 = new ArrayList();

    static ArrayList<ArrayList<Card>> player2PropertySet = new ArrayList();
    static ArrayList<Card> player2PropertySet1 = new ArrayList();
    static ArrayList<Card> player2PropertySet2 = new ArrayList();
    static ArrayList<Card> player2PropertySet3 = new ArrayList();


    static ArrayList<Card> player1bank = new ArrayList();
    static ArrayList<Card> player2bank = new ArrayList();


    public static JButton button[] = new JButton[30];
    GameScreen() {
        setLayout(null);
        MenuListener menuListener = new MenuListener();
        GameListener gameListener = new GameListener(this);
        button[0] = addButton(menuListener,"EXIT",80,30,10,10,10);
        button[1] = addButton(gameListener,"开始发牌",80,30,900,400,10);
        button[0].setVisible(true);
        button[1].setVisible(true);

        add(button[0]);
        add(button[1]);

        button[2] = addButton(gameListener,"放置1",80,30,1100,750,10);
        button[3] = addButton(gameListener,"放置2",80,30,1200,750,10);
        button[4] = addButton(gameListener,"放置3",80,30,1300,750,10);

        add(button[2]);
        add(button[3]);
        add(button[4]);


        button[11] = addButton(gameListener,"放置1",80,30,100,10,10);
        button[12] = addButton(gameListener,"放置2",80,30,200,10,10);
        button[13] = addButton(gameListener,"放置3",80,30,300,10,10);

        add(button[11]);
        add(button[12]);
        add(button[13]);

        //玩家1开始回合
        button[5] = addButton(gameListener,"开始回合",80,30,900,400,10);
        add(button[5]);
        //玩家2开始回合
        button[8] = addButton(gameListener,"开始回合",80,30,900,400,10);
        add(button[8]);

        //玩家1出牌
        button[6] = addButton(gameListener,"出牌",80,30,900,400,10);
        add(button[6]);

        //玩家1结束回合
        button[7] = addButton(gameListener,"结束回合",80,30,1100,400,10);
        add(button[7]);

        //玩家2出牌
        button[9] = addButton(gameListener,"出牌",80,30,900,300,10);
        add(button[9]);

        //玩家2结束回合
        button[10] = addButton(gameListener,"结束回合",80,30,1100,300,10);
        add(button[10]);

        //玩家一强制交易
        button[14] = addButton(gameListener,"交换",80,30,1300,400,10);
        add(button[14]);

        //玩家1存钱进入银行
        button[15] = addButton(gameListener,"银行",80,30,1300,400,10);
        add(button[15]);

        //玩家2存钱进入银行
        button[16] = addButton(gameListener,"银行",80,30,1300,300,10);
        add(button[16]);


        button[17] = addButton(gameListener,"拿来主义",80,30,1300,400,10);
        add(button[17]);

        button[18] = addButton(gameListener,"拿来主义",80,30,1300,300,10);
        add(button[18]);

        //玩家一丢弃牌
        button[19] = addButton(gameListener,"弃牌",80,30,1300,400,10);
        add(button[19]);

        //玩家2存钱进入银行
        button[20] = addButton(gameListener,"弃牌",80,30,1300,300,10);
        add(button[20]);


        label = new JLabel();
        label.setSize(700, 50);
        label.setLocation(300, 420);
        label.setFont(new Font("仿宋", Font.BOLD, 22));
        label.setText("请点击“开始发牌“");

        label.setForeground(new Color(0x005708));
        add(label);

        player1PropertySet.add(player1PropertySet1);
        player1PropertySet.add(player1PropertySet2);
        player1PropertySet.add(player1PropertySet3);

        player2PropertySet.add(player2PropertySet1);
        player2PropertySet.add(player2PropertySet2);
        player2PropertySet.add(player2PropertySet3);

    }

    public static void updateText(String text) {
        label.setText(text);
    }


    protected void paintComponent(Graphics g) {
        //创建背景
        try {
            g.drawImage(ImageIO.read(new File("src/images/back.png")), 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //准备牌盒子
        createCardBox();
        Collections.shuffle(cardBox);
        for (int i = 0; i < cardBox.size(); i++) {
            add(cardBox.get(i));
            //drawCard(g,cardBox.get(i));
        }

        //准备头像
        Head player1 = createHead(this, "Player1", 10, 550);
        Head player2 = createHead(this, "Player2", 1400, 250);
        add(player1);
        add(player2);
        //发牌


        //开始回合按钮

    }

    public void createCardBox(){
        int x = (getWidth()-140)/2;
        int y = (getHeight()-240)/2;
        for (int i = 0; i < 4; i++) {
            createCard(this,"强制交易",false,x,y,cardBox);
        }
        for (int i = 0; i < 11; i++) {
            createCard(this,"通行证",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createCard(this,"彩色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 3; i++) {
            createCard(this,"绿色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createCard(this,"蓝色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 3; i++) {
            createCard(this,"浅蓝色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 3; i++) {
            createCard(this,"红色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 4; i++) {
            createCard(this,"铁路地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 3; i++) {
            createCard(this,"黄色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 3; i++) {
            createCard(this,"橙色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createCard(this,"棕色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 3; i++) {
            createCard(this,"紫色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createCard(this,"设施地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createCard(this,"紫色-橙色地产",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createCard(this,"红色-黄色地产",false,x,y,cardBox);
        }
        createCard(this,"棕色-浅蓝色地产",false,x,y,cardBox);
        createCard(this,"浅蓝色-铁路地产",false,x,y,cardBox);
        createCard(this,"绿色-蓝色地产",false,x,y,cardBox);
        createCard(this,"铁路-绿色地产",false,x,y,cardBox);
        createCard(this,"铁路-设施地产",false,x,y,cardBox);
        for (int i = 0; i < 2; i++) {
            createRent(this,"紫色-橙色租金","紫色-橙色租金",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createRent(this,"铁路-设施租金","铁路-设施租金",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createRent(this,"绿色-蓝色租金","绿色-蓝色租金",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createRent(this,"棕色-浅蓝色租金","棕色-浅蓝色租金",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createRent(this,"红色-黄色租金","红色-黄色租金",false,x,y,cardBox);
        }
        for (int i = 0; i < 3; i++) {
            createRent(this,"彩色租金","彩色租金",false,x,y,cardBox);
        }
        for (int i = 0; i < 6; i++) {
            createCash(this,1,"1M",false,x,y,cardBox);
        }
        for (int i = 0; i < 5; i++) {
            createCash(this,2,"2M",false,x,y,cardBox);
        }
        for (int i = 0; i < 3; i++) {
            createCash(this,4,"4M",false,x,y,cardBox);
        }
        for (int i = 0; i < 3; i++) {
            createCash(this,3,"3M",false,x,y,cardBox);
        }
        for (int i = 0; i < 2; i++) {
            createCash(this,5,"5M",false,x,y,cardBox);
        }
        createCash(this,10,"10M",false,x,y,cardBox);
        for (int i = 0; i < 20; i++) {
            createCard(this,"物业接管",false,x,y,cardBox);
        }


    }

    public void createCard(GameScreen gameScreen,String name, boolean up, int x, int y, ArrayList<Card> cardSet){
        Card card = null;
        if(name == "彩色地产") {
            card = new MultifyWildProperty(gameScreen, name, false);
        }else if (name =="蓝色地产"){
            card = new BlueProperty(gameScreen,name,false);
        }else if (name=="强制交易"){
            card = new ForceDeal(gameScreen,name,false);
        }else if (name=="通行证"){
            card = new PassGo(gameScreen,name,false);
        }else if (name=="红色地产"){
            card = new RedProperty(gameScreen,name,false);
        }else if (name=="绿色地产"){
            card = new GreenProperty(gameScreen,name,false);
        }else if (name=="紫色地产"){
            card = new PurpleProperty(gameScreen,name,false);
        }else if (name=="棕色地产"){
            card = new BrownProperty(gameScreen,name,false);
        }else if (name=="黄色地产"){
            card = new YellowProperty(gameScreen,name,false);
        }else if (name=="浅蓝色地产"){
            card = new LightBlueProperty(gameScreen,name,false);
        }else if (name=="铁路地产"){
            card = new RailroadProperty(gameScreen,name,false);
        }else if (name=="设施地产"){
            card = new UtilityProperty(gameScreen,name,false);
        }else if (name=="橙色地产"){
            card = new OrangeProperty(gameScreen,name,false);
        }else if (name=="紫色-橙色地产"){
            card = new PurOraProperty(gameScreen,name,false);
        }else if (name=="棕色-浅蓝色地产"){
            card = new BroLigProperty(gameScreen,name,false);
        }else if (name=="浅蓝色-铁路地产"){
            card = new LigRaiProperty(gameScreen,name,false);
        }else if (name=="绿色-蓝色地产"){
            card = new GreBluProperty(gameScreen,name,false);
        }else if (name=="铁路-绿色地产"){
            card = new RaiGreProperty(gameScreen,name,false);
        }else if (name=="红色-黄色地产"){
            card = new RedYelProperty(gameScreen,name,false);
        }else if (name=="铁路-设施地产"){
            card = new RaiUtiProperty(gameScreen,name,false);
        }else if (name=="物业接管"){
            card = new DealBreaker(gameScreen,name,false);
        }
        card.setLocation(x, y);
        cardSet.add(card);
    }

    public void createCash(GameScreen gameScreen,int value,String name, boolean up, int x, int y, ArrayList<Card> cardSet) {
        Card card = null;
        card = new Cash(gameScreen,name,false,value);
        card.setLocation(x, y);
        cardSet.add(card);
    }
    public void createRent(GameScreen gameScreen,String color, String name, boolean up, int x, int y, ArrayList<Card> cardSet) {
        Card card = null;
        card = new Rent(gameScreen,name,false,color);
        card.setLocation(x, y);
        cardSet.add(card);
    }

    public Head createHead(GameScreen gameScreen,String name, int x,int y){
        Head head = new Head(gameScreen,name);
        head.setLocation(x,y);
        return head;
    }

    JButton addButton(ActionListener actionListener, String text, int width, int height, int x, int y, int size){
        JButton button1 = new JButton(text);
        button1.setBounds(x, y, width, height);
        button1.addActionListener(actionListener);
        button1.setVisible(false);
        Font font = new Font("仿宋", Font.BOLD, size);
        button1.setFont(font);
        return button1;
    }


    public static void getTwoNewCard(Graphics g){
        if(playerturn == 1) {
            for (int i = 0; i < 2; i++) {
                player1CardSet.add(cardBox.get(i));
                cardBox.remove(i);
                //moveCard(g, player1CardSet.get(i), player1CardSet.get(i).getLocation(), new Point(10 + (player1CardSet.size()-2+i) * 100, 600));
            }
            for (int i = 0; i < player1CardSet.size(); i++) {
                moveCard(g, player1CardSet.get(i), player1CardSet.get(i).getLocation(), new Point(10 + i * 100, 600));

            }
        }
        if(playerturn == 2) {
            for (int i = 0; i < 2; i++) {
                player2CardSet.add(cardBox.get(i));
                cardBox.remove(i);
                //moveCard(g, player1CardSet.get(i), player1CardSet.get(i).getLocation(), new Point(10 + (player1CardSet.size()-2+i) * 100, 600));
            }
            for (int i = 0; i < player2CardSet.size(); i++) {
                moveCard(g, player2CardSet.get(i), player2CardSet.get(i).getLocation(), new Point(1300 - i * 100, 10));

            }
        }
    }

    public static void LayoutProperty(Graphics g,int propertySetIndex,Card card) {
        if (playerturn == 1) {
            if(propertySetIndex == 1) {
                player1PropertySet1.add(card);
                player1CardSet.remove(card);
            }else if (propertySetIndex == 2){
                player1PropertySet2.add(card);
                player1CardSet.remove(card);
            }else if (propertySetIndex == 3){
                player1PropertySet3.add(card);
                player1CardSet.remove(card);
            }
            for (int i = 0; i < player1CardSet.size(); i++) {
                moveCard(g, player1CardSet.get(i), player1CardSet.get(i).getLocation(), new Point(10 + i * 100, 600));
            }
            for (int i = 0; i < player1PropertySet1.size(); i++) {
                moveCard(g, player1PropertySet1.get(i), player1PropertySet1.get(i).getLocation(), new Point(1090, 450+i*45));
            }
            for (int i = 0; i < player1PropertySet2.size(); i++) {
                moveCard(g, player1PropertySet2.get(i), player1PropertySet2.get(i).getLocation(), new Point(1220, 450+i*45));
            }
            for (int i = 0; i < player1PropertySet3.size(); i++) {
                moveCard(g, player1PropertySet3.get(i), player1PropertySet3.get(i).getLocation(), new Point(1350, 450+i*45));
            }
        } else if (playerturn == 2) {
            if(propertySetIndex == 1) {
                player2PropertySet1.add(card);
                player2CardSet.remove(card);
            }else if (propertySetIndex == 2){
                player2PropertySet2.add(card);
                player2CardSet.remove(card);
            }else if (propertySetIndex == 3){
                player2PropertySet3.add(card);
                player2CardSet.remove(card);
            }
            for (int i = 0; i < player2CardSet.size(); i++) {
                moveCard(g, player2CardSet.get(i), player2CardSet.get(i).getLocation(), new Point(1300 - i * 100, 10));
            }
            for (int i = 0; i < player2PropertySet1.size(); i++) {
                moveCard(g, player2PropertySet1.get(i), player2PropertySet1.get(i).getLocation(), new Point(10, 10+i*45));
            }
            for (int i = 0; i < player2PropertySet2.size(); i++) {
                moveCard(g, player2PropertySet2.get(i), player2PropertySet2.get(i).getLocation(), new Point(140, 10+i*45));
            }
            for (int i = 0; i < player2PropertySet3.size(); i++) {
                moveCard(g, player2PropertySet3.get(i), player2PropertySet3.get(i).getLocation(), new Point(270, 10+i*45));
            }
        }
    }
    public static  void reLayCard(Graphics g,ArrayList<Card> cardSet){
        if(playerturn==1) {
            for (int i = 0; i < cardSet.size(); i++) {
                moveCard(g, cardSet.get(i), cardSet.get(i).getLocation(), new Point(10 + i * 100, 600));
            }
        }
    }

    public static void LayoutCash(Graphics g,Card card) {
        if (playerturn == 1) {
            player1bank.add(card);
            player1CardSet.remove(card);
            player1Money += card.value;
            for (int i = 0; i < player1CardSet.size(); i++) {
                moveCard(g, player1CardSet.get(i), player1CardSet.get(i).getLocation(), new Point(10 + i * 100, 600));
            }
            for (int i = 0; i < player1bank.size(); i++) {
                moveCard(g, player1bank.get(i), player1bank.get(i).getLocation(), new Point(880, 350+i*50));
            }
            if(Cash.value==1){
                Cash.sum1+=1;
            }else if(Cash.value==2){
                Cash.sum1+=2;
            }else if(Cash.value==3){
                Cash.sum1+=3;
            }else if(Cash.value==4){
                Cash.sum1+=4;
            }else if(Cash.value==5){
                Cash.sum1+=5;
            }else if(Cash.value==10){
                Cash.sum1+=10;
            }
            System.out.println(Cash.getSum1());
        } else if (playerturn == 2) {
            player2bank.add(card);
            player2CardSet.remove(card);
            player2Money += card.value;
            for (int i = 0; i < player2CardSet.size(); i++) {
                moveCard(g, player2CardSet.get(i), player2CardSet.get(i).getLocation(), new Point(1300 - i * 100, 10));
            }
            for (int i = 0; i < player2bank.size(); i++) {
                moveCard(g, player2bank.get(i), player2bank.get(i).getLocation(), new Point(10, 350+i*50));
            }
            if(Cash.value==1){
                Cash.sum2+=1;
            }else if(Cash.value==2){
                Cash.sum2+=2;
            }else if(Cash.value==3){
                Cash.sum2+=3;
            }else if(Cash.value==4){
                Cash.sum2+=4;
            }else if(Cash.value==5){
                Cash.sum2+=5;
            }else if(Cash.value==10){
                Cash.sum2+=10;
            }
            System.out.println(Cash.getSum2());
        }
    }

    public static void dealInitCard(Graphics g){
        for (int i = 0; i < 5; i++) {
            player1CardSet.add(cardBox.get(i));
            cardBox.remove(i);
            moveCard(g, player1CardSet.get(i), player1CardSet.get(i).getLocation(), new Point(10 + i * 100, 600));

        }
        for (int i = 0; i < 5; i++) {
            player2CardSet.add(cardBox.get(i));
            cardBox.remove(i);
            moveCard(g, player2CardSet.get(i), player2CardSet.get(i).getLocation(), new Point(1300 - i * 100, 10));

        }
    }
    public static void moveCard(Graphics g,Card card, Point from, Point to) {
        if (to.x != from.x) {
            double k = (1.0) * (to.y - from.y) / (to.x - from.x);
            double b = to.y - to.x * k;
            int flag = 0;
            if (from.x < to.x)
                flag = 20;
            else {
                flag = -20;
            }
            for (int i = from.x; Math.abs(i - to.x) > 20; i += flag) {
                double y = k * i + b;
                card.setLocation(i, (int) y);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        card.setLocation(to);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
