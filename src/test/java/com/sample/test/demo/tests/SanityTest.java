package com.sample.test.demo.tests;


import com.sample.test.demo.constants.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.page.Index_page;
import com.sample.test.demo.TestBase;

public class SanityTest extends TestBase {
	

    @Test(testName="Placing Order of your Pizza with CC Payment.")
    public void Sanity_place_order_cc() {
    	
    	String qty = "5";
    	 driver.navigate().refresh();
	    	Index_page ip = new Index_page(driver);
	    	
	    	
	    	ip.select_pizza(PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName());
	    	ip.select_pizza_topping1(PizzaToppings.MOZZARELLA.getDisplayName());
	    	ip.select_pizza_topping2(PizzaToppings.ITALIANHAM.getDisplayName());
	    	ip.enter_pizza_qty(qty);
	    	 ip.enter_name("test user");
	    	 ip.enter_phone_number("9292929292");
	    	 ip.enter_email("test@gmail.com");
	    	 ip.click_ccpayment();
			 ip.click_placeOrder();
	
    	
    	Assert.assertEquals(ip.get_dialog_box_text().split("!")[0],"Thank you for your order"); //Validating if your order is placed successfully.
    	ip.close_dialog();
    	
    	
    }

    
    @Test(testName="Placing Order of your Pizza with Cash Payment.")
    public void Sanity_place_order_cash() {
    	
    	
    	String qty = "75";
    	driver.navigate().refresh();
    	Index_page ip = new Index_page(driver);
    	
    	
    	ip.select_pizza(PizzaTypes.SMALL_ONETOPPINGS.getDisplayName());
    	ip.select_pizza_topping1(PizzaToppings.OLIVES.getDisplayName());
    	
    	ip.enter_pizza_qty(qty);
    	 ip.enter_name("test user");
    	 ip.enter_phone_number("9292929292");
    	 ip.enter_email("test@gmail.com");
    	 ip.click_cashpayment();
		 ip.click_placeOrder();

	
	Assert.assertEquals(ip.get_dialog_box_text().split("!")[0],"Thank you for your order"); //Validating if your order is placed successfully.
	ip.close_dialog();

    	
    }

}
