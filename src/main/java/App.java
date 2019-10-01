
import exceptions.ApiException;
import models.Departments;
import models.News;
import models.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.post;

public class App {

    public static void main(String[] args) {


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/departments/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "depart-form.hbs");
        }, new HandlebarsTemplateEngine());

//        new department display and save in db
        post("/departments/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name=request.queryParams("name");
            String info=request.queryParams("info");
            int empnumber=Integer.parseInt(request.queryParams("empnumber"));
            System.out.println(name);
            System.out.println(info);
            Departments newDepartments= new Departments(name,info,empnumber);
            newDepartments.create();
            model.put("name",newDepartments.getName());
            model.put("info",newDepartments.getInfo());
            model.put("empNumber",newDepartments.getEmpnumber());
            model.put("Departments",newDepartments);
            return new ModelAndView(model, "departments.hbs");
        }, new HandlebarsTemplateEngine());

        get("/departments", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Departments> departments = Departments.AllDepartments();
            model.put("departments", departments);
            return new ModelAndView(model, "departments.hbs");
        }, new HandlebarsTemplateEngine());

          //User

        get("/users/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "user-form.hbs");
        }, new HandlebarsTemplateEngine());

        //        new department display and save in db
        post("/users/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name=request.queryParams("name");
            String post=request.queryParams("post");
            String role=request.queryParams("role");
            String departname=request.queryParams("departname");
            Users newUsers= new Users(name,post,role,departname);
            newUsers.create();
            model.put("name",newUsers.getName());
            model.put("post",newUsers.getPost());
            model.put("role",newUsers.getRole());
            model.put("departname",newUsers.getDepartname());
            model.put("Users",newUsers);
            return new ModelAndView(model, "users.hbs");
        }, new HandlebarsTemplateEngine());

        get("/users", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Users> users =Users.AllUsers();
            model.put("users", users);
            return new ModelAndView(model, "users.hbs");
        }, new HandlebarsTemplateEngine());

       // news

        get("/news/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "news-form.hbs");
        }, new HandlebarsTemplateEngine());

        //        new department display and save in db
        post("/news/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String topic=request.queryParams("topic");
            String news=request.queryParams("news");
            News newNews= new News(topic,news);
            newNews.create();
            model.put("topic",newNews.getTopic());
            model.put("news",newNews.getNews());
            model.put("News",newNews);
            return new ModelAndView(model, "news.hbs");
        }, new HandlebarsTemplateEngine());

        get("/news", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<News> news =News.AllNews();
            model.put("news", news);
            return new ModelAndView(model, "news.hbs");
        }, new HandlebarsTemplateEngine());


    }
}


