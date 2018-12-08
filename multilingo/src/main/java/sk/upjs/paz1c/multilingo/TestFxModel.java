package sk.upjs.paz1c.multilingo;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.upjs.paz1c.multilingo.entities.Test;

@SuppressWarnings("restriction")
public class TestFxModel {

	private Test test;
	private StringProperty createdBy = new SimpleStringProperty();
	private ObjectProperty<LocalDate> createdDate = new SimpleObjectProperty<LocalDate>();
	private DoubleProperty numberOfQuestions = new SimpleDoubleProperty();
	private StringProperty language = new SimpleStringProperty();
	private StringProperty level = new SimpleStringProperty();
	
	public TestFxModel(Test test) {
		this.test = test;
		setCreatedBy(test.getCreatedBy());
		setCreatedDate(test.getCreatedDate());
		setNumberOfQuestions(test.getNumberOfQuestions());
		setLanguage(test.getLanguage());
		setLevel(test.getLevel());
	}
	
	public void setTest(Test test) {
		setCreatedBy(test.getCreatedBy());
		setCreatedDate(test.getCreatedDate());
		setNumberOfQuestions(test.getNumberOfQuestions());
		setLanguage(test.getLanguage());
		setLevel(test.getLevel());
	}
	
	public Test getTest() {
		Test t = new Test();
		t.setCreatedBy(getCreatedBy());
		t.setCreatedDate(getCreatedDate());
		t.setNumberOfQuestions(getNumberOfQuestions());
		t.setLanguage(getLanguage());
		t.setLevel(getLevel());
		return t;
	}
	
	public String getCreatedBy() {
		return createdBy.get();
	}
	public void setCreatedBy(String name) {
		this.createdBy.set(name);
	}
	public StringProperty createdByProperty() {
		return createdBy;
	}
	public LocalDate getCreatedDate() {
		return createdDate.get();
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate.set(createdDate);
	}
	public ObjectProperty<LocalDate> createdDateProperty() {
		return createdDate;
	}
	public Double getNumberOfQuestions() {
		return numberOfQuestions.get();
	}
	public void setNumberOfQuestions(Double numberOfQuestions) {
		this.numberOfQuestions.set(numberOfQuestions);
	}
	public DoubleProperty numberOfQuestionsProperty() {
		return numberOfQuestions;
	}
	public String getLanguage() {
		return language.get();
	}
	public void setLanguage(String language) {
		this.language.set(language);
	}
	public StringProperty languageProperty() {
		return language;
	}
	public String getLevel() {
		return level.get();
	}
	public void setLevel(String level) {
		this.level.set(level);
	}
	public StringProperty nameProperty() {
		return level;
	}
}
