package models.dao;
    import models.Departments;
    import models.Users;
    import models.Departments;
    import models.News;
    import org.sql2o.Connection;
    import org.sql2o.Sql2o;
    import org.sql2o.Sql2oException;
    import java.util.ArrayList;
    import java.util.List;

public class Sql2oUsersDao implements UsersDao {

    private final Sql2o sql2o;
    public Sql2oUsersDao (Sql2o sql2o)
    {
        this.sql2o = sql2o;
    }

    int id;
    @Override
    public void create(Users users) {
        String sql = "INSERT INTO users (name, post, role, departName) VALUES (:name,:post,:role,:departName)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addUserToDepartment(Users users, Departments departments) {

    }

    @Override
    public List<Users> AllUsers() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }

    public Users findById(int userId) {
        String sql = "SELECT from users WHERE id=:id"; //raw sql
        try (Connection con = sql2o.open()) {

            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

        return null;
    }
}
