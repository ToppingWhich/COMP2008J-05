package wwww;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class MenuScreen extends JPanel implements ActionListener {
    public static JButton button[] = new JButton[11];
    protected void paintComponent(Graphics g) {
        try {
            g.drawImage(ImageIO.read(new File("src/images/back.png")), 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Font titleFont = new Font("Arial", Font.BOLD, 75); // 更改字体样式和大小
        FontMetrics fontMetrics = g.getFontMetrics(titleFont);
        String title = "Monopoly Deal Card Game";
        int titleWidth = fontMetrics.stringWidth(title);
        int titleHeight = fontMetrics.getHeight();
        int x = (getWidth() - titleWidth) / 2-50;
        int y = getHeight() / 4; // 上移标题位置
        g.setColor(Color.RED);
        g.fillRect(x - 10, y - titleHeight, titleWidth + 20, titleHeight + 30); // 绘制背景矩形
        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString(title, x, y); // 绘制标题文本
    }

    MenuScreen() {
        setLayout(null);
        MenuListener menuListener = new MenuListener();
        button[0] = addButton(menuListener,"EXIT",400,75,550,660,50);
        button[1] = addButton(menuListener,"How To Play?",400,75,550,300,50);
        button[2] = addButton(menuListener,"Two Players",400,75,550,390,50);
        button[3] = addButton(menuListener,"Three Players",400,75,550,480,50);
        button[4] = addButton(menuListener,"Four Players",400,75,550,570,50);
        add(button[0]);
        add(button[1]);
        add(button[2]);
        add(button[3]);
        add(button[4]);

    }

    JButton addButton(MenuListener menuListener, String text, int width, int height, int x, int y, int size){
        JButton button1 = new JButton(text);
        button1.setBounds(x, y, width, height);
        button1.setOpaque(true);
        button1.setBorderPainted(true);
        button1.setForeground(new Color(0xAB070707, true));
        button1.addActionListener(menuListener);
        button1.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, size);
        button1.setFont(font);
        return button1;
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


