package net.javaguides.springboot.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.Student;

@Repository
public class StudentRepository {
	public List<Student> studentList(){
		return Arrays.asList(
				new Student(1,"Tom",25),
				new Student(2,"John",18),
				new Student(3,"Ryan",22)
				);
	}
}
