package wwww;


import java.awt.*;
import java.util.ArrayList;

/**
 * @Author liwenyan
 * @Date 2023/5/13 20:20
 * @PackageName:mdcg.gamepresentation
 * @ClassName: Animation
 * @Description: TODO
 * @Version 1.0
 */
public class Animation {
    public static CardType jugdeType(ArrayList<Card> list) {
        int len = list.size();
        if (len == 1){
            String name = list.get(0).getName();
            if (name == "passGo"){
                System.out.println("pass");
                return CardType.passGo;
            }else if(name == "diChan") {
                return CardType.diChan;
            }
        }
        return null;
    }

    public static void move(Card card, Point from, Point to) {
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

    public static void moveHead(Head head, Point from, Point to) {
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

                head.setLocation(i, (int) y);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        head.setLocation(to);
    }
}
