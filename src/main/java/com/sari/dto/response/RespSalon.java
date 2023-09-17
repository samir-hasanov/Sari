package com.sari.dto.response;

import com.sari.entity.Barbar;
import lombok.Data;

@Data
public class RespSalon {
    private Long id;
    private String name;
    private String image;
    private String address;
    private Barbar barbarId;
}
