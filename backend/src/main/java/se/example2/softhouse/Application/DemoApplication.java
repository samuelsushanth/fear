package se.example2.softhouse.Application;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import se.example2.softhouse.Application.Note.NoteResource;
import se.example2.softhouse.Application.Note.addquestionDAO;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.Resources.QuestionResource;
import se.example2.softhouse.core.Question;

/**
 * Created by hxs on 2016-08-16.
 */
public class DemoApplication extends Application<DemoConfiguration> {

    @Override
    public void run(DemoConfiguration configuration, Environment environment) throws Exception {
        //environment.jersey().register(new NoteResource(configuration.getDefaultNote()));

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        final QuestionDAO dao = jdbi.onDemand(QuestionDAO.class);
        //final addquestionDAO dao = jdbi.onDemand(addquestionDAO.class);

        //dao.createTable();
        environment.jersey().register(new QuestionResource(configuration.getDefaultQuestion(),dao));
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




