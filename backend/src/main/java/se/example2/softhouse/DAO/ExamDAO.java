package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
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

    @SqlUpdate("insert into Exam (text) values (:text)")
    void insQues(@BindBean Exam exam);

    @SqlUpdate("delete from Exam where (id)=(:id)")
    void delQues(@BindBean Exam exam);

    @SqlUpdate("update QUESTIONS set (text)=(:text) where (id)=(:id)")
    void updQues(@BindBean Exam exam);


}
