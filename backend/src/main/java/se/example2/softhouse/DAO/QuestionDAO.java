package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Exam;
import se.example2.softhouse.core.Question;

import java.util.List;

/**
 * Created by charan on 9/6/2016.
 */
import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionDAO {

    @SqlUpdate("create table if not exists Question (id Long auto_increment primary key, text varchar(2000))")
    void createQuestionTable();

    @SqlUpdate("delete table Question")
    void deleteQuestionTable();

    @SqlQuery("select * from Question")
    List<Question> list();


    /* @SqlQuery("select * from Exam where (id) =(:id)")
     Exam retrieve(@Bind("id") int id);
     @GetGeneratedKeys
     @SqlUpdate("insert into Exam (id, text) values (:id, :text)")
     int create(@BindBean Exam exam);
     @SqlUpdate("delete from Exam where (id)=(:id)")
     void destroy(@BindBean Exam exam);
     @SqlUpdate("update Exam set (text)=(:text) where (id)=(:id)")
     void update(@BindBean Exam exam);
     @SqlQuery("select (id) from Exam where (text)=(:text)")
     Long get(@BindBean Exam exam );
 */
    @GetGeneratedKeys
    @SqlUpdate("insert into Question (id, text) values (:id, :text)")
    int create(@BindBean Question question);

    @SqlQuery("select * from Question where id = :id")
    Question retrieve(@Bind("id") int id);

    @SqlUpdate("delete from Question where id = :id")
    void delete(@Bind int id);

    @SqlUpdate("update Question set text = :u.text where id = :id")
    void update(@Bind("id") int id, @BindBean("u") Question question);
}