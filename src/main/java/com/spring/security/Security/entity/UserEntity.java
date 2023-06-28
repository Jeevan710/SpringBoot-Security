package com.spring.security.Security.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user",
uniqueConstraints= {@UniqueConstraint(columnNames="user_name"),@UniqueConstraint(columnNames="email")})
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="user_name")
	@NotBlank
	@Size(max=20)
	private String userName;
	@Column(name="email")
	@NotBlank
	@Size(max=50)
	private String email;
	@NotBlank
	@Column(name="password")
	@Size(max=120)
	private String password;
	@ManyToMany(cascade=CascadeType.ALL ,fetch=FetchType.EAGER)
	@JoinTable(name="user_roles",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<RoleEntity> roles=new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

}
