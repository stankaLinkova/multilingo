package sk.upjs.paz1c.multilingo;
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
        
    	
    }
}
