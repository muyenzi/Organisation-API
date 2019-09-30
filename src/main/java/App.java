import static spark.Spark.*;

import com.google.gson.Gson;
import exceptions.ApiException;
import models.dao.Sql2oDepartmentsDao;
import models.dao.Sql2oNewsDao;
import models.dao.Sql2oUsersDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.Departments;
import models.Users;
import models.News;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class App {

    public static void main(String[] args) {
        Sql2oDepartmentsDao departmentsDao;
        Sql2oUsersDao usersDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");

    }
}
