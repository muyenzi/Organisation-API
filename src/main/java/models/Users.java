package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class Users {
    private   int id;
    private String name;
    private String post;
    private String role;
    private String departname;


    public Users(String name, String post, String role, String departname) {
        this.name = name;
        this.post = post;
        this.role = role;
        this.departname = departname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public String getRole() {
        return role;
    }

    public String getDepartname() {
        return departname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(name, users.name) &&
                Objects.equals(post, users.post) &&
                Objects.equals(role, users.role) &&
                Objects.equals(departname, users.departname);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, post, role, departname);
//    }

    public void create() {
        try(Connection con =DB.sql2o.open()){
        String sql = "INSERT INTO users (name, post, role, departname) VALUES (:name,:post,:role,:departname)";
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("post", this.post)
                    .addParameter("role", this.role)
                    .addParameter("departname" ,this.departname)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void addUserToDepartment(Users users, Departments departments) {

    }


    public static List<Users> AllUsers() {
        String sql="SELECT * FROM users";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(Users.class);
        }
    }


    public void deleteById(int id) {

    }


    public void clearAll() {

    }

    public Users findById(int userId) {
        String sql = "SELECT from users WHERE id=:id"; //raw sql
        try (Connection con =DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

        return null;
    }
}