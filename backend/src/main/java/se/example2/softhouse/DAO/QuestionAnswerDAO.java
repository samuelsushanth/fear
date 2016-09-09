package se.example2.softhouse.DAO;

/**
 * Created by charan on 9/6/2016.
 */
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.ExamQuestion;
import se.example2.softhouse.core.Question;
import se.example2.softhouse.core.QuestionAnswer;

import java.util.List;
@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionAnswerDAO {
    @SqlUpdate("create table if not exists QuestionAnswer (id Long auto_increment primary key,examId Long,questionId Long)")
    void createQuestionAnswerTable();

    @SqlUpdate("delete table QuestionAnswer")
    void deleteQuestionAnswerTable();

    @SqlQuery("select * from QuestionAnswer")
    List<QuestionAnswer> list();

    @SqlUpdate("insert into QuestionAnswer (questionId,correctChoiceId) values (:questionId, :correctChoiceId)")
    void insQuestionAnswer(@BindBean QuestionAnswer questionAnswer);

    @SqlUpdate("delete from QuestionAnswer where (questionId)=(:questionId)")
    void delQuestionAnswer(@BindBean QuestionAnswer questionAnswer);

    @SqlUpdate("update QuestionAnswer set (questionId,,correctChoiceId)=(:questionId, :correctChoiceId) where (id)=(:id)")
    void updQuestionAnswer(@BindBean QuestionAnswer questionAnswer);
    //get corresponding exams questions
    @SqlQuery("select * from QuestionAnswer where (questionId)=(:questionId) ")
    List<QuestionAnswer> listQuestions(@BindBean QuestionAnswer questionAnswer);



}
