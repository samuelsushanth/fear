package se.example2.softhouse.Resources;

/**
 * Created by charan on 9/12/2016.
 */
import se.example2.softhouse.DAO.*;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.Exam;
import se.example2.softhouse.core.ExamQuestion;
import se.example2.softhouse.core.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
@Path("/exam/{examId}/question/{questionId}/choice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChoiceResource {
  private ChoiceDAO choiceDAO;
    public ChoiceResource(ChoiceDAO choiceDAO ) {
        this.choiceDAO = choiceDAO;

    }
    @GET
    public List<Choice> list(@PathParam("questionId") Integer id) {

        return choiceDAO.getChoices(id);
    }
    @POST
    public Choice create(@PathParam("questionId") int questionId, Choice choice) {
        int choiceId = choiceDAO.create(choice,questionId);

     /*     examQuestion.setExamId((long)examId);
           examQuestion.setQuestionId((long)questionId);
           examQuestionDAO.create(examQuestion);*/
      if (choice.getIsCorrect()=="true") {
          choiceDAO.createInQuestionChoice(questionId, choiceId);
      }
        return choiceDAO.retrieve(choiceId);
    }

    @GET
    @Path("/{choiceId}")
    public Choice retrieve(@PathParam("choiceId") Integer id) {
        return choiceDAO.retrieve(id);
    }



    @PUT
    @Path("/{choiceId}")
    public Response update(@PathParam("choiceId") int choiceId,Choice choice) {
        Optional<Choice> update = Optional.ofNullable(choiceDAO.retrieve(choiceId));

        if (update.isPresent()) {
            choiceDAO.update(choiceId, choice);
            return Response.ok(choiceDAO.retrieve(choiceId)).build();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("/{choiceId}")
    public Response delete(@PathParam("choiceId") int choiceId,Choice choice) {
        choiceDAO.delete(choiceId);
        if (choice.getIsCorrect()=="true") {
            choiceDAO.deleteInQuestionChoice(choiceId);
        }
        return Response.ok().build();
    }

}
