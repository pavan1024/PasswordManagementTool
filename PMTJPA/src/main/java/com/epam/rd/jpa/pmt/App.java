package com.epam.rd.jpa.pmt;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.epam.pmt.crudoperations.AccountOperations;
import com.epam.pmt.db.MasterProvider;
import com.epam.pmt.db.SingletonEntityManagerFactory;
import com.epam.pmt.entities.Account;
import com.epam.pmt.entities.Master;
import com.epam.pmt.ui.Menu;

public class App 
{
    public static void main( String[] args )
    {

//    	
//    	Master master=new Master();
//    	master.setUsername("master");
//    	master.setPassword("Master@123");
//    	
//    	
//    	List<Account> accounts=new ArrayList<>();
//    	Account account1=new Account();
//    	account1.setUrl("https://www.yahoo.com");
//    	account1.setGroupName("yahoo");
//    	account1.setUserName("yahoouser");
//    	account1.setPassword("Yahoo@123");
//    	
//    	Account account2=new Account();
//    	account2.setUrl("https://www.gmail.com");
//    	account2.setGroupName("google");
//    	account2.setUserName("gmailuser");
//    	account2.setPassword("Gmail@123");
//    	
//    	Account account3=new Account();
//    	account3.setUrl("https://www.drive.com");
//    	account3.setGroupName("google");
//    	account3.setUserName("driveuser");
//    	account3.setPassword("Drive@123");
//    	
//    	Account account4=new Account();
//    	account4.setUrl("https://www.facebook.com");
//    	account4.setGroupName("facebook");
//    	account4.setUserName("facebookuser");
//    	account4.setPassword("Facebook@123");
//    	
//    	accounts.add(account1);
//    	accounts.add(account2);
//    	accounts.add(account3);
//    	accounts.add(account4);
//    	master.setAccounts(accounts);
//    	
//    	EntityManagerFactory entityManagerFactory=SingletonEntityManagerFactory.getEntityManagerFactory();
//    	EntityManager entityManager =entityManagerFactory.createEntityManager();
//    	
//    	entityManager.getTransaction().begin();
//    	entityManager.merge(master);
//    	entityManager.getTransaction().commit();
    	
    //	MasterProvider.setMaster("master","Master@123");
        //System.out.println(AccountOperations.checkIfURLExists("https://www.gmail.com"));
   // 	Menu.operations();
    	
//    	if(AccountOperations.createAccount("https://www.meta.com","facebook","metauser","Meta@123")) {
//    		System.out.println("Account Created");
//    	}
//    	else {
//    		System.out.println("Account not created");
//    	}
//    	
    	
//    	if(AccountOperations.deleteAccount("https://www.drive.com")) {
//    		System.out.println("Account Deleted");
//    	}
//    	else {
//    		System.out.println("Account Deletion Failure");
//    	}
    	
    	
//    	if(AccountOperations.updateAccountUsername("https://www.gmail.com", "gmailus")) {
//    		System.out.println("Username updated successfully");
//    	}
//    	else {
//    		System.out.println("Username Updation Failure");
//    	}
//    	

    	
//    	AccountOperations.viewAllAccounts();
    	
//    	if(AccountOperations.readByGroup("facebook")) {
//    		
//    	}else {
//    		System.out.println("Group Not Found");
//    	}
    	
    	
        
    }
}
