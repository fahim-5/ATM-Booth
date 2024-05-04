package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Signup extends JFrame {

    JLabel ub, pb, pb3;
    JTextField tf;
    JPasswordField pf, pf2;
    JButton lb, cb, lb1, bb, eb;
    Container c;
    Font f;
    ImageIcon img, img2;
    int spaces = 100;

    public Signup() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 800, 300);
        this.setTitle(" ".repeat(spaces) + "E-cash");

        f = new Font("Arial Bold", Font.BOLD, 16);

        Cursor cr = new Cursor(Cursor.HAND_CURSOR);

        img = new ImageIcon(getClass().getResource("logo2.jpeg"));
        this.setIconImage(img.getImage());

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.darkGray);

        img2 = new ImageIcon(getClass().getResource("bg1.jpg"));
        JLabel bg = new JLabel(img2);
        bg.setBounds(0, 0, getWidth(), getHeight());
        c.add(bg);

        ub = new JLabel("Enter Username");
        ub.setBounds(110, 8, 150, 50);
        ub.setFont(f);
        ub.setForeground(Color.WHITE);

        bg.add(ub);

        tf = new JTextField();
        tf.setBounds(250, 20, 400, 30);
        tf.setFont(f);
        tf.setCursor(cr);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setBackground(Color.DARK_GRAY);
        tf.setForeground(Color.WHITE);

        bg.add(tf);

        pb = new JLabel("Enter Password");
        pb.setBounds(110, 70, 150, 30);
        pb.setForeground(Color.white);
        pb.setFont(f);
        bg.add(pb);

        pb3 = new JLabel("Re-type Password");
        pb3.setBounds(110, 120, 150, 30);
        pb3.setFont(f);
        pb3.setForeground(Color.white);
        bg.add(pb3);

        pf = new JPasswordField();
        pf.setBounds(250, 71, 400, 30);
        pf.setFont(f);
        pf.setCursor(cr);
        pf.setHorizontalAlignment(JTextField.CENTER);
        pf.setBackground(Color.DARK_GRAY);
        pf.setForeground(Color.WHITE);
        bg.add(pf);

        pf2 = new JPasswordField();
        pf2.setBounds(250, 120, 400, 30);
        pf2.setFont(f);
        pf2.setCursor(cr);
        pf2.setHorizontalAlignment(JTextField.CENTER);
        pf2.setBackground(Color.DARK_GRAY);
        pf2.setForeground(Color.WHITE);
        bg.add(pf2);

        lb = new JButton("Sign Up");
        lb.setBounds(280, 170, 110, 30);
        lb.setFont(f);
        lb.setCursor(cr);
        lb.setBackground(Color.cyan);
        lb.setForeground(Color.black);
        bg.add(lb);

        lb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = tf.getText();
                String password = (String) pf.getText();

                if ((name.isEmpty() || password.isEmpty()) == true) {
                    JOptionPane.showMessageDialog(null, "Enter Username & Password ", "Info", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    if (pf.getText().equals(pf2.getText())) {      // if password or re-type  password match

                        FileWriter fileWriter = new FileWriter("D:/Opp Lab Project/data.txt", true);
                        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                            
                            bufferedWriter.write(name);
                            bufferedWriter.newLine();
                            bufferedWriter.flush();

                            bufferedWriter.write(password);
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                        }

                        JOptionPane.showMessageDialog(null, "Your account has been created successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Your retype Password Didn't Match", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        cb = new JButton("Clear");
        cb.setBounds(405, 170, 90, 30);
        cb.setFont(f);
        cb.setCursor(cr);
        cb.setBackground(Color.cyan);
        cb.setForeground(Color.black);
        bg.add(cb);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tf.setText("");
                pf.setText("");
                pf2.setText("");

            }
        });

        lb1 = new JButton("Login");
        lb1.setBounds(510, 170, 90, 30);
        lb1.setFont(f);
        lb1.setCursor(cr);
        lb1.setBackground(Color.cyan);
        lb1.setForeground(Color.black);
        bg.add(lb1);

        lb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                loginPage logPage = new loginPage();

            }
        });

        bb = new JButton("Back");
        bb.setBounds(0, 233, 90, 30);
        bb.setFont(f);
        bb.setBackground(Color.cyan);
        bb.setForeground(Color.black);
        bb.setCursor(cr);
        bg.add(bb);

        bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SignUp1 thnk = new SignUp1();
            }
        });

        eb = new JButton("Exit");
        eb.setBounds(705, 233, 90, 30);
        eb.setFont(f);
        eb.setBackground(Color.cyan);
        eb.setForeground(Color.black);
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
        Signup frame = new Signup();

    }

}
