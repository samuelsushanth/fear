package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.Question;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionDAO {
    @SqlUpdate("create table if not exists QUESTIONS (id int auto_increment primary key, text varchar(2000))")
    void createQuestionTable();

    @SqlUpdate("delete table QUESTIONS")
    void deleteQuestionTable();

    @SqlQuery("select * from QUESTIONS")
    List<Question> list();

   @GetGeneratedKeys
   @SqlUpdate("insert into QUESTIONS (id, text) values (:id, :text)")
   int create(@BindBean Question question);

    @SqlQuery("select * from QUESTIONS where id = :id")
    Question retrieve(@Bind("id") int id);

    @SqlUpdate("delete from QUESTIONS where id = :id")
    void delete(@Bind("id") int id);

    @SqlUpdate("update QUESTIONS set text = :u.text where id = :id")
    void update(@Bind("id") long id, @BindBean("u") Question question);

    /* @SqlUpdate("insert into QUESTIONS (text) values (:text)")
    Long insQues(@BindBean Question question);

    @SqlUpdate("delete from QUESTIONS where (id)=(:id)")
    void delQues(@BindBean Question question);

    @SqlUpdate("update QUESTIONS set (text)=(:text) where (id)=(:id)")
    void updQues(@BindBean Question question);

    @SqlQuery("select (id) from QUESTIONS where (text)=(:text)")
    Long getQuestionId(@BindBean Question question );*/


}
