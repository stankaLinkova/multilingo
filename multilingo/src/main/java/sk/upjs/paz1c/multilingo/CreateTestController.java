package sk.upjs.paz1c.multilingo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Test;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.TestDao;



@SuppressWarnings("restriction")
public class CreateTestController {
	
	
	private TestDao testDao;
	private TestFxModel testModel;
	private School school;

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

    public CreateTestController(School school) {
		testDao = DaoFactory.INSTANCE.getTestDao();
		testModel = new TestFxModel();
		this.school = school;
	}
    
    
    @FXML
    void initialize() {
    	
    	createTestButton.setOnAction(new EventHandler<ActionEvent>() {

    		public void handle(ActionEvent event) {
				Test test = testModel.getTest();
				testDao.save(test);
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Success");
				alert.setHeaderText("Test created");
				alert.setContentText("You have successfully created the test.");
				alert.showAndWait();
			}
		});
    	
    }
}
