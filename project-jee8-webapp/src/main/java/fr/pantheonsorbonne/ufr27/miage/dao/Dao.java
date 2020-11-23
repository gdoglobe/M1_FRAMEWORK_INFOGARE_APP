package fr.pantheonsorbonne.ufr27.miage.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	public T save(T t);
	public T find(long id);
	public T update(T t);
	public void delete(T t);
	public List<T> findAll();
}
