package model;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import domen.Contact;

public class Model {
	
	private static final String fileName = "contacts.txt";
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	public Model() {
		
		readTheFile();
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	
	private void readTheFile() {
		
		try {
			
			BufferedReader readContacts = new BufferedReader(new FileReader(new File(fileName)));
			String contactRow = "";
			Contact contact;
			
			while ((contactRow = readContacts.readLine()) != null) {
				
				StringTokenizer token = new StringTokenizer(contactRow, ";");
				String name = token.nextToken();
				String surname = token.nextToken();
				String number = token.nextToken();
				
				contact = new Contact(name, surname, number);
				contacts.add(contact);
			}
			
			readContacts.close();
		} catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
