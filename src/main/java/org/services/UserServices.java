package org.services;

import org.interfaces.UserInterface;
import org.database.PostgreSQLConnect;
import org.database.UserEntity;
import org.hibernate.Session; // Ensure you have the correct Hibernate imports
import org.hibernate.Transaction; // Ensure you have the correct Hibernate imports
import org.hibernate.SessionFactory; // Ensure you have the correct Hibernate imports
import org.hibernate.cfg.Configuration; // Ensure you have the correct Hibernate imports

public class UserServices implements UserInterface {
    private boolean isConnected;
    private String username;
    private String password;
    private String email;

    // Constructor
    public UserServices() {}

    // Constructor to initialize username, password, and email
    public UserServices(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Methods

    public boolean DBConnect() {
        isConnected = PostgreSQLConnect.connect();

        if (isConnected) {
            System.out.println("Connected to the database.");
            return true; // Return true if connected
        } else {
            System.out.println("Failed to connect to the database.");
            return false; // Return false if not connected
        }
    }

    @Override
    public boolean Login() {
        if (!this.isConnected) {
            return false;
        }

        // Create a new UserEntity
        UserEntity user = new UserEntity(this.username, this.password, this.email);

        // Hibernate session setup
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user); // The id will be generated automatically

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public void Logout() {
        // Implement logout logic here
    }
}
