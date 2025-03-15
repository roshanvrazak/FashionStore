package com.fashionstore.service;

import java.util.List;

import com.fashionstore.entity.Admin;

public interface AdminService {

	Admin getAdminById(Long adminId);

	Admin getAdminByUsername(String username);

	Admin getAdminByEmail(String email);

	List<Admin> getAllAdmins();

	Admin createAdmin(Admin admin);

	Admin updateAdmin(Admin admin);

	void deleteAdmin(Long adminId);

	Admin saveAdmin(Admin admin);

	boolean authenticateAdmin(String username, String password);
}
