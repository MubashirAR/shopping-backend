package com.niit.backend.dao;

import com.niit.backend.model.ShippingAddress;

public interface ShippingAddressDAO {

	public boolean save(ShippingAddress shippingaddress);
	
	public boolean update(ShippingAddress shippingaddress);
	
	public boolean delete(ShippingAddress shippingaddress);
	
	
	
}
