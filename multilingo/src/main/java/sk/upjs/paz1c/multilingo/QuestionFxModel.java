package sk.upjs.paz1c.multilingo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.entities.School;


@SuppressWarnings("restriction")
public class QuestionFxModel {

	
	private Question question;
	private StringProperty task = new SimpleStringProperty();
	private StringProperty rightAnswer = new SimpleStringProperty();
	private StringProperty wrongAnswer1 = new SimpleStringProperty();
	private StringProperty wrongAnswer2 = new SimpleStringProperty();
	private StringProperty wrongAnswer3 = new SimpleStringProperty();
	private StringProperty wrongAnswer4 = new SimpleStringProperty();	
	private Long idTest;
	
	
	public QuestionFxModel() {
		
	}

	public QuestionFxModel (Question question){
		this.question = question;
		setTask(question.getTask());
		setRightAnswer(question.getRightAnswer());
		setWrongAnswer1(question.getWrongAnswer1());
		setWrongAnswer2(question.getWrongAnswer2());
		setWrongAnswer3(question.getWrongAnswer3());
		setWrongAnswer4(question.getWrongAnswer4());
		setIdTest(question.getIdTest());
}
	

	
	public Question getQuestion() {
		question = new Question();
		question.setTask(getTask());
		question.setRightAnswer(getRightAnswer());
		question.setWrongAnswer1(getWrongAnswer1());
		question.setWrongAnswer2(getWrongAnswer2());
		question.setWrongAnswer3(getWrongAnswer3());
		question.setWrongAnswer4(getWrongAnswer4());
		question.setIdTest(getIdTest());
		return question;
	}
	
	
	
	public StringProperty getTaskProperty() {
		return task;
	}

	public String getTask() {
		return task.get();
	}

	public void setTask(String task) {
		this.task.set(task);;
	}


	public StringProperty getRightAnswerProperty() {
		return rightAnswer;
	}
	
	public String getRightAnswer() {
		return rightAnswer.get();
	}


	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer.set(rightAnswer);;
	}


	public StringProperty getWrongAnswer1Property() {
		return wrongAnswer1;
	}
	
	public String getWrongAnswer1() {
		return wrongAnswer1.get();
	}


	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1.set(wrongAnswer1);;
	}


	public StringProperty getWrongAnswer2Property() {
		return wrongAnswer2;
	}
	
	public String getWrongAnswer2() {
		return wrongAnswer2.get();
	}


	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2.set(wrongAnswer2);;
	}

	public StringProperty getWrongAnswer3Property() {
		return wrongAnswer3;
	}
	
	public String getWrongAnswer3() {
		return wrongAnswer3.get();
	}


	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3.set(wrongAnswer3);;
	}

	public StringProperty getWrongAnswer4Property() {
		return wrongAnswer4;
	}
	
	public String getWrongAnswer4() {
		return wrongAnswer4.get();
	}


	public void setWrongAnswer4(String wrongAnswer4) {
		this.wrongAnswer4.set(wrongAnswer4);;
	}
	
	public Long getIdTest() {
		return idTest;
	}


	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	
	
}
