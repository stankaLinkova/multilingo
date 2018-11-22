package sk.upjs.paz1c.multilingo.entities;

public class Question {

	
	private Long id;
	// zadana otazka
	private String task;
	// az 5 odpovedi
	private String rightAnswer;
	private String wrongAnswer1;
	private String wrongAnswer2;
	private String wrongAnswer3;
	private String wrongAnswer4;
	private Long idTest;
	
	

	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
	}

	public String getWrongAnswer3() {
		return wrongAnswer3;
	}

	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3 = wrongAnswer3;
	}

	public String getWrongAnswer4() {
		return wrongAnswer4;
	}

	public void setWrongAnswer4(String wrongAnswer4) {
		this.wrongAnswer4 = wrongAnswer4;
	}

	@Override
	public String toString() {
		return "Task: " + task + ", Right answer: " + rightAnswer + ", Wrong answer #1: " + wrongAnswer1
				+ ", Wrong answer #2: " + wrongAnswer2 + ", Wrong answer #3: " + wrongAnswer3 + ", Wrong answer #4: "
				+ wrongAnswer4;
	}
}
