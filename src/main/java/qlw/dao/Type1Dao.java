package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Type1;

@Repository
@Transactional
public class Type1Dao extends BaseDao<Type1, Integer> {

}
