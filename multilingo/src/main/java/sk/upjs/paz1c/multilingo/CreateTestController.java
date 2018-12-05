package sk.upjs.paz1c.multilingo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateTestController {

    @FXML
    private TextField wrongAnswer2Text;

    @FXML
    private TextField rightAnswerText;

    @FXML
    private TextField wrongAnswer1Text;

    @FXML
    private TextField wrongAnswer4Text;

    @FXML
    private TextField wrongAnswer3Text;

    @FXML
    private Button createTestButton;

    @FXML
    private Button backButton;

    @FXML
    private TextArea questionText;

    @FXML
    private Button createQuestionButton;

    @FXML
    void initialize() {
        assert wrongAnswer2Text != null : "fx:id=\"wrongAnswer2Text\" was not injected: check your FXML file 'create_test_scene.fxml'.";
        assert rightAnswerText != null : "fx:id=\"rightAnswerText\" was not injected: check your FXML file 'create_test_scene.fxml'.";
        assert wrongAnswer1Text != null : "fx:id=\"wrongAnswer1Text\" was not injected: check your FXML file 'create_test_scene.fxml'.";
        assert wrongAnswer4Text != null : "fx:id=\"wrongAnswer4Text\" was not injected: check your FXML file 'create_test_scene.fxml'.";
        assert wrongAnswer3Text != null : "fx:id=\"wrongAnswer3Text\" was not injected: check your FXML file 'create_test_scene.fxml'.";
        assert createTestButton != null : "fx:id=\"createTestButton\" was not injected: check your FXML file 'create_test_scene.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'create_test_scene.fxml'.";
        assert questionText != null : "fx:id=\"questionText\" was not injected: check your FXML file 'create_test_scene.fxml'.";
        assert createQuestionButton != null : "fx:id=\"createQuestionButton\" was not injected: check your FXML file 'create_test_scene.fxml'.";

    }
}
