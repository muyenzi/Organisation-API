package models;

import javax.print.DocFlavor;

public class News {
    public  int id;
    public String topic ;
    public String news;
    public int departId;

    public News(String topic, String news, int departId) {
        this.topic = topic;
        this.news = news;
        this.departId = departId;
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
}
