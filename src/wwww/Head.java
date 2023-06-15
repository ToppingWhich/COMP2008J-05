package wwww;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author liwenyan
 * @Date 2023/5/23 13:55
 * @PackageName:wwww
 * @ClassName: Head
 * @Description: TODO
 * @Version 1.0
 */
public class Head extends JLabel implements MouseListener {
    //游戏主界面
    GameScreen gameScreen;

    //牌的名字
    String name;


    //牌显示正面还是反面
    boolean up;
    //是否可点击
    boolean canClick = true;

    //当前状态，是否已经被点击
    boolean clicked = false;

    public Head(GameScreen m, String name) {
        this.gameScreen = m;
        this.name = name;
        //判断当前的牌是显示正面还是背面
        this.turnFront();
        //设置牌的宽高大小
        this.setSize(50, 50);
        //把牌显示出来
        this.setVisible(true);
        //给每一张牌添加鼠标监听
        this.addMouseListener(this);
    }

    public Head(){

    }

    public Head(GameScreen gameScreen, String name, boolean canClick, boolean clicked) {
        this.gameScreen = gameScreen;
        this.name = name;
        this.canClick = canClick;
        this.clicked = clicked;
    }
    //显示正面
    public void turnFront() {
        this.setIcon(new ImageIcon("src/images/熊.jpg"));
        this.up = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (canClick) {
            Point from = this.getLocation();
            int step;
            if (clicked){
                step = 20;
            }else {
                step = -20;
            }
            clicked = !clicked;
            Point to = new Point(from.x, from.y + step);
            this.setLocation(to);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * 获取
     * @return gameJFrame
     */
    public GameScreen getGameScreen() {
        return gameScreen;
    }

    /**
     * 设置
     * @param gameScreen
     */
    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return up
     */
    public boolean isUp() {
        return up;
    }



    /**
     * 设置
     * @param up
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * 获取
     * @return canClick
     */
    public boolean isCanClick() {
        return canClick;
    }

    /**
     * 设置
     * @param canClick
     */
    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    /**
     * 获取
     * @return clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * 设置
     * @param clicked
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

}
