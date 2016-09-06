package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;


public class Question {
    @JsonProperty
    private Integer id;

    @JsonProperty
    @NotEmpty
    private String question;

   /* @JsonProperty
    @NotEmpty
    private ArrayList choice;*/


    @JsonProperty
    @NotEmpty
    private int CA;


    public Question() {

    }
    public  Question(String ques,int corr)
    {
        question = ques;
        CA=corr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

   /*  public ArrayList getchoice() {
        return choice;
    }

    public void setChoice(ArrayList opc) {
        this.choice = opc;
    }
*/
    public int getCA() {
        return CA;
    }

    public void setCA(int ca) {
        this.CA = ca;
    }

}
