package com.svetikov.svetikovspring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String role;


    public Role() {
    }

    public Role(Integer roleId,String role) {
        this.roleId=roleId;
        this.role = role;
    }
}
