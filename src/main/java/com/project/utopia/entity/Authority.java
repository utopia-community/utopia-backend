package com.project.utopia.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    private static final long serialVersionUID = 8734140534986494039L;

    @Id
    private String email;

    //convert enum from numbers to String type
    @Enumerated(EnumType.STRING)
    private AuthorityType authority;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AuthorityType getAuthorities() {
        return authority;
    }

    public void setAuthorities(AuthorityType authority) {
        this.authority = authority;
    }
}
