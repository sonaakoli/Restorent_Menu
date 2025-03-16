package com.shonali.restomenu.repositories;

import com.shonali.restomenu.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
