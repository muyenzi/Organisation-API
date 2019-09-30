package models.dao;
   import models.Departments;
   import models.News;
   import models.Users;
   import java.util.BitSet;
   import java.util.List;

public interface UsersDao {

    //create
    void create(Users user);
    void addUserToDepartment(Users users, Departments departments);

    //read
    List<Users> AllUsers();
//    List<Departments> getAllDepartmentsForAUser(int id);


    //delete
    void deleteById(int id);
    void clearAll();
}

