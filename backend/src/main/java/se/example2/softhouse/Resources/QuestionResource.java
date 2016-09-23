package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.*;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.Exam;
import se.example2.softhouse.core.ExamQuestion;
import se.example2.softhouse.core.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Path("/exam/{examId}/question")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionResource {

    private QuestionDAO questionDAO;
    private ExamQuestionDAO examQuestionDAO;
    private ChoiceDAO choiceDAO;
    private QuestionAnswerDAO questionAnswerDAO;
    private ExamQuestion examQuestion =new ExamQuestion();
    public QuestionResource(QuestionDAO questionDAO, ExamQuestionDAO examQuestionDAO, ChoiceDAO choiceDAO,QuestionAnswerDAO questionAnswerDAO) {
        this.questionDAO = questionDAO;
        this.examQuestionDAO =examQuestionDAO;
        this.choiceDAO=choiceDAO;
        this.questionAnswerDAO=questionAnswerDAO;
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
    public Response create(@PathParam("examId") int examId, Question question) {

        List<Question>  questionList=questionDAO.getQuestions(examId);

       for (int i = 0; i <questionList.size(); i++) {
           Question question1 = questionList.get(i);

            if (Objects.equals(question.getText(), question1.getText())) {
                throw new NotFoundException();
            }

        }

       int questionId = questionDAO.create(question);
            examQuestionDAO.createinExamQuestion(examId, questionId);
        return Response.ok(questionDAO.retrieve(questionId)).build();
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
        questionDAO.deleteinExamQuestion(examId, questionId);
        Optional<List<Choice>> update = Optional.ofNullable(choiceDAO.getChoices(questionId));
        if (update.isPresent()) {
            choiceDAO.deleteByQuestion(questionId);
            questionAnswerDAO.deleteInQuestionAnswerByQuestionId(questionId);
        }
        return Response.ok().build();
    }
}