package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.MyCart;

public interface CartDAO {
	
	public List<MyCart>	list(String userId);
	
	public MyCart get(String id);
	
	public boolean save(MyCart myCart);
	
	public boolean delete(MyCart myCart);
	
	public boolean delete(String id);

	
	public boolean update(MyCart myCart);
	
	
	public Long getTotalAmount(String id);

	public MyCart getCartByID(String id);

}