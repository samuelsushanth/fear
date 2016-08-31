package se.example2.softhouse.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by sasanksaisujanadapa on 25/08/16.
 */

public class Question {
    @JsonProperty
    private Integer id;

    @JsonProperty
    @NotEmpty
    private String question;

    @JsonProperty
    @NotEmpty
    private String opa;

    @JsonProperty
    @NotEmpty
    private String opb;

    @JsonProperty
    @NotEmpty
    private String opc;

    @JsonProperty
    @NotEmpty
    private String corr_op;

    public Question() {
        super();
    }

    public Question(Integer id, String question) {
        super();
        this.id = id;
        this.question = question;
    }


    public Question(Integer id, String question, String opa) {
        super();
        this.id = id;
        this.question = question;
        this.opa = opa;
    }

    public Question(Integer id, String question, String opa, String opb) {
        super();
        this.id = id;
        this.question = question;
        this.opa = opa;
        this.opb = opb;
    }

    public Question(Integer id, String question, String opa, String opb, String opc) {
        super();
        this.id = id;
        this.question = question;
        this.opa = opa;
        this.opb = opb;
        this.opc = opc;
    }

    public Question(Integer id, String question, String opa, String opb, String opc, String corr_op) {
        super();
        this.id = id;
        this.question = question;
        this.opa = opa;
        this.opb = opb;
        this.opc = opc;
        this.corr_op = corr_op;
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

    public String getOpa() {
        return opa;
    }

    public void setOpa(String opa) {
        this.opa = opa;
    }

    public String getOpb() {
        return opb;
    }

    public void setOpb(String opb) {
        this.opb = opb;
    }

    public String getOpc() {
        return opc;
    }

    public void setOpc(String opc) {
        this.opc = opc;
    }

    public String getCorr_op() {
        return corr_op;
    }

    public void setCorr_op(String corr_op) {
        this.corr_op = corr_op;
    }

}
