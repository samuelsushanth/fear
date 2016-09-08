package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.QuestionAnswer;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionAnswerDAO {

    @SqlUpdate("create table if not exists QUESTION_ANSWER (question_id int(10), answer_id int(10))")
    void createQuestionAnswerTable();

    @SqlUpdate("insert into QUESTION_ANSWER (question_id, answer_id) values (:question_id, :answer_id)")
    int create(@BindBean QuestionAnswer questionAnswer);
    /*
        @SqlUpdate("update QUESTION_ANSWER set question_id = :u.question_id, answer_id = :u.answer_id where id = :id")
        void update(@Bind("id") int id, @BindBean("u") QuestionAnswer questionAnswer);

        @SqlQuery("select * from QUESTION_ANSWER where question_id = :id")
        QuestionAnswer retrieve(@Bind("id") int id);



        @SqlUpdate("delete from QUESTION_ANSWER where question_id = :it")
        void delete(@Bind int id);
    */
    @SqlQuery("select * from QUESTION_ANSWER")
    List<QuestionAnswer> list();

}
