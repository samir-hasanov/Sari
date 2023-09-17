package com.sari.dto.request;

import com.sari.entity.Barbar;
import lombok.Data;

@Data
public class ReqSalon {
    private Long id;
    private String name;
    private String image;
    private String address;
    private Barbar barbarId;
}
