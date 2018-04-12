package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
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
	
	private void readTheFile() {}

}
