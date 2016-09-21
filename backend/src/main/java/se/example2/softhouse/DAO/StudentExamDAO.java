package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.*;
import se.example2.softhouse.core.Question;
import se.example2.softhouse.core.StudentExam;

import java.util.List;

/**
 * Created by charan on 9/21/2016.
 */
public interface StudentExamDAO {

    @SqlUpdate("create table if not exists :tableName (id Long auto_increment primary key,userId Long,examId Long,questionId Long,selectedId Long,marks Long)")
    void createStudentExamTable(@Bind("tableName") String tableName);

    @SqlUpdate("delete table :tableName")
    void deleteQuestionTable(@Bind("tableName") String tableName);

    @SqlQuery("select * from :tableName")
    List<StudentExam> list(@Bind("tableName") String tableName);

    @GetGeneratedKeys
    @SqlUpdate("insert into Question (id, userId,examId,questionId,selectedId,marks) values (:id,:userId,:examId,:questionId,:selectedId,:marks)")
    int create(@BindBean StudentExam studentExam);

    @SqlQuery("select * from :tableName where id = :id")
    StudentExam retrieve(@Bind("tableName") String tableName,@Bind("id") int id);


}
