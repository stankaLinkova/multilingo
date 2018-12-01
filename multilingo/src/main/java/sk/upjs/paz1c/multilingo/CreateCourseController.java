package sk.upjs.paz1c.multilingo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateCourseController {

    @FXML
    private DatePicker endOfCourseDatePicker;

    @FXML
    private DatePicker startOfCourseDatePicker;

    @FXML
    private TextField levelText;

    @FXML
    private Button backButton;

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

    @FXML
    void initialize() {
        assert endOfCourseDatePicker != null : "fx:id=\"endOfCourseDatePicker\" was not injected: check your FXML file 'create_course_scene.fxml'.";
        assert startOfCourseDatePicker != null : "fx:id=\"startOfCourseDatePicker\" was not injected: check your FXML file 'create_course_scene.fxml'.";
        assert levelText != null : "fx:id=\"levelText\" was not injected: check your FXML file 'create_course_scene.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'create_course_scene.fxml'.";
        assert languageTaughtText != null : "fx:id=\"languageTaughtText\" was not injected: check your FXML file 'create_course_scene.fxml'.";
        assert taughtInText != null : "fx:id=\"taughtInText\" was not injected: check your FXML file 'create_course_scene.fxml'.";
        assert timeOfLecturesText != null : "fx:id=\"timeOfLecturesText\" was not injected: check your FXML file 'create_course_scene.fxml'.";
        assert createCourseButton != null : "fx:id=\"createCourseButton\" was not injected: check your FXML file 'create_course_scene.fxml'.";
        assert informationText != null : "fx:id=\"informationText\" was not injected: check your FXML file 'create_course_scene.fxml'.";

    }
}
