package se.example2.softhouse.Resources;

/**
 * Created by charan on 9/12/2016.
 */
import se.example2.softhouse.DAO.*;
import se.example2.softhouse.core.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Path("/exam/{examId}/question/{questionId}/choice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChoiceResource {
  private ChoiceDAO choiceDAO;
    private  QuestionAnswerDAO questionAnswerDAO;
        public ChoiceResource(ChoiceDAO choiceDAO,QuestionAnswerDAO questionAnswerDAO ) {
        this.choiceDAO = choiceDAO;
            this.questionAnswerDAO=questionAnswerDAO;
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

      if (choice.getIsCorrect()== 1)
      {

          int choiceid=questionAnswerDAO.createInQuestionAnswer(questionId,choiceId);

      }
      //choice.setIsCorrect(choice.getIsCorrect());
        return choiceDAO.retrieve(choiceId);
        //return choice;
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
    public Response delete(@PathParam("choiceId") int choiceId,@PathParam("questionId") int questionId) {
        choiceDAO.delete(choiceId);

        long choiceIdold=questionAnswerDAO.getChoiceId(questionId);
     //   questionAnswerDAO.deleteInQuestionAnswer(choiceId);

            if(choiceIdold==choiceId) {
                questionAnswerDAO.deleteInQuestionAnswer(choiceId);
            }

        return Response.ok().build();
    }

    @GET
    @Path("/correctChoiceId")
    public long retrieveCorrectchoice(@PathParam("questionId") int questionId) {
        return questionAnswerDAO.getChoiceId(questionId);
    }


}
