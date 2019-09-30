
import com.google.gson.Gson;
import exceptions.ApiException;
import models.Users;
import models.dao.Sql2oDepartmentsDao;
import models.dao.Sql2oUsersDao;
import models.dao.Sql2oNewsDao;
import models.Departments;
import org.eclipse.jetty.server.Authentication;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oDepartmentsDao departmentsDao;
        Sql2oUsersDao usersDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();

             // post a  department
        post("/departments/new", "application/json", (req, res) -> {
            Departments departments = gson.fromJson(req.body(), Departments.class);
            departmentsDao.create(departments);
            res.status(201);
            res.type("application/json");
            return gson.toJson(departments);
        });

        //get all departments
        get("/departments", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(departmentsDao.AllDepartments());//send it back to be displayed
        });

        // find a department
        get("/departments/:id", "application/json", (req, res) -> {
            int departId = Integer.parseInt(req.params("id"));
            Departments departmentsToFind = departmentsDao.findById(departId);
            if (departmentsToFind == null){
                throw new ApiException(404, String.format("department with the id: \"%s\" doesn't exists", req.params("id")));
            }
            return gson.toJson(departmentsToFind);
        });

        // add user
        post("/users/new", "application/json", (req, res) -> {
            Users users = gson.fromJson(req.body(), Users.class);
            usersDao.create(users);
            res.status(201);
            res.type("application/json");
            return gson.toJson(users);
        });

        //get all users
        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(usersDao.AllUsers());//send it back to be displayed
        });

        // find a user
        get("/users/:id", "application/json", (req, res) -> {
            int userId = Integer.parseInt(req.params("id"));
            Users usersToFind = usersDao.findById(userId);
            if (usersToFind == null){
                throw new ApiException(404, String.format("the user with the id: \"%s\" doesn't exists", req.params("id")));
            }
            return gson.toJson(usersToFind);
        });
    }
}