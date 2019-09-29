package models;

import java.util.Objects;

public class Users {
    public  int id;
    public String name;
    public String post;
    public String role;
    public String departName;


    public Users(String name, String post, String role, String departName) {
        this.name = name;
        this.post = post;
        this.role = role;
        this.departName = departName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public String getRole() {
        return role;
    }

    public String getDepartName() {
        return departName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(name, users.name) &&
                Objects.equals(post, users.post) &&
                Objects.equals(role, users.role) &&
                Objects.equals(departName, users.departName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, post, role, departName);
    }
}
