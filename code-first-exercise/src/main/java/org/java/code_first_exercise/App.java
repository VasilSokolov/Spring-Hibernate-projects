package org.java.code_first_exercise;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise_db");
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.getTransaction().commit();
        
        em.close();
        //end 
    }
}
