package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Created by charan on 9/29/2016.
 */
public class Result {
    @JsonProperty
    @NotEmpty
    private List result;

    @JsonProperty
    private int numberOfQuestions;

    @JsonProperty
    private int numberOfCorrectanswers;

    public int getNumberOfCorrectanswers() {
        return numberOfCorrectanswers;
    }

    public void setNumberOfCorrectanswers(int numberOfCorrectanswers) {
        this.numberOfCorrectanswers = numberOfCorrectanswers;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
