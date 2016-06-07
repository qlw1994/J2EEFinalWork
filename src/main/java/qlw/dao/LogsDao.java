package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Logs;

@Repository
@Transactional
public class LogsDao extends BaseDao<Logs, Integer> {

}
