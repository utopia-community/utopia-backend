package com.project.utopia.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    private static final long serialVersionUID = 101L;

    @Id
    private String email;

    //convert enum from numbers to String type
   // @Enumerated(EnumType.STRING)
    private String authorities;

    public String getEmailId() {
        return email;
    }

    public void setEmailId(String email) {
        this.email = email;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authority) {
        this.authorities = authority;
    }
}
