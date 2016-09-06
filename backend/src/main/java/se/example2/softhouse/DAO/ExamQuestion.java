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
import se.example2.softhouse.core.Question;
import java.util.List;
@RegisterMapperFactory(BeanMapperFactory.class)
public interface ExamQuestion {
    @SqlUpdate("create table if not exists ExamQuestion (id Long auto_increment primary key,examId Long,questionId Long)")
    void createExamQuestionTable();

    @SqlUpdate("delete table ExamQuestion")
    void deleteExamQuestionTable();

    @SqlQuery("select * from ExamQuestion")
    List<ExamQuestion> list();

    @SqlUpdate("insert into ExamQuestion (examId,questionId) values (:examId,:questionId)")
    void insExamQuestion(@BindBean ExamQuestion examquestion);

    @SqlUpdate("delete from ExamQuestion where (examId)=(:examId)")
    void delExamQuestion(@BindBean ExamQuestion examquestion);

    @SqlUpdate("update ExamQuestion set (examId,questionId)=(:examId,:questionId) where (id)=(:id)")
    void updExamQuestion(@BindBean ExamQuestion examquestion);
    //get corresponding exams questions
    @SqlQuery("select * from ExamQuestion where (examId)=(:examId) ")
    List<ExamQuestion> listQuestions(@BindBean ExamQuestion examquestion);


}
