package models.dao;
   import models.Departments;
   import models.News;
   import models.Users;
   import org.sql2o.Connection;
   import org.sql2o.Sql2oException;

   import java.util.BitSet;
   import java.util.List;

public interface UsersDao {

    //create
    void create(Users users);
    void addUserToDepartment(Users users, Departments departments);

    //read
    List<Users> AllUsers();
//    List<Departments> getAllDepartmentsForAUser(int id);


    //delete
    void deleteById(int id);
    void clearAll();


}

