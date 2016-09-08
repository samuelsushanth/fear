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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> showquestionstoui()
    {
        return questiondao.list();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addquestiontodb(Qfull qfull) {
        q1.setText(qfull.getQuestiontext());
        e1.setText(qfull.getExamtext());

        qid=questiondao.insQues(q1);


        /*if (q1 != null) {
            qid=questiondao.insQues(q1); //question table

            for( c : ch)
            {

                c.setQuestionId(qid);
                Long cid = choicedao.insChoice(c); //choice table
                if (c.getIscorrect()=="true")

                {
                    aid=cid;
                }

            }
            qa.setQuestionId(qid);qa.setCorrectChoiceId(aid);
           questionAnswerdao.insQuestionAnswer(qa);  //questionanswer table

            long eid=examdao.insQues(e1);  //exam table
            eq.setQuestionId(qid);eq.setExamId(eid);
            examQuestiondao.insExamQuestion(eq); //examquestions table


            throw new WebApplicationException(Response.Status.OK);
        } else {
            throw new WebApplicationException(Status.BAD_REQUEST);
        }*/

    }




}