package com.shonali.restomenu.service;

import com.shonali.restomenu.dto.MenuItemDto;
import com.shonali.restomenu.models.MenuItem;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MenuItemService {
    public List<MenuItemDto> getAllMenuItems();
    public MenuItemDto createMenuItem(MenuItemDto menuItemDto);
    public MenuItemDto updateMenuItem(Long id,MenuItemDto menuItemDto);
    public void deleteMenuItem(Long id);

}
