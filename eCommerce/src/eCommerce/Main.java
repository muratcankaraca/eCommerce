package eCommerce;
import java.util.List;

import eCommerce.business.concretes.AuthManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.amazonEmail.AmazonMailManagerAdapter;
import eCommerce.core.googleEmail.GoogleMailManagerAdapter;
import eCommerce.dataAccess.concretes.InMemoryUserDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		 
		
		InMemoryUserDao inMemoryUserDao=new InMemoryUserDao();
		AuthManager authManager=new AuthManager(new UserManager(inMemoryUserDao, new AmazonMailManagerAdapter()));
			
		User murat =new User(1,"Murat","Karaca","murat@gmail.com","342423432",true);
		User ali =new User(2,"Ali","Kara","murat2@gmail.com","5435432",true);
		
		
		authManager.register(murat);
		
		UserManager userManager=new UserManager(inMemoryUserDao, new GoogleMailManagerAdapter());
		//userManager.update(murat);
		//userManager.delete(3);
		userManager.getAll();
		
		
		
		
		
		
		
		
		

	}

}