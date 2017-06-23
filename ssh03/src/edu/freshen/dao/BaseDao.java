package edu.freshen.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 数据访问的通用接口
 * @author Administrator
 * @param <T>
 */
public interface BaseDao <T>{
	/**
	 * 插入一个实体对象
	 * @param entity 待插入的实体对象
	 * @return 成功时返回1，否则返回0
	 */
	public int insertEntity(T entity);
	/**
	 * 根据ID删除一个实体对象
	 * @param entityClass 待删除实体对象
	 * @param id  待删除实体对象的主键
	 * @return 成功时返回1，否则返回0
	 */
	public int deleteEntity(Class entityClass,Serializable id);
	/**
	 * 根据id修改实体对象
	 * @param entity 待修改实体
	 * @param id 待修改实体主键
	 * @return 成功时返回1，否则返回0
	 */
	public int updateEntity(T entity,Serializable id);
	/**
	 * 根据主键，查询实体 
	 * @param id 
	 * @param entityClass
	 * @return
	 */
	public T getEntity(Class entityClass,Serializable id);
	/**
	 * 查询所有实体对象
	 * @param entityClass 待查询实体类型
	 * @return 实体对象集合
	 */
	public List<T> queryAll(Class entityClass);
	/**
	 * 分页查询实体对象
	 * @param entityClass 待查询实体类型
	 * @param start  开始记录
	 * @param size   待查询记录数
	 * @return 实体对象集合
	 */
	public List<T> queryByPage(Class entityClass,int start,int size);
	/**
	 * 统计制定实体类型 的 个数
	 * @param entityClass 待统计类型
	 * @return 记录条数
	 */
	public Long countItem(Class entityClass);
	
}
