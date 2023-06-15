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
        button[1] = addButton(menuListener,"BACK MENU",800,100,400,50,50);
        add(button[0]);
        add(button[1]);
    }

    protected void paintComponent(Graphics g) {
        try {
            g.drawImage(ImageIO.read(new File("src/images/back.png")), 0, 0, getWidth(),getHeight(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        showText("The objective of the game is to be the first player to complete 3 " +
                "full property sets on the table in front of you. Each property card tells " +
                "you how many property cards you need of that color to complete the set. " +
                "For example, the dark blue set only needs 2 dark blue property cards to " +
                "be completed and the black railroad set needs 4 railroad property cards " +
                "to be a completed set.",g,25,80,190,1500);
        showText("There are 3 places where cards can be played during a turn:\n" +
                "1. A player can place money cards or action cards (rent, house, hotel, force deal, pass go, etc) face up in their bank.\n" +
                "2. A player can play property cards face up in front of them in their property section.\n" +
                "3. A player can play action cards in the middle discard pile.",g,30,80,300,1500);
        showText("Each player is dealt 5 cards at the start of the game and then picks up 2 cards " +
                "from the remaining draw pile at the beginning of each turn.\n" +
                "Each player can play up to 3 cards per turn. A play is considered any " +
                "time a card is laid on the table (such as money into your bank, property " +
                "cards on the table, action cards played into the middle, etc). You do not " +
                "need to play all 3 cards per turn if you do not want to.\n" +
                "At the end of each player’s turn, they cannot have more than 7 cards in " +
                "their hand. If they do, they need to discard the excess cards into the discard pile.",g,25,80,500,1500);
        showText("For more information: https://monopolydealrules.com/index.php?page=general#top",g,30,150,730,1500);
    }
    //The method that can display the game rules in the page
    void showText(String text, Graphics graphics, int size, int x, int y, int maxWidth) {
        Font font = new Font("Arial", Font.PLAIN, size);
        graphics.setFont(font);

        String[] lines = text.split("\n");
        int lineHeight = graphics.getFontMetrics().getHeight();
        int currentY = y;

        for (String line : lines) {
            String[] words = line.split(" ");
            StringBuilder currentLine = new StringBuilder(words[0]);

            for (int i = 1; i < words.length; i++) {
                if (graphics.getFontMetrics().stringWidth(currentLine + " " + words[i]) < maxWidth) {
                    currentLine.append(" ").append(words[i]);
                } else {
                    graphics.drawString(currentLine.toString(), x, currentY);
                    currentLine = new StringBuilder(words[i]);
                    currentY += lineHeight;
                }
            }

            graphics.drawString(currentLine.toString(), x, currentY);
            currentY += lineHeight;
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


