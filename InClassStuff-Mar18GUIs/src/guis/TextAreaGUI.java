package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaGUI extends JFrame implements ActionListener {

	//declare all widgets and data fields
	private JLabel label1, label2, label3;
	private JButton button1, button2;
	private JTextField input;
	private JTextArea output;
	private JPanel inputPanel, outputPanel, mainPanel;
	private double sum;
	
	public TextAreaGUI() {
		
		//initialize all widgets and data fields
		label1 = new JLabel("Enter A number: ");
		input = new JTextField(10);
		input.addActionListener(this);
		
		//label2 = new JLabel("");
		button1 = new JButton("Go!");
		button1.addActionListener(this); //tell the button to listen for a button click
		button2 = new JButton("Clear All");
		button2.addActionListener(this); //tell the button to listen for a button click
		
		output = new JTextArea(10, 30);
		
		
		//set up the panel
		inputPanel = new JPanel();  //panels have a default layout of FlowLayout
		inputPanel.setLayout(new GridLayout(2,2));
		
		//add widgets to panel
		inputPanel.add(label1);
		inputPanel.add(input);
		inputPanel.add(button1);
		inputPanel.add(button2);
		
		outputPanel = new JPanel();
		outputPanel.setLayout(new FlowLayout());
		outputPanel.add(new JScrollPane(output));
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		//add panel to canvas (window)
		mainPanel.add(inputPanel);
		mainPanel.add(outputPanel);
		
		
		this.add(mainPanel);
		
		sum = 0;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1 || e.getSource() == input) {
			double num = Double.parseDouble(input.getText());
			sum += num;
			//output.setText("Sum: " + sum);  //set the text to whatever
			output.append("Sum: " + sum + "\n"); 
			input.setText(""); //clear the text field
			
		}
		else if(e.getSource() == button2) {
			input.setText("");
			output.setText("");
			sum = 0;
		}
		else {
			System.out.println("Something terrible has happened.");
		}
	}
	
	public static void main(String[] args) {
		//call to the constructor to create the object
		TextAreaGUI gui = new TextAreaGUI();
		
		//GUI behaviours
		gui.setVisible(true); //can see the GUI
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //this is what the x button 
		gui.setSize(500,300);  //default size of GUI in pixels, width,height
		gui.setTitle("GUIs are Great!");  //title on the Windows
		gui.setResizable(true);
	}


}
