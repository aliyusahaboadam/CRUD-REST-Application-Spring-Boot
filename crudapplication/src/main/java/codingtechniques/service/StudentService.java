package codingtechniques.service;


import java.util.Optional;

import codingtechniques.model.Student;

public interface StudentService {
	
	void saveStudent(Student student);
	Iterable<Student> getStudents();
	Optional<Student> getStudentById(Long id);
	void deleteStudentById(Long id);
	

}
