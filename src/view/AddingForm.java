package view;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
