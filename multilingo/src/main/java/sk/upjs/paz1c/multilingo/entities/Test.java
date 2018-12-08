package sk.upjs.paz1c.multilingo.entities;

import java.time.LocalDate;

public class Test {

	private Long id;
	private String createdBy;
	private LocalDate createdDate;
	private Double numberOfQuestions;
	private String language;
	private String level;
	private Long idSchool;
	
	
	public Long getIdSchool() {
		return idSchool;
	}

	public void setIdSchool(Long idSchool) {
		this.idSchool = idSchool;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public double getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(double numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	

	@Override
	public String toString() {
		return "Created by: " + createdBy + ", Date of creation: " + createdDate + ", Number of questions: "
				+ numberOfQuestions + ", Language: " + language + ", Level: " + level;
	}

}
