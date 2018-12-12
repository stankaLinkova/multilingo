package sk.upjs.paz1c.multilingo;
import java.io.IOException;
import java.util.Map;

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
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Test;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

@SuppressWarnings("restriction")
public class ProfileSchoolController {
		
	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
	private ObservableList<Course> courses;
	private Course selectedCourse;
	private ObservableList<Test> tests;
	private Test selectedTest;
	private CourseDao courseDao = DaoFactory.INSTANCE.getCourseDao();
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();


	@FXML
    private ListView<Test> testsListView;

    @FXML
    private Text nameSchoolText;

    @FXML
    private Text loginSchoolText;

    @FXML
    private Text emailSchoolText;

    @FXML
    private Button removeCourseButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button showProfileButton;

    @FXML
    private Button showCoursesButton;

    @FXML
    private Button detailCourseButton;

    @FXML
    private Text addressSchoolText;

    @FXML
    private Button removeTestButton;

    @FXML
    private Button showTestsButton;

    @FXML
    private ListView<Course> coursesListView;

    
    private School school;
    
    public ProfileSchoolController(School school) {
		this.school = school;
	}
	@FXML
    void initialize() {
		
		loginSchoolText.setText(school.getLogin());
		emailSchoolText.setText(school.getEmail());
		addressSchoolText.setText(school.getAddress());
		nameSchoolText.setText(school.getName());		
		
		courses = FXCollections.observableArrayList(schoolDao.getAllMyCourses(school.getId()));
		coursesListView.setItems(courses);
		coursesListView.getSelectionModel().selectFirst();
		selectedCourse = coursesListView.getSelectionModel().getSelectedItem();
		coursesListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {

			public void changed(ObservableValue<? extends Course> observable, Course oldValue, Course newValue) {
				selectedCourse = newValue;								
			}
		});
		
		tests = FXCollections.observableArrayList(schoolDao.getAllMyTests(school.getId()));
		testsListView.setItems(tests);
		testsListView.getSelectionModel().selectFirst();
		selectedTest = testsListView.getSelectionModel().getSelectedItem();
		testsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Test>() {

			public void changed(ObservableValue<? extends Test> observable, Test oldValue, Test newValue) {
				if(newValue ==null) {
					selectedTest = oldValue;
				} else {
					selectedTest = newValue;
				}
				
			}
		});
		
    	showCoursesButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				CoursesSchoolController coursesSchoolController = new CoursesSchoolController(school);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("courses_school_scene.fxml"));
				fxmlLoader.setController(coursesSchoolController);
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
				TestsSchoolController testsSchoolController = new TestsSchoolController(school);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tests_school_scene.fxml"));
				fxmlLoader.setController(testsSchoolController);
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
    	
    	removeCourseButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				courseDao.delete(selectedCourse.getId());
				coursesListView.getItems().remove(selectedCourse);
				
				
			}
		});
    	
    	removeTestButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				testDao.delete(selectedTest.getId());
				testsListView.getItems().remove(selectedTest);
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
