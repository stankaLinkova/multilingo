package sk.upjs.paz1c.multilingo.entities;

public class School {

	private Long id;
	private String name;
	private String address;
	private String email;


	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Name: " + name + ", Address: " + address+", E-mail: " + email;
	}
}
