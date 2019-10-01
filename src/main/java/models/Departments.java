package models;
import org.sql2o.Connection;

import org.sql2o.Sql2oException;

import java.util.BitSet;
import java.util.List;
import java.util.Objects;

public class Departments {
    private int id;
    private String name;
    private String info;
    private int empnumber;

    public Departments(String name, String info, int empnumber) {
        this.name = name;
        this.info = info;
        this.empnumber = empnumber;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public int getEmpnumber() {
        return empnumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setEmpnumber(int empnumber) {
        this.empnumber = empnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return id == that.id &&
                empnumber == that.empnumber &&
                Objects.equals(name, that.name) &&
                Objects.equals(info, that.info);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, info, empnumber);
//    }

    public void create() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO departments (name, info, empnumber) VALUES (:name, :info, :empnumber)";
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("info", this.info)
                    .addParameter("empnumber", this.empnumber)
                    .executeUpdate()
                    .getKey();
        }
    }


    public static List<Departments> AllDepartments() {
        String sql = "SELECT * FROM departments";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(Departments.class);
        }
    }


    public static Departments findById(int id) {
        try (Connection connect = DB.sql2o.open()) {
            String sql = "SELECT * FROM departments WHERE id= :id;";
            Departments departments = connect.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Departments.class);
            if (departments == null) {
                throw new UnsupportedOperationException("Sorry, this department cannot be found.");
            }
            return departments;
        }
    }


    public static List<Users> getAllUsersForDepartments(int departId) {
        return null;
    }


    public static void deleteById(int id) {
        String sql = "DELETE from departments WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


}

