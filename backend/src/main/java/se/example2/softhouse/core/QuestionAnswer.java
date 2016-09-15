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
    private int choiceId;

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }


    public int getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
