package sk.upjs.paz1c.multilingo;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.business.CreateQuestionManager;
import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Test;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.QuestionDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;



@SuppressWarnings("restriction")
public class CreateQuestionController {
	
	
	private Test test;
	private School school;
	private QuestionDao questionDao;
	private QuestionFxModel questionModel;
	private int counterOfQuestions;
	private CreateQuestionManager manager;
	private TestDao testDao;

    @FXML
    private TextField wrongAnswer2Text;

    @FXML
    private Label questionCounterLabel;
    @FXML
    private TextField rightAnswerText;

    @FXML
    private TextField wrongAnswer1Text;

    @FXML
    private TextField wrongAnswer4Text;

    @FXML
    private TextField wrongAnswer3Text;


    @FXML
    private Button backButton;

    @FXML
    private TextArea questionText;

    @FXML
    private Button createQuestionButton;

    public CreateQuestionController(Test test, School school) {
		questionDao = DaoFactory.INSTANCE.getQuestionDao();
		questionModel = new QuestionFxModel();
		this.test = test;
		this.school = school;
		counterOfQuestions = 1;
		manager = new CreateQuestionManager();
		testDao = DaoFactory.INSTANCE.getTestDao();
	}
    
    
    @FXML
    void initialize() {
    	
    	 
    	rightAnswerText.textProperty().bindBidirectional(questionModel.getRightAnswerProperty());
    	questionText.textProperty().bindBidirectional(questionModel.getTaskProperty());
    	wrongAnswer1Text.textProperty().bindBidirectional(questionModel.getWrongAnswer1Property());
    	wrongAnswer2Text.textProperty().bindBidirectional(questionModel.getWrongAnswer2Property());
    	wrongAnswer3Text.textProperty().bindBidirectional(questionModel.getWrongAnswer3Property());
    	wrongAnswer4Text.textProperty().bindBidirectional(questionModel.getWrongAnswer4Property());
    	questionModel.setIdTest(test.getId());
    	questionCounterLabel.setText("1" + "/" + test.getNumberOfQuestions());
    
    	createQuestionButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Question question = questionModel.getQuestion();
				if(!manager.everyFieldFilled(question)) {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Wrong filling");
					alert.setContentText("Make sure you filled all of the fields.");
					alert.showAndWait();
					return;
					
				}
				questionDao.save(question);
				questionText.setText("");
				rightAnswerText.setText("");
				wrongAnswer1Text.setText("");
				wrongAnswer2Text.setText("");
				wrongAnswer3Text.setText("");
				wrongAnswer4Text.setText("");
				counterOfQuestions++;
				questionCounterLabel.setText(counterOfQuestions + "/" + test.getNumberOfQuestions());
				if(counterOfQuestions == test.getNumberOfQuestions() + 1) {
					manager.testCreated(backButton, school);
				}
				
			}
		});
    	
    	
    	backButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				testDao.delete(test.getId());
				TestsSchoolController testsSchoolController = new TestsSchoolController(school);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tests_school_scene.fxml"));
				fxmlLoader.setController(testsSchoolController);
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
