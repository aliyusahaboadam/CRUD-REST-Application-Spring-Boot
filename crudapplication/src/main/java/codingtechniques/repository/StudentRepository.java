package codingtechniques.repository;

import org.springframework.data.repository.CrudRepository;

import codingtechniques.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
