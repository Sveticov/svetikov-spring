package com.svetikov.svetikovspring.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private int isActive;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Users() {
    }
    public Users(Users users) {
        this.username=users.getUsername();
        this.password=users.getPassword();
        this.isActive=users.getIsActive();
        this.roles=users.getRoles();
    }
    public Users(String username, String password, int isActive, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
    }
}
