package com.fashionstore.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@NotBlank
	@Size(max = 50)
	private String username;

	@NotBlank
	@Email
	@Size(max = 100)
	private String email;


	@NotBlank
	private String password;

	@Size(max = 50)
	private String name;


	@Size(max = 255)
	private String address;

	@Size(max = 20)
	private String phoneNumber;
	
	@NotBlank
	private String role = "USER";


}
