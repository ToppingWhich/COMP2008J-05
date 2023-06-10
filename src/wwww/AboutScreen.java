package wwww;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AboutScreen extends JPanel implements ActionListener {

    public static JButton button[] = new JButton[2];
    AboutScreen() {
        setLayout(null);
        MenuListener menuListener = new MenuListener();
        button[0] = addButton(menuListener,"EXIT",800,100,400,740,50);
        button[1] = addButton(menuListener,"BACK MENU",800,100,400,300,50);
        add(button[0]);
        add(button[1]);
    }

    protected void paintComponent(Graphics g) {
        try {
            g.drawImage(ImageIO.read(new File("src/images/back.png")), 0, 0, getWidth(),getHeight(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        showTextMid("Game Rules",g,100);
    }//ooooooo

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
        graphics.drawString(text, x, y);
    }
//上传侧手
    JButton addButton(MenuListener menuListener, String text, int width, int height, int x, int y, int size){
        JButton button1 = new JButton(text);
        button1.setBounds(x, y, width, height);
        button1.addActionListener(menuListener);
        button1.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, size);
        button1.setFont(font);
        return button1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


