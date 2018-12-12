package sk.upjs.paz1c.multilingo;
import java.io.IOException;

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
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.StudentDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

@SuppressWarnings("restriction")
public class TestsStudentController {
	
	private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();
	private ObservableList<Object[]> tests;
	private Object[] selectedTest;
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();


    @FXML
    private ListView<Object[]> testsListView;

    @FXML
    private Button takeATestButton;

    @FXML
    private Button showTestsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button showProfileButton;

    @FXML
    private Button showCoursesButton;
    
    private Student student;

   public TestsStudentController(Student student) {
	this.student = student;
}
	@FXML
    void initialize() {
		
		tests = FXCollections.observableArrayList(studentDao.getCompletedTests(student.getId()));
		testsListView.setItems(tests);
		int size = tests.size();
		System.out.println(size);
		System.out.println(studentDao.getCompletedTests(student.getId()).get(0));
//		String[] stringArray = Arrays.copyOf(studentDao.getCompletedTests(student.getId()).get(0), size, String[].class);
//		SysString[] stringArray = Arrays.copyOf(studentDao.getCompletedTests(student.getId()).get(0), size, String[].class);
//		tem.out.println(stringArray);
		testsListView.getSelectionModel().selectFirst();
		selectedTest = testsListView.getSelectionModel().getSelectedItem();
		testsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object[]>() {

			public void changed(ObservableValue<? extends Object[]> observable, Object[] oldValue, Object[] newValue) {
				if(newValue ==null) {
					selectedTest = oldValue;
				} else {
					selectedTest = newValue;
				}
				
			}
		});
		
		
		
		showProfileButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				ProfileStudentController profileStudentController = new ProfileStudentController(student);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile_student_scene.fxml"));
				fxmlLoader.setController(profileStudentController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) showProfileButton.getScene().getWindow();
				stage.setTitle("MultiLingo: Profile");
				stage.setScene(scene);
				stage.show();
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
    	
    	takeATestButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
			}
		});
    }
}
