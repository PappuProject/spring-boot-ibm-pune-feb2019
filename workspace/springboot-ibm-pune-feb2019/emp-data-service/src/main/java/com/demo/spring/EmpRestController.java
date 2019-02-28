package com.demo.spring;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {

	@Autowired
	EmpRepository repo;
	
	//@RequestMapping(path="/emp/find/{id}",method=RequestMethod.GET,	produces=MediaType.APPLICATION_JSON_VALUE)
	
	@GetMapping(path="/emp/find/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findEmp(@PathVariable("id")int id,ServletRequest req) {
		System.out.println("Response from : "+req.getLocalAddr()+":"+req.getLocalPort());
		Optional<Emp> o=repo.findById(id);
				if(o.isPresent()) {
					return ResponseEntity.ok(o.get());
				}else {
					return ResponseEntity.notFound().build();
				}
	}
	@PostMapping(path="/emp/save",produces=MediaType.TEXT_PLAIN_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Emp e) {
		
		if(repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Emp Exists in Database");
		}else {
			repo.save(e);
			return ResponseEntity.ok("Emp Saved");
		}
	}
	@GetMapping(path="/emp/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> getAll(){
		return ResponseEntity.ok(repo.findAll());
	}
	
}
