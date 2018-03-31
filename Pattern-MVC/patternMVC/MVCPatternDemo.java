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
public class MVCPatternDemo {

    public static void main(String[] args) {

        //Fetch student record based on the database
        Student model = retriveStudentFromDatabase();

        //Create a view : to write student details on console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //update model data     -->         Edit a object with a controller
        controller.setStudentName("Luigi");
        controller.setStudentSurname("Verdi");

        controller.updateView();
    }

    /**
     *
     * Class to extract the info from the Database
     *
     */
    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Mario");
        student.setSurname("Rossi");
        return student;
    }
}
