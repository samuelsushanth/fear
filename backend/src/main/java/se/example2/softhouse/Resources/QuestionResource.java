package se.example2.softhouse.Resources;

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

@Path("/question")



public class QuestionResource {

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

    public QuestionResource(QuestionDAO qdao,ChoiceDAO chdao,QuestionAnswerDAO qadao,ExamDAO edao,ExamQuestionDAO eqdao) {
        questiondao =qdao;
        choicedao=chdao;
        questionAnswerdao=qadao;
        examdao=edao;
        examQuestiondao=eqdao;
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> showquestionstoui()
    {
        questions=new ArrayList<>();

        questions=questiondao.list();
        return questions;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addquestiontodb(Question q, List<Choice> ch, Exam e) {
        q1=q;
        e1=e;
        if (q != null) {
            qid=questiondao.insQues(q);

          /*  for( c : ch)
            {

                c.setQuestionId(qid);
                Long cid = choicedao.insChoice(c);
                if (c.getIscorrect()=="true")

                {
                    aid=cid;
                }

            }*/
            qa.setQuestionId(qid);qa.setCorrectChoiceId(aid);
           questionAnswerdao.insQuestionAnswer(qa);

            long eid=examdao.insQues(e);
            eq.setQuestionId(qid);eq.setExamId(eid);
            examQuestiondao.insExamQuestion(eq);


            throw new WebApplicationException(Response.Status.OK);
        } else {
            throw new WebApplicationException(Status.BAD_REQUEST);
        }

    }




}