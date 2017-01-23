package gr.quizbomb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.repository.GenericRepository;
import gr.quizbomb.service.GenericService;

public class GenericServiceImpl<T> implements GenericService<T> {

	@Autowired
	private GenericRepository<T> dao;

	@Override
	@Transactional
	public T create(T t) {
		T createdT = t;
		return dao.save(createdT);
	}

	@Override
	@Transactional
	public T delete(long id) {
		T deletedT = dao.findOne(id);
		dao.delete(deletedT);
		return deletedT;
	}

	@Override
	@Transactional
	public T update(T t) {
		T createdT = t;
		return dao.save(createdT);
	}

	@Override
	@Transactional
	public T findById(long id) {
		return dao.findOne(id);
	}

}
