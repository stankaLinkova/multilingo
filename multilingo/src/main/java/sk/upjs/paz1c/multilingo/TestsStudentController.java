package sk.upjs.paz1c.multilingo;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.entities.Student;

@SuppressWarnings("restriction")
public class TestsStudentController {


    @FXML
    private ListView<?> testsListView;

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

   
	@FXML
    void initialize() {
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
				CoursesStudentController coursesStudentController = new CoursesStudentController();
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
