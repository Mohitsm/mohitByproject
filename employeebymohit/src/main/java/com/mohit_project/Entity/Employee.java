package com.mohit_project.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	private String name;
	private String zName;
	private String email;
	private String mobile;
	private String dob;
	private String password;
	private String fname;
	private Double salary;
	private String address;
	private String jod;
	private String gender;
	private String category;
	private String marritalStatus;
	private String status;
	private String site;
	private String work;
	private String zmageName;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 @JsonManagedReference
    private List<Attendance> attendances;


}
