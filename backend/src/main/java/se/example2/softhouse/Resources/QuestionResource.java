package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.ExamDAO;
import se.example2.softhouse.DAO.ExamQuestionDAO;
import se.example2.softhouse.DAO.QuestionAnswerDAO;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.core.Exam;
import se.example2.softhouse.core.ExamQuestion;
import se.example2.softhouse.core.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/exam/{id}/question")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionResource {

    private QuestionDAO questionDAO;
    private ExamQuestionDAO examQuestionDAO;
    private ExamQuestion examQuestion =new ExamQuestion();
    public QuestionResource(QuestionDAO questionDAO,ExamQuestionDAO examQuestionDAO ) {
        this.questionDAO = questionDAO;
        this.examQuestionDAO =examQuestionDAO;
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
    public Question create(@PathParam("id") int id, Question question) {
        int questionId = questionDAO.create(question);
          examQuestion.setExamId((long)id);
           examQuestion.setQuestionId((long)questionId);
           examQuestionDAO.create(examQuestion);
        return questionDAO.retrieve(questionId);
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
    public Response delete(@PathParam("id") int id) {
        questionDAO.delete(id);
        return Response.ok().build();
    }
}