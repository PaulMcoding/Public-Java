package Assignment;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JFrame{

	protected String title;
	protected double etrepeneur;
	protected double not_etrepeneur;
	JFrame frame;
	JButton button, button2, button3;
	JPanel panel1, panel2;
	JLabel label, label2;
	JTextField text_in;
	
	public GUI(String title, double etrepeneur, double not_etrepeneur)
	{
		this.title = title;
		this.etrepeneur = etrepeneur;
		this.not_etrepeneur = not_etrepeneur;
		
		frame = new JFrame(title);
		
		//Frame having "frame" is unneccessary but i like it
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create buttons
		button = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		
		//create panel
		panel1 = new JPanel();
		panel1.setBackground(new Color(217, 160, 250));
		panel1.setLayout(new GridLayout(5, 2));
		frame.add(panel1);
		
		//create a count label
		label = new JLabel("Etrepeneur likelihood " + etrepeneur, JLabel.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.white);
		panel1.add(label);
		
				
		//add the changing message label
		label2 = new JLabel("Not Etrpeneur Likelihood "+not_etrepeneur, JLabel.CENTER);
		label2.setOpaque(true);
		label2.setBackground(Color.LIGHT_GRAY);
		panel1.add(label2);
		
		//add the counter button to the panel
		button.setText("Counter");
		button.setToolTipText("Count number of click");
		button.setBackground(Color.blue);
		button.setOpaque(true);
		panel1.add(button);
		//button.setPreferredSize(getPreferredSize());
		//button.setBorderPainted(false);
		
		//add close app button
		button2.setText("Close");
		button2.setToolTipText("Close App");
		button2.setBackground(Color.cyan);
		button2.setOpaque(true);
		panel1.add(button2);
		//button2.setBorderPainted(false);	
		
		//make message button and add it to panel
		button3.setText("Message");
		button3.setToolTipText("show a message");
		button3.setBackground(Color.orange);
		button3.setOpaque(true);
		panel1.add(button3);
		
		//make new text field
		text_in = new JTextField();
		text_in.setToolTipText("Input the text you want to input");
		text_in.setText("Name");
		panel1.add(text_in);

//		panel1.add(text_in);
//		panel1.add(button);
//		panel1.add(button3);
//		//panel1.add(label);
//		panel1.add(label2);
//		panel1.add(button2);
		
		pack();
	}
	
	
}
