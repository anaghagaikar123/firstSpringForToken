package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(value = "/spring")
public class SpringController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/home")
	public void home() {
		System.out.println("at home first url....");

	}

	@PutMapping(value = "/add")
	public void add(@RequestBody Student std) {
		System.out.println("at add" + std.getName());
		studentService.save(std);
	}

	@GetMapping(value = "/getToken/{name}/{pwd}")
	public String getToken(@PathVariable String name, @PathVariable String pwd) {
		System.out.println("in controller.......");
		String token = "";

		if (name != null && pwd != null) {
			token = Jwts.builder().setSubject(name + " " + pwd).claim("role", "student").setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS512, "secretKey").compact();
		}
		return token;
	}
}
