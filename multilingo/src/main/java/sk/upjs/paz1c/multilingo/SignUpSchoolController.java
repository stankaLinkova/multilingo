package sk.upjs.paz1c.multilingo;
import java.io.IOException;

import org.springframework.util.AlternativeJdkIdGenerator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.business.SignUpAsSchoolManager;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;

@SuppressWarnings("restriction")
public class SignUpSchoolController {

	@FXML
    private Button createAccountButton;

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button backButton;

    @FXML
    private TextField addressText;

    @FXML
    private TextField emailText;

    @FXML
    private PasswordField confirmPasswordText;

    @FXML
    private TextField nameText;

    
    private SchoolFxModel schoolModel = new SchoolFxModel();
    private SignUpAsSchoolManager manager;
    private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
    
    
    @FXML
    void initialize() {
    	
    	loginText.textProperty().bindBidirectional(schoolModel.loginProperty());
    	passwordText.textProperty().bindBidirectional(schoolModel.passwordProperty());
    	nameText.textProperty().bindBidirectional(schoolModel.nameProperty());
    	addressText.textProperty().bindBidirectional(schoolModel.addressProperty());
    	emailText.textProperty().bindBidirectional(schoolModel.emailProperty());
    	manager = new SignUpAsSchoolManager();
    	
    	
    	
    	backButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				SignInController signInController = new SignInController();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log_in_scene.fxml"));
				fxmlLoader.setController(signInController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) backButton.getScene().getWindow();
				stage.setTitle("MultiLingo: Sign in");
				stage.setScene(scene);
				stage.show();
			}
		});
    	
    	// To do
    	createAccountButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				String confirmationPassword = confirmPasswordText.getText();
				if(!manager.canCreate(schoolModel.getSchool(), confirmationPassword)) {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Invalid values");
					alert.setContentText("Possible problems:\n- Your login already exists or your passwords don't match\n- You probably didn't fill every field.");
					alert.showAndWait();
					return;
				}
				schoolDao.save(schoolModel.getSchool());
				SignInController signInController = new SignInController();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log_in_scene.fxml"));
				fxmlLoader.setController(signInController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) backButton.getScene().getWindow();
				stage.setTitle("MultiLingo: Sign in");
				stage.setScene(scene);
				stage.show();
			}
		});
    }
}
