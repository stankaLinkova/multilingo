package sk.upjs.paz1c.multilingo;
import java.awt.color.CMMException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;


@SuppressWarnings("restriction")
public class CreateCourseController {
	
	private CourseDao courseDao;
	private CourseFxModel courseModel;
	private School school;
	

    @FXML
    private DatePicker endOfCourseDatePicker;

    @FXML
    private DatePicker startOfCourseDatePicker;

    @FXML
    private TextField levelText;


    @FXML
    private TextField languageTaughtText;

    @FXML
    private TextField taughtInText;

    @FXML
    private TextField timeOfLecturesText;

    @FXML
    private Button createCourseButton;

    @FXML
    private TextArea informationText;

    public CreateCourseController(School school) {
		courseDao = DaoFactory.INSTANCE.getCourseDao();
		courseModel = new CourseFxModel();
		this.school = school;
	}
    
           
	@FXML
    void initialize() {
        
    	languageTaughtText.textProperty().bindBidirectional(courseModel.languageTaughtProperty());
    	taughtInText.textProperty().bindBidirectional(courseModel.taughtInProperty());
    	informationText.textProperty().bindBidirectional(courseModel.informationProperty());
    	timeOfLecturesText.textProperty().bindBidirectional(courseModel.timeOfLecturesProperty());
    	levelText.textProperty().bindBidirectional(courseModel.levelProperty());
    	endOfCourseDatePicker.valueProperty().bindBidirectional(courseModel.endOfCourseProperty());
    	startOfCourseDatePicker.valueProperty().bindBidirectional(courseModel.startOfCourseProperty());
    	courseModel.setIdSchool(school.getId());
    	
    	
    	
    	createCourseButton.setOnAction(new EventHandler<ActionEvent>() {

    		public void handle(ActionEvent event) {
				Course course = courseModel.getCourse();
				courseDao.save(course);
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Success");
				alert.setHeaderText("Course created");
				alert.setContentText("You have successfully created the course.");
				alert.showAndWait();
				
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
				Stage stage = (Stage) createCourseButton.getScene().getWindow();
				stage.setTitle("MultiLingo: Courses");
				stage.setScene(scene);
				stage.show();
			}
		});
    	
    	
    }
}
