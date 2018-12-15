package sk.upjs.paz1c.multilingo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Test;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

public class CreateTestController {

	private School school;
	private TestDao testDao;
	private TestFxModel testModel;
	

    @FXML
    private TextField createdByText;

    @FXML
    private TextField numberOfQuestionsText;

    @FXML
    private TextField languageText;

    @FXML
    private TextField levelText;

    @FXML
    private DatePicker createdDateDatePicker;

    @FXML
    private Button createTestButton;

    @FXML
    private Button backButton;

    public CreateTestController(School school) {
		this.school = school;
		testDao = DaoFactory.INSTANCE.getTestDao();
		testModel = new TestFxModel();
	}
    
    @FXML
    void initialize() {
    	
    	createdByText.textProperty().bindBidirectional(testModel.createdByProperty());
    	createdByText.setText(school.getName());
    	createdByText.setEditable(false);
    	languageText.textProperty().bindBidirectional(testModel.languageProperty());
    	levelText.textProperty().bindBidirectional(testModel.levelProperty());
    	createdDateDatePicker.valueProperty().bindBidirectional(testModel.createdDateProperty());
    	numberOfQuestionsText.textProperty().bindBidirectional(testModel.numberOfQuestionsProperty(), new NumberStringConverter());
    	testModel.setIdSchool(school.getId());
    	
    	
    	
    	createTestButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Test test = testModel.getTest();
				testDao.save(test);				
				CreateQuestionController createQuestionController = new CreateQuestionController(test, school);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create_question_scene.fxml"));
				fxmlLoader.setController(createQuestionController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage)createTestButton.getScene().getWindow();
				stage.setTitle("Creating a test");
				stage.setScene(scene);
				stage.show();
			}
		});
    	
    	
    	
    	backButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
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
