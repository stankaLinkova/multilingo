package sk.upjs.paz1c.multilingo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class TestsSchoolController {

    @FXML
    private ListView<?> testsListView;

    @FXML
    private Button createTestButton;

    @FXML
    private Button showTestsButton;

    @FXML
    private Button shoeProfileButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button showCoursesButton;

    @FXML
    void initialize() {
        assert testsListView != null : "fx:id=\"testsListView\" was not injected: check your FXML file 'tests_school_scene.fxml'.";
        assert createTestButton != null : "fx:id=\"createTestButton\" was not injected: check your FXML file 'tests_school_scene.fxml'.";
        assert showTestsButton != null : "fx:id=\"showTestsButton\" was not injected: check your FXML file 'tests_school_scene.fxml'.";
        assert shoeProfileButton != null : "fx:id=\"shoeProfileButton\" was not injected: check your FXML file 'tests_school_scene.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'tests_school_scene.fxml'.";
        assert showCoursesButton != null : "fx:id=\"showCoursesButton\" was not injected: check your FXML file 'tests_school_scene.fxml'.";

    }
}
