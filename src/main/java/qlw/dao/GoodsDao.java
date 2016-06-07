package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Goods;

@Repository
@Transactional
public class GoodsDao extends BaseDao<Goods, Integer> {

}
