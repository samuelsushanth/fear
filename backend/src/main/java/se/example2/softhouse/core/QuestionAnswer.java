package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by sasanksaisujanadapa on 05/09/16.
 */
public class QuestionAnswer {
    @JsonProperty
    @NotEmpty
    private int question_id;

    @JsonProperty
    @NotEmpty
    private int answer_id;

    public QuestionAnswer() {}

    public QuestionAnswer(int question_id, int answer_id) {
        this.question_id = question_id;
        this.answer_id = answer_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answerId) {
        this.answer_id = answerId;
    }

    @Override
    public String toString() {
        return "QuestionAnswer{" +
                "question_id=" + question_id +
                ", answer_id=" + answer_id +
                '}';
    }
}
