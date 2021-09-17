package com.project.utopia.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "requests")
public class Request implements Serializable {
    private static final long serialVersionUID = 105L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int requestId;

    private String title;
    private String content;

    @ManyToOne
    private Customer customer;
}