package tiil.edu.project_quizzappmatchgrade3.Item1;

public class Question_Quiz {

    String questions, answer1, answer2, answer3, answer4, correctAnswer;

    public Question_Quiz(String questions, String answer1, String answer2, String answer3, String answer4, String correctAnswer) {
        this.questions = questions;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestions() {

        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {

        return answer4;
    }

    public void setAnswer4(String answer4) {

        this.answer4 = answer4;
    }

    public String getCorrectAnswer() {

        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {

        this.correctAnswer = correctAnswer;
    }
}
