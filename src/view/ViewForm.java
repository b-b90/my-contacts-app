package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewForm implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel nameLabel1 = new JLabel("Name:");
	JLabel nameLabel2 = new JLabel();
	JLabel surnameLabel1 = new JLabel("Surname:");
	JLabel surnameLabel2 = new JLabel();
	JLabel numberLabel1 = new JLabel("Telephone number:");
	JLabel numberLabel2 = new JLabel();
	JButton closeButton = new JButton("Close");
	
	public void view() {
		
		nameLabel1.setBounds(20, 20, 120, 20);
		surnameLabel1.setBounds(20, 60, 120, 20);
		numberLabel1.setBounds(20, 100, 120, 20);
		
		nameLabel2.setBounds(145, 20, 120, 25);
		surnameLabel2.setBounds(145, 60, 120, 25);
		numberLabel2.setBounds(145, 100, 120, 25);
		
		closeButton.setBounds(60, 180, 150, 30);
		closeButton.addActionListener(this);
		
		panel.setLayout(null);
		panel.setBackground(Color.lightGray);
		panel.add(nameLabel1);
		panel.add(nameLabel2);
		panel.add(numberLabel1);
		panel.add(numberLabel2);
		panel.add(surnameLabel1);
		panel.add(surnameLabel2);
		panel.add(closeButton);
		
		frame.add(panel);
		frame.setSize(290, 300);
		frame.setLocation(500, 200);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		frame.setVisible(false);
	}
}
