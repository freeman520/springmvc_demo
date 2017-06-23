package edu.freshen.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.freshen.dao.DbVersionDao;
import edu.freshen.entity.DbVersion;
@Scope("prototype")
@Repository("dbVersionDao")
public class DbVersionDaoImpl extends BaseDaoImpl<DbVersion> implements DbVersionDao {

}
