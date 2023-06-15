package wwww;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @Author liwenyan
 * @Date 2023/5/24 18:13
 * @PackageName:wwww
 * @ClassName: Cash
 * @Description: TODO
 * @Version 1.0
 */
public class Cash extends Card{
    GameScreen gameScreen;
    public  static String cardType;
    Graphics g;
    //牌的名字
    String name;
    //牌显示正面还是反面
    boolean up;
    //是否可点击
    boolean canClick;

    //当前状态，是否已经被点击
    boolean clicked;
    public static int value;
    boolean roteted;
    static int sum1;
    static int sum2;

    public Cash(GameScreen gameScreen, String name, boolean up,int value) {
        super(gameScreen, name, up);
        this.value = value;
    }

    public Cash() {
        super();
    }
    public static int getSum1(){
        return sum1;
    }
    public static int getSum2(){
        return sum2;
    }
    @Override
    void used(GameScreen gameScreen) {
        if(GameScreen.playerturn == 1) {
            //显示”银行”按钮
            gameScreen.button[15].setVisible(true);
            this.clicked = false;
        }else if(GameScreen.playerturn == 2) {
            gameScreen.button[16].setVisible(true);
            this.clicked = false;
        }
    }

    public Cash(GameScreen gameScreen, String name, boolean canClick, boolean clicked) {
        super(gameScreen, name, canClick, clicked);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        return new Dimension(size.height, size.width);
    }
    @Override
    public void turnFront() {
//        if(this.roteted){
//            System.out.println("旋转");
//            if (this.value == 1) {
//                this.setIcon(new ImageIcon("src/images/1ro.png"));
//            } else if (this.value == 2) {
//                this.setIcon(new ImageIcon("src/images/2ro.png"));
//            } else if (this.value == 3) {
//                this.setIcon(new ImageIcon("src/images/3ro.png"));
//            } else if (this.value == 4) {
//                this.setIcon(new ImageIcon("src/images/4ro.png"));
//            } else if (this.value == 5) {
//                this.setIcon(new ImageIcon("src/images/5ro.png"));
//            } else if (this.value == 10) {
//                this.setIcon(new ImageIcon("src/images/10ro.png"));
//            }
//        }else {
            if (this.value == 1) {
                this.setIcon(new ImageIcon("src/images/1M-money-card.png"));
            } else if (this.value == 2) {
                this.setIcon(new ImageIcon("src/images/2M-money-card.png"));
            } else if (this.value == 3) {
                this.setIcon(new ImageIcon("src/images/3M-money-card.png"));
            } else if (this.value == 4) {
                this.setIcon(new ImageIcon("src/images/4M-money-card.png"));
            } else if (this.value == 5) {
                this.setIcon(new ImageIcon("src/images/5M-money-card.png"));
            } else if (this.value == 10) {
                this.setIcon(new ImageIcon("src/images/10M-money-card.png"));
            }
        //}
    }


    public void rotate() {
        this.setSize(240,140);
        if (this.value == 1) {
            this.setIcon(new ImageIcon("src/images/1ro.png"));
        } else if (this.value == 2) {
            this.setIcon(new ImageIcon("src/images/2ro.png"));
        } else if (this.value == 3) {
            this.setIcon(new ImageIcon("src/images/3ro.png"));
        } else if (this.value == 4) {
            this.setIcon(new ImageIcon("src/images/4ro.png"));
        } else if (this.value == 5) {
            this.setIcon(new ImageIcon("src/images/5ro.png"));
        } else if (this.value == 10) {
            this.setIcon(new ImageIcon("src/images/10ro.png"));
        }
    }
//    public void rotate() {
//        super.rotate();
//    }
//
//    public void rotate1() {
//        this.setSize(240,140);
//        if (this.value == 1) {
//            this.setIcon(new ImageIcon("src/images/1ro.png"));
//            sum1+=1;
//
//        } else if (this.value == 2) {
//            this.setIcon(new ImageIcon("src/images/2ro.png"));
//            sum1+=2;
//
//        } else if (this.value == 3) {
//            this.setIcon(new ImageIcon("src/images/3ro.png"));
//            sum1+=3;
//
//        } else if (this.value == 4) {
//            this.setIcon(new ImageIcon("src/images/4ro.png"));
//            sum1+=4;
//
//        } else if (this.value == 5) {
//            this.setIcon(new ImageIcon("src/images/5ro.png"));
//            sum1+=5;
//
//        } else if (this.value == 10) {
//            this.setIcon(new ImageIcon("src/images/10ro.png"));
//            sum1+=10;
//        }
//    }
//    public void rotate2() {
//        this.setSize(240,140);
//        if (this.value == 1) {
//            this.setIcon(new ImageIcon("src/images/1ro.png"));
//
//            sum2+=1;
//        } else if (this.value == 2) {
//            this.setIcon(new ImageIcon("src/images/2ro.png"));
//
//            sum2+=2;
//        } else if (this.value == 3) {
//            this.setIcon(new ImageIcon("src/images/3ro.png"));
//
//            sum2+=3;
//        } else if (this.value == 4) {
//            this.setIcon(new ImageIcon("src/images/4ro.png"));
//
//            sum2+=4;
//        } else if (this.value == 5) {
//            this.setIcon(new ImageIcon("src/images/5ro.png"));
//
//            sum2+=5;
//        } else if (this.value == 10) {
//            this.setIcon(new ImageIcon("src/images/10ro.png"));
//            sum2+=10;
//        }
//    }



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

}
