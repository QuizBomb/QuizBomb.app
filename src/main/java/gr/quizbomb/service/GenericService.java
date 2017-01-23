package gr.quizbomb.service;

public interface GenericService<T> {
	
	public T create(T t);
	
	public T findById(long id);
	
	public T update(T t);
	
	public T delete(long id);
		
}
