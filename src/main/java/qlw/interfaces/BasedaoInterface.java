package qlw.interfaces;

import java.io.Serializable;
import java.util.List;

public interface BasedaoInterface<T, PK extends Serializable> {
	public void save(Class<T> entity);

	public void update(Class<T> entity);

	public void delete(PK id);

	public T findById(PK pk);

	public List<T> findByHQL(String hql, Object[] params);

	public int getAllRowCount(String hql, Object[] params);

	public List<T> findByPage(int start, int count);
}
