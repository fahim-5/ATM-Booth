package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginPage extends JFrame {

    int spaces = 100;
    JLabel l1, l2;
    JTextField tf;
    JPasswordField pf;
    JButton lb, cb,bb,eb;
    Container c;
    Font f;
    ImageIcon img, img2;

    public loginPage() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300,200,800, 300);
        this.setTitle(" ".repeat(spaces) + "E-cash");

        f = new Font("Arial", Font.BOLD, 16);
         Cursor cr = new Cursor(Cursor.HAND_CURSOR);

        img = new ImageIcon(getClass().getResource("logo2.jpeg"));
        this.setIconImage(img.getImage());

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.darkGray);

        img2 = new ImageIcon(getClass().getResource("bg1.jpg"));
        JLabel bg = new JLabel(img2);
        bg.setBounds(0, 0, getWidth(), getHeight());
        c.add(bg);

        l1 = new JLabel("Enter Username");
        l1.setBounds(110, 8, 150, 50);
        l1.setForeground(Color.white);
        l1.setFont(f);
        bg.add(l1);

        tf = new JTextField();
        tf.setBounds(280, 20, 400, 30);
        tf.setFont(f);
        tf.setCursor(cr);
        tf.setBackground(Color.DARK_GRAY);
        tf.setForeground(Color.WHITE);
        tf.setHorizontalAlignment(JTextField.CENTER);
        bg.add(tf);

        l2 = new JLabel("Enter Password");
        l2.setBounds(110, 70, 150, 30);
        l2.setFont(f);
        l2.setForeground(Color.white);
        bg.add(l2);

        pf = new JPasswordField();
        pf.setBounds(280, 70, 400, 30);
        pf.setFont(f);
        pf.setCursor(cr);
        pf.setBackground(Color.DARK_GRAY);
        pf.setForeground(Color.WHITE);
        pf.setHorizontalAlignment(JTextField.CENTER);
        bg.add(pf);

        lb = new JButton("Login");
        lb.setBounds(330, 130, 110, 30);
        lb.setFont(f);
        lb.setCursor(cr);
        lb.setBackground(Color.cyan);
        lb.setForeground(Color.black);
        bg.add(lb);
        
        lb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String n = tf.getText();
                String p = (String) pf.getText();
                
                
                if((n.isEmpty() || p.isEmpty())== true){
            JOptionPane.showMessageDialog(null, "Enter Username & Password ", "Info", JOptionPane.ERROR_MESSAGE);
                       return;
                }
                
                
                int flag = 0;
                int flag2 = 0;

                FileReader f; 
                
                try {
                    f = new FileReader("D:/Opp Lab Project/data.txt");
                    BufferedReader br = new BufferedReader(f);
                    String line;
                    try {
                        while ((line = br.readLine()) != null) {
                            if (line.equals(n)) {
                                flag = 1;
                            }
                            if (line.equals(p)) {
                                flag2 = 1;
                            }

                        }

                        if (flag == 1 && flag2 == 1) {
                            
                            dispose();
                            Bank1 bank1 = new Bank1(n,p);

                        } else {
                            JOptionPane.showMessageDialog(null, "“Username and password did't match", "Info", JOptionPane.OK_OPTION);

                        }

                    } catch (IOException ex) {
                        System.out.println(ex);
                    }

                    br.close();                
                } catch (IOException ex) {
                    Logger.getLogger(loginPage.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "File not Found", "Info", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        cb = new JButton("Clear");
        cb.setBounds(450, 130, 90, 30);
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

            }
        });
         
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
                 Home home = new Home();
            }
        });
       
    }

    public static void main(String[] args) {
        loginPage logPage = new loginPage();
    }
}
