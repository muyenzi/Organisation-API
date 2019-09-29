package models;

public class Users {
    public  int id;
    public String name;
    public String post;
    public String role;
    public String depName;


    public Users(String name, String post, String role, String depName) {
        this.name = name;
        this.post = post;
        this.role = role;
        this.depName = depName;
    }


}
