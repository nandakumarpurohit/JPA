package com.demo.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.demo.model.CD;
import com.demo.service.ItemService;

public class Main {

  public static void main(String[] args) {

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample-persistence-unit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    ItemService service = new ItemService(em);

    // Creates and persists a CD
    tx.begin();
    CD cd = new CD("Sergent Pepper");
    cd = service.createCD(cd);
    tx.commit();

    System.out.println("CD Persisted : " + cd);

    // Finds the CD by primary key
    cd = service.findCD(cd.getId());

    System.out.println("CD Found     : " + cd);

    // Removes the CD
    //tx.begin();
    //service.removeCD(cd);
    //tx.commit();

    //System.out.println("CD Removed");

    // Finds the CD by primary key
    //cd = service.findCD(cd.getId());

    //System.out.println("CD Not Found : " + cd);

    em.close();
    emf.close();
  }
}


