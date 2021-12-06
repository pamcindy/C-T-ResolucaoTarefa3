package model;

public class Question {

	private String category, type, difficulty, question, correct_answer,
	incorrect_answer1, incorrect_answer2, incorrect_answer3, references;

	
	public Question() {
		
	}
	
	public Question(String category, String type, String difficulty, String question, String correct_answer,
			String incorrect_answer1, String incorrect_answer2, String incorrect_answer3, String references) {
		this.category = category;
		this.type = type;
		this.difficulty = difficulty;
		this.question = question;
		this.correct_answer = correct_answer;
		this.incorrect_answer1 = incorrect_answer1;
		this.incorrect_answer2 = incorrect_answer2;
		this.incorrect_answer3 = incorrect_answer3;
		this.references = references;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	public String getIncorrect_answer1() {
		return incorrect_answer1;
	}

	public void setIncorrect_answer1(String incorrect_answer1) {
		this.incorrect_answer1 = incorrect_answer1;
	}

	public String getIncorrect_answer2() {
		return incorrect_answer2;
	}

	public void setIncorrect_answer2(String incorrect_answer2) {
		this.incorrect_answer2 = incorrect_answer2;
	}

	public String getIncorrect_answer3() {
		return incorrect_answer3;
	}

	public void setIncorrect_answer3(String incorrect_answer3) {
		this.incorrect_answer3 = incorrect_answer3;
	}

	public String getReferences() {
		return references;
	}

	public void setReferences(String references) {
		this.references = references;
	}
	
	
	
	
	
	
}
