package lab_12;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by jcpatac on 10/27/2016.
 */
public class Calculator extends JFrame {

    public static final long serialVersionUID = 1L;

    private JMenuBar menu;
    private JMenu file;
    private JMenuItem close;

    private JMenu edit;
    private JMenuItem copy;
    private JMenuItem viewHelp;

    private JMenu help;
    private JMenuItem aboutCalc;

    private JTextArea displayScreen;
    private JTextArea displayStatus;

    private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton decimal;

    private JButton plus;
    private JButton minus;
    private JButton multiply;
    private JButton divide;
    private JButton result;
    private JButton backspace;
    private JButton clear;
    private JButton percent;
    private JButton plusMinus;

    private BigDecimal firstTmp = new BigDecimal("0.0");
    private BigDecimal secondTmp = new BigDecimal("0.0");
    private BigDecimal forPercent = new BigDecimal("0.0");

    private boolean[] operations = new boolean[4];
    private boolean[] operationsForChecking = new boolean[4];


    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e) {
            System.out.println("Couldn't load system look!");
        }

        new Calculator();
    }

    public Calculator() {
        super("Calculator");
        displayScreenInterface();
        displayStatusInterface();
        menuBarInterface();
        buttonsInterface();
        calculatorInterface(this);
    }

    private void buttonsInterface() {
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        decimal = new JButton(".");

        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        result = new JButton("=");
        backspace = new JButton("Del");
        clear = new JButton("AC");
        percent = new JButton("%");
        plusMinus = new JButton("+/-");

        clear.setBounds(10, 65, 60, 50);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayScreen.setText("0");
                displayStatus.setText("");
                for (int i = 0; i < operations.length; i++) {
                    operations[i] = false;
                }
                firstTmp = new BigDecimal("0");
                secondTmp = new BigDecimal("0");
            }
        });
        add(clear);

        backspace.setBounds(77, 65, 60, 50);
        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currText = displayScreen.getText();
                if (currText != null && currText.length() > 0 && (!(currText.equals("0")))) {
                    currText = currText.substring(0, currText.length() - 1);

                    if (currText.length() == 0) {
                        currText = "0";
                    }
                }
                displayScreen.setText(currText);
            }
        });
        add(backspace);

        percent.setBounds(144, 65, 60, 50);
        percent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forPercent = (new BigDecimal(displayScreen.getText())).divide(new BigDecimal("100"));
                secondTmp = firstTmp.multiply(forPercent);
                displayScreen.setText(secondTmp + "");
            }
        });
        add(percent);
        divide.setBounds(211, 65, 60, 50);
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operations.length;i++) {
                    if (operations[i] == true) {
                        operations[i] = false;
                        operationsForChecking[i] = false;
                        ctr++;
                    }
                }
                if (ctr == 0) {
                    firstTmp = new BigDecimal(displayScreen.getText());
                }
                operations[0] = true;
                operationsForChecking[0] = true;
                displayStatus.setText(firstTmp + " /");
            }
        });
        add(divide);

        seven.setBounds(10, 120, 60, 50);
        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operationsForChecking.length;i++) {
                    if (operationsForChecking[i] == true) {
                        operationsForChecking[i] = false;
                        ctr++;
                        break;
                    }
                }
                if (ctr == 0) {
                    if (test()) {
                        displayScreen.append("7");
                    }
                }else {
                    displayScreen.setText("7");
                    ctr--;
                }
            }

        });
        add(seven);
        eight.setBounds(77, 120, 60, 50);
        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operationsForChecking.length;i++) {
                    if (operationsForChecking[i] == true) {
                        operationsForChecking[i] = false;
                        ctr++;
                        break;
                    }
                }
                if (ctr == 0) {
                    if (test()) {
                        displayScreen.append("8");
                    }
                }else {
                    displayScreen.setText("8");
                    ctr--;
                }
            }

        });
        add(eight);
        nine.setBounds(144, 120, 60, 50);
        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operationsForChecking.length;i++) {
                    if (operationsForChecking[i] == true) {
                        operationsForChecking[i] = false;
                        ctr++;
                        break;
                    }
                }
                if (ctr == 0) {
                    if (test()) {
                        displayScreen.append("9");
                    }
                }else {
                    displayScreen.setText("9");
                    ctr--;
                }
            }

        });
        add(nine);
        multiply.setBounds(211, 120, 60, 50);
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operations.length;i++) {
                    if (operations[i] == true) {
                        operations[i] = false;
                        operationsForChecking[i] = false;
                        ctr++;
                    }
                }
                if (ctr == 0) {
                    firstTmp = new BigDecimal(displayScreen.getText());
                }
                operations[1] = true;
                operationsForChecking[1] = true;
                displayStatus.setText(firstTmp + " *");
            }
        });
        add(multiply);

        four.setBounds(10, 175, 60, 50);
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operationsForChecking.length;i++) {
                    if (operationsForChecking[i] == true) {
                        operationsForChecking[i] = false;
                        ctr++;
                        break;
                    }
                }
                if (ctr == 0) {
                    if (test()) {
                        displayScreen.append("4");
                    }
                }else {
                    displayScreen.setText("4");
                    ctr--;
                }
            }

        });
        add(four);
        five.setBounds(77, 175, 60, 50);
        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operationsForChecking.length;i++) {
                    if (operationsForChecking[i] == true) {
                        operationsForChecking[i] = false;
                        ctr++;
                        break;
                    }
                }
                if (ctr == 0) {
                    if (test()) {
                        displayScreen.append("5");
                    }
                }else {
                    displayScreen.setText("5");
                    ctr--;
                }
            }

        });
        add(five);
        six.setBounds(144, 175, 60, 50);
        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operationsForChecking.length;i++) {
                    if (operationsForChecking[i] == true) {
                        operationsForChecking[i] = false;
                        ctr++;
                        break;
                    }
                }
                if (ctr == 0) {
                    if (test()) {
                        displayScreen.append("6");
                    }
                }else {
                    displayScreen.setText("6");
                    ctr--;
                }
            }

        });
        add(six);
        minus.setBounds(211, 175, 60, 50);
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operations.length;i++) {
                    if (operations[i] == true) {
                        operationsForChecking[i] = false;
                        operations[i] = false;
                        ctr++;
                    }
                }
                if (ctr == 0) {
                    firstTmp = new BigDecimal(displayScreen.getText());
                }
                operationsForChecking[2] = true;
                operations[2] = true;
                displayStatus.setText(firstTmp + " -");
            }
        });
        add(minus);

        one.setBounds(10, 230, 60, 50);
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operationsForChecking.length;i++) {
                    if (operationsForChecking[i] == true) {
                        operationsForChecking[i] = false;
                        ctr++;
                        break;
                    }
                }
                if (ctr == 0) {
                    if (test()) {
                        displayScreen.append("1");
        }
                }else {
                    displayScreen.setText("1");
                    ctr--;
                }
            }

        });
        add(one);
        two.setBounds(77, 230, 60, 50);
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operationsForChecking.length;i++) {
                    if (operationsForChecking[i] == true) {
                        operationsForChecking[i] = false;
                        ctr++;
                        break;
                    }
                }
                if (ctr == 0) {
                   if (test()) {
                        displayScreen.append("2");
        }
                }else {
                    displayScreen.setText("2");
                    ctr--;
                }
            }

        });
        add(two);
        three.setBounds(144, 230, 60, 50);
        add(three);
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operationsForChecking.length;i++) {
                    if (operationsForChecking[i] == true) {
                        operationsForChecking[i] = false;
                        ctr++;
                        break;
                    }
                }
                if (ctr == 0) {
                    if (test()) {
                        displayScreen.append("3");
                    }
                }else {
                    displayScreen.setText("3");
                    ctr--;
                }
            }
        });
        plus.setBounds(211, 230, 60, 50);
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr = 0;
                for (int i = 0; i < operations.length;i++) {
                    if (operations[i] == true) {
                        operations[i] = false;
                        operationsForChecking[i] = false;
                        ctr++;
                    }
                }
                if (ctr == 0) {
                    firstTmp = new BigDecimal(displayScreen.getText());
                }
                operationsForChecking[3] = true;
                operations[3] = true;
                displayStatus.setText(firstTmp + " +");
            }
        });
        add(plus);

        zero.setBounds(10, 285, 60, 50);
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayScreen.getText().equalsIgnoreCase("0") || displayScreen.getText().length() > 13) {
                    return;
                }else {
                    int ctr = 0;
                    for (int i = 0; i < operationsForChecking.length;i++) {
                        if (operationsForChecking[i] == true) {
                            operationsForChecking[i] = false;
                            ctr++;
                            break;
                        }
                    }
                    if (ctr == 0) {
                        displayScreen.append("0");
                    }else {
                        displayScreen.setText("0");
                        ctr--;
                    }
                }
            }

        });
        add(zero);
        decimal.setBounds(77, 285, 60, 50);
        decimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayScreen.getText().contains(".")) {
                    return;
                }else {
                    displayScreen.append(".");
                }
            }

        });
        add(decimal);
        plusMinus.setBounds(144, 285, 60, 50);
        plusMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = displayScreen.getText();
                BigDecimal bigDecimal = new BigDecimal(number).negate();
                displayScreen.setText(bigDecimal + "");
                if (displayScreen.getText().endsWith(".0")) {
                    displayScreen.setText(displayScreen.getText().replace(".0", ""));
                }
            }
        });
        add(plusMinus);

        result.setBounds(211, 285, 60, 50);
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operations[0]) {
                    secondTmp = new BigDecimal(displayScreen.getText());
                    if (secondTmp.compareTo(new BigDecimal("0")) != 0) {
                        MathContext mathContext = new MathContext(14, RoundingMode.HALF_UP);
                        BigDecimal answer = firstTmp.divide(secondTmp, mathContext);
                        displayScreen.setText(answer + "");
                    }else {
                        displayStatus.setText("");
                        displayScreen.setText("Error: Zero division!");
                        return;
                    }
                }else if (operations[1]) {
                    secondTmp = new BigDecimal(displayScreen.getText());
                    BigDecimal answer = firstTmp.multiply(secondTmp);
                    displayScreen.setText(answer + "");
                }else if (operations[2]) {
                    secondTmp = new BigDecimal(displayScreen.getText());
                    BigDecimal answer = firstTmp.subtract(secondTmp);
                    displayScreen.setText(answer + "");
                }else if (operations[3]) {
                    secondTmp = new BigDecimal(displayScreen.getText());
                    BigDecimal answer = firstTmp.add(secondTmp);
                    displayScreen.setText(answer + "");
                }

                firstTmp = new BigDecimal("0");
                secondTmp = new BigDecimal("0");
                displayStatus.setText("");
                for (int i = 0; i < operations.length; i++) {
                    operations[i] = false;
                }
            }
        });
        add(result);
    }

    private void displayScreenInterface() {
        displayScreen =  new JTextArea("0");
        displayScreen.setBounds(10, 23, 261, 36);
        displayScreen.setEditable(false);
        displayScreen.setFont(new Font("Garamond", Font.BOLD, 25));
        displayScreen.setBackground(Color.LIGHT_GRAY);
        add(displayScreen);
    }

    private void displayStatusInterface() {
        displayStatus = new JTextArea("");
        displayStatus.setBounds(10, 10, 261, 13);
        displayStatus.setEditable(false);
        displayStatus.setFont(new Font("Arial", Font.PLAIN, 11));
        displayStatus.setBackground(Color.LIGHT_GRAY);
        add(displayStatus);
    }

    private void menuBarInterface() {
        menu = new JMenuBar();
        file = new JMenu(" File ");
        edit = new JMenu(" Edit ");
        help = new JMenu(" Help ");

        close = new JMenuItem("Close");
        copy = new JMenuItem("Copy");
        viewHelp = new JMenuItem("View Help");
        aboutCalc = new JMenuItem("About Calculator");

        setJMenuBar(menu);

        menu.add(file);
        menu.add(edit);
        menu.add(help);

        file.add(close);
        edit.add(copy);
        help.add(viewHelp);
        help.add(aboutCalc);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(ABORT);
            }
        });

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strCopy = displayScreen.getText();
                StringSelection selection = new StringSelection(strCopy);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
            }
        });

        viewHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "No help topics! Still Working on it!", "Calculator Help", JOptionPane.WARNING_MESSAGE);
            }
        });

        aboutCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "(c) 2016 jcpatac", "About Calculator", JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }

    private boolean test() {
        if (displayScreen.getText().length() > 18) {
            return false;
        }
        if (displayScreen.getText().equalsIgnoreCase("0")) {
            displayScreen.setText("");
        }
        return true;
    }

    private void calculatorInterface(Calculator calculator) {
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setSize(288, 400);
        calculator.setResizable(false);
        calculator.setLayout(null);
        calculator.setLocationRelativeTo(null);
        calculator.setVisible(true);
    }
}
