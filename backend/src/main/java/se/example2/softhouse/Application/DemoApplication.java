package se.example2.softhouse.Application;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.h2.tools.Server;
import org.skife.jdbi.v2.DBI;
import se.example2.softhouse.DAO.*;
import se.example2.softhouse.DAO.QuestionAnswerDAO;
import se.example2.softhouse.Resources.ExamResource;
import se.example2.softhouse.Resources.QuestionResource;
import se.example2.softhouse.core.Question;
import se.example2.softhouse.core.QuestionAnswer;

import java.sql.SQLException;

/**
 * Created by hxs on 2016-08-16.
 */
public class DemoApplication extends Application<DemoConfiguration> {

    @Override
    public void run(DemoConfiguration configuration, Environment environment) throws SQLException {
        Server myH2adminGUI = org.h2.tools.Server.createWebServer("-webDaemon");
        myH2adminGUI.start();
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        final QuestionDAO qdao = jdbi.onDemand(QuestionDAO.class);
        final ChoiceDAO chdao = jdbi.onDemand(ChoiceDAO.class);
        final QuestionAnswerDAO qadao = jdbi.onDemand(QuestionAnswerDAO.class);
        final ExamDAO edao = jdbi.onDemand(ExamDAO.class);
        final ExamQuestionDAO eqdao= jdbi.onDemand(ExamQuestionDAO.class);

        qdao.createQuestionTable();
        chdao.createChoiceTable();
        qadao.createQuestionAnswerTable();   //initial table creations
        edao.createExamTable();
        eqdao.createExamQuestionTable();
        //Question q = new Question();

        //q.setId(2);
        //q.setText("abc");

        //dao.insQues(q);
        //dao.insQues(q);
        environment.jersey().register(new QuestionResource(qdao,chdao,qadao,edao,eqdao)); //registering resources
        environment.jersey().register(new ExamResource());

        //dao.createSomethingTable();

        //dao.insert(2, "Aaron");

        //String name = dao.findNameById(2);


    }

    @Override
    public void initialize(Bootstrap<DemoConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new DemoApplication().run(args);
    }
}




