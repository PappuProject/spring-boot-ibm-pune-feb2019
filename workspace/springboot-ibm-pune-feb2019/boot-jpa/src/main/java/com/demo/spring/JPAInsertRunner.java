package com.demo.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

@Component
@Transactional
public class JPAInsertRunner implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;
	@Override
	public void run(String... args) throws Exception {
		
		//em.persist(new Emp(106, "Narendra", "Dlehi", 67000));
		
		Emp e= em.find(Emp.class, 104);
		System.out.println(e);
		
		Query query=em.createQuery("select e from Emp e");
		
		List<Emp> empList=query.getResultList();
		for(Emp e1:empList) {
			System.out.println(e1);
		}

	}

}
