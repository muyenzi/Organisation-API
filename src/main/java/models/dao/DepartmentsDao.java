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
    List<Departments> AllDepart();
    Departments findById(int id);

//    void addRestaurantToFoodtype(Restaurant restaurant, Foodtype foodtype);

    List<Users> getAllUsersForDepartments(int departId);

    List<Users> getAllUsersForADepartment(int departId);


    //delete
    void deleteById(int id);
    void clearAll();

    BitSet Department(int departId);
}
