package sk.upjs.paz1c.multilingo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class ProfileSchoolController {


    @FXML
    private ListView<?> testsListView;

    @FXML
    private Text nameSchoolText;

    @FXML
    private Text loginSchoolText;

    @FXML
    private Text emailSchoolText;

    @FXML
    private Button removeCourseButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button showProfileButton;

    @FXML
    private Button showCoursesButton;

    @FXML
    private Button detailCourseButton;

    @FXML
    private Text addressSchoolText;

    @FXML
    private Button removeTestButton;

    @FXML
    private Button showTestsButton;

    @FXML
    private ListView<?> coursesListView;

    @FXML
    void initialize() {
        assert testsListView != null : "fx:id=\"testsListView\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert nameSchoolText != null : "fx:id=\"nameSchoolText\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert loginSchoolText != null : "fx:id=\"loginSchoolText\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert emailSchoolText != null : "fx:id=\"emailSchoolText\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert removeCourseButton != null : "fx:id=\"removeCourseButton\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert showProfileButton != null : "fx:id=\"showProfileButton\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert showCoursesButton != null : "fx:id=\"showCoursesButton\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert detailCourseButton != null : "fx:id=\"detailCourseButton\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert addressSchoolText != null : "fx:id=\"addressSchoolText\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert removeTestButton != null : "fx:id=\"removeTestButton\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert showTestsButton != null : "fx:id=\"showTestsButton\" was not injected: check your FXML file 'profile_school_scene.fxml'.";
        assert coursesListView != null : "fx:id=\"coursesListView\" was not injected: check your FXML file 'profile_school_scene.fxml'.";

    }
}
