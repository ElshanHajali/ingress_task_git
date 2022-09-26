package demo.repository;

import demo.dto.Student;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentRepo implements IParentRepository {
    private final static List<Student> students = new ArrayList<>();;

    @Override
    public List<Object> fetchAll() {
        return Collections.singletonList(students);
    }

    @Override
    public Object fetchById(long id) {
        return students.get((int)id - 1);
    }

    @Override
    public boolean save(Object obj) {
        obj = new Object();
        students.add(new Student(1, "Rasul"));
        students.add(new Student(2, "Emil"));
        students.add(new Student(3, "Kamil"));
        students.add(new Student(4, "Malik"));
        return true;
    }

    @Override
    public boolean update(String name, long id) {
        Student existStudent = students.get((int)id - 1);
        if (
                Strings.isNotEmpty(name) &&
                !name.equalsIgnoreCase("") &&
                !name.equals(existStudent.getName())
        ) {
            existStudent.setName(name);
            return true;
        } else return false;
    }

    @Override
    public boolean delete(long id) {
        if (students.get((int) id - 1) != null) {
            students.remove((int)id - 1);
            return true;
        } else return false;
    }

}
