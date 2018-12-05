package sk.upjs.paz1c.multilingo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class SignInController {

	@FXML
	private Hyperlink signUpAsSchool;

	@FXML
	private Hyperlink signUpAsStudent;

	@FXML
	private TextField loginTField;

	@FXML
	private Button buttonSignIn;

	@FXML
	private PasswordField passwordTField;

	@FXML
	void initialize() {
		signUpAsSchool.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				SignUpSchoolController signUpSchoolController = new SignUpSchoolController();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign_up_as_a_school_scene.fxml"));
				fxmlLoader.setController(signUpSchoolController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) signUpAsSchool.getScene().getWindow();
				stage.setTitle("MultiLingo: Sign up");
				stage.setScene(scene);
				stage.show();
			}
		});
		
		signUpAsStudent.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				SignUpStudentController signUpStudentController = new SignUpStudentController();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign_up_as_a_student_scene.fxml"));
				fxmlLoader.setController(signUpStudentController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) signUpAsStudent.getScene().getWindow();
				stage.setTitle("MultiLingo: Sign up");
				stage.setScene(scene);
				stage.show();
			}
		});
		
		// To do
		buttonSignIn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				ProfileSchoolController profileSchoolController = new ProfileSchoolController();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile_school_scene.fxml"));
				fxmlLoader.setController(profileSchoolController);
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) buttonSignIn.getScene().getWindow();
				stage.setTitle("MultiLingo: Menu");
				stage.setScene(scene);
				stage.show();
			}
		});
	}
}
