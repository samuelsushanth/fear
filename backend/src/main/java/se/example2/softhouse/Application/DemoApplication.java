package se.example2.softhouse.Application;

import java.sql.SQLException;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.h2.tools.Server;
import org.skife.jdbi.v2.DBI;

import com.google.common.base.Joiner;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.Resources.QuestionResource;
import se.example2.softhouse.Resources.HelloWorldResource;
/**
 * Created by sasanksaisujanadapa on 2016-08-16.
 */
public class DemoApplication extends Application<DemoConfiguration>
{

    private static final String API_URL_PATTERN = "/api/*";


    public static void main(final String[] args) throws Exception {
        new DemoApplication().run(args);
    }

        @Override
    public void run(DemoConfiguration configuration, final Environment environment) throws SQLException
        {
            configureCrossOriginFilter(configuration, environment);

            HelloWorldResource helloWorldResource = new HelloWorldResource(configuration.getTemplate(),
                    configuration.getDefaultName());
            environment.jersey().register(helloWorldResource);

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

    private void configureCrossOriginFilter(DemoConfiguration configuration, Environment environment) {
        String[] allowedOrigins = configuration.getAllowedOrigins();
        if (allowedOrigins == null || allowedOrigins.length == 0) {
            return;
        }

        Dynamic filter = environment.servlets().addFilter("CrossOriginFilter", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, API_URL_PATTERN);
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, Joiner.on(',').join(allowedOrigins));
        filter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM,
                "X-Requested-With,Content-Type,Accept,Accept-Language,Origin,Authorization");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,PUT,DELETE");
        filter.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");
    }




    }
}


