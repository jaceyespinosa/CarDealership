package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
