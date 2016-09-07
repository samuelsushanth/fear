package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.QuestionAnswerDAO;
import se.example2.softhouse.core.QuestionAnswer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/question-answer")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class QuestionAnswerResource {
    private QuestionAnswerDAO questionAnswerDAO;

    public QuestionAnswerResource(QuestionAnswerDAO questionAnswerDao) {
        this.questionAnswerDAO = questionAnswerDao;
    }

    @GET
    public List<QuestionAnswer> list() {
        return questionAnswerDAO.list();
    }
}