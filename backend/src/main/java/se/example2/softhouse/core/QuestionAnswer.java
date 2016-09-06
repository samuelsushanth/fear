package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by charan on 9/6/2016.
 */
public class QuestionAnswer {
    @JsonProperty
    private Long id;

    @JsonProperty
    @NotEmpty
    private Long questionId;

    @JsonProperty
    @NotEmpty
    private Long correctChoiceId;

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public Long getCorrectChoiceId() {
        return correctChoiceId;
    }

    public void setCorrectChoiceId(Long correctChoiceId) {
        this.correctChoiceId = correctChoiceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
