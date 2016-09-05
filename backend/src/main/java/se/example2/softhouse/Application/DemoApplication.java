package se.example2.softhouse.Application;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.h2.tools.Server;
import org.skife.jdbi.v2.DBI;
import se.example2.softhouse.DAO.ChoiceDAO;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.Resources.ChoiceResource;
import se.example2.softhouse.Resources.QuestionResource;

import java.sql.SQLException;

/**
 * Created by hxs on 2016-08-16.
 */
public class DemoApplication extends Application<DemoConfiguration> {

    @Override
    public void run(DemoConfiguration configuration, Environment environment) throws SQLException {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        Server myH2adminGUI = org.h2.tools.Server.createWebServer("-webDaemon");
        myH2adminGUI.start();


        final QuestionDAO questiondao = jdbi.onDemand(QuestionDAO.class);
        questiondao.createQuestionTable();
        environment.jersey().register(new QuestionResource(questiondao));

        final ChoiceDAO choicedao = jdbi.onDemand(ChoiceDAO.class);
        choicedao.createChoiceTable();
        environment.jersey().register(new ChoiceResource(choicedao));


    }

    @Override
    public void initialize(Bootstrap<DemoConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new DemoApplication().run(args);
    }
}




