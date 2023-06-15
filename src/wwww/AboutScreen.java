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

//    void showTextMid(String text, Graphics graphics, int size) {
//        Font font = new Font("Arial", Font.BOLD, size);
//        graphics.setFont(font);
//
//        // 获取面板的大小
//        Dimension panelSize = getSize();
//        // 获取文字的高度
//        int textHeight = graphics.getFontMetrics().getHeight();
//
//        // 拆分多行文字
//        String[] lines = text.split("\n");
//
//        // 计算文字的位置
//        int totalTextHeight = lines.length * textHeight;
//        int startY = (panelSize.height - totalTextHeight) / 2;
//
//        // 在界面中心绘制多行文字
//        for (String line : lines) {
//            int textWidth = graphics.getFontMetrics().stringWidth(line);
//            int startX = (panelSize.width - textWidth) / 2;
//
//            graphics.drawString(line, startX, startY);
//
//            // 更新下一行文字的起始位置
//            startY += textHeight;
//        }
//    }

//    void showTextMid(String text,Graphics graphics,int size){
//        Font font = new Font("Arial", Font.BOLD, size);
//        graphics.setFont(font);
//        // 获取面板的大小
//        Dimension panelSize = getSize();
//        // 获取文字的宽度和高度
//        int textWidth = graphics.getFontMetrics().stringWidth(text);
//        int textHeight = graphics.getFontMetrics().getHeight();
//        // 计算文字的位置
//        int x = (panelSize.width - textWidth) / 2;
//        int y = (panelSize.height + textHeight) / 2;
//        // 在界面中心绘制文字
//        graphics.drawString(text, x, y);
//    }


    //void showTextMid(String text, Graphics graphics, int size, int maxWidth) {
//    Font font = new Font("Arial", Font.BOLD, size);
//    graphics.setFont(font);
//    // 获取面板的大小
//    Dimension panelSize = getSize();
//    // 获取文字的高度
//    int textHeight = graphics.getFontMetrics().getHeight();
//    // 按照指定的宽度分割文字
//    List<String> lines = splitText(text, graphics, maxWidth);
//    // 计算文字的起始位置
//    int startY = (panelSize.height - (lines.size() * textHeight)) / 2;
//    // 在界面中心绘制每一行文字
//    for (int i = 0; i < lines.size(); i++) {
//        String line = lines.get(i);
//        int textWidth = graphics.getFontMetrics().stringWidth(line);
//        int startX = (panelSize.width - textWidth) / 2;
//        int y = startY + (i * textHeight);
//        graphics.drawString(line, startX, y);
//    }
//}
//
//    List<String> splitText(String text, Graphics graphics, int maxWidth) {
//        List<String> lines = new ArrayList<>();
//        String[] words = text.split(" ");
//        StringBuilder lineBuilder = new StringBuilder();
//        for (String word : words) {
//            int lineLength = graphics.getFontMetrics().stringWidth(lineBuilder.toString()) + graphics.getFontMetrics().stringWidth(" " + word);
//            System.out.println(lineLength);
//            //int lineLength = graphics.getFontMetrics().stringWidth(lineBuilder.toString() + " " + word);
//            if (lineLength <= maxWidth) {
//                lineBuilder.append(" ").append(word);
//            } else {
//                lines.add(lineBuilder.toString().trim());
//                lineBuilder.setLength(0);
//                lineBuilder.append(word);
//            }
//        }
//        if (lineBuilder.length() > 0) {
//            lines.add(lineBuilder.toString().trim());
//        }
//        return lines;
//    }
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


