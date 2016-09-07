package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Question;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionDAO {
    @SqlUpdate("create table if not exists QUESTIONS (id int auto_increment primary key, question varchar(1000))")
    void createQuestionTable();

    @GetGeneratedKeys
    @SqlUpdate("insert into QUESTIONS (id, question) values (:id, :question)")
    int create(@BindBean Question question);

    @SqlUpdate("update QUESTIONS set question = :u.question where id = :id")
    void update(@Bind("id") int id, @BindBean("u") Question question);

    @SqlQuery("select * from QUESTIONS where id = :id")
    Question retrieve(@Bind("id") int id);

    @SqlQuery("select * from QUESTIONS")
    List<Question> list();

    @SqlUpdate("delete from QUESTIONS where id = :it")
    void delete(@Bind int id);
}
