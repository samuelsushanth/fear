package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Question;

import java.awt.*;
import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface ChoiceDAO extends QuestionDAO {
    @SqlUpdate("create table if not exists CHOICES (id int auto_increment primary key, question_id varchar(80), choice varchar(80))")
    void createChoiceTable();

    @GetGeneratedKeys
    @SqlUpdate("insert into CHOICES (id, question_id, choice) values (:id, :question_id, :choice)")
    int create(@BindBean Choice choice);

    @SqlUpdate("update CHOICES set question_id = :u.question_id, choice = :u.choice where id = :id")
    void update(@Bind("id") int id, @BindBean("u") Choice choice);

    @SqlQuery("select * from CHOICES where id = :id")
    Question retrieve(@Bind("id") int id);

    @SqlQuery("select * from CHOICES")
    List<Question> list();

    @SqlUpdate("delete from CHOICES where id = :it")
    void delete(@Bind int id);

}
