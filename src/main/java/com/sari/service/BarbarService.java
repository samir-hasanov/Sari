package com.sari.service;

import com.sari.dto.request.ReqBarbar;
import com.sari.dto.response.RespBarbar;
import com.sari.dto.response.RespStatusList;
import com.sari.dto.response.Response;

import java.util.List;

public interface BarbarService {
    RespStatusList saveBarbar(ReqBarbar reqBarbar);

    Response<List<RespBarbar>> barbarList();

    RespStatusList delBarbar(Long id);

    Response<RespBarbar> getBarbarById(Long id);
}
