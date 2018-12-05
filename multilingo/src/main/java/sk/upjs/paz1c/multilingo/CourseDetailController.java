package sk.upjs.paz1c.multilingo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

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
    private Button closeButton;

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
        assert timeOfLectureText != null : "fx:id=\"timeOfLectureText\" was not injected: check your FXML file 'course_detail_scene.fxml'.";
        assert studentsListView != null : "fx:id=\"studentsListView\" was not injected: check your FXML file 'course_detail_scene.fxml'.";
        assert levelText != null : "fx:id=\"levelText\" was not injected: check your FXML file 'course_detail_scene.fxml'.";
        assert startOfCourseText != null : "fx:id=\"startOfCourseText\" was not injected: check your FXML file 'course_detail_scene.fxml'.";
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'course_detail_scene.fxml'.";
        assert languageTaughtText != null : "fx:id=\"languageTaughtText\" was not injected: check your FXML file 'course_detail_scene.fxml'.";
        assert taughtInText != null : "fx:id=\"taughtInText\" was not injected: check your FXML file 'course_detail_scene.fxml'.";
        assert endOfCourseText != null : "fx:id=\"endOfCourseText\" was not injected: check your FXML file 'course_detail_scene.fxml'.";
        assert informationText != null : "fx:id=\"informationText\" was not injected: check your FXML file 'course_detail_scene.fxml'.";

    }
}
