package models.dao;
        import models.Departments;
        import models.News;
        import models.Users;
        import java.util.BitSet;
        import java.util.List;

    public interface NewsDao {

        //create
        void create(News news);

        //read
        List<News> AllNews();

        List<News> getAllNewsForDepartments(int departId);


        //delete
        void deleteById(int id);

        void clearAll();
    }


