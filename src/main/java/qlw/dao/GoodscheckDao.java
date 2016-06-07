package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Goodscheck;

@Repository
@Transactional
public class GoodscheckDao extends BaseDao<Goodscheck, Integer> {

}
