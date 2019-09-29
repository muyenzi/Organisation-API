package models;

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
}
