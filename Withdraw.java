package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends JFrame {

    private final int SPACES = 100;
    private JLabel l1;
    private JTextField tf;
    private JButton lb, eb, bb, cb;
    private Container c;
    private Font f, f2;
    private String name, pass;
    private int tk;
    private ImageIcon img, img2;

    public Withdraw(String name, String pass) {
        this.name = name;
        this.pass = pass;
        initializeGUI();
    }

    private void initializeGUI() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 800, 300);
        this.setTitle(" ".repeat(SPACES) + "E-cash");

        f = new Font("Arial", Font.BOLD, 24);
        f2 = new Font("Arial", Font.BOLD, 16);

        Cursor cr = new Cursor(Cursor.HAND_CURSOR);

        img = new ImageIcon(getClass().getResource("logo2.jpeg"));
        this.setIconImage(img.getImage());

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);

        img2 = new ImageIcon(getClass().getResource("bg1.jpg"));
        JLabel bg = new JLabel(img2);
        bg.setBounds(0, 0, getWidth(), getHeight());
        c.add(bg);

        l1 = new JLabel("Enter your withdrawal amount :");
        l1.setBounds(250, 30, 500, 50);
        l1.setFont(f);
        l1.setForeground(Color.BLACK);
        bg.add(l1);

        tf = new JTextField();
        tf.setBounds(220, 80, 400, 30);
        tf.setFont(f2);
        tf.setBackground(Color.DARK_GRAY);
        tf.setForeground(Color.WHITE);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setCursor(cr);
        bg.add(tf);

        cb = new JButton("Clear");
        cb.setBounds(445, 120, 90, 30);
        cb.setFont(f2);
        cb.setCursor(cr);
        cb.setBackground(Color.CYAN);
        cb.setForeground(Color.BLACK);
        bg.add(cb);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("");
            }
        });

        lb = new JButton("Withdraw");
        lb.setBounds(280, 120, 150, 30);
        lb.setFont(f2);
        lb.setCursor(cr);
        lb.setBackground(Color.CYAN);
        lb.setForeground(Color.BLACK);
        bg.add(lb);

        lb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String amountText = tf.getText();

                if (amountText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter Withdrawal amount", "Info",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!amountText.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid digit.", "Info",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int amount = Integer.parseInt(amountText);

                try {
                    FileReader fileReader = new FileReader("D:/Opp Lab Project/data2.txt");
                    boolean found;
                    StringBuilder sb;
                    boolean Dflag;
                    try (BufferedReader br = new BufferedReader(fileReader)) {
                        String line;
                        found = false;
                        sb = new StringBuilder();
                        Dflag = false;
                        while ((line = br.readLine()) != null) {
                            String[] arr = line.split(" ");
                            if (arr[0].equals(name) && arr[1].equals(pass)) {
                                tk = Integer.parseInt(arr[2]);   //  this tk is how much waes there 
                                if (amount <= tk) {      // this condition will deposite.
                                    tk -= amount;
                                    sb.append(name).append(" ").append(pass).append(" ").append(tk).append("\n");
                                    found = true;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Insufficient funds.", "Info",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                                Dflag = true;       // if he fail to deposit becz of new commer (adnan)
                            } else {
                                sb.append(line).append("\n");
                            }
                        }
                    }

                    if (!Dflag) {
                        JOptionPane.showMessageDialog(null, "Please deposite First", "Info",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    if (found) {       // now time to replace the string builder 
                        FileWriter fileWriter = new FileWriter("D:/Opp Lab Project/data2.txt");
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        bufferedWriter.write(sb.toString());
                        bufferedWriter.close();

                        dispose();
                        FThanks thnk = new FThanks(tk);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Withdraw.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        bb = new JButton("Back");
        bb.setBounds(0, 233, 90, 30);
        bb.setFont(f2);
        bb.setBackground(Color.CYAN);
        bb.setForeground(Color.BLACK);
        bb.setCursor(cr);
        bg.add(bb);

        bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bank1 bank1 = new Bank1(name, pass);
                bank1.setVisible(true);
                dispose();
            }
        });

        eb = new JButton("Exit");
        eb.setBounds(705, 233, 90, 30);
        eb.setFont(f2);
        eb.setBackground(Color.CYAN);
        eb.setForeground(Color.BLACK);
        eb.setCursor(cr);
        bg.add(eb);

        eb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Home home = new Home();
            }
        });
    }

    public static void main(String[] args) {
        Withdraw withdraw = new Withdraw("Fahim", "56565");
    }
}
