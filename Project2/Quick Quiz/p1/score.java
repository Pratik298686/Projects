package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class score extends JFrame implements ActionListener{
    score(String username, int score){
         setBounds(600, 150, 750, 550);
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("p1/Pic3.png"));
         Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);

         JLabel l1 = new JLabel(i3);
         l1.setBounds(0, 200, 300, 250);
         add(l1);

         JLabel l2 = new JLabel("Thanku "+username+" for playing Quick Quiz");
         l2.setBounds(45, 30, 700, 30);
         l2.setFont(new Font("RAILWAY",Font.PLAIN,26));
         add(l2);
         
         JLabel l3 = new JLabel("Your Score is : "+score);
         l3.setBounds(350, 200, 300, 30);
         l3.setFont(new Font("Jokerman",Font.PLAIN,26));
         l3.setForeground(new Color(199,21,133));
         add(l3);

         JButton b1 = new JButton("Play Again");
         b1.setBackground(Color.BLUE);
         b1.setForeground(Color.WHITE);
         b1.setBounds(400, 270, 120, 30);
         b1.addActionListener(this);
         add(b1);
        }
    public static void main(String[] args) {
        new score("",0).setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      this.setVisible(false);
      new QuickQuiz().setVisible(true);
        
    }
}
