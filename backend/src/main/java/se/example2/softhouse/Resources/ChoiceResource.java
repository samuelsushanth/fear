package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.ChoiceDAO;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/question")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ChoiceResource {

    private ChoiceDAO choiceDAO;

    public ChoiceResource(ChoiceDAO choiceDAO) {
        this.choiceDAO = choiceDAO;
    }

    @GET
    public List<Question> list() {
        return choiceDAO.list();
    }

    @GET
    @Path("/{id}")
    public Question retrieve(@PathParam("id") Integer id) {
        return choiceDAO.retrieve(id);
    }

    @POST
    public Question create(Question question) {
        int id = choiceDAO.create(question);
        return choiceDAO.retrieve(id);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Choice choice) {
        Optional<Question> update = Optional.ofNullable(choiceDAO.retrieve(id));

        if (update.isPresent()) {
            choiceDAO.update(id, choice);
            return Response.ok(choiceDAO.retrieve(id)).build();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        choiceDAO.delete(id);
        return Response.ok().build();
    }
}