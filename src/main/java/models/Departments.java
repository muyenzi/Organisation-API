package models;

import java.util.Objects;

public class Departments {
    public   int id;
    public  String name;
    public  String info;
    public  int    empNumber;

    public Departments(String name, String info, int empNumber) {
        this.name = name;
        this.info = info;
        this.empNumber = empNumber;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return id == that.id &&
                empNumber == that.empNumber &&
                Objects.equals(name, that.name) &&
                Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, info, empNumber);
    }
}
