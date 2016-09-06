package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Question;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionDAO {



        @SqlUpdate("create table if not exists QUESTIONS (id int auto_increment primary key, question varchar(1000), ca int)")
        void createQuestionTable();

        @SqlUpdate("insert into QUESTIONS (question,ca) values (:question, :CA)")
        void insQues(@BindBean Question question);

         @SqlQuery("select * from QUESTIONS")
         List<Question> list();

}
