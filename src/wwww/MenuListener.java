package wwww;

import java.awt.event.*;

public class MenuListener implements ActionListener {
    public static boolean about;
    public static boolean exit;
    public static boolean menu;
    public static boolean newGame;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MenuScreen.button[1] ){
            about = true;
        }else if (e.getSource() == MenuScreen.button[0]|| e.getSource() == AboutScreen.button[0]||e.getSource() == GameScreen.button[0]){
            exit =true;
        }else if (e.getSource() == MenuScreen.button[2]){
            newGame = true;
        }else if (e.getSource() == AboutScreen.button[1] ) {
            menu = true;
        }
    }
}
