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

        //Create background
        try {
            g.drawImage(ImageIO.read(new File("src/images/back.png")), 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        showTextMid("Three-person model",g,100);
    }
    void showTextMid(String text,Graphics graphics,int size){
        Font font = new Font("Arial", Font.BOLD, size);
        graphics.setFont(font);
        // Gets the size of the panel
        Dimension panelSize = getSize();
        // Gets the width and height of text
        int textWidth = graphics.getFontMetrics().stringWidth(text);
        int textHeight = graphics.getFontMetrics().getHeight();
        // Calculate the position of the text
        int x = (panelSize.width - textWidth) / 2;
        int y = (panelSize.height + textHeight) / 2;
        // Draw text in the center of the interface
        graphics.drawString(text, x, 150);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
