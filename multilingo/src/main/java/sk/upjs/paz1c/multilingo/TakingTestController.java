package sk.upjs.paz1c.multilingo;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.entities.Test;

public class TakingTestController {

	private Test test;
	private Student student;
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

    public TakingTestController(Test test,Question question, Student student) {
		this.test = test;
		this.question = question;
		this.student = student;
	}
    
    @FXML
    void initialize() {
    	
    	  	
    	ToggleGroup toggleGroup = new ToggleGroup();

    	firstAnswerRButton.setToggleGroup(toggleGroup);
    	secondAnswerRButton.setToggleGroup(toggleGroup);
    	thirdAnswerRButton.setToggleGroup(toggleGroup);
    	fourthAnswerRButton.setToggleGroup(toggleGroup);
    	fifthAnswerRButton.setToggleGroup(toggleGroup);
    	
    	questionText.setText(question.getTask());
    	
    	
    	
    	
    	
    	

    	nextQuestionButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				TakingTestController takingTestController = new TakingTestController(test, question, student);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("take_a_test_scene.fxml"));
				fxmlLoader.setController(takingTestController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) nextQuestionButton.getScene().getWindow();
				stage.setTitle("MultiLingo: Taking the test");
				stage.setScene(scene);
				stage.show();
			}
		});
    	
    	
    	backButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				TestsStudentController testsStudentController = new TestsStudentController(student);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tests_student_scene.fxml"));
				fxmlLoader.setController(testsStudentController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) backButton.getScene().getWindow();
				stage.setTitle("MultiLingo: Tests");
				stage.setScene(scene);
				stage.show();
			}
		});
    }
}
