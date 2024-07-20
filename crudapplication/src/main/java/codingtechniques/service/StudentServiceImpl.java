package codingtechniques.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codingtechniques.exception.StudentNotFoundException;
import codingtechniques.model.Student;
import codingtechniques.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);	
	}

	@Override
	public Iterable<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent()) {
			throw new StudentNotFoundException();
		}
		return student;
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}



	
}
