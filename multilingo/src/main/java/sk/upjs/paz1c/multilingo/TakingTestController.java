package sk.upjs.paz1c.multilingo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.entities.Test;

public class TakingTestController {

	private Test test;
	private Question question;
	
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

    public TakingTestController(Test test,Question question) {
		this.test = test;
		this.question = question;
	}
    
    @FXML
    void initialize() {
    	
    	
    	
    	ToggleGroup toggleGroup = new ToggleGroup();

    	firstAnswerRButton.setToggleGroup(toggleGroup);
    	secondAnswerRButton.setToggleGroup(toggleGroup);
    	thirdAnswerRButton.setToggleGroup(toggleGroup);
    	fourthAnswerRButton.setToggleGroup(toggleGroup);
    	fifthAnswerRButton.setToggleGroup(toggleGroup);
    	
    
    }
}
