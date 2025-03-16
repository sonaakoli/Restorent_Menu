package com.shonali.restomenu.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menu_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String name;
    
    @Column(length = 1000)
    private String description;
    
    private double price;

}
