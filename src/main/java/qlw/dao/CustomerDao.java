package qlw.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Customer;

@Repository
public class CustomerDao extends BaseDao<Customer, String> {

}
