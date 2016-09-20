package se.example2.softhouse.DAO;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.core.Exam;
import se.example2.softhouse.core.UserDetails;

import java.util.List;

/**
 * Created by charan on 9/16/2016.
 */
@RegisterMapperFactory(BeanMapperFactory.class)

public interface UserRegisterDAO {
    @SqlUpdate("create table if not exists User (id Long auto_increment , username varchar(2000) primary key,emailaddress varchar(20),password varchar(8),occupation varchar(20))")
    void createUserTable();

    @SqlUpdate("delete table User")
    void deleteUserTable();

    @SqlQuery("select * from User")
    List<UserDetails> list();

    @GetGeneratedKeys
    @SqlUpdate("insert into User (id, username, emailaddress, password, occupation) values (:id,:userName,:emailAddress,:password,:occupation)")
    int create(@BindBean UserDetails userDetails);

    @SqlQuery("select * from User where id = :id")
    UserDetails retrieve(@Bind("id") int id);

    @SqlQuery("select * from User where (username)= (:userName) and (password)=(:password)")
    UserDetails retrieveoccupation(@BindBean UserDetails userDetails);

    @SqlQuery("select * from User where userName = :userName")
    UserDetails  retrieveByUserName(@Bind("userName") String userName );


}
