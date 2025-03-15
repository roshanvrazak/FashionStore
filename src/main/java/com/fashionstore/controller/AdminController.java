package com.fashionstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.entity.Admin;
import com.fashionstore.jwtConfig.JwtTokenUtil;
import com.fashionstore.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
		// Save the admin with hashed password
		Admin savedAdmin = adminService.saveAdmin(admin);
		return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
	}

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@GetMapping("/generate-token")
	public String generateToken() {
		
		String adminUsername = "admin";

		String token = jwtTokenUtil.generateToken(adminUsername);
		return token;
	}

	@GetMapping("/validate-token")
	public boolean validateToken(@RequestParam String token) {
		return jwtTokenUtil.validateToken(token);
	}


	@GetMapping("/{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Long adminId) {
		Admin admin = adminService.getAdminById(adminId);
		if (admin != null) {
			return ResponseEntity.ok(admin);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/username/{username}")
	public ResponseEntity<Admin> getAdminByUsername(@PathVariable String username) {
		Admin admin = adminService.getAdminByUsername(username);
		if (admin != null) {
			return ResponseEntity.ok(admin);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<Admin> getAdminByEmail(@PathVariable String email) {
		Admin admin = adminService.getAdminByEmail(email);
		if (admin != null) {
			return ResponseEntity.ok(admin);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		List<Admin> admins = adminService.getAllAdmins();
		return ResponseEntity.ok(admins);
	}

	@PostMapping
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		Admin createdAdmin = adminService.createAdmin(admin);
		return ResponseEntity.ok(createdAdmin);
	}

	@PutMapping("/{adminId}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long adminId, @RequestBody Admin admin) {
		admin.setAdminId(adminId);
		Admin updatedAdmin = adminService.updateAdmin(admin);
		return ResponseEntity.ok(updatedAdmin);
	}

	@DeleteMapping("/{adminId}")
	public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminId) {
		adminService.deleteAdmin(adminId);
		return ResponseEntity.noContent().build();
	}
}
