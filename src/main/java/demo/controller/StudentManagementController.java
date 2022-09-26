package demo.controller;

import demo.dto.Student;
import demo.service.IParentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/management/student")
public class StudentManagementController {
    private final IParentService studentService;

    public StudentManagementController(
            @Qualifier(value = "studentService") IParentService studentService
    ) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Object obj) {
        if(studentService.save(obj)) {
            return new ResponseEntity<>((Student) obj, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/name/{name}/id/{id}")
    public ResponseEntity<Student> update(
            @PathVariable String name, @PathVariable long id
    ) {
        if(studentService.update(name, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Student> delete(@PathVariable long id) {
        if(studentService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
