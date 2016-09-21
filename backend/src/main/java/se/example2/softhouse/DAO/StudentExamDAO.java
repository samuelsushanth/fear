package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Question;
import se.example2.softhouse.core.StudentExam;

import java.util.List;

/**
 * Created by charan on 9/21/2016.
 */
@RegisterMapperFactory(BeanMapperFactory.class)
public interface StudentExamDAO {

    @SqlUpdate("create table if not exists studentexam (id Long auto_increment primary key,userId Long,examId Long,questionId Long,selectedId Long,marks Long)")
    void createStudentExamTable();

    @SqlUpdate("delete table studentexam")
    void deleteQuestionTable();

    @SqlQuery("select * from studentexam")
    List<StudentExam> list();

    @GetGeneratedKeys
    @SqlUpdate("insert into studentexam (id, userId,examId,questionId,selectedId,marks) values (:id,:userId,:examId,:questionId,:selectedId,:marks)")
    int create(@BindBean StudentExam studentExam);

    @SqlQuery("select * from studentexam where id = :id")
    StudentExam retrieve(@Bind("id") int id);


}
