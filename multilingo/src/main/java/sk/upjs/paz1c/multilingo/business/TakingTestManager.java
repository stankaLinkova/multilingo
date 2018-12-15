package sk.upjs.paz1c.multilingo.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import javafx.print.Collation;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import sk.upjs.paz1c.multilingo.entities.Question;

public class TakingTestManager {

	//kontrola spravnosti
	public boolean checkAnswer(String rightAnswer, RadioButton selectedAnswer) {
		return rightAnswer.equals(selectedAnswer.getText());
	}

	//vypisanie do sceny hodnoty danej otazky
	public void handleQuestion(Question question, RadioButton firstAnswerRButton,
			RadioButton secondAnswerRButton, RadioButton thirdAnswerRButton,
			RadioButton fourthAnswerRButton, RadioButton fifthAnswerRButton, TextArea questionText) {
	
		//naplnenie listu
		List<RadioButton> answers = new ArrayList<RadioButton>();
		answers.add(firstAnswerRButton);
		answers.add(secondAnswerRButton);
		answers.add(thirdAnswerRButton);
		answers.add(fourthAnswerRButton);
		answers.add(fifthAnswerRButton);
		
		//randomizacia odpovedi
		Collections.shuffle(answers);
		
		//naplnenie lablov pri radiobuttonoch
		answers.get(0).setText(question.getRightAnswer());
		answers.get(1).setText(question.getWrongAnswer1());
		answers.get(2).setText(question.getWrongAnswer2());
		answers.get(3).setText(question.getWrongAnswer3());
		answers.get(4).setText(question.getWrongAnswer4());
		
		questionText.setText(question.getTask());
		
		
		
	}

	

}
