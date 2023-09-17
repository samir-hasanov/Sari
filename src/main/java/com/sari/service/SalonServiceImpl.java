package com.sari.service;

import com.sari.dto.request.ReqSalon;
import com.sari.dto.response.RespSalon;
import com.sari.dto.response.RespStatus;
import com.sari.dto.response.RespStatusList;
import com.sari.dto.response.Response;
import com.sari.entity.Salon;
import com.sari.exception.EnumCode;
import com.sari.exception.ExceptionConstants;
import com.sari.exception.MyException;
import com.sari.repostory.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalonServiceImpl implements SalonService{
    @Autowired
    private SalonRepository salonRepository;

    @Override
    public RespStatusList saveSalon(ReqSalon reqSalon) {
        RespStatusList response=new RespStatusList();
        try {
            if(reqSalon==null){
                throw new MyException(ExceptionConstants.REQUEST_NULL,"Request null");
            }
            Salon salon=new Salon();
            salon.setName(reqSalon.getName());
            salon.setImage(reqSalon.getImage());
            salon.setAddress(reqSalon.getAddress());
            salon.setBarbarId(reqSalon.getBarbarId());
            salonRepository.save(salon);
            response.setStatus(RespStatus.getMessage());
        }catch (MyException e){
            e.printStackTrace();
            response.setStatus(new RespStatus(e.getCode(),e.getMessage()));

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_SERVER_ERROR,"Internal server error"));
        }
        return response;
    }

    @Override
    public Response<List<RespSalon>> getSalonList() {

        Response<List<RespSalon>> response=new Response<>();
        List<RespSalon> list=new ArrayList<>();
        try {
            List<Salon> salons=salonRepository.findByActive(EnumCode.Active.getValue());
            if(salons==null){
            throw new MyException(ExceptionConstants.DATA_NOT_FOUND,"Data not found");
            }

            for (Salon salon:salons){
                RespSalon respSalon=new RespSalon();
                respSalon.setId(salon.getId());
                respSalon.setName(salon.getName());
                respSalon.setImage(salon.getImage());
                respSalon.setAddress(salon.getAddress());
                respSalon.setBarbarId(salon.getBarbarId());
                list.add(respSalon);
            }
            response.setT(list);
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

    @Override
    public Response<RespSalon> getSalonById(Long id) {
        Response<RespSalon> response=new Response<>();
        try {
            if(id==null){
                throw new MyException(ExceptionConstants.REQUEST_NULL,"Request null");
            }
            Salon salon=salonRepository.getReferenceById(id);
            if(salon==null){
                throw new MyException(ExceptionConstants.DATA_NOT_FOUND,"Data not found");
            }
            RespSalon respSalon=new RespSalon();
            respSalon.setId(salon.getId());
            respSalon.setName(salon.getName());
            respSalon.setImage(salon.getImage());
            respSalon.setImage(salon.getAddress());
            respSalon.setBarbarId(salon.getBarbarId());
            response.setT(respSalon);
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

    @Override
    public RespStatusList updateSalon(ReqSalon reqSalon) {
        RespStatusList response=new RespStatusList();

        try {
            String name=reqSalon.getName();
            String image=reqSalon.getImage();
            String address=reqSalon.getAddress();
            Long id=reqSalon.getId();
            if(name==null||image==null||address==null){
                throw new MyException(ExceptionConstants.REQUEST_NULL,"Request null");
            }
            Salon salon=salonRepository.findByIdAndActive(id,EnumCode.Active.getValue());
            if(salon==null){
                throw new MyException(ExceptionConstants.DATA_NOT_FOUND,"Data not found");
            }
            salon.setName(reqSalon.getName());
            salon.setAddress(reqSalon.getAddress());
            salon.setImage(reqSalon.getImage());
            salon.setBarbarId(reqSalon.getBarbarId());
            salonRepository.save(salon);
            response.setStatus(RespStatus.getMessage());

        } catch (MyException e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(e.getCode(),e.getMessage()));
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_SERVER_ERROR,"Internal server error"));
        }
        return response;
    }

    @Override
    public RespStatusList delSalon(Long id) {
        RespStatusList response=new RespStatusList();
        try {
            if(id==null){
                throw new MyException(ExceptionConstants.REQUEST_NULL,"Request null");
            }

            Salon salon=salonRepository.findByIdAndActive(id,EnumCode.Active.getValue());
            if(salon==null){
                throw new MyException(ExceptionConstants.DATA_NOT_FOUND,"Data not found");
            }
            salon.setActive(EnumCode.DeActive.getValue());
            salonRepository.save(salon);
            response.setStatus(RespStatus.getMessage());

        } catch (MyException e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(e.getCode(),e.getMessage()));
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_SERVER_ERROR,"Internal server error"));
        }
        return response;
    }
}
