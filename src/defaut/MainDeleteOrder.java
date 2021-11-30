package defaut;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteOrder {

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
			int orderId = 1;
			Order tempOrder = session.get(Order.class, orderId);
			
			System.out.println(tempOrder);
			System.out.println("Products: " + tempOrder.getProducts());
			
			// delete order
			System.out.println("\nDeleting order: " + tempOrder);
			session.delete(tempOrder);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
