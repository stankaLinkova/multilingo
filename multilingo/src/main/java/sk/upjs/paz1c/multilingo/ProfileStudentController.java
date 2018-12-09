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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.entities.Student;

@SuppressWarnings("restriction")
public class ProfileStudentController {

    
	@FXML
    private ListView<?> showCoursesListView;

    @FXML
    private Button showProfileButton;

    @FXML
    private Text emailStudentText;

    @FXML
    private Button removeTestButton;

    @FXML
    private Button logoutButton;

    @FXML
    private ListView<?> showTestsListView;

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

    public ProfileStudentController(Student student) {
		
	}

	@FXML
    void initialize() {
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
    	
    	showTestsButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				TestsStudentController testsStudentController = new TestsStudentController();
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
				CourseDetailController courseDetailController = new CourseDetailController();       
				showModalWindow(courseDetailController, "course_detail_scene.fxml");
			}
		});
    	
    	removeCourseButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
			}
		});
    	
    	removeTestButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
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
