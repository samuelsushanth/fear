package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.ExamDAO;
import se.example2.softhouse.core.Exam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/exam")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamResource {
    private ExamDAO examDAO;

    public ExamResource(ExamDAO examDAO) {
        this.examDAO = examDAO;
    }

    @GET
    public List<Exam> list() {
        return examDAO.list();
    }

    @POST
    public Exam create(Exam exam) {
        int id = examDAO.create(exam);
        return examDAO.retrieve(id);
    }

    @GET
    @Path("/{id}")
    public Exam retrieve(@PathParam("id") Integer id) {
        return examDAO.retrieve(id);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Exam exam) {
        Optional<Exam> update = Optional.ofNullable(examDAO.retrieve(id));

        if (update.isPresent()) {
            examDAO.update(id, exam);
            return Response.ok(examDAO.retrieve(id)).build();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        examDAO.delete(id);
        return Response.ok().build();
    }
}
