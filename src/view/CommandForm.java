package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Model;

public class CommandForm {
	
	JFrame frame;
	JPanel panel;
	JLabel textboxLabel;
	JTextField topTextbox;
	JRadioButton fullRadio;
	JRadioButton partRadio;
	JRadioButton allRadio;
	ButtonGroup radioGroup;
	JButton searchButton;
	JTable table;
	JScrollPane scroll;
	JButton showButton;
	JButton addButton;
	JButton deleteButton;
	ViewForm viewForm;
	AddingForm addForm;
	DefaultTableModel model;
	Model m;
	String [] columns = {"Name", "Surname", "Number"};
	
	public void go() {
		
		textboxLabel = new JLabel("Contact:");
		textboxLabel.setBounds(80, 20, 60, 20);
		topTextbox = new JTextField();
		topTextbox.setBounds(150, 20, 200, 25);
		
		fullRadio = new JRadioButton("Full data");
		partRadio = new JRadioButton("Part of data");
		allRadio = new JRadioButton("View all");
		radioGroup = new ButtonGroup();
		radioGroup.add(fullRadio);
		radioGroup.add(partRadio);
		radioGroup.add(allRadio);
		fullRadio.setBounds(110, 70, 90, 25);
		partRadio.setBounds(200, 70, 100, 25);
		allRadio.setBounds(310, 70, 90, 25);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(180, 120, 120, 30);
		searchButton.addActionListener(new SearchListener());
		showButton = new JButton("Show contact");
		showButton.setBounds(50, 470, 120, 30);
		showButton.addActionListener(new ShowListener());
		addButton = new JButton("Add contact");
		addButton.setBounds(180, 470, 120, 30);
		addButton.addActionListener(new AddListener());
		deleteButton = new JButton("Delete contact");
		deleteButton.setBounds(310, 470, 120, 30);
		deleteButton.addActionListener(new DeleteListener());
		
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columns);
		scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(4, 165, 475, 290);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(textboxLabel);
		panel.add(topTextbox);
		panel.add(fullRadio);
		panel.add(partRadio);
		panel.add(allRadio);
		panel.add(searchButton);
		panel.add(showButton);
		panel.add(addButton);
		panel.add(deleteButton);
		panel.add(scroll);
		
		frame = new JFrame();
		frame.add(panel);
		frame.setSize(500, 550);
		frame.setLocation(400, 120);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class SearchListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			m = new Model();
			Object [] rowData = new Object[3];
			model.setRowCount(0);
			
			for (int i = 0; i < m.getContacts().size(); i++) {
				
				if (topTextbox.getText().equals("") || allRadio.isSelected()) {
					
					if (allRadio.isSelected()) {
						
						rowData[0] = m.getContacts().get(i).name;
						rowData[1] = m.getContacts().get(i).surname;
						rowData[2] = m.getContacts().get(i).telNumber;
						model.addRow(rowData);
					} else {
						
						JOptionPane.showMessageDialog(frame, "You must enter search parametres", "Enter search parametres", JOptionPane.WARNING_MESSAGE);
						
						break;
					}
				} else {
					
					if (fullRadio.isSelected() && (topTextbox.getText().toLowerCase().equals(m.getContacts().get(i).name.toLowerCase()) || topTextbox.getText().toLowerCase().equals(m.getContacts().get(i).surname.toLowerCase()))) {
						
						rowData[0] = m.getContacts().get(i).name;
						rowData[1] = m.getContacts().get(i).surname;
						rowData[2] = m.getContacts().get(i).telNumber;
						model.addRow(rowData);
					} else if (partRadio.isSelected() && (m.getContacts().get(i).name.toLowerCase().contains(topTextbox.getText().toLowerCase()) || m.getContacts().get(i).surname.toLowerCase().contains(topTextbox.getText().toLowerCase()))) {
						
						rowData[0] = m.getContacts().get(i).name;
						rowData[1] = m.getContacts().get(i).surname;
						rowData[2] = m.getContacts().get(i).telNumber;
						model.addRow(rowData);
					} else if (fullRadio.isSelected() == false && partRadio.isSelected() == false) {
						
						JOptionPane.showMessageDialog(frame, "You didn't select any of radio buttons", "Select full or part radio buttons", JOptionPane.WARNING_MESSAGE);
						
						break;
					}	
				}	
			}
			
			if (model.getRowCount() == 0 && (fullRadio.isSelected() == true || partRadio.isSelected() == true) && !topTextbox.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(frame, "We couldn't find contact with that parametres", "No contact", JOptionPane.INFORMATION_MESSAGE);
			}
		}		
	}
	
	class ShowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			viewForm = new ViewForm();
			int index = table.getSelectedRow();
			
			if (index >= 0) {
			
				String name = model.getValueAt(index, 0).toString();
				String surname = model.getValueAt(index, 1).toString();
				String number = model.getValueAt(index, 2).toString();
			
				viewForm.nameLabel2.setText(name);
				viewForm.surnameLabel2.setText(surname);
				viewForm.numberLabel2.setText(number);
				viewForm.view();
			} else {
				
				JOptionPane.showMessageDialog(frame, "You didn't select contact!", "Select contact", JOptionPane.WARNING_MESSAGE);
			}
			
		}		
	}
	
	class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			addForm = new AddingForm();
			addForm.add();
			
		}		
	}
	
	class DeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			m = new Model();
			int index = table.getSelectedRow();
			BufferedReader readContacts = null;
			PrintWriter newContact = null;
			File contacts = null;
			File contacts1 = null;
			
			if (index >= 0) {
				
				String numberDelete = model.getValueAt(index, 2).toString();
				model.removeRow(index);
				
				try {
					contacts = new File("contacts.txt");
					readContacts = new BufferedReader(new FileReader(contacts));
					
					contacts1 = new File("contacts1.txt");
					contacts1.createNewFile();
					newContact = new PrintWriter(new FileWriter(contacts1, true));
					
					String contactRow = "";
					
					while ((contactRow = readContacts.readLine()) != null) {
						
						StringTokenizer token = new StringTokenizer(contactRow, ";");
						String name = token.nextToken();
						String surname = token.nextToken();
						String number = token.nextToken();
						
						if (numberDelete.equals(number)) {
							
							continue;
						} else {
							
							newContact.println(name + ";" + surname + ";" + number);
						}						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					
					try {
						readContacts.close();
						newContact.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if (contacts.delete()) {
						
						contacts1.renameTo(contacts);
					}
				}
				
			} else {
				
				JOptionPane.showMessageDialog(frame, "You didn't select contact!", "Select contact", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		
	}

}
