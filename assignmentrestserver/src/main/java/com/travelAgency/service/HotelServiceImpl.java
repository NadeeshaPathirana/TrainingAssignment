package com.travelAgency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelAgency.dao.HotelDao;
import com.travelAgency.model.Hotel;

@Service
@Transactional(readOnly = true)
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Transactional
    @Override
    public int save(Hotel hotel){
        return hotelDao.save(hotel);
    }

    @Override
    public Hotel get(int id){
        return hotelDao.get(id);
    }

    @Override
    public List<Hotel> list(){
        return hotelDao.list();
    }
}
