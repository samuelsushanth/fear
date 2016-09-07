package se.example2.softhouse.Resources;

/**
 * Created by charan on 9/6/2016.
 */
import com.codahale.metrics.annotation.Timed;
        import se.example2.softhouse.Application.Note.addquestionDAO;
        import se.example2.softhouse.DAO.*;
        import se.example2.softhouse.core.*;

        import javax.ws.rs.*;
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;
        import javax.ws.rs.core.Response.Status;
        import java.sql.Array;
        import java.util.ArrayList;
        import java.util.List;

@Path("/exam")

public class ExamResource {
    private QuestionDAO questiondao;
    private ChoiceDAO choicedao;
    private QuestionAnswerDAO questionAnswerdao;
    private ExamDAO examdao;
    private ExamQuestionDAO examQuestiondao;

    private Question q1;
    private Choice  c;
    private QuestionAnswer qa;
    private Exam e1;
    private ExamQuestion eq;
    private List<Question> questions;
    private Long qid;
    private Long aid;

    public ExamResource(QuestionDAO qdao,ChoiceDAO chdao,QuestionAnswerDAO qadao,ExamDAO edao,ExamQuestionDAO eqdao) {
        questiondao =qdao;
        choicedao=chdao;
        questionAnswerdao=qadao;
        examdao=edao;
        examQuestiondao=eqdao;
    }


    private List<Exam> exams;
    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exam> showexams()
    {
        exams=new ArrayList<>();

        exams=examdao.list();
        return exams;
    }

}
