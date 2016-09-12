package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.ChoiceDAO;
import se.example2.softhouse.DAO.ExamDAO;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.Exam;
import se.example2.softhouse.core.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/exam")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamResource {
    private ExamDAO examdao;
    private QuestionDAO questionDAO;
    private ChoiceDAO choiceDAO;
    public ExamResource(ExamDAO examDAO,QuestionDAO questionDAO,ChoiceDAO choiceDAO) {
        this.examdao = examDAO;this.questionDAO=questionDAO;
    }


    @GET
    public List<Exam> list() {
        return examdao.list();
    }

    @GET
    @Path("/{id}")
    public Exam retrieve(@PathParam("id") Integer id) {
        return examdao.retrieve(id);
    }

    @POST
    public Exam create(Exam exam) {
        int id = examdao.create(exam);
        return examdao.retrieve(id);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Exam exam) {
        Optional<Exam> update = Optional.ofNullable(examdao.retrieve(id));

        if (update.isPresent()) {
            examdao.update(id, exam);
            return Response.ok(examdao.retrieve(id)).build();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        examdao.delete(id);
        Optional<List<Long>> update = Optional.ofNullable(questionDAO.checkQuestionInExamQuestion(id));
        if (update.isPresent()) {
            questionDAO.deleteinExamQuestionByExamId(id);

          /*  for(Integer questionId : update) {               //deleting for each question
                questionDAO.delete(questionId);
                choiceDAO.deleteByQuestion(questionId);
                choiceDAO.deleteInQuestionAnswerByQuestionId(questionId);
            }*/
        }
        return Response.ok().build();
    }
}