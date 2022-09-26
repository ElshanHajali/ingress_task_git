package demo.controller;

import demo.dto.Student;
import demo.service.IParentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final IParentService studentService;

    public StudentController(
            @Qualifier(value = "studentService") IParentService studentService
    ) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Object> getStudents() {
        return studentService.fetchAll();
    }

    @GetMapping("id/{id}")
    public  Object getStudentById(@PathVariable long id) {
        return studentService.fetchById(id);
    }
}
