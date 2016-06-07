package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Business;

@Transactional
@Repository
public class BusinessDao extends BaseDao<Business, String> {

}
