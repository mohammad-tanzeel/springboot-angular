package tanzeel.apiwithspringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import tanzeel.apiwithspringboot.model.Blog;
import tanzeel.apiwithspringboot.model.Student;
import tanzeel.apiwithspringboot.repository.StudentRepository;


//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@Operation(summary = "Find all Students", description = "All students", tags = { "students" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Student.class)))) })
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String name) {
		try {
			List<Student> students = new ArrayList<>();

			if (name == null)
				studentRepository.findAll().forEach(students::add);
			else
				studentRepository.findByNameContaining(name).forEach(students::add);

			if (students.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		try {
			Student _student = studentRepository.save(new Student(student.getName(), student.getStandard(), student.getAge(), student.isPublished()));
//					.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false, tutorial.getAuthor()));
			return new ResponseEntity<>(_student, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
