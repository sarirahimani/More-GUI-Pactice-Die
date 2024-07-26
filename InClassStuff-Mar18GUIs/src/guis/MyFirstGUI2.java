package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFirstGUI2 extends JFrame implements ActionListener {

	//declare all widgets and data fields
	private JLabel label1, label2, label3;
	private JButton button1;
	private JTextField field1, field2;
	private JPanel panel1;
	private int count;
	
	public MyFirstGUI2() {
		
		//initialize all widgets and data fields
		label1 = new JLabel("Enter your name please: ");
		field1 = new JTextField(10);
		//label2 = new JLabel("");
		field2 = new JTextField(30);
		field2.setEditable(false);
		button1 = new JButton("Go!");
		button1.addActionListener(this); //tell the button to listen for a button click
		
		//set up the panel
		panel1 = new JPanel();  //panels have a default layout of FlowLayout
		panel1.setLayout(new FlowLayout());
		
		//add widgets to panel
		panel1.add(label1);
		panel1.add(field1);
		panel1.add(button1);
		panel1.add(field2);
		
		//add panel to canvas (window)
		this.add(panel1);
		
		count = 0;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		count++;
		String name = field1.getText();
		field2.setText(name + ", you clicked the button " + count + " times!");
	}
	
	public static void main(String[] args) {
		//call to the contructor to create the object
		MyFirstGUI2 gui = new MyFirstGUI2();
		
		//GUI behaviours
		gui.setVisible(true); //can see the GUI
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //this is what the x button 
		gui.setSize(1000,300);  //default size of GUI in pixels, width,height
		gui.setTitle("GUIs are Great!");  //title on the Windows
		gui.setResizable(true);
	}


}
