package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

@Component
public class JpaRepoRunner implements CommandLineRunner {

	@Autowired
	EmpRepository repo;
	@Override
	public void run(String... args) throws Exception {
		

		Optional<Emp> o=repo.findById(105);
		if(o.isPresent()) {
			System.out.println(o.get());
		}else {
			System.out.println("Emp Not Found..");
		}
		
		repo.save(new Emp(107, "James", "Pune", 90000));
		
		
		for(Emp e: repo.findAll()) {
			System.out.println(e);
		}
	}

}
