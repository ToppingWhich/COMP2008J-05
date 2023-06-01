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
            g.drawImage(ImageIO.read(new File("src/images/back.png")), 0, 0, getWidth(),getHeight(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.setColor(Color.RED);
        showTextMid("Monopoly Deal Card Game",g,100);
        //g.drawString("Monopoly Deal Card Game",getWidth()/2,getHeight()/3);
    }
    //1111

    MenuScreen() {
        setLayout(null);
        MenuListener menuListener = new MenuListener();
        button[0] = addButton(menuListener,"EXIT",800,100,400,740,50);
        button[1] = addButton(menuListener,"How To Play?",800,100,400,300,50);
        button[2] = addButton(menuListener,"Two Players",800,100,400,410,50);
        button[3] = addButton(menuListener,"Three Players",800,100,400,520,50);
        button[4] = addButton(menuListener,"Four Players",800,100,400,630,50);
        add(button[0]);
        add(button[1]);
        add(button[2]);
        add(button[3]);
        add(button[4]);

    }

    JButton addButton(MenuListener menuListener, String text, int width, int height, int x, int y, int size){
        JButton button1 = new JButton(text);
        button1.setBounds(x, y, width, height);
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


