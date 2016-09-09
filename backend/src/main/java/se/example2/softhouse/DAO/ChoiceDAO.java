package se.example2.softhouse.DAO;

/**
 * Created by charan on 9/6/2016.
 */
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.Question;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface ChoiceDAO {
    @SqlUpdate("create table if not exists CHOICE (id int auto_increment primary key, text varchar(2000),questionId int)")
    void createChoiceTable();

    @SqlUpdate("delete table CHOICE")
    void deleteChoiceTable();

    @SqlQuery("select * from CHOICE")
    List<Choice> list();

    @SqlUpdate("insert into CHOICE (text,questionId) values (:text,:questionId)")
    Long insChoice(@BindBean Choice choice);

    @SqlUpdate("delete from CHOICE where (id)=(:id)")
    void delChoice(@BindBean Choice choice);

    @SqlUpdate("update CHOICE set (text,questionId)=(:text,:questionId) where (id)=(:id)")
    void updChoice(@BindBean Choice choice);

    @SqlQuery("select (id) from CHOICE where (text)=(:text)")
    Long getChoiceId(@BindBean Choice choice);

    @SqlQuery("select * from CHOICE where (questionId) = (:questionId)")
    List<Choice> getChoicesForQuestion(@BindBean Choice choice);
}
