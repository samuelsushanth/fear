package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.*;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.Qfull;
import se.example2.softhouse.core.Question;
import se.example2.softhouse.core.StudentExam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 * Created by charan on 9/21/2016.
 */
@Path("/student/takeatest/{examId}/{userId}/question")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentExamResource {
    private QuestionDAO questionDAO;
    private ExamQuestionDAO examQuestionDAO;
    private ChoiceDAO choiceDAO;
    private StudentExamDAO studentExamDAO;
    private QuestionAnswerDAO questionAnswerDAO;
    private UserRegisterDAO userRegisterDAO;

    public StudentExamResource(UserRegisterDAO userRegisterDAO,QuestionDAO questionDAO, ExamQuestionDAO examQuestionDAO, ChoiceDAO choiceDAO, StudentExamDAO studentExamDAO, QuestionAnswerDAO questionAnswerDAO) {
        this.questionDAO = questionDAO;
        this.examQuestionDAO =examQuestionDAO;
        this.choiceDAO=choiceDAO;
        this.studentExamDAO=studentExamDAO;
        this.questionAnswerDAO=questionAnswerDAO;
        this.userRegisterDAO=userRegisterDAO;
    }

    @GET
    public List<Question> list(@PathParam("examId") Integer id) {

        return questionDAO.getQuestions(id);
    }

    @GET
    @Path("/{questionId}")
    public Qfull retrieve(@PathParam("questionId") Integer questionId)
    {

      Question question = questionDAO.retrieve(questionId);
      List<Choice> choices =choiceDAO.getChoices(questionId);

       Qfull qfull = new Qfull(question,choices);

        return  qfull;
    }

    @POST
    public void create() {

    }

    @PUT
    @Path("/{questionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public StudentExam update(@PathParam("examId") int examId,@PathParam("userId") int userId,@PathParam("questionId") int questionId,Qfull qfull) {
           int marks =0;int id;
       long selectedId=qfull.getSelectedId();

        long answerId= questionAnswerDAO.getChoiceId(questionId);
        if(selectedId==answerId) {
            marks = 1;
        }
        StudentExam studentExam= new StudentExam(userId,examId,questionId,selectedId,marks);
      /*  id = studentExamDAO.create(studentExam);
        return studentExamDAO.retrieve(id);*/
        Optional<StudentExam> update = Optional.ofNullable(studentExamDAO.retrieveByQuestionId(questionId));
        if (update.isPresent()) {
           studentExamDAO.update(questionId,studentExam);
            id=studentExamDAO.retrieveIdByQuestionId(questionId);
           return studentExamDAO.retrieve(id);

        }
        else {
           id = studentExamDAO.create(studentExam);
           return studentExamDAO.retrieve(id);
        }
    }

    @DELETE
    @Path("/{questionId}")
    public void delete() {

    }

    @GET
    @Path("/result")
    public List<StudentExam> retrieve(@PathParam("userId") int userId,@PathParam("examId") int examId)
    {

        return studentExamDAO.retrieveAnswers(userId,examId);

    }

}
