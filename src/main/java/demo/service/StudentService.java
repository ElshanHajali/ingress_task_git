package demo.service;

import demo.utils.ICRUD;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IParentService {
    private final ICRUD studentRepository;

    public StudentService(@Qualifier(value = "studentRepo") ICRUD studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Object> fetchAll() {
        return studentRepository.fetchAll();
    }

    @Override
    public Object fetchById(long id) {
        return studentRepository.fetchById(id);
    }

    @Override
    public boolean save(Object obj) {
        return studentRepository.save(obj);
    }

    @Override
    public boolean update(String name, long id) {
        return studentRepository.update(name, id);
    }

    @Override
    public boolean delete(long id) {
        return studentRepository.delete(id);
    }

}
