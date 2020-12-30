package GUI;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Main {
    public static int ysize;
    public static int xsize;
    public static boolean notdone = true;

    public static void main(String[] args) {
        LightsOut game = new LightsOut();

        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (game.gameDone == true)
       {
            if (JOptionPane.showConfirmDialog(null, "You Won!\nPlay Again?", "Lights Out",
                    JOptionPane.YES_NO_OPTION) != 0)
            {
                JOptionPane.showMessageDialog(null, "Thanks for Playing!");
                game.dispose();
                break;
            }
            // change the yes option
        }
    }
}