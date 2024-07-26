package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFirstGUI extends JFrame implements ActionListener {

	//declare all widgets and data fields
	private JLabel label1, label2, label3;
	private JButton button1, button2;
	private JTextField field1, field2;
	private JPanel panel1;
	private double sum;
	
	public MyFirstGUI() {
		
		//initialize all widgets and data fields
		label1 = new JLabel("Enter A number: ");
		field1 = new JTextField(10);
		field1.addActionListener(this);
		
		//label2 = new JLabel("");
		field2 = new JTextField(30);
		field2.setEditable(false);
		button1 = new JButton("Go!");
		button1.addActionListener(this); //tell the button to listen for a button click
		button2 = new JButton("Exit");
		button2.addActionListener(this); //tell the button to listen for a button click
		
		
		//set up the panel
		panel1 = new JPanel();  //panels have a default layout of FlowLayout
		panel1.setLayout(new FlowLayout());
		
		//add widgets to panel
		panel1.add(label1);
		panel1.add(field1);
		panel1.add(button1);
		panel1.add(field2);
		panel1.add(button2);
		
		//add panel to canvas (window)
		this.add(panel1);
		
		sum = 0;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1 || e.getSource() == field1) {
			double num = Double.parseDouble(field1.getText());
			sum += num;
			field2.setText("Sum: " + sum);
		}
		else if(e.getSource() == button2) {
			System.exit(0);
		}
		else {
			System.out.println("Something terrible has happened.");
		}
	}
	
	public static void main(String[] args) {
		//call to the constructor to create the object
		MyFirstGUI gui = new MyFirstGUI();
		
		//GUI behaviours
		gui.setVisible(true); //can see the GUI
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //this is what the x button 
		gui.setSize(1000,300);  //default size of GUI in pixels, width,height
		gui.setTitle("GUIs are Great!");  //title on the Windows
		gui.setResizable(true);
	}


}
