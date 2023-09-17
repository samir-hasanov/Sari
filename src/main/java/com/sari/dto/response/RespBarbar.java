package com.sari.dto.response;

import com.sari.entity.Gender;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class RespBarbar {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String image;
    private Gender genderId;
}
