package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;


public class Question {
    @JsonProperty
    private Long id;

    @JsonProperty
    @NotEmpty
    private String text;




    public Question() {

    }
    public  Question(String ques)
    {
        text = ques;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String question) {
        this.text = question;
    }

}
