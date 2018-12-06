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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class CourseDetailController {

	@FXML
    private Text timeOfLectureText;

    @FXML
    private ListView<?> studentsListView;

    @FXML
    private Text levelText;

    @FXML
    private Text startOfCourseText;


    @FXML
    private Text languageTaughtText;

    @FXML
    private Text taughtInText;

    @FXML
    private Text endOfCourseText;

    @FXML
    private TextArea informationText;

    @FXML
    void initialize() {
    
    }
}
