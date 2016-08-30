package se.example2.softhouse.Resources;

import com.codahale.metrics.annotation.Timed;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.core.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/questions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class QuestionResource {

    private QuestionDAO questionDAO;

    public QuestionResource(QuestionDAO dao) {
        questionDAO = dao;
    }

    @GET
    @Path("/{id}")
    @Timed
    public Question getQuestion(@PathParam("id") Integer id) {
        Question q = questionDAO.findQuestionById(id);
        if (q != null) {
            return q;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }




    @POST
    @Timed
    public void saveQuestion(Question question) {
        if (question != null) {
            questionDAO.insertQuestion(question);
            throw new WebApplicationException(Response.Status.OK);
        } else {
            throw new WebApplicationException(Status.BAD_REQUEST);
        }

    }

    @PUT
    @Path("/{id}")
    public void updateQuestion(@PathParam("id") int id, Question question) {
        if (question != null) {
            questionDAO.updateQuestion(question, id);
            throw new WebApplicationException(Response.Status.OK);
        } else {
            throw new WebApplicationException(Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("/{id}")
    @Timed
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public void deleteQuestion(@PathParam("id") Integer id) {

        if (questionDAO.findQuestionById(id) != null) {
            questionDAO.deleteQuestionById(id);
            throw new WebApplicationException(Response.Status.OK);
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }


}