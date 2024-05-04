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

public class FThanks extends JFrame {

    int spaces = 100;
    Container c;
    JLabel pb;
    Font f2,f3,f;
    JLabel ub;
    ImageIcon img,img2;
    JButton bb,eb;
    Cursor cr;

    public FThanks(int tk) {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300,200,800, 300);
        this.setTitle(" ".repeat(spaces) + "E-cash");

        f2 = new Font("Arial", Font.BOLD, 40);
       f= new Font("Arial", Font.BOLD, 20);
       f3 = new Font("Arial", Font.BOLD, 50);
        
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
        pb = new JLabel("Thank You.");
        pb.setBounds(260, 115, 500, 50);
        pb.setForeground(Color.green);
        pb.setFont(f3);
        bg.add(pb);

        ub = new JLabel(" Your current amount : " + tk);
        ub.setBounds(130, 50, 600, 50);
        ub.setFont(f2);
        ub.setForeground(Color.cyan);
        bg.add(ub);
        
        bb = new JButton("Home");
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
            }
        });
       
    }

    public static void main(String[] args) {
        FThanks thnk = new FThanks(456);

    }

}
