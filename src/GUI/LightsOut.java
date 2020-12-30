package GUI;
import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.awt.BorderLayout;
import javax.swing.JPanel;

//add timer
//solution


public class LightsOut
{
    //private Container window;
    public JButton[][] buttonList = new JButton[5][5];
    public volatile boolean gameDone = false;
    private Timer timer = new Timer("timer: ");
    private int count = 0;

    JRadioButton solution = new JRadioButton("Solution");
    JRadioButton random = new JRadioButton("Random");
    JRadioButton reset = new JRadioButton("Reset");
    JLabel clicks = new JLabel();
    JFrame window = new JFrame();


    public LightsOut()
    {
        window.setLayout(new GridLayout(0,5));
        for (int i = 0; i < buttonList.length; i++)
        {// Generates tiles and adds listeners to each button.
            for (int j = 0; j < buttonList.length; j++)
            {
                buttonList[i][j] = new JButton("");
                buttonList[i][j].setBackground(Color.white);
                buttonList[i][j].addActionListener(new ButtonPress());
                window.add(buttonList[i][j],BorderLayout.CENTER);
            }
        }
        window.add(clicks);
        window.add(solution);
        window.add(reset);
        window.add(random);
        window.setSize(5*100, 5*100); // size of each box

        reset.addActionListener(new reset());
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random ranGen = new Random(); // randomize
                for (JButton[] buttonrow : buttonList)
                {
                    for (JButton button : buttonrow)
                    {
                        boolean temp = ranGen.nextBoolean();
                        if (temp)
                        {
                            button.doClick();
                        }
                    }
                }
            }
        });
        window.repaint();
        window.setVisible(true);
    }
    public class ButtonPress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ea) {
            boolean done = false;
            int x = 0;
            int y = 0;
            count++;
            clicks.setText("clicks"+count);


            for (int i = 0; i < buttonList.length; i++) {
                for (int j = 0; j < buttonList[i].length; j++) {
                    if (((JButton) ea.getSource()).equals(buttonList[i][j])) {
                        done = true;
                        x = i;
                        y = j;
                        break;
                    }
                }
                if (done) {
                    break;
                }
            }
            switchColor(buttonList[x][y]);
            if (x > 0) {// Check if there is a space available to the left of the selected tile
                switchColor(buttonList[x - 1][y]);
            }
            if (x < buttonList.length - 1) {// Check if there is a space available to the right of the selected tile
                switchColor(buttonList[x + 1][y]);
            }
            if (y > 0) {// Check if there is a space available to the top of the selected tile
                switchColor(buttonList[x][y - 1]);
            }
            if (y < buttonList[x].length - 1) {// Check if there is a space available to the bottom of the selected tile
                switchColor(buttonList[x][y + 1]);
            }
            if (checkWin()) {// Checks for a winner and executes freeze and toggles gameDone variable
                for (JButton[] buttonrow : buttonList) {
                    for (JButton button : buttonrow) {
                        button.setBackground(Color.green);
                        button.setEnabled(false);
                        gameDone = true;
                    }
                }
            }
        }
    }

        private boolean checkWin() {// Checks for all tiles to be black
            // TODO Auto-generated method stub
            for (JButton[] buttonrow : buttonList)
            {
                for (JButton button : buttonrow)
                {
                    if (button.getBackground() == Color.white)
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        public void switchColor(JButton button)
        {// Used to switch color from black to white or vice versa.
            if (button.getBackground().equals(Color.black))
            {
                button.setBackground(Color.white);
            } else
                {
                button.setBackground(Color.black);
            }
        }


    public class reset implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            for (JButton[] buttonrow : buttonList)
            {
                for (JButton button : buttonrow)
                {
                    button.setBackground(Color.white);
                }
            }
        }
    }

    public void setDefaultCloseOperation(int exitOnClose) {
    }

    public void dispose() {
    }

}

