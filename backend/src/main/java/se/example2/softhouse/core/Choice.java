package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;


public class Choice {
    @JsonProperty
    private Integer id;

    @JsonProperty
    @NotEmpty
    private int question_id;

    @JsonProperty
    @NotEmpty
    private String choice;

    public Choice() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {this.choice = choice;}

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question_id='" + question_id + '\'' +
                ", choice=" + choice +
                '}';
    }
}
