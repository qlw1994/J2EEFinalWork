package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Customer;

@Repository
@Transactional
public class CustomerDao extends BaseDao<Customer, String> {

}
