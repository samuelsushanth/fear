package se.example2.softhouse.Resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import se.example2.softhouse.core.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sasanksaisujanadapa on 30/08/16.
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private String template;
    private String defaultName;
    private AtomicLong counter;
    public String value=null;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();

    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);

    }


}

