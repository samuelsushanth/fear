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
public interface ExamDAO {

    @SqlUpdate("create table if not exists Exam (id Long auto_increment primary key, text varchar(2000))")
    void createExamTable();

    @SqlUpdate("delete table Exam")
    void deleteExamTable();

    @SqlQuery("select * from Exam")
    List<Exam> list();

    @GetGeneratedKeys
    @SqlUpdate("insert into Exam (id, text) values (:id, :text)")
    int create(@BindBean Exam exam);

    @SqlQuery("select * from Exam where id = :id")
    Exam retrieve(@Bind("id") int id);

    @SqlUpdate("delete from Exam where id = :id")
    void delete(@Bind("id") int id);

    @SqlUpdate("update Exam set text = :u.text where id = :id")
    void update(@Bind("id") int id, @BindBean("u") Exam exam);
}