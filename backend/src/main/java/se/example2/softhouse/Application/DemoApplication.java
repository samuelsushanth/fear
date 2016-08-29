package se.example2.softhouse.Application;


import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import se.example2.softhouse.DAO.QuestionDAO;
import se.example2.softhouse.Resources.QuestionResource;

/**
 * Created by sasanksaisujanadapa on 2016-08-16.
 */
public class DemoApplication extends Application<DemoConfiguration>
{
    @Override
    public void run(DemoConfiguration config, Environment environment)
    {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "h2sql");
        final QuestionDAO dao = jdbi.onDemand(QuestionDAO.class);
        environment.jersey().register(new QuestionResource(dao));
    }

}


