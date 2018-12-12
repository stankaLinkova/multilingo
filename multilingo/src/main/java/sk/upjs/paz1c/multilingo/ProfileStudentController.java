package sk.upjs.paz1c.multilingo;
import java.io.IOException;
import java.util.Arrays;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.entities.Test;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.StudentDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

@SuppressWarnings("restriction")
public class ProfileStudentController {

	private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();
	private ObservableList<Course> courses;
	private Course selectedCourse;
	private ObservableList<Object[]> tests;
	private Object[] selectedTest;
	private CourseDao courseDao = DaoFactory.INSTANCE.getCourseDao();
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();
    
	@FXML
    private ListView<Course> showCoursesListView;

    @FXML
    private Button showProfileButton;

    @FXML
    private Text emailStudentText;

    @FXML
    private Button removeTestButton;

    @FXML
    private Button logoutButton;

    @FXML
    private ListView<Object[]> showTestsListView;

    @FXML
    private Text loginStudentText;

    @FXML
    private Text nameSurnameStudentText;

    @FXML
    private Button detailCourseButton;
    
    @FXML
    private Button showCoursesButton;

    @FXML
    private Button removeCourseButton;

    @FXML
    private Button showTestsButton;

    private Student student;
    
    public ProfileStudentController(Student student) {
		this.student = student;
	}

	@FXML
    void initialize() {
		
		loginStudentText.setText(student.getLogin());
		emailStudentText.setText(student.getEmail());
		nameSurnameStudentText.setText(student.getName() +" "+ student.getSurname());
		
		courses = FXCollections.observableArrayList(studentDao.getMyCourses(student.getId()));
		showCoursesListView.setItems(courses);
		showCoursesListView.getSelectionModel().selectFirst();
		selectedCourse = showCoursesListView.getSelectionModel().getSelectedItem();
		showCoursesListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {

			public void changed(ObservableValue<? extends Course> observable, Course oldValue, Course newValue) {
				selectedCourse = newValue;								
			}
		});
		
		tests = FXCollections.observableArrayList(studentDao.getCompletedTests(student.getId()));
		showTestsListView.setItems(tests);
		int size = tests.size();
		System.out.println(size);
		System.out.println(studentDao.getCompletedTests(student.getId()).get(0));
//		String[] stringArray = Arrays.copyOf(studentDao.getCompletedTests(student.getId()).get(0), size, String[].class);
//		SysString[] stringArray = Arrays.copyOf(studentDao.getCompletedTests(student.getId()).get(0), size, String[].class);
//		tem.out.println(stringArray);
		showTestsListView.getSelectionModel().selectFirst();
		selectedTest = showTestsListView.getSelectionModel().getSelectedItem();
		showTestsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object[]>() {

			public void changed(ObservableValue<? extends Object[]> observable, Object[] oldValue, Object[] newValue) {
				if(newValue ==null) {
					selectedTest = oldValue;
				} else {
					selectedTest = newValue;
				}
				
			}
		});
		
		
		
    	showCoursesButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				CoursesStudentController coursesStudentController = new CoursesStudentController(student);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("courses_student_scene.fxml"));
				fxmlLoader.setController(coursesStudentController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) showCoursesButton.getScene().getWindow();
				stage.setTitle("MultiLingo: Courses");
				stage.setScene(scene);
				stage.show();
			}
		});
    	
    	showTestsButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				TestsStudentController testsStudentController = new TestsStudentController(student);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tests_student_scene.fxml"));
				fxmlLoader.setController(testsStudentController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) showTestsButton.getScene().getWindow();
				stage.setTitle("MultiLingo: Tests");
				stage.setScene(scene);
				stage.show();
			}
		});
    	
    	logoutButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				SignInController signInController = new SignInController();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log_in_scene.fxml"));
				fxmlLoader.setController(signInController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) logoutButton.getScene().getWindow();
				stage.setTitle("MultiLingo: Sign in");
				stage.setScene(scene);
				stage.show();
			}
		});
    	
    	detailCourseButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				CourseDetailController courseDetailController = new CourseDetailController(selectedCourse);       
				showModalWindow(courseDetailController, "course_detail_scene.fxml");
			}
		});
    	
    	//TODO odstran aj studenta z db kurzov a testov
    	removeCourseButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				showCoursesListView.getItems().remove(selectedCourse);
						
				
			}
		});
    	
    	removeTestButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				showTestsListView.getItems().remove(selectedTest);
			}
		});
    }
    
    private void showModalWindow(Object controller, String fxml) {
		try {
			FXMLLoader fxmlLoader = new	FXMLLoader(getClass().getResource(fxml));
			fxmlLoader.setController(controller);
			Parent rootPane	= fxmlLoader.load();
			Scene scene	= new Scene(rootPane);
			
			Stage dialog = new Stage();
			dialog.setScene(scene);
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
