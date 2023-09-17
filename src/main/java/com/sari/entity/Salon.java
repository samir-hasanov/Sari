package com.sari.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@Entity
@Data
@DynamicInsert
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String address;
    @ManyToOne(fetch = FetchType.EAGER)
    private Barbar barbarId;
    @ColumnDefault(value = "1")
    private Integer active;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate;
}
