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

@Path("/exam/{examId}/question")
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
    public List<Question> list(@PathParam("examId") Integer id) {

        return questionDAO.getQuestions(id);
    }

    @GET
    @Path("/{questionId}")
    public Question retrieve(@PathParam("questionId") Integer id) {
        return questionDAO.retrieve(id);
    }

    @POST
    public Question create(@PathParam("examId") int examId, Question question) {
        int questionId = questionDAO.create(question);
     /*     examQuestion.setExamId((long)examId);
           examQuestion.setQuestionId((long)questionId);
           examQuestionDAO.create(examQuestion);*/
       questionDAO.createinExamQuestion(examId,questionId);
        return questionDAO.retrieve(questionId);
    }

    @PUT
    @Path("/{questionId}")
    public Response update(@PathParam("questionId") int questionId, Question question) {
        Optional<Question> update = Optional.ofNullable(questionDAO.retrieve(questionId));

        if (update.isPresent()) {
            questionDAO.update(questionId, question);
            return Response.ok(questionDAO.retrieve(questionId)).build();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("/{questionId}")
    public Response delete(@PathParam("examId") int examId,@PathParam("questionId") int questionId) {
        questionDAO.delete(questionId);
        questionDAO.deleteinExamQuestion(examId,questionId);
        return Response.ok().build();
    }
}