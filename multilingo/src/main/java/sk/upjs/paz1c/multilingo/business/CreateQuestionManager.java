package sk.upjs.paz1c.multilingo.business;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sk.upjs.paz1c.multilingo.TestsSchoolController;
import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.entities.School;

public class CreateQuestionManager {

	public void testCreated(Node node, School school) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Success");
		alert.setHeaderText("Test created");
		alert.setContentText("You have successfully created the test.");
		alert.showAndWait();
		
		TestsSchoolController testsSchoolController = new TestsSchoolController(school);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../tests_school_scene.fxml"));
		fxmlLoader.setController(testsSchoolController);
		Parent rootPane = null;
		try {
			rootPane = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setTitle("MultiLingo: Tests");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public boolean everyFieldFilled(Question question) {
		
		return  question.getTask() != null &&
				question.getRightAnswer() != null &&
				question.getWrongAnswer1() != null && 
				question.getWrongAnswer2() != null &&
				question.getWrongAnswer3() != null &&
				question.getWrongAnswer4() != null;
	}
}
