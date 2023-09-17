package com.sari.service;


import com.sari.dto.request.ReqBarbar;
import com.sari.dto.response.RespBarbar;
import com.sari.dto.response.RespStatus;
import com.sari.dto.response.RespStatusList;
import com.sari.dto.response.Response;
import com.sari.entity.Barbar;
import com.sari.exception.EnumCode;
import com.sari.exception.ExceptionConstants;
import com.sari.exception.MyException;
import com.sari.repostory.BarbarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BarbarServiceImpl implements BarbarService {

    @Autowired
    private BarbarRepository barbarRepository;

    @Override
    public RespStatusList saveBarbar(ReqBarbar reqBarbar) {
        RespStatusList response = new RespStatusList();
        try {
            if (reqBarbar == null) {
                throw new MyException(ExceptionConstants.REQUEST_NULL, "Request null");
            }
            Barbar barbar = new Barbar();
            barbar.setName(reqBarbar.getName());
            barbar.setSurname(reqBarbar.getSurname());
            barbar.setImage(reqBarbar.getImage());
            barbar.setEmail(reqBarbar.getEmail());
            barbar.setPhone(reqBarbar.getPhone());
            barbar.setGenderId(reqBarbar.getGenderId());
            barbarRepository.save(barbar);
            response.setStatus(RespStatus.getMessage());
        } catch (MyException e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(e.getCode(), e.getMessage()));

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_SERVER_ERROR, "Internal server error"));
        }

        return response;
    }

    @Override
    public Response<List<RespBarbar>> barbarList() {

        Response<List<RespBarbar>> response = new Response<>();
        List<RespBarbar> list = new ArrayList<>();
        try {
            List<Barbar> barbars = barbarRepository.findByActive(EnumCode.Active.getValue());
            if (barbars == null) {
                throw new MyException(ExceptionConstants.DATA_NOT_FOUND, "Data not found");
            }
            for (Barbar barbar : barbars) {
                RespBarbar respBarbar = new RespBarbar();
                respBarbar.setId(barbar.getId());
                respBarbar.setName(barbar.getName());
                respBarbar.setSurname(barbar.getSurname());
                respBarbar.setImage(barbar.getImage());
                respBarbar.setPhone(barbar.getPhone());
                respBarbar.setEmail(barbar.getEmail());
                respBarbar.setGenderId(barbar.getGenderId());
                list.add(respBarbar);
            }
            response.setT(list);
            response.setRespStatus(RespStatus.getMessage());
        } catch (MyException e) {
            e.printStackTrace();
            response.setRespStatus(new RespStatus(e.getCode(), e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            response.setRespStatus(new RespStatus(ExceptionConstants.INTERNAL_SERVER_ERROR, "Internal server error"));
        }
        return response;
    }

    @Override
    public RespStatusList delBarbar(Long id) {
        RespStatusList response = new RespStatusList();
        try {
            if (id == null) {
                throw new MyException(ExceptionConstants.REQUEST_NULL, "Request null");
            }
            Barbar barbar = barbarRepository.findByIdAndActive(id, EnumCode.Active.getValue());
            barbar.setActive(EnumCode.DeActive.getValue());
            barbarRepository.save(barbar);
            response.setStatus(RespStatus.getMessage());
        } catch (MyException e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(e.getCode(), e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_SERVER_ERROR, "Internal server error"));
        }

        return response;
    }

    @Override
    public Response<RespBarbar> getBarbarById(Long id) {
        Response<RespBarbar> response = new Response<>();
        try {
            if (id == null) {
                throw new MyException(ExceptionConstants.REQUEST_NULL, "Request null");
            }
            Barbar barbar = barbarRepository.findByIdAndActive(id, EnumCode.Active.getValue());
            if (barbar == null) {
                throw new MyException(ExceptionConstants.DATA_NOT_FOUND, "Data not found");
            }
            RespBarbar respBarbar=new RespBarbar();
            respBarbar.setId(barbar.getId());
            respBarbar.setName(barbar.getName());
            respBarbar.setSurname(barbar.getSurname());
            respBarbar.setEmail(barbar.getEmail());
            respBarbar.setPhone(barbar.getPhone());
            respBarbar.setImage(barbar.getImage());
            respBarbar.setGenderId(barbar.getGenderId());
            response.setT(respBarbar);
            response.setRespStatus(RespStatus.getMessage());
        } catch (MyException e) {
            e.printStackTrace();
            response.setRespStatus(new RespStatus(e.getCode(),e.getMessage()));
        }catch (Exception e){
            e.printStackTrace();
            response.setRespStatus(new RespStatus(ExceptionConstants.INTERNAL_SERVER_ERROR,"Internal server error"));
        }
        return response;
    }
}
