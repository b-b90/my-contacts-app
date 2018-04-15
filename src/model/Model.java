package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import domen.Contact;

public class Model {
	
	private static final String fileName = "contacts.txt";
	public static Model instance = null;
	private File f;
	private Scanner s;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	public Model() {}
	
	public static Model getPod() {
		
		return instance;
	}
	
	private void readTheFile() {
		
		try {
			
			BufferedReader readContacts = new BufferedReader(new FileReader(new File(fileName)));
			String contactRow = "";
			
			while ((contactRow = readContacts.readLine()) != null) {
				
				StringTokenizer token = new StringTokenizer(contactRow, ";");
				String name = token.nextToken();
				String surname = token.nextToken();
				String number = token.nextToken();
				
				Contact contact = new Contact(name, surname, number);
				contacts.add(contact);
				
				System.out.println(contact);
			}
			
			readContacts.close();
		} catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
