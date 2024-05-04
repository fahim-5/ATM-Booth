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

public class SignUp1 extends JFrame {

    int spaces = 100;
    Container c;
    JLabel pb;
    Font f2, f;
    JButton b2, b1, bb, eb;
    ImageIcon img, img2;

    public SignUp1() {

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

        pb = new JLabel("Do you want to Create an account?");
        pb.setBounds(150, 60, 600, 50);
        pb.setFont(f2);
        pb.setForeground(Color.green);
        bg.add(pb);

        b2 = new JButton("NO");
        b2.setBounds(370, 130, 90, 30);
        b2.setFont(f);
        b2.setBackground(Color.cyan);
        b2.setForeground(Color.black);
        b2.setCursor(cr);
        bg.add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Thanks thnk = new Thanks();
            }
        });

        b1 = new JButton("YES");
        b1.setBounds(250, 130, 110, 30);
        b1.setFont(f);
        bg.add(b1);
        b1.setBackground(Color.cyan);
        b1.setCursor(cr);
        b1.setForeground(Color.black);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Signup frame = new Signup();
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

                Home home = new Home();
                home.setVisible(true);
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
        SignUp1 thnk = new SignUp1();

    }
}
