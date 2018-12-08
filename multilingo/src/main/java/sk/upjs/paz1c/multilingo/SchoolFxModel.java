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

	public SchoolFxModel(School school) {
		this.school = school;
		setName(school.getName());
		setAddress(school.getAddress());
		setEmail(school.getEmail());
	}

	public School getSchool() {
		school.setName(getName());
		school.setAddress(getAddress());
		school.setEmail(getEmail());
		return school;
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

	public StringProperty AddressProperty() {
		return address;
	}
}
