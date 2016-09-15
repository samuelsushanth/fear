package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by charan on 9/6/2016.
 */
public class QuestionAnswer {
    @JsonProperty
    private int id;

    @JsonProperty
    @NotEmpty
    private int questionId;

    @JsonProperty
    @NotEmpty
    private int correctChoiceId;

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getCorrectChoiceId() {
        return correctChoiceId;
    }

    public void setCorrectChoiceId(int correctChoiceId) {
        this.correctChoiceId = correctChoiceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
