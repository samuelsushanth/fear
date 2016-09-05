package se.example2.softhouse.Resources;

import com.codahale.metrics.annotation.Timed;
import se.example2.softhouse.Application.Note.addquestionDAO;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.core.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/addquestion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class QuestionResource {

    private QuestionDAO qdao;

    private Question q1;



    public QuestionResource(QuestionDAO QDAO) {
        qdao = QDAO;



    }

    @GET
    @Timed
    public Question addquestiontodb() {
        //if (question != null) {
          //  qdao.insQues(question);

            //throw new WebApplicationException(Response.Status.OK);
        //} else {
         //   throw new WebApplicationException(Status.BAD_REQUEST);
       // }
        return q1;

    }

    @POST
    @Timed
    public void addquestiontodb(Question question) {
        if (question != null) {
            qdao.insQues(question);

            throw new WebApplicationException(Response.Status.OK);
        } else {
            throw new WebApplicationException(Status.BAD_REQUEST);
        }

    }




}