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

public class Home extends JFrame {

    int spaces = 100;
    Container c;
    JLabel pb, pb1;
    Font f2, f, f3;
    JButton b1, b2, bb, eb;
    ImageIcon img, img2;
    Cursor cr;

    public Home() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 800, 300);
        this.setTitle(" ".repeat(spaces) + "  E-Cash ");

        cr = new Cursor(Cursor.HAND_CURSOR);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.darkGray);

        img = new ImageIcon(getClass().getResource("logo2.jpeg"));
        this.setIconImage(img.getImage());

        img2 = new ImageIcon(getClass().getResource("bg1.jpg"));
        JLabel bg = new JLabel(img2);
        bg.setBounds(0, 0, getWidth(), getHeight());
        c.add(bg);

        f = new Font("Arial", Font.BOLD, 16);
        f2 = new Font("Monoton", Font.BOLD, 50);
        f3 = new Font("Arial", Font.CENTER_BASELINE, 20);

        pb = new JLabel("Welcome to E-Cash ");
        pb.setBounds(155, 35, 500, 50);
        pb.setFont(f2);
        pb.setForeground(Color.green);
        bg.add(pb);

        pb1 = new JLabel("Dear user,do you have an E-cash account ?");
        pb1.setBounds(190, 100, 500, 50);
        pb1.setFont(f3);
        pb1.setForeground(Color.BLACK);
        bg.add(pb1);

        b1 = new JButton("YES");
        b1.setBounds(265, 155, 90, 30);
        b1.setBackground(Color.cyan);
        b1.setForeground(Color.black);
        b1.setFont(f);
        b1.setCursor(cr);
        bg.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                loginPage logPage = new loginPage();

            }
        });

        b2 = new JButton("NO");
        b2.setBounds(390, 155, 90, 30);
        b2.setBackground(Color.cyan);
        b2.setForeground(Color.black);
        b2.setFont(f);
        b2.setCursor(cr);
        bg.add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SignUp1 thnk = new SignUp1();
            }
        });

        bb = new JButton("Login");
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
                loginPage logPage = new loginPage();

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

            }
        });
    }

    public static void main(String[] args) {
        Home home = new Home();
        home.setVisible(true);
    }

}
