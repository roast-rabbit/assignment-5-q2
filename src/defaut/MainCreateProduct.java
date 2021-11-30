package defaut;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {

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
			
			// create a product
			Product tempProduct = new Product("book");
			
			// save the product
			System.out.println("\n Saving the product");
			
			session.save(tempProduct);
			System.out.println("Saved the product: " + tempProduct);
			long millis = System.currentTimeMillis();
			Date date = new java.sql.Date(millis);
			
			// create the orders
			Order order1 = new Order(date, "John");
			Order order2 = new Order(date, "Joe");
			
			// add orders to the product
			tempProduct.addOrder(order1);
			tempProduct.addOrder(order2);
			// save the orders
			System.out.println("\n Saving orders...");
			session.save(order1);
			session.save(order2);
			System.out.println("\n Saved orders: " + tempProduct.getOrders());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
