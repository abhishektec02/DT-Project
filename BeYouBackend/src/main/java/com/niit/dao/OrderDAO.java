package com.niit.dao;

import com.niit.model.OrderDetail;

public interface OrderDAO

{
    public boolean saveOrder(OrderDetail orderDetail);
    public boolean updateCart(String username);
}
