package se.example2.softhouse.Resources;

import io.dropwizard.auth.Auth;
import se.example2.softhouse.DAO.*;
import se.example2.softhouse.core.Question;
import se.example2.softhouse.core.StudentExam;
import se.example2.softhouse.core.UserDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by charan on 9/21/2016.
 */
@Path("/student/takeatest/{examId}/result")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentExamResultResource {
    private QuestionDAO questionDAO;
    private ExamQuestionDAO examQuestionDAO;
    private ChoiceDAO choiceDAO;
    private StudentExamDAO studentExamDAO;
    private QuestionAnswerDAO questionAnswerDAO;
    private UserRegisterDAO userRegisterDAO;

    public StudentExamResultResource(StudentExamDAO studentExamDAO) {
        this.questionDAO = questionDAO;
        this.examQuestionDAO =examQuestionDAO;
        this.choiceDAO=choiceDAO;
        this.studentExamDAO=studentExamDAO;
        this.questionAnswerDAO=questionAnswerDAO;
        this.userRegisterDAO=userRegisterDAO;
    }

    @GET
    public List<StudentExam> retrieve(@Auth UserDetails userDetails, @PathParam("examId") Long examId)
    {
        String userName=userDetails.getUserName();
        long userId=userRegisterDAO.retrieveUserId(userName);
        return studentExamDAO.retrieveAnswers(userId,examId);

    }
}
