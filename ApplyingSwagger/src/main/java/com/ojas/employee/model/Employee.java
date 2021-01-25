package com.ojas.employee.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Float salary;
	private String department;
	private String password;
	private Boolean isEnabled;
	
	@ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	 @JoinTable(name = "Employee_Role", 
     joinColumns = @JoinColumn(name = "id"), 
     inverseJoinColumns = @JoinColumn(name = "roleid"))
	private Set<Roles>roles;
}
