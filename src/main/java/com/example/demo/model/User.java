package com.example.demo.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
//@Table(name = "MyUsers")
public class User {
	@Id
	@GeneratedValue
	Integer id;
	String name;
	String address;
	Integer age;
	Long phoneNo;
	String email;
	@ElementCollection
	List<String> stuLang;
	
}
