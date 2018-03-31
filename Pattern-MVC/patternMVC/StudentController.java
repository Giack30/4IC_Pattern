/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternMVC;

/**
 *
 * @author [Group Project - BOTUSHAROV - CAPPELLATO - INGALISO - ROSATO ]
 */
public class StudentController {

    private final Student model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentSurname(String surname) {
        model.setSurname(surname);
    }

    public String getStudentSurname() {
        return model.getSurname();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getSurname());
    }
}
