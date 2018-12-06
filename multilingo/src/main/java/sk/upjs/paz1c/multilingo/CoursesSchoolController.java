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
import javafx.stage.Modality;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class CoursesSchoolController {

	@FXML
    private Button showTestsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button createCourseButton;

    @FXML
    private Button showProfileButton;

    @FXML
    private Button showCoursesButton;

    @FXML
    private ListView<?> coursesListView;

    @FXML
    private Button detailCourseButton;

    @FXML
    void initialize() {
    	showProfileButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				ProfileSchoolController profileSchoolController = new ProfileSchoolController();
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
    	
    	showTestsButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				TestsSchoolController testsSchoolController = new TestsSchoolController();
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
				stage.setTitle("MultiLingo");
				stage.setScene(scene);
				stage.show();
			}
		});
    	
    	createCourseButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
			}
		});
    	
    	detailCourseButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				CourseDetailController courseDetailController = new CourseDetailController();       
				showModalWindow(courseDetailController, "course_detail_scene.fxml");
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
