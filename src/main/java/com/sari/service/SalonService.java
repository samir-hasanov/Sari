package com.sari.service;

import com.sari.dto.request.ReqSalon;
import com.sari.dto.response.RespSalon;
import com.sari.dto.response.RespStatusList;
import com.sari.dto.response.Response;

import java.util.List;

public interface SalonService {
    RespStatusList saveSalon(ReqSalon reqSalon);

    Response<List<RespSalon>> getSalonList();

    Response<RespSalon> getSalonById(Long id);

    RespStatusList updateSalon(ReqSalon reqSalon);

    RespStatusList delSalon(Long id);
}
