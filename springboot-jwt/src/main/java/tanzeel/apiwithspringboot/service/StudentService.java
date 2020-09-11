package tanzeel.apiwithspringboot.service;


import tanzeel.apiwithspringboot.model.Student;
import tanzeel.apiwithspringboot.repository.StudentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public  StudentService(final StudentRepository studentRepository){this.studentRepository = studentRepository;}

    @Transactional(readOnly = true)
    public List<Student> getAllStudents(final int count){
        return this.studentRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Student> getStudent(final Long id){return this.studentRepository.findById(id);}
}
