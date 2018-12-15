package sk.upjs.paz1c.multilingo;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.upjs.paz1c.multilingo.entities.Course;

@SuppressWarnings("restriction")
public class CourseFxModel {
	
	//fxmodel kurzu, ktory vytvori a nasetuje hodnoty zo scen
	
	private Course course;
	private StringProperty languageTaught = new SimpleStringProperty();
	private StringProperty taughtIn = new SimpleStringProperty();
	private StringProperty level = new SimpleStringProperty();
	private ObjectProperty<LocalDate> startOfCourse = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<LocalDate> endOfCourse = new SimpleObjectProperty<LocalDate>();
	private StringProperty timeOfLectures = new SimpleStringProperty();
	private StringProperty information = new SimpleStringProperty();
	private Long idSchool;

	CourseFxModel(Course course){
		this.course = course;
		setLanguageTaught(course.getLanguageTaught());
		setTaughtIn(course.getTaughtIn());
		setLevel(course.getLevel());
		setStartOfCourse(course.getStartOfCourse());
		setEndOfCourse(course.getEndOfCourse());
		setTimeOfLectures(course.getTimeOfLectures());
		setInformation(course.getInformation());
		setIdSchool(course.getSchoolId());
		
	}
	
	public CourseFxModel() {
		
	}
	

	public Course getCourse() {
		course = new Course();
		course.setLanguageTaught(getLanguageTaught());
		course.setTaughtIn(getTaughtIn());
		course.setLevel(getLevel());
		course.setStartOfCourse(getStartOfCourse());
		course.setEndOfCourse(getEndOfCourse());
		course.setTimeOfLectures(getTimeOfLectures());
		course.setInformation(getInformation());
		course.setSchoolId(getIdSchool());
		
		return course;
	}
	
	

	public Long getIdSchool() {
		return idSchool;
	}

	public void setIdSchool(Long idSchool) {
		this.idSchool = idSchool;
	}

	public String getLanguageTaught() {
		return languageTaught.get();
	}

	public void setLanguageTaught(String languageTaught) {
		this.languageTaught.set(languageTaught);
	}

	public StringProperty languageTaughtProperty() {
		return languageTaught;
	}

	public String getTaughtIn() {
		return taughtIn.get();
	}

	public void setTaughtIn(String taughtIn) {
		this.taughtIn.set(taughtIn);
	}

	public StringProperty taughtInProperty() {
		return taughtIn;
	}

	public String getLevel() {
		return level.get();
	}

	public void setLevel(String level) {
		this.level.set(level);
	}

	public StringProperty levelProperty() {
		return level;
	}

	public LocalDate getStartOfCourse() {
		return startOfCourse.get();
	}

	public void setStartOfCourse(LocalDate startOfCourse) {
		this.startOfCourse.set(startOfCourse);
	}

	public ObjectProperty<LocalDate> startOfCourseProperty() {
		return startOfCourse;
	}

	public LocalDate getEndOfCourse() {
		return endOfCourse.get();
	}

	public void setEndOfCourse(LocalDate endOfCourse) {
		this.endOfCourse.set(endOfCourse);
	}

	public ObjectProperty<LocalDate> endOfCourseProperty() {
		return endOfCourse;
	}

	public String getTimeOfLectures() {
		return timeOfLectures.get();
	}

	public void setTimeOfLectures(String timeOfLectures) {
		this.timeOfLectures.set(timeOfLectures);
	}

	public StringProperty timeOfLecturesProperty() {
		return timeOfLectures;
	}

	public String getInformation() {
		return information.get();
	}

	public void setInformation(String information) {
		this.information.set(information);
	}

	public StringProperty informationProperty() {
		return information;
	}
}
