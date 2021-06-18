package p1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

class QuickQuiz extends JFrame implements ActionListener{

    JButton b1,b2;
    JTextField t1;
    QuickQuiz(){
        setBounds(400, 200, 1200, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("p1/Pic1.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 600, 500);
        add(l1);

        JLabel l2 = new JLabel("Quick Quiz");
        l2.setFont(new Font("Mongolian Baiti", Font.BOLD,40));
        l2.setForeground(new Color(30,144,254));
        l2.setBounds(750, 40, 300, 45);
        add(l2);

        JLabel l3 = new JLabel("Enter Your Name");
        l3.setFont(new Font("Viner Hand ITC", Font.BOLD,18));
        l3.setForeground(new Color(30,144,254));
        l3.setBounds(810, 150, 300, 20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(735, 200, 300, 25);
        t1.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(t1);

        b1 = new JButton("Rules");
        b1.setBounds(735, 270, 120, 25);
        b1.setBackground(new Color(30,144,254));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Exit");
        b2.setBounds(915, 270, 120, 25);
        b2.setBackground(new Color(30,144,254));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
           String name = t1.getText();
           this.setVisible(false);
           new Rules(name);
        }else{
         System.exit(0);
        }
        
    }
    public static void main(String[] args) {
       new QuickQuiz();
    }
    
}