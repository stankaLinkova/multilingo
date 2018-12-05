package sk.upjs.paz1c.multilingo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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

    @FXML
    void initialize() {
        assert testsListView != null : "fx:id=\"testsListView\" was not injected: check your FXML file 'tests_student_scene.fxml'.";
        assert takeATestButton != null : "fx:id=\"takeATestButton\" was not injected: check your FXML file 'tests_student_scene.fxml'.";
        assert showTestsButton != null : "fx:id=\"showTestsButton\" was not injected: check your FXML file 'tests_student_scene.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'tests_student_scene.fxml'.";
        assert showProfileButton != null : "fx:id=\"showProfileButton\" was not injected: check your FXML file 'tests_student_scene.fxml'.";
        assert showCoursesButton != null : "fx:id=\"showCoursesButton\" was not injected: check your FXML file 'tests_student_scene.fxml'.";

    }
}
