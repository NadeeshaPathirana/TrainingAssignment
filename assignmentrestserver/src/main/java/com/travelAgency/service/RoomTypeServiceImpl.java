package com.travelAgency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelAgency.dao.RoomTypeDao;
import com.travelAgency.model.RoomType;

import javax.persistence.OneToMany;

@Service
@Transactional(readOnly = true)
public class RoomTypeServiceImpl implements RoomTypeService{
    @Autowired
    private RoomTypeDao roomTypeDao;

    @Transactional
    @Override
    public int save(RoomType roomType){
        return roomTypeDao.save(roomType);
    }

    @Override
    public RoomType get(int id){
        return roomTypeDao.get(id);
    }

    @Override
    public List<RoomType> list(){
        return roomTypeDao.list();
    }
}
