package models;

public class Departments {
    public   int id;
    public  String departName;
    public  String description;
    public  int    empNumber;

    public Departments(String depName, String description, int empNumber) {
        this.departName = depName;
        this.description = description;
        this.empNumber = empNumber;
    }

    public String getDepartName() {
        return departName;
    }

    public String getDescription() {
        return description;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }
}
