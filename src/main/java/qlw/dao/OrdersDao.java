package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Orders;

@Repository
@Transactional
public class OrdersDao extends BaseDao<Orders, Integer> {

}
