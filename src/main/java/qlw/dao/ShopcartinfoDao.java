package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Shopcartinfo;

@Repository
@Transactional
public class ShopcartinfoDao extends BaseDao<Shopcartinfo, Integer> {

}
