package sk.upjs.paz1c.multilingo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.upjs.paz1c.multilingo.entities.School;

@SuppressWarnings("restriction")
public class SchoolFxModel {
	
	private School school;
	private StringProperty name = new SimpleStringProperty();
	private StringProperty address = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	private StringProperty login = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	
	public SchoolFxModel(School school) {
		this.school = school;
		setName(school.getName());
		setAddress(school.getAddress());
		setEmail(school.getEmail());
		setLogin(school.getLogin());
		setPassword(school.getPassword());
		
	}

	public SchoolFxModel() {
		
	}
	
	public School getSchool() {
		school = new School();
		school.setName(getName());
		school.setAddress(getAddress());
		school.setEmail(getEmail());
		school.setLogin(getLogin());
		school.setPassword(getPassword());
		return school;
	}

	
	
	public StringProperty loginProperty() {
		return login;
	}

	public String getLogin() {
		return login.get();
	}
	
	public void setLogin(String login) {
		this.login.set(login);
	}
	
	public StringProperty passwordProperty() {
		return password;
	}

	public String getPassword() {
		return password.get();
	}
	
	public void setPassword(String password) {
		this.password.set(password);
	}
	
	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public StringProperty emailProperty() {
		return this.email;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}

	public String getAddress() {
		return address.get();
	}

	public void setAddress(String surname) {
		this.address.set(surname);
	}

	public StringProperty addressProperty() {
		return address;
	}
}
