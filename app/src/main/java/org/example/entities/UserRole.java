package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// function for specifying user's role 

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table()
public class UserRole {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column("role_id")
    private Long roleID;

    private String name;


}
