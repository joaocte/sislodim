package br.faculdadeidez.psa.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOFactory<T> {
	private static EntityManager manager;

	public DAOFactory() {
		manager = getManager();
	}

	public static EntityManager getManager() {
		if (manager == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sislodim");
			manager = factory.createEntityManager();
		}
		return manager;
	}

	public void persist(T obj) {
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
	}

	public void remove(T obj) {
		manager.getTransaction().begin();
		manager.remove(obj);
		manager.getTransaction().commit();
	}

	public void update(T obj) {
		manager.getTransaction().begin();
		manager.merge(obj);
		manager.getTransaction().commit();
	}
	
	T find(Class<T> classe, Object chave){
		return manager.find(classe, chave);
	}

	List<T> findAll(Class<T> classe) {
		Query query = manager.createQuery("select a from "+classe.getSimpleName()+" a");
		return (List<T>) query.getResultList();
	}

	List<T> findByField(Class<T> classe, String campo, String valor) {
		Query query = manager.createQuery("select a from "+classe.getSimpleName()+" a " + "where a."
				+ campo + " = \"" + valor + "\"");
		return (List<T>) query.getResultList();
	}

}