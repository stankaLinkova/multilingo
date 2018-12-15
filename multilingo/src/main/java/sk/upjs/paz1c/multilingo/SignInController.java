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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.business.GeneralManager;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;
import sk.upjs.paz1c.multilingo.persistent.StudentDao;


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
	private RadioButton schoolRadioButton;

	@FXML
	private RadioButton studentRadioButton;

	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
	private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();

	@FXML
	void initialize() {

		// toggleGroup aby mohlo byt iba jedno zaskrtnute
		ToggleGroup toggleGroup = new ToggleGroup();

		schoolRadioButton.setToggleGroup(toggleGroup);
		studentRadioButton.setToggleGroup(toggleGroup);
		toggleGroup.selectToggle(studentRadioButton);

		
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

		
		buttonSignIn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				FXMLLoader fxmlLoader = null;
				//overujeme ci je student alebo skola, aby sme vedeli zobrazit profil 
				//a prehladavat databazu na login a heslo 
				if (studentRadioButton.isSelected()) {
					Student student = studentDao.getStudentByLogin(loginTField.getText(), GeneralManager.hashPassword(passwordTField.getText()));
					if (student != null) {
						ProfileStudentController profileStudentController = new ProfileStudentController(student);
						fxmlLoader = new FXMLLoader(getClass().getResource("profile_student_scene.fxml"));
						fxmlLoader.setController(profileStudentController);
					}
				} else {
					School school = schoolDao.getSchoolByLogin(loginTField.getText(), GeneralManager.hashPassword(passwordTField.getText()));
					if (school != null) {
						ProfileSchoolController profileSchoolController = new ProfileSchoolController(school);
						fxmlLoader = new FXMLLoader(getClass().getResource("profile_school_scene.fxml"));
						fxmlLoader.setController(profileSchoolController);
					}
				}
				if (fxmlLoader == null) {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Invalid login or password");
					alert.setContentText(
							"Please make sure you typed the right login, password and whether you chose the right user(Student/School).");
					alert.showAndWait();
					return;

				}
				Parent rootPane = null;
				try {
					rootPane = fxmlLoader.load();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(rootPane);
				Stage stage = (Stage) buttonSignIn.getScene().getWindow();
				stage.setTitle("MultiLingo: Profile");
				stage.setScene(scene);
				stage.show();
			}
		});
	}
}
