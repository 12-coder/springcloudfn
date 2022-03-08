package net.javaguides.springboot;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.repository.StudentRepository;

@SpringBootApplication
public class SpringCloudAwsLambdaApplication {

	
	@Autowired
	private StudentRepository repo;
	
	@Bean
	public Supplier<List<Student>> students(){
		return ()->repo.studentList();
	}
	
	@Bean
	public Function<String,List<Student>> findByName(){
		
		return (input)->repo.studentList().stream().filter(student->student.getName().equals(input)).collect(Collectors.toList());
	}
	
	@Bean
	public MyConsumer myConsumerBean() {
		return new MyConsumer();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAwsLambdaApplication.class, args);
	}

}
