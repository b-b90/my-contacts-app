package domen;

public class Contact {
	
	private String name, surname, telNumber;
	
	public Contact() {}
	
	public Contact(String name, String surname, String number) {
		
		this.name = name;
		this.surname = surname;
		this.telNumber = number;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getTelNumber() {
		return telNumber;
	}
	
	public String toString() {
		
		return "Name: " + name + ";" + " Surname: " + surname + ";" + " Telphone number: " + telNumber + ";";
	}

}
