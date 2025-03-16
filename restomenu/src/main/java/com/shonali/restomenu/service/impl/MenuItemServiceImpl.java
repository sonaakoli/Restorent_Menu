package com.shonali.restomenu.service.impl;

import com.shonali.restomenu.dto.MenuItemDto;
import com.shonali.restomenu.models.MenuItem;
import com.shonali.restomenu.repositories.MenuItemRepository;
import com.shonali.restomenu.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;


    @Override
    public List<MenuItemDto> getAllMenuItems() {
        List<MenuItem> all = menuItemRepository.findAll();
        List<MenuItemDto> list = all.stream().map((items) -> entityToDto(items)).toList();
        return list;
    }


    @Override
    public MenuItemDto createMenuItem(MenuItemDto menuItemDto) {
    	
        MenuItem menuItem = MenuItem.builder().name(menuItemDto.getName())
        		.id(menuItemDto.getId())
                .price(menuItemDto.getPrice())
                .description(menuItemDto.getDescription())
                .build();
        MenuItem save = menuItemRepository.save(menuItem);
        MenuItemDto menuItemDto1 = entityToDto(save);
        return menuItemDto1;

    }

    @Override
    public MenuItemDto updateMenuItem(Long id, MenuItemDto menuItemDto) {
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item Of Give Item Is Not Found!"));
        menuItem.setName(menuItemDto.getName());
        menuItem.setPrice(menuItemDto.getPrice());
        menuItem.setDescription(menuItemDto.getDescription());
        MenuItem save = menuItemRepository.save(menuItem);
        MenuItemDto menuItemDto1 = entityToDto(save);

        return menuItemDto1;
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);

    }

    private MenuItemDto entityToDto(MenuItem items) {
        MenuItemDto menuitemsdto = MenuItemDto.builder()
                .name(items.getName())
                .price(items.getPrice())
                .description(items.getDescription()).build();
        return menuitemsdto;
    }
    private MenuItem dtoToEntity(MenuItemDto itemsDto) {
        MenuItem menuitems = MenuItem.builder()
                .name(itemsDto.getName())
                .price(itemsDto.getPrice())
                .description(itemsDto.getDescription()).build();
        return menuitems;
    }
}
