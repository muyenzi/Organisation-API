package models.dao;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{
    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o)
    {
        this.sql2o = sql2o;
    }

    @Override
    public void create(News news) {
        String sql = "INSERT INTO news (topic, news, departId) VALUES (:topic,:news,:departId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<News> AllNews() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public List<News> getAllNewsForDepartments(int departId) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
