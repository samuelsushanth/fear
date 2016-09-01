package se.example2.softhouse.core;


import org.hibernate.validator.constraints.NotEmpty;


public class Question {
    private Integer id;
    private String question;
    private NotEmpty.List choice;
    private String ca;

    public Question() {
        super();
    }

    public Question(Integer id, String question) {
        super();
        this.id = id;
        this.question = question;
    }

    public Question(Integer id, String question, NotEmpty.List choice) {
        super();
        this.id = id;
        this.question = question;
        this.choice = choice;
    }

    public Question(Integer id, String question, NotEmpty.List choice, String ca) {
        super();
        this.id = id;
        this.question = question;
        this.choice = choice;
        this.ca=ca;
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

    public void setChoice(NotEmpty.List choice) {
        this.choice = choice;
    }

    public String getCa() { return ca;}

    public void setCa(String ca) {
        this.ca = ca;
    }

}
