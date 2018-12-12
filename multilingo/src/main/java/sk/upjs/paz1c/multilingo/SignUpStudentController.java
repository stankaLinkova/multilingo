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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.business.SignUpAsSchoolManager;
import sk.upjs.paz1c.multilingo.business.SignUpAsStudentManager;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;
import sk.upjs.paz1c.multilingo.persistent.StudentDao;

@SuppressWarnings("restriction")
public class SignUpStudentController {

	@FXML
	private Button createAccountButton;

	@FXML
	private TextField loginText;

	@FXML
	private TextField surnameText;

	@FXML
	private PasswordField passwordText;

	@FXML
	private Button backButton;

	@FXML
	private TextField emailText;

	@FXML
	private PasswordField confirmPasswordText;

	@FXML
	private TextField nameText;

	
	private StudentFxModel studentModel = new StudentFxModel();
    private SignUpAsStudentManager manager;
    private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();
	
	@FXML
	void initialize() {
		
		
		
		loginText.textProperty().bindBidirectional(studentModel.loginProperty());
    	passwordText.textProperty().bindBidirectional(studentModel.passwordProperty());
    	nameText.textProperty().bindBidirectional(studentModel.nameProperty());
    	surnameText.textProperty().bindBidirectional(studentModel.surnameProperty());
    	emailText.textProperty().bindBidirectional(studentModel.emailProperty());
    	manager = new SignUpAsStudentManager();
		
		
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
				if(!manager.canCreate(studentModel.getStudent(), confirmationPassword)) {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Invalid values");
					alert.setContentText("Possible problems:\n- Your login already exists or your passwords don't match\n- You probably didn't fill every field.");
					alert.showAndWait();
					return;
				}
				
				studentDao.save(studentModel.getStudent());
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
