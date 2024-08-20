package dao;

import student.Student;

import java.util.List;
import java.util.Optional;

public interface CRUDStudent {
    Student insert(Student toInsert);

    Optional<Student> findOneById(String id);

    List<Student> findAll();

    Student updateOneById(String id, Student updatedStudent);

    Student deleteById(String id);
}
