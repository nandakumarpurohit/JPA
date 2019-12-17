package com.demo.main;

import static com.demo.utility.Util.date;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.demo.model.CD;
import com.demo.model.Musician;
import com.demo.service.CDService;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

	    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample-persistence-unit");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();

	    CDService service = new CDService(em);

	    // Creates and persists a CD
	    tx.begin();
	    
	    Set<Musician> beatles = new HashSet<>();
	    beatles.add(new Musician("John", "Lennon"));
	    beatles.add(new Musician("Paul", "McCartney"));
	    beatles.add(new Musician("Ringo", "Starr"));
	    beatles.add(new Musician("Georges", "Harrison"));
	    
	    CD sergentPepper = new CD("Sergent Pepper");
	    sergentPepper.setMusicians(beatles);
	    
	    sergentPepper = service.createCD(sergentPepper);
	    
	    tx.commit();

	    System.out.println("CD Persisted : " + sergentPepper);

	    // Finds the cd by primary key
	    CD sergentPepper2 = service.findCD(sergentPepper.getId());

	    System.out.println("CD Found     : " + sergentPepper2);
	    //System.out.println("   Musicians : " + sergentPepper.getMusicians());

	    // Deletes the cd
	    //tx.begin();
	    //service.removeCD(cd.getId());
	    //tx.commit();

	    //System.out.println("CD Removed");

	    // Finds the cd  by primary key
	    //cd = service.findCD(cd.getId());

	    //System.out.println("CD Not Found : " + cd);

	    em.close();
	    emf.close();
	  }
}


