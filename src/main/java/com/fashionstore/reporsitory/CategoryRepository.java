package com.fashionstore.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Add custom query methods if needed
}
