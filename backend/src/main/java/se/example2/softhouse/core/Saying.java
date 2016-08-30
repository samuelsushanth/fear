package se.example2.softhouse.core;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by sasanksaisujanadapa on 30/08/16.
 */

public class Saying {
    private long id;

    @Length(max = 3)
    @JsonProperty
    private String content;

    public Saying() {

    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

}