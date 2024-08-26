package com.mohit_project.Controller;

import java.time.LocalDateTime;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.Entity.Hello;
import com.mohit_project.serviceIpml.HelloService;



@RestController
@RequestMapping("/api/Hello")
public class HelloControler {
	
	@Autowired
	private HelloService helloService;
	
	 @GetMapping
	    public List<Hello> getAllHelloRecords() {
	        return helloService.getAllHelloRecords();
	    }

	    @GetMapping("/{id}")
	    public Hello getHelloById(@PathVariable Long id) {
	        return helloService.getHelloById(id);
	    }

	    @PostMapping("/punchIn")
	    public Hello punchIn(@RequestBody Hello Hello) {
	        Hello.setPunchIn(LocalDateTime.now());
	        return helloService.punchIn(Hello);
	    }

	    @PutMapping("/punchOut/{id}")
	    public Hello punchOut(@PathVariable Long id) {
	        return helloService.punchOut(id, LocalDateTime.now());
	    }
	    
	    @GetMapping("/countp")
		public ResponseEntity<Long> countPresentEmployees(){
			return ResponseEntity.ok(this.helloService.getPresentEmployees());

		}

		@GetMapping("/counta")
		public ResponseEntity<Long> countAbsentEmployees(){
			return ResponseEntity.ok(this.helloService.getAbsentEmployees());

		}

		@GetMapping("/countl")
		public ResponseEntity<Long> countLateEmployees(){
			return ResponseEntity.ok(this.helloService.getLateEmployees());

		}

		@GetMapping("/counth")
		public ResponseEntity<Long> countHalfDayEmployees(){
			return ResponseEntity.ok(this.helloService.getHalfDayEmployees());

		}
		@GetMapping("/countpl")
		public ResponseEntity<Long> countPaidLeaveEmployees(){
			return ResponseEntity.ok(this.helloService.getPaidLeaveEmployees());

		}
		

	

}
