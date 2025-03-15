package com.fashionstore.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fashionstore.entity.Admin;
import com.fashionstore.entity.Customer;
import com.fashionstore.reporsitory.AdminRepository;
import com.fashionstore.reporsitory.CustomerRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public JwtUserDetailsService(CustomerRepository customerRepository, AdminRepository adminRepository) {
        this.customerRepository = customerRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Try to load a Customer by username
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null) {
            // You can customize the roles and authorities based on your application's logic
            return User.withUsername(customer.getUsername())
                    .password(customer.getPassword())
                    .roles("CUSTOMER")
                    .build();
        }

        // Try to load an Admin by username
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            // You can customize the roles and authorities based on your application's logic
            return User.withUsername(admin.getUsername())
                    .password(admin.getPassword())
                    .roles("ADMIN")
                    .build();
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
