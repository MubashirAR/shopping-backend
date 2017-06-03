package com.niit.backend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.dao.SupplierDAO;
import com.niit.backend.model.Supplier;
@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}
	/*public List<Supplier> list()
	{
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}
	*/
	
	public boolean save(Supplier supplier)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public java.util.List<Supplier> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getSupplierByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier getSupplierByID(String id) {
		return (Supplier)sessionFactory.getCurrentSession().createQuery("from Supplier where id='"+id+"'").uniqueResult();
	}

	public Supplier getSupplierByName(String name) {
		return (Supplier)sessionFactory.getCurrentSession().createQuery("from Supplier where name='"+name+"'").uniqueResult();
	}

	public boolean saveOrUpdate(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
}