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
	
	public StudentFxModel(Student student) {
		this.student = student;
		setName(student.getName());
		setSurname(student.getSurname());
		setEmail(student.getEmail());
	}
	
	public Student getStudent() {
		student.setName(getName());
		student.setSurname(getSurname());
		student.setEmail(getEmail());
		return student;
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
