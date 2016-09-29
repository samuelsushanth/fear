package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Created by charan on 9/29/2016.
 */
public class Result {
    @JsonProperty
    private List<StudentExam> result;

    @JsonProperty
    private int numberOfQuestions;

    @JsonProperty
    private int numberOfCorrectanswers;

    public Result(List<StudentExam> result,int numberOfQuestions,int numberOfCorrectanswers)
    {
        result=result;
        numberOfCorrectanswers=numberOfCorrectanswers;
        numberOfQuestions=numberOfQuestions;
    }
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

    public List<StudentExam> getResult() {
        return result;
    }

    public void setResult(List<StudentExam> result) {
        this.result = result;
    }
}
