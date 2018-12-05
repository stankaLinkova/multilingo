package sk.upjs.paz1c.multilingo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class ProfileStudentController {


    @FXML
    private ListView<?> showCoursesListView;

    @FXML
    private Button showProfileButtonS;

    @FXML
    private Text emailStudentText;

    @FXML
    private Button removeTestButton;

    @FXML
    private Button logoutButtonS;

    @FXML
    private ListView<?> showTestsListView;

    @FXML
    private Text loginStudentText;

    @FXML
    private Text nameSurnameStudentText;

    @FXML
    private Button showCoursesButtonS;

    @FXML
    private Button removeCourseButton;

    @FXML
    private Button showTestsButtonS;

    @FXML
    void initialize() {
        assert showCoursesListView != null : "fx:id=\"showCoursesListView\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert showProfileButtonS != null : "fx:id=\"showProfileButtonS\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert emailStudentText != null : "fx:id=\"emailStudentText\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert removeTestButton != null : "fx:id=\"removeTestButton\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert logoutButtonS != null : "fx:id=\"logoutButtonS\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert showTestsListView != null : "fx:id=\"showTestsListView\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert loginStudentText != null : "fx:id=\"loginStudentText\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert nameSurnameStudentText != null : "fx:id=\"nameSurnameStudentText\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert showCoursesButtonS != null : "fx:id=\"showCoursesButtonS\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert removeCourseButton != null : "fx:id=\"removeCourseButton\" was not injected: check your FXML file 'profile_student_scene.fxml'.";
        assert showTestsButtonS != null : "fx:id=\"showTestsButtonS\" was not injected: check your FXML file 'profile_student_scene.fxml'.";

    }
}
