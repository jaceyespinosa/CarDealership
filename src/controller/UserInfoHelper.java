package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarDealership;

public class UserInfoHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarDealership");
	public void insertItem(CarDealership car) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		em.close();
	}
	public List<CarDealership> showAllCars() {
		EntityManager em = emfactory.createEntityManager();
		List<CarDealership> allItems = em.createQuery("SELECT A FROM CarDealership A").getResultList();
		return allItems;
	}
	public void deleteItem(CarDealership toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarDealership> typedQuery = em.createQuery("SELECT cd FROM CarDealership cd " + "WHERE cd.model = :selectedModel " + "AND cd.description = :selectedDescription " + "AND cd.price = :selectedPrice",
		        CarDealership.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedDescription", toDelete.getDescription());
		typedQuery.setParameter("selectedPrice", toDelete.getPrice());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		CarDealership result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public CarDealership searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarDealership found = em.find(CarDealership.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(CarDealership toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
