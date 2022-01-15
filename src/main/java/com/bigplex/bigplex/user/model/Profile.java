package com.bigplex.bigplex.user.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue
    private int userId;
    @Column(unique=true)
    private String userName;
    @Column(unique=true)
    private String contact;
    private String password;
    private String name;
    private String image;
   @OneToMany(targetEntity = Role.class,cascade= CascadeType.ALL, fetch= FetchType.EAGER)
   @JoinColumn()
   private Set<Role> roles;
    private String userStatus;

}
