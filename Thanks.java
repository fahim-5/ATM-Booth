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

public class Thanks extends JFrame {

    int spaces = 100;
    Container c;
    JLabel pb;
    Font f2, f;
    ImageIcon img, img2;
    JButton eb;
    Cursor cr;

    public Thanks() {

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 800, 300);
        this.setTitle(" ".repeat(spaces) + "E-cash");

        f2 = new Font("Arial", Font.BOLD, 50);
        f = new Font("Arial", Font.BOLD, 16);
        cr = new Cursor(Cursor.HAND_CURSOR);

        img = new ImageIcon(getClass().getResource("logo2.jpeg"));
        this.setIconImage(img.getImage());

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.darkGray);

        img2 = new ImageIcon(getClass().getResource("bg1.jpg"));
        JLabel bg = new JLabel(img2);
        bg.setBounds(0, 0, getWidth(), getHeight());
        c.add(bg);

        pb = new JLabel("Thanks for visite E-Cash");
        pb.setBounds(115, 70, 700, 50);
        pb.setFont(f2);
        pb.setForeground(Color.orange);
        bg.add(pb);

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
        Thanks thnk = new Thanks();

    }
}
