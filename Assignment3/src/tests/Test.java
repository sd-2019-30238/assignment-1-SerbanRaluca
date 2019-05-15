package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.BeforeClass;

import businessLogic.beans.Product;
import cqrs.commandHandlers.UpdateProductPriceHandler;
import cqrs.readModel.LoginCheckQueryResult;
import cqrs.readModel.ProductQueryService;
import cqrs.readModel.UserQueryService;
import cqrs.writeModel.UpdateProductPriceCommand;

class Test {
	
	 @BeforeClass
     public static void setUpBeforeClass() throws Exception {
        
     }

	@org.junit.jupiter.api.Test
	void findProductTest() {
		 
		 try {
			Product product=ProductQueryService.findProduct("c1i1");
			assertTrue(product.getName().equals("Thonet"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.jupiter.api.Test
	void loginCheckTest() { 
		LoginCheckQueryResult result=UserQueryService.loginCheck("roxana18","roxana18august1997");
		assertEquals(result.getLoginRole(),"Admin_Role");
		
	}
	
	@org.junit.jupiter.api.Test
	void updatePriceCommandTest() {
		UpdateProductPriceCommand command=new UpdateProductPriceCommand("c1i1",600.00);
		UpdateProductPriceHandler handler=new UpdateProductPriceHandler();
		handler.handle(command);
		try {
			Product p=ProductQueryService.findProduct("c1i1");
			assertEquals(p.getPrice(),600.00);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
