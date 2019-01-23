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

import com.travelAgency.model.Hotel;

@Repository
public class HotelDaoImpl extends AbstractDao<Integer, Hotel> implements HotelDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int save(Hotel hotel){
        System.out.println("at HotelDao : "+hotel.getHotelName()+" "+hotel.getHotelId());
        sessionFactory.getCurrentSession().save(hotel);
        return hotel.getHotelId();
    }

    @Override
    public Hotel get(int id){
        return sessionFactory.getCurrentSession().get(Hotel.class, id);
    }

    @Override
    public List<Hotel> list(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Hotel> criteriaQuery = criteriaBuilder.createQuery(Hotel.class);
        Root<Hotel> root = criteriaQuery.from(Hotel.class);
        criteriaQuery.select(root);
        Query<Hotel> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
