package com.ojas.employee.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@ToString
@Entity

public class Roles {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer roleid;
	private String roleName;

}
