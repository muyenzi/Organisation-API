package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Objects;

public class News {
    private int id;
    private String topic;
    private String news;
    private int departId;
    private String departname;

    public News(String departname , String topic, String news) {
        this.topic = topic;
        this.news = news;
        this.departname=departname;
        this.departId = departId;
    }

    public String getDepartname() {
        return departname;
    }

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getNews() {
        return news;
    }

    public int getDepartId() {
        return departId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news1 = (News) o;
        return id == news1.id &&
                departId == news1.departId &&
                Objects.equals(topic, news1.topic) &&
                Objects.equals(news, news1.news) &&
                Objects.equals(departname, news1.departname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, news, departId, departname);
    }

    public void create() {

        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO news (departname, topic, news ) VALUES (:departname,:topic,:news)";
            int id = (int) con.createQuery(sql, true)
                    .addParameter("departname" , this.departname)
                    .addParameter("topic", this.topic)
                    .addParameter("news", this.news)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static  List<News> AllNews() {
        String sql = "SELECT * FROM news";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(News.class);
        }
    }

    public List<News> getAllNewsForDepartments(int departId) {
        return null;
    }

    public List<News> getAllNewsForDepartments() {
        return null;
    }

    public static void deleteById(int id) {
        String sql = "DELETE from news WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
