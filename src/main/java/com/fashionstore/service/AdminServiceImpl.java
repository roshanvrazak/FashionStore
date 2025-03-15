package com.fashionstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionstore.entity.Admin;
import com.fashionstore.jwtConfig.PasswordHasher;
import com.fashionstore.reporsitory.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin getAdminById(Long adminId) {
		return adminRepository.findById(adminId).orElse(null);
	}

	@Override
	public Admin getAdminByUsername(String username) {
		return adminRepository.findByUsername(username);
	}

	@Override
	public Admin getAdminByEmail(String email) {
		return adminRepository.findByEmail(email);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public void deleteAdmin(Long adminId) {
		adminRepository.deleteById(adminId);
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		// Hash the admin's password before saving it
		String hashedPassword = PasswordHasher.hashPassword(admin.getPassword());
		admin.setPassword(hashedPassword);
		return adminRepository.save(admin);
	}

	@Override
	public boolean authenticateAdmin(String username, String password) {
		Admin admin = getAdminByUsername(username);
		if (admin == null) {
			return false; // Admin not found
		}
		// Compare the stored hashed password with the input hashed password
		String storedPasswordHash = admin.getPassword();
		String inputPasswordHash = PasswordHasher.hashPassword(password);

		return storedPasswordHash.equals(inputPasswordHash);

	}
}
