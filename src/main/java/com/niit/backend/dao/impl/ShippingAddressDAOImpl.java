package com.niit.backend.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.dao.ShippingAddressDAO;
import com.niit.backend.model.ShippingAddress;


@Transactional
@Repository("shippingaddressDAO")
public class ShippingAddressDAOImpl implements ShippingAddressDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(ShippingAddress shippingaddress) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean update(ShippingAddress shippingaddress) {
		
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(shippingaddress);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}


	}

	@Override
	public boolean delete(ShippingAddress shippingaddress) {
		// TODO Auto-generated method stub
		return false;
	}

}
