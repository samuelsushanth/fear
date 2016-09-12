package se.example2.softhouse.DAO;

/**
 * Created by charan on 9/6/2016.
 */
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.Question;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface ChoiceDAO {
    @SqlUpdate("create table if not exists Choice (id Long auto_increment primary key, text varchar(2000),questionId Long)")
    void createChoiceTable();

    @SqlUpdate("delete table Choice")
    void deleteChoiceTable();

    @SqlQuery("select * from Choice")
    List<Choice> list();

    @GetGeneratedKeys
    @SqlUpdate("insert into Choice (id, text, questionId) values (:id, :text, :questionId)")
    int create(@BindBean Choice choice,@Bind("questionId") int questionId);

    @SqlQuery("select * from Choice where id = :id")
    Choice retrieve(@Bind("id") int id);

    @SqlUpdate("delete from Choice where id = :id")
    void delete(@Bind("id") int id);

    @SqlUpdate("update Choice set text = :u.text where id = :id")
    void update(@Bind("id") int id, @BindBean("u") Choice choice);


    @SqlQuery("select * from Choice where questionId = :questionId")
    List<Choice> getChoices(@Bind("questionId") int questionId);

    @SqlUpdate("delete from QuestionAnswer where choiceId = :choiceId")
    void deleteInQuestionChoice(@Bind("choiceId") int choiceId);

    @SqlUpdate("insert into QuestionAnswer (questionId, choiceId) values (:questionId, :choiceId)")
    void createInQuestionChoice(@Bind("questionId") int questionId,@Bind("choiceId") int choiceId);




}
