package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class AddingForm {
	
	JFrame frame = new JFrame("Add new contact");
	JPanel panel = new JPanel();
	JLabel nameLabel = new JLabel("Name:");
	JLabel surnameLabel = new JLabel("Surname:");
	JLabel numberLabel = new JLabel("Telephone number:");
	JTextField nameText = new JTextField();
	JTextField surnameText = new JTextField();
	JTextField numberText = new JTextField();
	JButton saveButton = new JButton("Save contact");
	
	public void add() {
		
		nameLabel.setBounds(15, 40, 120, 20);
		surnameLabel.setBounds(15, 80, 120, 20);
		numberLabel.setBounds(15, 120, 120, 20);
		
		nameText.setBounds(145, 40, 120, 25);
		surnameText.setBounds(145, 80, 120, 25);
		numberText.setBounds(145, 120, 120, 25);
		
		saveButton.setBounds(70, 170, 150, 30);
		saveButton.addActionListener(new SaveListener());
		
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(numberLabel);
		panel.add(numberText);
		panel.add(surnameLabel);
		panel.add(surnameText);
		panel.add(saveButton);
		panel.setLayout(null);
		
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setLocation(500, 200);
		frame.setVisible(true);
	}
	
	class SaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (nameText.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(frame, "You must enter a name", "Enter name", JOptionPane.WARNING_MESSAGE);
			} else if (surnameText.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(frame, "You must enter a surname", "Enter surname", JOptionPane.WARNING_MESSAGE);
			} else if (numberText.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(frame, "You must enter a number", "Enter number", JOptionPane.WARNING_MESSAGE);
			} else {
				
				try {
					
					PrintWriter newContact = new PrintWriter(new FileWriter(new File("contacts.txt"), true));
					
					newContact.println(nameText.getText() + ";" + surnameText.getText() + ";" + numberText.getText());
					
					JOptionPane.showMessageDialog(frame, "Contact is saved", "Success", JOptionPane.INFORMATION_MESSAGE);
					
					nameText.setText("");
					surnameText.setText("");
					numberText.setText("");
					
					newContact.close();
					
				} catch (IOException ev) {
					
					ev.printStackTrace();
					
					JOptionPane.showMessageDialog(frame, "Contact is not saved", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
		
	}
}
