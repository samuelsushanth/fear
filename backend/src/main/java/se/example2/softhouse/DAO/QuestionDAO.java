package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.Question;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionDAO {
    @SqlUpdate("create table if not exists QUESTIONS (id Long auto_increment primary key, text varchar(2000))")
    void createQuestionTable();

    @SqlUpdate("delete table QUESTIONS")
    void deleteQuestionTable();

    @SqlQuery("select * from QUESTIONS")
    List<Question> list();

    @SqlUpdate("insert into QUESTIONS (text) values (:text)")
    Long insQues(@BindBean Question question);

    @SqlUpdate("delete from QUESTIONS where (id)=(:id)")
    void delQues(@BindBean Question question);

    @SqlUpdate("update QUESTIONS set (text)=(:text) where (id)=(:id)")
    void updQues(@BindBean Question question);

    @SqlQuery("select (id) from QUESTIONS where (text)=(:text)")
    Long getQuestionId(@BindBean Question question );


}
