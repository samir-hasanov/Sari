package com.sari.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
public class Barbar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String image;
    @ManyToOne(fetch = FetchType.EAGER)
    private Gender genderId;
    @ColumnDefault(value = "1")
    private Integer active;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate;
}
