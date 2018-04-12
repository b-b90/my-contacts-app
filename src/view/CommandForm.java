package view;

import javax.swing.*;

public class CommandForm {
	
	public void go() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel textboxLabel = new JLabel("Contact:");
		JTextField topTextbox = new JTextField();
		JRadioButton fullRadio = new JRadioButton("Full data");
		JRadioButton partRadio = new JRadioButton("Part of data");
		ButtonGroup radioGroup = new ButtonGroup();
		JButton searchButton = new JButton("Search");
		JTable table = new JTable();
		JScrollPane scroll = new JScrollPane();
		JButton showButton = new JButton("Show contact");
		JButton addButton = new JButton("Add contact");
	}

}
