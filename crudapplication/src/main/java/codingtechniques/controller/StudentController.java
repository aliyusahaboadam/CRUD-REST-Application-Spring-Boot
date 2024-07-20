package codingtechniques.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import codingtechniques.model.Student;
import codingtechniques.service.StudentService;

@RestController
public class StudentController {
	
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	// CREATE
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		studentService.saveStudent(student);
		return ResponseEntity.ok(student);
	}
	
   // READ
	
	@GetMapping("/students")
	public ResponseEntity<Iterable<Student>> getStudents (){
		Iterable<Student> students = studentService.getStudents();
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.header("semester", "2nd")
				.header("year", "2024")
				.body(students);
	}
	
	// UPDATE
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(
			@PathVariable Long id, @RequestBody Student newStudentDetails){
		Optional<Student> studentDetails = studentService.getStudentById(id);
		Student student = studentDetails.get();
		
		student.setName(newStudentDetails.getName());
		student.setDepartment(newStudentDetails.getDepartment());
		student.setLevel(newStudentDetails.getLevel());
		
		studentService.saveStudent(student);
		
		return ResponseEntity.ok(student);
	} 
	
	
	// Delete
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStduent(@PathVariable Long id){
		studentService.deleteStudentById(id);
		return ResponseEntity.ok("Student with the " + id + " deleted");
	}
	
	
	
	
}
