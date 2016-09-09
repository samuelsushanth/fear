package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by charan on 9/7/2016.
 */
public class Qfull {

    @JsonProperty
    private String questiontext;

   @JsonProperty
    private List<Choice> choices;

    @JsonProperty
    private String examtext;

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public String getQuestiontext() {
        return questiontext;
    }
  /*
    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
*/
    public String getExamtext() {
        return examtext;
    }

    public void setExamtext(String examtext) {
        this.examtext = examtext;
    }

    @Override
    public String toString() {
        return "Note{" +
                "question=" + questiontext +
                ", choices='" + //choices + '\'' +
                ", examname='" +examtext + '\'' +
                '}';
    }
}
