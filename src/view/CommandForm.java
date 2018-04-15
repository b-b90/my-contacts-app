package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CommandForm {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel textboxLabel = new JLabel("Contact:");
	JTextField topTextbox = new JTextField();
	JRadioButton fullRadio = new JRadioButton("Full data");
	JRadioButton partRadio = new JRadioButton("Part of data");
	ButtonGroup radioGroup = new ButtonGroup();
	JButton searchButton = new JButton("Search");
	JTable table = new JTable();
	JScrollPane scroll = new JScrollPane(table);
	JButton showButton = new JButton("Show contact");
	JButton addButton = new JButton("Add contact");
	ViewForm view = new ViewForm();
	AddingForm add = new AddingForm();
	
	public void go() {
		
		textboxLabel.setBounds(80, 20, 60, 20);
		topTextbox.setBounds(150, 20, 200, 25);
		
		radioGroup.add(fullRadio);
		radioGroup.add(partRadio);
		fullRadio.setBounds(155, 70, 100, 25);
		partRadio.setBounds(255, 70, 100, 25);
		
		searchButton.setBounds(180, 120, 120, 30);
		showButton.setBounds(120, 470, 120, 30);
		showButton.addActionListener(new ShowListener());
		addButton.setBounds(250, 470, 120, 30);
		addButton.addActionListener(new AddListener());
		
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(4, 165, 475, 290);
		
		panel.setLayout(null);
		panel.add(textboxLabel);
		panel.add(topTextbox);
		panel.add(fullRadio);
		panel.add(partRadio);
		panel.add(searchButton);
		panel.add(showButton);
		panel.add(addButton);
		panel.add(scroll);
		
		frame.add(panel);
		frame.setSize(500, 550);
		frame.setLocation(400, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ShowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			view.view();
			
		}		
	}
	
	class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			add.add();
			
		}		
	}

}
