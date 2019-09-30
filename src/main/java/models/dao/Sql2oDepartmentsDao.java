package models.dao;
import models.Departments;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


public class Sql2oDepartmentsDao implements DepartmentsDao{

    private final Sql2o sql2o;
    public Sql2oDepartmentsDao(Sql2o sql2o)
    {
        this.sql2o = sql2o;
    }

    @Override
    public void create(Departments departments) {
        String sql = "INSERT INTO departments (name, info, empNumber) VALUES (:name, :info, :empNumber)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public List<Departments> AllDepartments()
    {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public Departments findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }
    }

    @Override
    public List<Users> getAllUsersForDepartments(int departId) {
        return null;
    }

//    @Override
//    public List<Users> getAllUsersForADepartments(int departId) {
//        return null;
//    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }

    @Override
    public BitSet Department(int departId) {
        return null;
    }
}
