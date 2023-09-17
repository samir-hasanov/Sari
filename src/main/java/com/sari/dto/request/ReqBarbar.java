package com.sari.dto.request;

import com.sari.entity.Gender;
import lombok.Data;

@Data
public class ReqBarbar {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String image;
    private Gender genderId;
}
