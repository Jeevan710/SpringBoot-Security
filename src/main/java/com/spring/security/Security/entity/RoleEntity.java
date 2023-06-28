package com.spring.security.Security.entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(name="role",length=20)
	private Erole role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Erole getRole() {
		return role;
	}
	public void setRole(Erole role) {
		this.role = role;
	}
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
