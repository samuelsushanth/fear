package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.ChoiceDAO;
import se.example2.softhouse.DAO.QuestionAnswerDAO;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.QuestionAnswer;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/choice")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ChoiceResource {

    private ChoiceDAO choiceDAO;
    private QuestionAnswerDAO questionAnswerDAO;

    public ChoiceResource(ChoiceDAO choiceDAO, QuestionAnswerDAO questionAnswerDao) {
        this.choiceDAO = choiceDAO;
        this.questionAnswerDAO = questionAnswerDao;
    }

    @GET
    public List<Choice> list() {
        return choiceDAO.list();
    }

    @GET
    @Path("/{id}")
    public Choice retrieve(@PathParam("id") Integer id) {
        return choiceDAO.retrieve(id);
    }


    @POST
    public Choice create(Choice choice) {
        int id = choiceDAO.create(choice);
        Choice addedChoice = choiceDAO.retrieve(id);

        if (choice.getIsCorrect()) {
            QuestionAnswer correctAnswer = new QuestionAnswer(choice.getQuestion_id(), id);
            questionAnswerDAO.create(correctAnswer);
            addedChoice.setIsCorrect(true);
        }

        return addedChoice;
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Choice choice) {
        Optional<Choice> update = Optional.ofNullable(choiceDAO.retrieve(id));

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