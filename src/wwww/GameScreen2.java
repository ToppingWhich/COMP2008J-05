package wwww;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameScreen2 extends JPanel implements ActionListener {

    protected void paintComponent(Graphics g) {

        //创建背景
        try {
            g.drawImage(ImageIO.read(new File("src/images/back.png")), 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        showTextMid("3人模式",g,100);
    }
    void showTextMid(String text,Graphics graphics,int size){
        Font font = new Font("Arial", Font.BOLD, size);
        graphics.setFont(font);
        // 获取面板的大小
        Dimension panelSize = getSize();
        // 获取文字的宽度和高度
        int textWidth = graphics.getFontMetrics().stringWidth(text);
        int textHeight = graphics.getFontMetrics().getHeight();
        // 计算文字的位置
        int x = (panelSize.width - textWidth) / 2;
        int y = (panelSize.height + textHeight) / 2;
        // 在界面中心绘制文字
        graphics.drawString(text, x, 150);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
