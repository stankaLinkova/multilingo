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
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Test;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

@SuppressWarnings("restriction")
public class TestsSchoolController {
	
	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();
	private ObservableList<Test> tests;
	
	@FXML
	private ListView<Test> testsListView;

	@FXML
	private Button createTestButton;

	@FXML
	private Button showTestsButton;

	@FXML
	private Button showProfileButton;

	@FXML
	private Button logoutButton;

	@FXML
	private Button showCoursesButton;
	
	private School school;
	
	public TestsSchoolController(School school) {
		this.school = school;
	}

	@FXML
	void initialize() {
		
		
		tests = FXCollections.observableArrayList(testDao.getAll());
		testsListView.setItems(tests);
		
		
		showProfileButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				ProfileSchoolController profileSchoolController = new ProfileSchoolController(school);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile_school_scene.fxml"));
				fxmlLoader.setController(profileSchoolController);
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
		createTestButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				CreateTestController createTestController = new CreateTestController(school);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create_test_scene.fxml"));
				fxmlLoader.setController(createTestController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage)createTestButton.getScene().getWindow();
				stage.setTitle("Creating a test");
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
				stage.setTitle("MultiLingo");
				stage.setScene(scene);
				stage.show();
			}
		});
	}
}
