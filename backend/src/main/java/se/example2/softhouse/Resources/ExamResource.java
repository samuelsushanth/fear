package se.example2.softhouse.Resources;

import se.example2.softhouse.DAO.ExamDAO;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.core.Exam;
import se.example2.softhouse.core.Question;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/exam")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamResource {
    private ExamDAO examdao;

    public ExamResource(ExamDAO examDAO) {
        this.examdao = examDAO;
    }


    @GET
    public List<Exam> list() {
        return examdao.list();
    }

    @GET
    @Path("/{id}")
    public Exam retrieve(@PathParam("id") Integer id) {
        return examdao.retrieve(id);
    }

    @POST
    public Exam create(Exam exam) {
        int id = examdao.create(exam);
        return examdao.retrieve(id);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Exam exam) {
        Optional<Exam> update = Optional.ofNullable(examdao.retrieve(id));

        if (update.isPresent()) {
            examdao.update(id, exam);
            return Response.ok(examdao.retrieve(id)).build();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        examdao.delete(id);
        return Response.ok().build();
    }
}
