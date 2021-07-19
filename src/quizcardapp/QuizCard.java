package quizcardapp;

public class QuizCard {
    private String question = null;
    private String answer = null;

    QuizCard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
