package p1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rules extends JFrame implements ActionListener{
    JButton b1,b2;
    String username;
    Rules(String username){
        this.username = username;
        setBounds(600,200,800,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Welcome"+username+" to Quick Quiz");
        l1.setForeground(new Color(30,144,255));
        l1.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        l1.setBounds(50, 20, 700, 60);
        add(l1);

        JLabel l2 = new JLabel("");
        //l2.setForeground(new Color(30,144,255));
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        l2.setBounds(20, 90, 600, 250);
        l2.setText(
            "<html>"+
            "1. 24 Question in the prelims. (One excluded for this ppt)"+"<br>"+
            "2. No Negative marks So take your best shot."+"<br>"+
            "3. 1 mark per Question unless otherwise intimated by QM"+"<br>"+
            "4. In Case of tie,'Sudden death' based upon the prelims answer will be restored to."+"<br>"+
            "5. Mobile Phone to be shifted off and inside pockets/bags"+"<br>"+
            "6. Audience mobiles on silent mode phase"+"<br>"+
            "7. Quizmaster's mobiles on silent mode please."+"<br>"+
            "html"
        );
        add(l2);

        b1 = new JButton("Back");
        b1.setBounds(250, 300, 100, 30);
        b1.setBackground(new Color(30,144,255));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Start");
        b2.setBounds(400, 300, 100, 30);
        b2.setBackground(new Color(30,144,255));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Rules("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
             this.setVisible(false);
             new QuickQuiz().setVisible(true);
        }else if(e.getSource()==b2){
            this.setVisible(false);
            new Quiz(username).setVisible(true);
        }
        
    }
}
