package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.core.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/question")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionResource {
    private QuestionDAO questionDAO;

    public QuestionResource(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @GET
    public List<Question> list() {
        return questionDAO.list();
    }

    @GET
    @Path("/{id}")
    public Question retrieve(@PathParam("id") Integer id) {
        return questionDAO.retrieve(id);
    }

    @POST
    public Question create(Question question) {
        int id = questionDAO.create(question);
        return questionDAO.retrieve(id);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Question question) {
        Optional<Question> update = Optional.ofNullable(questionDAO.retrieve(id));

        if (update.isPresent()) {
            questionDAO.update(id, question);
            return Response.ok(questionDAO.retrieve(id)).build();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        questionDAO.delete(id);
        return Response.ok().build();
    }
}