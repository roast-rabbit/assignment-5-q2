package defaut;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder {

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
			
			long millis = System.currentTimeMillis();
			Date date = new java.sql.Date(millis);
			
			// create an order
			Order tempOrder = new Order(date, "Johnoson");
			
			// save the orders
			System.out.println("\n Saving orders...");
			session.save(tempOrder);
			
			System.out.println("\n Saved orders: " + tempOrder);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
