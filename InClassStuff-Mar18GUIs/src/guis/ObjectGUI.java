package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

public class ObjectGUI extends JFrame implements ActionListener {

	//declare all widgets and data fields

	private JTextField inputField;
	private JButton createButton, rollButton;
	private JTextArea outputArea;
	
	private JPanel inputPanel, outputPanel;
	
	private Die myDie;
	
	public ObjectGUI() {
		
		inputField = new JTextField(5);
		createButton = new JButton("Create");
		rollButton = new JButton("Roll!");
		rollButton.setEnabled(false);
		outputArea = new JTextArea(10,30);
	
		inputField.addActionListener(this);
		createButton.addActionListener(this);
		rollButton.addActionListener(this);
		
		
		inputPanel = new JPanel();
		outputPanel = new JPanel();
		
		inputPanel.setLayout(new GridLayout(1,3));
		
		this.setLayout(new FlowLayout());
		
		inputPanel.add(inputField);
		inputPanel.add(createButton);
		inputPanel.add(rollButton);
		
		outputPanel.add(new JScrollPane(outputArea));
		
		this.add(inputPanel);
		this.add(outputPanel);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputField || e.getSource() == createButton) {
			try {
				int numSides = Integer.parseInt(inputField.getText());
				myDie = new Die(numSides);
				outputArea.append("You created: " + myDie + "\n");
				rollButton.setEnabled(true);
			}
			catch(NumberFormatException g) {
				JOptionPane.showMessageDialog(null, "That's not ideal.");
			}
			catch(IllegalArgumentException f) {
				JOptionPane.showMessageDialog(null, "Not a valid number of sides.");
			}
			
		}
		else if(e.getSource() == rollButton) {
			myDie.roll();
			outputArea.append("You rolled: " + myDie.getSideUp() + "\n");
		}
		else
			System.out.println("Something happened - don't know where!?");

			
	}
	
	public static void main(String[] args) {
		//call to the constructor to create the object
		ObjectGUI gui = new ObjectGUI();
		
		//GUI behaviours
		gui.setVisible(true); //can see the GUI
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //this is what the x button 
		gui.setSize(500,300);  //default size of GUI in pixels, width,height
		gui.setTitle("GUIs are Great!");  //title on the Windows
		gui.setResizable(true);
	}


}
