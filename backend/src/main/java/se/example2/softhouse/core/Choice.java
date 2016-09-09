package se.example2.softhouse.core;


        import com.fasterxml.jackson.annotation.JsonProperty;
        import org.hibernate.validator.constraints.NotEmpty;

        import java.util.ArrayList;
/**
 * Created by charan on 9/6/2016.
 */
public class Choice {
    @JsonProperty
    private int id;

    @JsonProperty
    @NotEmpty
    private String text;

    @JsonProperty
    @NotEmpty
    private int questionId;

    @JsonProperty
    @NotEmpty
    private String iscorrect;

    public void setIscorrect(String iscorrect) {
        this.iscorrect = iscorrect;
    }

    public String getIscorrect() {
        return iscorrect;
    }

    public Choice() {

    }
    public  Choice(String choic)
    {
        text = choic;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*
        public void setId(int id) {
            this.id = id;
        }
    */

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
