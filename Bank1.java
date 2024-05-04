package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Bank1 extends JFrame {

    String name,pass;
    JLabel ub, pb, pb3;
    JTextField tf;
    JPasswordField pf2;
    JButton b1, b2, bb, eb;
    Container c;
    Font f, f2;
    ImageIcon img, img2;
    int spaces = 100;
    

    public Bank1(String name, String pass) {
        this.name = name;
        this.pass=pass;
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 800, 300);
        this.setTitle(" ".repeat(spaces) + "E-cash");

        f2 = new Font("Arial", Font.BOLD, 30);
        f = new Font("Arial", Font.BOLD, 16);

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

        pb = new JLabel("Withdraw or Deposite ?  ");
        pb.setBounds(230, 70, 600, 50);
        pb.setFont(f2);
        pb.setForeground(Color.black);
        bg.add(pb);

        b2 = new JButton("Deposite");
        b2.setBounds(380, 130, 120, 30);
        b2.setFont(f);
        b2.setCursor(cr);
        b2.setBackground(Color.cyan);
        b2.setForeground(Color.black);
        bg.add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Deposite dp = new Deposite(name,pass);

            }
        });

        b1 = new JButton("Withdraw");
        b1.setBounds(260, 130, 110, 30);
        b1.setFont(f);
        b1.setCursor(cr);
        b1.setBackground(Color.cyan);
        b1.setForeground(Color.black);
        bg.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Withdraw with = new Withdraw(name,pass);
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
                
                loginPage logPage = new loginPage();
                logPage.setVisible(true);
                dispose();
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
        Bank1 bank1 = new Bank1("Fahim","1111");
    }
}
