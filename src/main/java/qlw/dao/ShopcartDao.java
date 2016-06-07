package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Shopcart;

@Repository
@Transactional
public class ShopcartDao extends BaseDao<Shopcart, Integer> {

}
