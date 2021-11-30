package defaut;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddProductsForOrder {

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
			int orderId = 2;
			Order tempOrder = session.get(Order.class, orderId);
			
			//System.out.println("\nLoaded order: " + tempOrder.getId());
			//System.out.println("\nLoaded order: " + tempOrder.getDate());
			//System.out.println("\nLoaded order: " + tempOrder.getCustomerName());
			//for(Product product : tempOrder.getProducts()) {
			//	System.out.println(product.getId());
			//}
			System.out.println("Products: " + tempOrder.getProducts());
			// create more products
			Product tempProduct1 = new Product("laptop");
			Product tempProduct2 = new Product("Game");
			// add order to products
			tempProduct1.addOrder(tempOrder);
			tempProduct2.addOrder(tempOrder);
			// save
			System.out.println("\nSaving the products ...");
	    	session.save(tempProduct1);
			session.save(tempProduct2);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
