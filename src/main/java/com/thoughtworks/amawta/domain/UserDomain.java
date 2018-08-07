package com.thoughtworks.amawta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "users")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "userCache")
public class UserDomain extends BaseModelDomain {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    private String email;

    private String password;

    private String role = ROLE_USER;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private Collection<PostDomain> post = new ArrayList<>();

    public UserDomain() {

    }

    public UserDomain(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setRoleAdmin() {
        this.role = ROLE_ADMIN;
    }

    public String getEmail() {
        return this.email;
    }

    public void setMail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

}