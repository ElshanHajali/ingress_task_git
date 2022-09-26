package demo;

import demo.repository.StudentRepo;

public class TestStudent {
    public static void main(String[] args) {

        StudentRepo studentRepo = new StudentRepo();

        //Save Student
        System.out.println("Students saved: " + studentRepo.save(new Object()));

        // Fetch all students
        System.out.println("Exist students: " + studentRepo.fetchAll());

        // Update Student
        System.out.println(
                "Updated: "+studentRepo.update("Hikmet", 1)
        );

        System.out.println(
                "Student 1: "+
                        " after update: " + studentRepo.fetchById(1)
        );

        // Delete Student
        System.out.println(
                studentRepo.fetchById(1) +
                " Deleted - " + studentRepo.delete(1)
        );
        
    }
}
