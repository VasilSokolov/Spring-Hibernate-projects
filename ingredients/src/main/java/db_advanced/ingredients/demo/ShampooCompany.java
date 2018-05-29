package db_advanced.ingredients.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;

import org.hibernate.jpa.HibernatePersistenceProvider;

import db_advanced.ingredients.model.AmmoniumChloride;
import db_advanced.ingredients.model.BasicIngredient;
import db_advanced.ingredients.model.Mint;
import db_advanced.ingredients.model.Nettle;
import db_advanced.ingredients.product.BasicShampoo;
import db_advanced.ingredients.product.ClassicLabel;
import db_advanced.ingredients.product.MyShampoo;
import db_advanced.ingredients.product.ProductionBatch;

/**
 * Hello world!
 *
 */
public class ShampooCompany {
	
	final static String PERSISTENCE_UNIT_NAME = "Shampoo";
	static EntityManagerFactory emf;
	static EntityManager em;
	
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        PersistenceProvider provider = new HibernatePersistenceProvider();
        
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
        
        em.getTransaction().begin();
//        createIngredients();
        createShampoo(); 
        
        em.getTransaction().commit();
        
        em.close();
        
    }
    
    private static void createShampoo() {
		BasicShampoo myShampoo = new MyShampoo();
		myShampoo = createLabel(myShampoo);
		Set<BasicIngredient> basicIngredients = createIngredients();
		myShampoo.setBasicIngredients(basicIngredients);
//		BasicShampoo myShampoo2 = new MyShampoo();
//		myShampoo2.setLabel(label1);
//		em.persist(myShampoo);
		
//		Set<BasicShampoo> basicShampoos = new HashSet<BasicShampoo>();
//		basicShampoos.add(myShampoo);
//		basicShampoos.add(myShampoo2);
		myShampoo = createBatch(myShampoo);
		em.persist(myShampoo);
	}
    
    private static BasicShampoo createBatch(BasicShampoo myShampoo) {
		ProductionBatch productionBatch = new ProductionBatch("Shampoo Bath");
		em.persist(productionBatch);
		myShampoo.setProductionBatch(productionBatch);
		return myShampoo;
    }
    
    private static BasicShampoo createLabel(BasicShampoo myShampoo) {
    	ClassicLabel label = new ClassicLabel("Fresh", "Nettle and Mint");
    	em.persist(label);
		myShampoo = new MyShampoo();
		myShampoo.setLabel(label);
		return myShampoo;
    }

	public static Set<BasicIngredient> createIngredients() {

        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();
        BasicIngredient ammoniumIngredient = new AmmoniumChloride();
        
        em.persist(mint);
        em.persist(nettle);
        em.persist(ammoniumIngredient);
        
        Set<BasicIngredient> basicIngredients = new HashSet<BasicIngredient>();
        basicIngredients.add(ammoniumIngredient);
        basicIngredients.add(nettle);
        basicIngredients.add(mint);
                
        return basicIngredients;
        //        List<BasicIngredient> bi = em.createQuery("SELECT b " + " FROM BasicIngredient b WHERE  b.name LIKE '%t%' ").getResultList();
//  
//        for (BasicIngredient basicIngredient : bi) {
//			System.out.println(basicIngredient);
//		}
        
    }
}
