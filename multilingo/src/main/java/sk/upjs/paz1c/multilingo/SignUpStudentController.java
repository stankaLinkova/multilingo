package sk.upjs.paz1c.multilingo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    @FXML
    void initialize() {
        assert createAccountButton != null : "fx:id=\"createAccountButton\" was not injected: check your FXML file 'sign_up_as_a_student_scene.fxml'.";
        assert loginText != null : "fx:id=\"loginText\" was not injected: check your FXML file 'sign_up_as_a_student_scene.fxml'.";
        assert surnameText != null : "fx:id=\"surnameText\" was not injected: check your FXML file 'sign_up_as_a_student_scene.fxml'.";
        assert passwordText != null : "fx:id=\"passwordText\" was not injected: check your FXML file 'sign_up_as_a_student_scene.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'sign_up_as_a_student_scene.fxml'.";
        assert emailText != null : "fx:id=\"emailText\" was not injected: check your FXML file 'sign_up_as_a_student_scene.fxml'.";
        assert confirmPasswordText != null : "fx:id=\"confirmPasswordText\" was not injected: check your FXML file 'sign_up_as_a_student_scene.fxml'.";
        assert nameText != null : "fx:id=\"nameText\" was not injected: check your FXML file 'sign_up_as_a_student_scene.fxml'.";

    }
}
