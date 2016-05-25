import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;


public class Telephone extends JFrame {
public Telephone() {
	// TODO Auto-generated constructor stub
	JPanel headpanel=new JPanel();
	headpanel.setLayout(new BorderLayout());

	JLabel head = new JLabel();
	head.setText("TELEPHONE DIRECTORY");
	head.setBackground(new Color(100,150,200));
	head.setForeground(Color.WHITE);
	head.setOpaque(true);
	head.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),BorderFactory.createEmptyBorder(20,20,20,20)));

	head.setFont(new Font("times new roman" , 5,40));
	head.setHorizontalAlignment(SwingConstants.CENTER);
	headpanel.add(head,BorderLayout.NORTH);
	
	add(headpanel);
	setSize(400, 400);
	setVisible(true);
}

public static void main(String args[]) {
	new Telephone();
}

}
