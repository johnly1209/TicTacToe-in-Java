import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Test
 */
public class TicTacToe extends JFrame {
    JPanel panel = new JPanel();
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String currentPlayer;
    Font font = new Font(Font.SERIF, Font.BOLD, 100);
    JMenuBar menuBar;
    JMenu mainMenu;
    JMenuItem ResetGame;
    JMenuItem ExitGame;

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
    }

    public void ButtonClicked(ActionEvent e) { // when you click on a button, this method is called
        ((JButton) e.getSource()).setText(currentPlayer);
        ((JButton) e.getSource()).setEnabled(false);

        if (currentPlayer.equals("X")) {
            ((JButton) e.getSource()).setBackground(Color.RED);
        } else {
            ((JButton) e.getSource()).setBackground(Color.GREEN);
        }
        // check for winner??
        // if we do:
        // display a message
        if (DoWeHaveAWinner()) {
            // display a message
            JOptionPane.showMessageDialog(panel, "Congratulations!" + currentPlayer + " wins!!!");

            // diasble all buttons
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }

        SwitchPlayer();
    }

    public boolean CheckThreeButton(JButton a, JButton b, JButton c) {
        return a.getText().equals(btn2.getText())
                && b.getText().equals(btn3.getText())
                && c.getText() != "";
    }

    public boolean DoWeHaveAWinner() {
        // check the first row
        if (CheckThreeButton(btn1, btn2, btn3)) {
            return true;
        }
        // check the second row
        if (CheckThreeButton(btn4, btn5, btn6)) {
            return true;
        }
        // check the third row
        if (CheckThreeButton(btn7, btn8, btn9)) {
            return true;
        }

        // check the first column
        if (CheckThreeButton(btn1, btn4, btn7)) {
            return true;
        }
        // check the second column
        if (CheckThreeButton(btn2, btn5, btn8)) {
            return true;
        }
        // check the third column
        if (CheckThreeButton(btn3, btn6, btn9)) {
            return true;
        }
        // check main diagonal
        if (CheckThreeButton(btn1, btn5, btn9)) {
            return true;
        }
        // check the other diagonal
        if (CheckThreeButton(btn3, btn5, btn7)) {
            return true;
        }
        // all else
        return false;
    }

    public void SwitchPlayer() {
        if (currentPlayer == "X") {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
        // currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public TicTacToe() {
        // super("My First Java Game");
        setTitle("My First Java Game");
        setVisible(true);
        setSize(400, 400);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // add the jpanel to the frame
        setContentPane(panel);

        // set a layout for our panel
        panel.setLayout(new GridLayout(3, 3));

        // build the buttons and add them to the panel
        btn1 = new JButton();
        panel.add(btn1);
        btn1.addActionListener(e -> ButtonClicked(e));
        btn1.setFont(font);

        btn2 = new JButton();
        panel.add(btn2);
        btn2.addActionListener(e -> ButtonClicked(e));
        btn2.setFont(font);

        btn3 = new JButton();
        panel.add(btn3);
        btn3.addActionListener(e -> ButtonClicked(e));
        btn3.setFont(font);

        btn4 = new JButton();
        panel.add(btn4);
        btn4.addActionListener(e -> ButtonClicked(e));
        btn4.setFont(font);

        btn5 = new JButton();
        panel.add(btn5);
        btn5.addActionListener(e -> ButtonClicked(e));
        btn5.setFont(font);

        btn6 = new JButton();
        panel.add(btn6);
        btn6.addActionListener(e -> ButtonClicked(e));
        btn6.setFont(font);

        btn7 = new JButton();
        panel.add(btn7);
        btn7.addActionListener(e -> ButtonClicked(e));
        btn7.setFont(font);

        btn8 = new JButton();
        panel.add(btn8);
        btn8.addActionListener(e -> ButtonClicked(e));
        btn8.setFont(font);

        btn9 = new JButton();
        panel.add(btn9);
        btn9.addActionListener(e -> ButtonClicked(e));
        btn9.setFont(font);

        currentPlayer = "X"; // initialize the player to x

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        mainMenu = new JMenu("Game Options");
        menuBar.add(mainMenu);

        ResetGame = new JMenuItem("Reset");
        ExitGame = new JMenuItem("Exit");
        ExitGame.addActionListener(e -> System.exit(EXIT_ON_CLOSE));
        mainMenu.add(ResetGame);
        mainMenu.add(ExitGame);
    }

}