package com.shonali.restomenu.controllers;

import com.shonali.restomenu.dto.MenuItemDto;
import com.shonali.restomenu.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MenuItemDto>> getAllMenuItems(){
        return ResponseEntity.ok(menuItemService.getAllMenuItems());
     }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MenuItemDto> updateMenuItem(@RequestBody MenuItemDto menuItemDto){
        return ResponseEntity.ok(menuItemService.createMenuItem(menuItemDto));
    }
     @PutMapping("/{id}")
     @ResponseStatus(HttpStatus.ACCEPTED)
     public ResponseEntity<MenuItemDto> updateMenuItem(@PathVariable Long id,@RequestBody MenuItemDto menuItemDto){
       return ResponseEntity.ok(menuItemService.updateMenuItem(id,menuItemDto));
     }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateMenuItem(@PathVariable Long id){
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.ok("deleted Sucessfully!");
    }
}

