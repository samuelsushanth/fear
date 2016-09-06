package se.example2.softhouse.core;


        import com.fasterxml.jackson.annotation.JsonProperty;
        import org.hibernate.validator.constraints.NotEmpty;

        import java.util.ArrayList;
/**
 * Created by charan on 9/6/2016.
 */
public class Choice {
    @JsonProperty
    private Long id;

    @JsonProperty
    @NotEmpty
    private String text;

    @JsonProperty
    @NotEmpty
    private Long questionId;


    public Choice() {

    }
    public  Choice(String choic)
    {
        text = choic;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
