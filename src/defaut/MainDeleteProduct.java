package defaut;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteProduct {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Order.class)
									 .addAnnotatedClass(Product.class)
									 .buildSessionFactory();
					
		// create session
		Session session = factory.getCurrentSession();
		
		try {
		
			// start a transaction
			session.beginTransaction();
			// get the order from database
			int productId = 2;
			Product tempProduct = session.get(Product.class, productId);
			
			System.out.println("Deleting product: " + tempProduct);
			
			session.delete(tempProduct);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
