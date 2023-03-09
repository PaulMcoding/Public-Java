package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui_1 extends JFrame implements ActionListener{

	JFrame frame;
	JPanel panel1;
	JButton button;
	JLabel label;
	JLabel label2;
	JButton button2;
	JButton button3;
	int count= 0;
	
	public Gui_1(String title)
	{
		
		frame = new JFrame(title);
		
		//create buttons
		button= new JButton();
		button2 = new JButton();
		button3 = new JButton();
		
		//create panel
		panel1 = new JPanel();
		
		//create a count label
		label = new JLabel();
		label2 = new JLabel();
		
		//Frame
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel
		frame.add(panel1);
		panel1.setBackground(Color.pink);
		
		//Flow layout
		panel1.setLayout(new FlowLayout());
		
		//add the button to the panel
		panel1.add(button);
		button.setText("Counter");
		button.setToolTipText("Count number of click");
		button.setBackground(Color.blue);
		button.setOpaque(true);
		button.setBorderPainted(false);
		
		panel1.add(label);
		label.setText("Count : 0");
		
		panel1.add(button3);
		button3.setText("Gnome");
		button3.setToolTipText("show me your gnobblins");
		button3.setBackground(Color.orange);
		button3.setOpaque(true);
		button3.setBorderPainted(false);
		
		panel1.add(label2);
		label2.setText("Hello there");
		
		panel1.add(button2);
		button2.setText("Close");
		button2.setToolTipText("Close App");
		button2.setBackground(Color.cyan);
		button2.setOpaque(true);
		button2.setBorderPainted(false);
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button)
		{
			count = count + 2;
			label.setText("Count : " +count);
		}
		else if(e.getSource() == button2)
		{
			System.exit(0);
		}
		else if(e.getSource() == button3)
		{
			JOptionPane.showMessageDialog(this, "I have changed your label");
			label2.setText("I am gnot a gnoblin");
		}
	}

}
