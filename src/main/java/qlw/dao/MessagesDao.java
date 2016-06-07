package qlw.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Messages;

@Repository
@Transactional
public class MessagesDao extends BaseDao<Messages, Integer> {

}
