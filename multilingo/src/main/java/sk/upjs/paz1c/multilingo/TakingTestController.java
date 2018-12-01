package sk.upjs.paz1c.multilingo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class TakingTestController {

    @FXML
    private RadioButton firstAnswerRButton;

    @FXML
    private Text fifthAnswerText;

    @FXML
    private Text thirdAnswerText;

    @FXML
    private Text fourthAnswerText;

    @FXML
    private Text secondAnswerText;

    @FXML
    private RadioButton secondAnswerRButton;

    @FXML
    private RadioButton fourthAnswerRButton;

    @FXML
    private TextArea questionText;

    @FXML
    private RadioButton thirdAnswerRButton;

    @FXML
    private Text firstAnswerText;

    @FXML
    private Button backButton;

    @FXML
    private RadioButton fifthAnswerRButton;

    @FXML
    private Button nextQuestionButton;

    @FXML
    private Button evaluateButton;

    @FXML
    void initialize() {
        assert firstAnswerRButton != null : "fx:id=\"firstAnswerRButton\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert fifthAnswerText != null : "fx:id=\"fifthAnswerText\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert thirdAnswerText != null : "fx:id=\"thirdAnswerText\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert fourthAnswerText != null : "fx:id=\"fourthAnswerText\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert secondAnswerText != null : "fx:id=\"secondAnswerText\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert secondAnswerRButton != null : "fx:id=\"secondAnswerRButton\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert fourthAnswerRButton != null : "fx:id=\"fourthAnswerRButton\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert questionText != null : "fx:id=\"questionText\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert thirdAnswerRButton != null : "fx:id=\"thirdAnswerRButton\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert firstAnswerText != null : "fx:id=\"firstAnswerText\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert fifthAnswerRButton != null : "fx:id=\"fifthAnswerRButton\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert nextQuestionButton != null : "fx:id=\"nextQuestionButton\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";
        assert evaluateButton != null : "fx:id=\"evaluateButton\" was not injected: check your FXML file 'take_a_test_scene.fxml'.";

    }
}
