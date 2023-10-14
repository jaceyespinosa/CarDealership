package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Garage;

public class GarageHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarDealership");

	public void insertCar(Garage garage) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(garage);
		em.getTransaction().commit();
		em.close();
	}

	public List<Garage> getCarsForUser(String userId) {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Garage> typedQuery = em.createQuery("SELECT g FROM Garage g WHERE g.userId = :selectedUserId", Garage.class);
		typedQuery.setParameter("selectedUserId", userId);
		List<Garage> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}

	public void removeCarFromGarage(Garage garage) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Garage> typedQuery = em.createQuery("SELECT g FROM Garage g WHERE g.id = :selectedId", Garage.class);
		typedQuery.setParameter("selectedId", garage.getId());
		typedQuery.setMaxResults(1);
		Garage result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}