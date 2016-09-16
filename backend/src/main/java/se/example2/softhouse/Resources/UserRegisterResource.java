package se.example2.softhouse.Resources;


import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.example2.softhouse.DAO.UserRegisterDAO;
import se.example2.softhouse.core.UserDetails;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by charan on 9/16/2016.
 */


@Path("/login/register")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRegisterResource {

  private UserRegisterDAO userRegisterDAO;
    public UserRegisterResource(UserRegisterDAO userRegisterDAO){
     this.userRegisterDAO=userRegisterDAO;

    }

    @GET
    public List<UserDetails> list() {
        return userRegisterDAO.list();
    }

    @POST
     public UserDetails registerUser(UserDetails userDetails)
    {
       int userId = userRegisterDAO.create(userDetails);
        return userRegisterDAO.retrieve(userId) ;
    }

}
