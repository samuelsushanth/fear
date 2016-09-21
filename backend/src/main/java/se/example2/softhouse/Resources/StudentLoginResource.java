package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.UserRegisterDAO;
import se.example2.softhouse.core.UserDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    public UserDetails registerUser(UserDetails userDetails) {


        userDetails=userRegisterDAO.retrieveoccupation(userDetails);
        userDetails.setPassword("");
        return userDetails;

    }
}