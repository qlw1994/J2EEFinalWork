package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Addresslist;

@Transactional
@Repository("addresslistDao")
public class AddresslistDao extends BaseDao<Addresslist, Integer> {

}
