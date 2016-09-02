package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Question;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionDAO {



        @SqlUpdate("create table if not exists QUESTIONS (id int auto_increment primary key, question varchar(1000), choice varchar(80), ca varchar(80))")
        void createQuestionTable();

        @SqlUpdate("insert into QUESTIONS (question, choice, ca) values (:question, :choice, :ca)")
        void insQues(@BindBean Question question);


}
