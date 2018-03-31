# PATTERN MVC

![view](https://i.imgur.com/zd6PArv.png)

## Student  --> Model 
Model represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.
```java
public class Student {

    private String surname;
    private String name;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## StudentController --> Controller
Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate.
```java
    private final Student model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }
```
Also have the setter and getter for the model, and the updater for the view
```java
    public void setStudentName(String name) {    }
    public String getStudentName() {    }
    public void setStudentSurname(String surname) {    }
    public String getStudentSurname() {    }
    public void updateView() {    }
```

## StudentView  --> View
View represents the visualization of the data that model contains.
```java
public void printStudentDetails(String studentName, String studentSurname) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Surname: " + studentSurname);
    }
```
