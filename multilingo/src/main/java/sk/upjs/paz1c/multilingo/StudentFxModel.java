package sk.upjs.paz1c.multilingo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.upjs.paz1c.multilingo.entities.Student;

@SuppressWarnings("restriction")
public class StudentFxModel {

	private Student student;
	private StringProperty name = new SimpleStringProperty();
	private StringProperty surname = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	private StringProperty login = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	
	public StudentFxModel(Student student) {
		this.student = student;
		setName(student.getName());
		setSurname(student.getSurname());
		setEmail(student.getEmail());
		setLogin(student.getLogin());
		setPassword(student.getPassword());
	}
	
	public StudentFxModel() {
		
	}
	
	public Student getStudent() {
		student = new Student();
		student.setName(getName());
		student.setSurname(getSurname());
		student.setEmail(getEmail());
		student.setLogin(getLogin());
		student.setPassword(getPassword());
		return student;
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
	public String getSurname() {
		return surname.get();
	}
	public void setSurname(String surname) {
		this.surname.set(surname);
	}
	public StringProperty surnameProperty() {
		return surname;
	}
}
