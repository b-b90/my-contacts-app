package model;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import domen.Contact;

public class Model {
	
	private static final String fileName = "contacts.txt";
	
	public static ArrayList<Contact> readTheFile() {
		
		BufferedReader readContacts = null;
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		try {
			
			readContacts = new BufferedReader(new FileReader(new File(fileName)));
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
			
			return contacts;
		} catch(IOException e) {
			
			e.printStackTrace();
			
			return contacts;
		} finally {
			
			try {
				readContacts.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
