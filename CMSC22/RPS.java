package GUIProgramming;

import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Created by jcpatac on 10/24/2016.
 */

public class RPS extends Frame {

    private int scorePlayer = 0;
    private int scoreComputer = 0;

    private Panel controls;
    private Frame main;

    private Label lblHeader;
    private Label status;
    private Label player;
    private Label computer;

    private CheckboxGroup buttons;
    private Checkbox cbgRock;
    private Checkbox cbgPaper;
    private Checkbox cbgScissors;
    private Checkbox cbgLizard;
    private Checkbox cbgSpocks;

    public int selection = 0;

    protected TextArea results;
    private TextArea playerScore;
    private TextArea computerScore;

    private Button select;

    public RPS() {
        showGUI();
    }

    private void showGUI() {
        main = new Frame("RPSLS");
        main.setSize(800, 800);
        main.setLayout(new GridLayout(3, 1));

        main.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        lblHeader = new Label();
        lblHeader.setAlignment(Label.CENTER);

        status = new Label();
        status.setAlignment(Label.LEFT);
        status.setSize(350, 100);

        controls = new Panel();
        controls.setLayout(new FlowLayout());

        Font font = new Font("SansSerif", Font.PLAIN, 12);
        select = new Button("RPSLS!");
        select.setPreferredSize(new Dimension(10, 10));
        select.setFont(font);
        select.addActionListener(new MyActionListener());

        results = new TextArea("Result:");
        results.setEditable(false);

        player = new Label("Player's Score", Label.RIGHT);
        computer = new Label("Computer's Score", Label.RIGHT);

        playerScore = new TextArea();
        playerScore.setEditable(false);
        computerScore = new TextArea();
        computerScore.setEditable(false);

        main.add(lblHeader);
        main.add(controls);
        main.add(status);
        main.add(results);
        main.add(player);
        main.add(computer);
        main.add(playerScore);
        main.add(computerScore);
        main.add(select);
        main.setVisible(true);
    }

    private void opts() {

        lblHeader.setText("Your Choice: ");

        buttons = new CheckboxGroup();

        cbgRock = new Checkbox("Rock", buttons, false);
        cbgPaper = new Checkbox("Paper", buttons, false);
        cbgScissors = new Checkbox("Scissors", buttons, false);
        cbgLizard = new Checkbox("Lizard", buttons, false);
        cbgSpocks = new Checkbox("Spocks", buttons, false);

        cbgRock.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selection = 1;
                status.setText("Rock Selected!");
            }
        });

        cbgPaper.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selection = 2;
                status.setText("Paper Selected");
            }
        });

        cbgScissors.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selection = 3;
                status.setText("Scissors Selected");
            }
        });

        cbgLizard.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selection = 4;
                status.setText("Lizard Selected");
            }
        });

        cbgSpocks.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selection = 5;
                status.setText("Spocks Selected");
            }
        });

        controls.add(cbgRock);
        controls.add(cbgPaper);
        controls.add(cbgScissors);
        controls.add(cbgLizard);
        controls.add(cbgSpocks);
        main.setVisible(true);

    }

    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int computer = -1;

            if (selection == 0) {
                results.setText("Must have a choice!");
            }else {
                computer = computerSelection(1, 5);
            }

            if (selection == 1) {
                results.setText("Result: \n\n Player chose ROCK");
            }else if (selection == 2) {
                results.setText("Result: \n\n Player chose PAPER");
            }else if (selection == 3) {
                results.setText("Result: \n\n Player chose SCISSORS");
            }else if (selection == 4) {
                results.setText("Result: \n\n Player chose LIZARD");
            }else if (selection == 5) {
                results.setText("Result: \n\n Player chose SPOCKS");
            }

            if (computer == 1) {
                results.append("\nComputer chose ROCK");
            }else if (computer == 2) {
                results.append("\nComputer chose PAPER");
            }else if (computer == 3) {
                results.append("\nComputer chose SCISSORS");
            }else if (computer == 4) {
                results.append("\nComputer chose LIZARD");
            }else if (computer == 5) {
                results.append("\nComputer chose SPOCKS");
            }

            if ((selection == 1 && (computer == 3 || computer == 4)) ||
                    (selection == 2 && (computer == 1 || computer == 5)) ||
                    (selection == 3 && (computer == 2 || computer == 4)) ||
                    (selection == 4 && (computer == 2 || computer == 5)) ||
                    (selection == 5 && (computer == 1 || computer == 3))) {
                scorePlayer++;
                playerScore.setText("" + scorePlayer);
                results.append("\n\n\nYou Win This Round!");
                if (scorePlayer == 5) {
                    gameOver("Player Wins!\n");
//                    System.exit(0);
                }

            }else if (selection != computer && computer >= 1){
                scoreComputer++;
                computerScore.setText("" + scoreComputer);
                results.append("\n\n\nComputer Wins this Round!");
                if (scoreComputer == 5) {
                    gameOver("Computer Wins!\n");
//                    System.exit(0);
                }

            }else {
                if (computer > 0 && selection > 0) {
                    results.append("\n\n\nDRAW!");
                }
            }
        }

        public int computerSelection(int min, int max) {
            Random random = new Random();
            int randomNum = random.nextInt((max - min) + 1) + min;
            return  randomNum;
        }

        public void gameOver(String winner) {
            Frame frame = new Frame();
            Dialog dialog = new Dialog(frame, "Game Over!", true);
            dialog.add("North", new Label(winner + " Try Again?"));
            Button yes = new Button("Yes");
            yes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    scorePlayer = 0;
                    scoreComputer = 0;
                    selection = 0;
                    playerScore.setText("0");
                    computerScore.setText("0");
                    results.setText("Result: ");
                    dialog.setVisible(false);
                    controls.removeAll();
                    opts();
                }
            });
            Button no = new Button("No");
            no.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(ABORT);
                }
            });
            dialog.add("South", no);
            dialog.add("Center", yes);
            dialog.pack();

            Dimension dimension = dialog.getSize();
            Dimension dimension1 = frame.getSize();
            Point point = frame.getLocation();
            dialog.setLocation(point.x + (int)(dimension1.getWidth() - dimension.getWidth()) / 2, point.y + (int)(dimension1.getHeight() - dimension.getHeight() / 2));
            dialog.setVisible(true);
        }

    }

    public static void main(String[] args) {
        RPS rps = new RPS();
        rps.opts();
    }

}