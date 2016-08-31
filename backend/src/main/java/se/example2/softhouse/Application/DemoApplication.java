package se.example2.softhouse.Application;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.skife.jdbi.v2.DBI;

import io.dropwizard.setup.Bootstrap;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.Resources.QuestionResource;
import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;

/**
 * Created by sasanksaisujanadapa on 2016-08-16.
 */
public class DemoApplication extends Application<DemoConfiguration>
{

    private static final String API_URL_PATTERN = "/api/*";

    @Override
    public void initialize(Bootstrap<DemoConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }



    public static void main(final String[] args) throws Exception {
        new DemoApplication().run(args);
    }

        @Override
    public void run(DemoConfiguration configuration, final Environment environment) throws SQLException
        {
            configureCrossOriginFilter(configuration, environment);



            final DBIFactory factory = new DBIFactory();
            final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "h2");
            Server myH2adminGUI = org.h2.tools.Server.createWebServer("-webDaemon");
            myH2adminGUI.start();

            QuestionDAO questionDAO = jdbi.onDemand(QuestionDAO.class);
            questionDAO.createQuestionTable();


            QuestionResource questionResource = new QuestionResource(questionDAO);
            environment.jersey().register(questionResource);

            final QuestionDAO dao = jdbi.onDemand(QuestionDAO.class);
            environment.jersey().register(new QuestionResource(dao));

        }




    }



