package sk.upjs.paz1c.multilingo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.business.TakingTestManager;
import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.entities.Test;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.StudentDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

public class TakingTestController {

	private Test test;
	private Student student;
	private Question selectedQuestion;
	private TestDao testDao;
	private StudentDao studentDao;
	List<Question> questions;
	private int questionsCounter;
	private int rightAnswers;
	private TakingTestManager manager;
	private RadioButton selectedAnswer;
	private ToggleGroup toggleGroup;
	
	
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

    public TakingTestController(Test test, Student student) {
		this.test = test;
		this.student = student;
		testDao = DaoFactory.INSTANCE.getTestDao();
		studentDao = DaoFactory.INSTANCE.getStudentDao();
		manager = new TakingTestManager();
	}
    
    @FXML
    void initialize() {
    	
    	toggleGroup = new ToggleGroup();
    	firstAnswerRButton.setToggleGroup(toggleGroup);
    	secondAnswerRButton.setToggleGroup(toggleGroup);
    	thirdAnswerRButton.setToggleGroup(toggleGroup);
    	fourthAnswerRButton.setToggleGroup(toggleGroup);
    	fifthAnswerRButton.setToggleGroup(toggleGroup);
    	toggleGroup.selectToggle(firstAnswerRButton);
 
    	selectedAnswer = firstAnswerRButton;
    	toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

    		public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
    			
    			
    			selectedAnswer = (RadioButton) newValue;
    			
    		}
		});
    	
    	questions = testDao.getAllMyQuestions(test.getId());
    	selectedQuestion = questions.get(0);
    	manager.handleQuestion(selectedQuestion,firstAnswerRButton, 
    			secondAnswerRButton, thirdAnswerRButton,
    			fourthAnswerRButton, fifthAnswerRButton, questionText);
    	
    	nextQuestionButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				if(manager.checkAnswer(selectedQuestion.getRightAnswer(), selectedAnswer )) {
					rightAnswers++;
				}
				questionsCounter++;
				if(questionsCounter == questions.size()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText("Test finished");
					alert.setContentText("You got " + rightAnswers + " right answers out of " + test.getNumberOfQuestions());
					alert.showAndWait();
					double percentage = (rightAnswers / test.getNumberOfQuestions()) * 100;
					studentDao.doTheTest(student, test, LocalDate.now(), (int)percentage);
					
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
					return;
				}
				selectedQuestion = questions.get(questionsCounter);
				manager.handleQuestion(selectedQuestion, firstAnswerRButton, 
		    			secondAnswerRButton, thirdAnswerRButton,
		    			fourthAnswerRButton, fifthAnswerRButton, questionText);
				toggleGroup.selectToggle(firstAnswerRButton);
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
