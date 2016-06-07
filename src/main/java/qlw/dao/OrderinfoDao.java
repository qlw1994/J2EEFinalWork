package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Orderinfo;

@Repository
@Transactional
public class OrderinfoDao extends BaseDao<Orderinfo, Integer> {

}
