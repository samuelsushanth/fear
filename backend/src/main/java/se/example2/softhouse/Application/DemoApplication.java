package se.example2.softhouse.Application;


import org.skife.jdbi.v2.DBI;


import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import se.example2.softhouse.DAO.UsersDAO;

/**
 * Created by hxs on 2016-08-16.
 */
public class DemoApplication extends Application<DemoConfiguration>
{
    @Override
    public void run(DemoConfiguration config, Environment environment)
    {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "h2sql");
        final UsersDAO dao = jdbi.onDemand(UsersDAO.class);
        environment.jersey().register(new UserResource(dao));
    }

}


