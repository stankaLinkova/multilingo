package sk.upjs.paz1c.multilingo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        assert signUpAsSchool != null : "fx:id=\"signUpAsSchool\" was not injected: check your FXML file 'log_in_scene.fxml'.";
        assert signUpAsStudent != null : "fx:id=\"signUpAsStudent\" was not injected: check your FXML file 'log_in_scene.fxml'.";
        assert loginTField != null : "fx:id=\"loginTField\" was not injected: check your FXML file 'log_in_scene.fxml'.";
        assert buttonSignIn != null : "fx:id=\"buttonSignIn\" was not injected: check your FXML file 'log_in_scene.fxml'.";
        assert passwordTField != null : "fx:id=\"passwordTField\" was not injected: check your FXML file 'log_in_scene.fxml'.";

    }
}
