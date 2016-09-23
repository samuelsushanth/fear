package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.UserRegisterDAO;
import se.example2.softhouse.core.Choice;
import se.example2.softhouse.core.UserDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * Created by charan on 9/21/2016.
 */
@Path("/student/takeatest/{examId}/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class StudentLoginResource {

    private UserRegisterDAO userRegisterDAO;
    public StudentLoginResource(UserRegisterDAO userRegisterDAO){
        this.userRegisterDAO=userRegisterDAO;

    }

    @GET
    public void list() {

    }

    @POST
    public Response registerUser(UserDetails userDetails) {

      Optional<UserDetails> update = Optional.ofNullable(userRegisterDAO.retrieveoccupation(userDetails));

        if (update.isPresent()) {
            userDetails=userRegisterDAO.retrieveoccupation(userDetails);
            userDetails.setPassword("");
            return Response.ok(userDetails).build();
        } else {
            throw new NotFoundException();
        }




    }
}
