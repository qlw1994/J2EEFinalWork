package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Headcheck;

@Repository
@Transactional
public class HeadcheckDao extends BaseDao<Headcheck, Integer> {

}
