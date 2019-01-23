package com.travelAgency.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelAgency.model.RoomType;

@Repository
public class RoomTypeDaoImpl extends AbstractDao<Integer, RoomType> implements RoomTypeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int save(RoomType roomType){
        sessionFactory.getCurrentSession().save(roomType);
        return roomType.getRoomTypeId();
    }

    @Override
    public RoomType get(int id){
        return sessionFactory.getCurrentSession().get(RoomType.class, id);
    }

    @Override
    public List<RoomType> list(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RoomType> criteriaQuery = criteriaBuilder.createQuery(RoomType.class);
        Root<RoomType> root = criteriaQuery.from(RoomType.class);
        criteriaQuery.select(root);
        Query<RoomType> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
