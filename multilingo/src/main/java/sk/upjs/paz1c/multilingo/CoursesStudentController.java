package sk.upjs.paz1c.multilingo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class CoursesStudentController {

    @FXML
    private Button joinTheCourseButton;

    @FXML
    private Button showTestsButton;

    @FXML
    private Button logoutButton;

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
        assert joinTheCourseButton != null : "fx:id=\"joinTheCourseButton\" was not injected: check your FXML file 'courses_student_scene.fxml'.";
        assert showTestsButton != null : "fx:id=\"showTestsButton\" was not injected: check your FXML file 'courses_student_scene.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'courses_student_scene.fxml'.";
        assert showProfileButton != null : "fx:id=\"showProfileButton\" was not injected: check your FXML file 'courses_student_scene.fxml'.";
        assert showCoursesButton != null : "fx:id=\"showCoursesButton\" was not injected: check your FXML file 'courses_student_scene.fxml'.";
        assert coursesListView != null : "fx:id=\"coursesListView\" was not injected: check your FXML file 'courses_student_scene.fxml'.";
        assert detailCourseButton != null : "fx:id=\"detailCourseButton\" was not injected: check your FXML file 'courses_student_scene.fxml'.";

    }
}
