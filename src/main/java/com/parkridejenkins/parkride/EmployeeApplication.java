package com.parkridejenkins.parkride;
import com.parkridejenkins.parkride.entity.Employee;
import com.parkridejenkins.parkride.repository.EmployeeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication{


	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public CommandLineRunner sampleData(EmployeeRepository employeeRepository){
		return (args)->{
		employeeRepository.save(new Employee(1L,"Ramesh", "Fadatare", "ramesh@gmail.com"));
        employeeRepository.save(new Employee(2L,"Tom", "Cruise", "tom@gmail.com"));
        employeeRepository.save(new Employee(3L,"John", "Cena", "john@gmail.com"));
        employeeRepository.save(new Employee(4L,"tony", "stark", "stark@gmail.com"));
		};
	}
}
