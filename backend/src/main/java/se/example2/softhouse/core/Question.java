package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;


public class Question {
    @JsonProperty
    private Integer id;

    @JsonProperty
    @NotEmpty
    private String question;

    @JsonProperty
    @NotEmpty
    private NotEmpty.List choice;


    @JsonProperty
    @NotEmpty
    private int CA;

    public Question() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

     public NotEmpty.List getchoice() {
        return choice;
    }

    public void setChoice(NotEmpty.List opc) {
        this.choice = opc;
    }

    public int getCA() {
        return CA;
    }

    public void setCA(int ca) {
        this.CA = ca;
    }

}
