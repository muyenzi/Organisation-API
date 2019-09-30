package models.dao;
        import models.Departments;
        import models.News;
        import models.Users;
        import java.util.BitSet;
        import java.util.List;

public interface DepartmentsDao {

    //create
    void create(Departments departments);
//    void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype);

    //read
    List<Departments> AllDepartments();
    Departments findById(int id);


    List<Users> getAllUsersForDepartments(int departId);



    //delete
    void deleteById(int id);
    void clearAll();

    BitSet Department(int departId);
}
