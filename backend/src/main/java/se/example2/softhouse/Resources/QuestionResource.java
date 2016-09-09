package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.*;
import se.example2.softhouse.core.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/exam/{id}/question")



public class QuestionResource {

    private QuestionDAO questionDAO;
    private ExamDAO examDAO;
    private ExamQuestionDAO examQuestionDAO;

    private Question q1;
    private Exam e1;
    private ExamQuestion eq;
    private List<Question> questions;
    private int qid;
    private int aid;

    public QuestionResource(QuestionDAO qdao,ExamDAO edao,ExamQuestionDAO eqdao) {
        questionDAO =qdao;
        examDAO =edao;
        examQuestionDAO =eqdao;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> list()
    {
        return questionDAO.list();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Question createQuestion(@PathParam("id") int examId, Question question) {
        int questionId=questionDAO.create(question);
        examQuestionDAO.createExamQuestion(examId,questionId);
        return questionDAO.retrieve(questionId);
    }




}