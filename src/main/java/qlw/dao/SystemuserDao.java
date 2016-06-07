package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Systemuser;

@Repository
@Transactional
public class SystemuserDao extends BaseDao<Systemuser, String> {

}
