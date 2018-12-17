package sk.upjs.paz1c.multilingo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.entities.Test;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;

@SuppressWarnings("restriction")
public class CourseDetailController {

	private CourseDao courseDao = DaoFactory.INSTANCE.getCourseDao();
	private ObservableList<Student> students;

	@FXML
	private Text timeOfLectureText;

	@FXML
	private ListView<Student> studentsListView;

	@FXML
	private Text levelText;

	@FXML
	private Text startOfCourseText;

	@FXML
	private Text languageTaughtText;

	@FXML
	private Text taughtInText;

	@FXML
	private Text endOfCourseText;

	@FXML
	private TextArea informationText;

	private Course course;

	public CourseDetailController(Course course) {
		this.course = course;
	}

	@FXML
	void initialize() {

		// iba prepojenie s textfieldami a hodnotami kurzu
		timeOfLectureText.setText(course.getTimeOfLectures());
		levelText.setText(course.getLevel());

		// Zdroj :
		// https://stackoverflow.com/questions/28177370/how-to-format-localdate-to-string
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDateTime = course.getStartOfCourse().format(formatter);
		String formattedDateTime2 = course.getEndOfCourse().format(formatter);

		startOfCourseText.setText(formattedDateTime);
		endOfCourseText.setText(formattedDateTime2);
		languageTaughtText.setText(course.getLanguageTaught());
		taughtInText.setText(course.getTaughtIn());
		informationText.setText(course.getInformation());
		informationText.setEditable(false);

		// vypisanie studentov
		students = FXCollections.observableArrayList(courseDao.getStudentsTakenTheCourse(course.getId()));
		studentsListView.setItems(students);

	}
}
