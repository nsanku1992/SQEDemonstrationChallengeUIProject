package com.sample.test.demo.tests;


import com.sample.page.Index_page;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Functional_POS extends TestBase {
	
	 @Test(testName="Place CC Order of you pizza and validate its cost.")
	    public void REP_place_order_cc() {
	    	
	    	
	    	String qty = "10";
	    	 driver.navigate().refresh();
		    	Index_page ip = new Index_page(driver);
		    	
		    	
		    	 ip.select_pizza(PizzaTypes.LARE_NOTOPPINGS.getDisplayName());
		    	 ip.enter_pizza_qty(qty);
		    	 ip.enter_name("test user");
		    	 ip.enter_phone_number("9292929292");
		    	 ip.enter_email("test@gmail.com");
		    	 ip.click_ccpayment();
		    	 String price =  String.valueOf(Double.valueOf(qty) * PizzaTypes.LARE_NOTOPPINGS.getCost());
				 ip.click_placeOrder();
		
		
				//Validating Order is placed successfully and price calculation is correct.
	    	Assert.assertEquals(ip.get_dialog_box_text().split("!")[0],"Thank you for your order");
	    	Assert.assertEquals(ip.get_dialog_box_text().split(" ")[6],price);
	    	ip.close_dialog();//Close dialog box.
	    	
	    	
	    }

    
    @Test(testName="Place Cash Order of you pizza and validate its cost.")
    public void REP_place_order_cash() {
    	String qty = "35";
   	 driver.navigate().refresh();
	    	Index_page ip = new Index_page(driver);
	    	
	    	
	    	 ip.select_pizza(PizzaTypes.LARE_NOTOPPINGS.getDisplayName());
	    	 ip.enter_pizza_qty(qty);
	    	 ip.enter_name("test user");
	    	 ip.enter_phone_number("9292929292");
	    	 ip.enter_email("test@gmail.com");
	    	 ip.click_cashpayment();
	    	 String price =  String.valueOf(Double.valueOf(qty) * PizzaTypes.LARE_NOTOPPINGS.getCost());
			 ip.click_placeOrder();
	
	
			//Validating Order is placed successfully and price calculation is correct.
   	Assert.assertEquals(ip.get_dialog_box_text().split("!")[0],"Thank you for your order");
   	Assert.assertEquals(ip.get_dialog_box_text().split(" ")[6],price);
   	ip.close_dialog();//Close dialog box.
   	
    	
    	
    	
    }
    
    
    @Test(testName="Make sure if we miss any mandatory field , we must get an alert")
    public void REP_place_order_cash_missing_field() {
    	
    	
    	String qty = "175";
    	driver.navigate().refresh();
    	Index_page ip = new Index_page(driver);
    	
    	
    	 ip.select_pizza(PizzaTypes.LARE_NOTOPPINGS.getDisplayName());
    	 ip.enter_pizza_qty(qty);
    	 
    	 ip.enter_phone_number("9292929292");
    	 ip.enter_email("test@gmail.com");
    	 ip.click_cashpayment();
    	 
		 ip.click_placeOrder();


	
		 Assert.assertEquals(ip.get_dialog_box_text(),"Missing name");//Validating that alert if coming when name is not entered.
	
	ip.close_dialog();
	
    	
    	
    }
    
    
    @Test(testName="Make sure if we miss any non-mandatory field , we must get not any alert and order must be placed successfully")
    public void REP_place_order_cash_missing_nonmad_field() {
    	
    	String qty = "90";
    	 driver.navigate().refresh();
	    	Index_page ip = new Index_page(driver);
	    	
	    	
	    	 ip.select_pizza(PizzaTypes.LARE_NOTOPPINGS.getDisplayName());
	    	 ip.enter_pizza_qty(qty);
	    	 ip.enter_name("test user");
	    	 ip.enter_phone_number("9292929292");
	    	 
	    	 ip.click_cashpayment();
	    	 
			 ip.click_placeOrder();
	
	
		
	Assert.assertEquals(ip.get_dialog_box_text().split("!")[0],"Thank you for your order");//Validating that order is placed sucessfully.
	
	ip.close_dialog();
	
 	
    	
    	
    	
    	
    	
    	
    }
    
    @Test(testName="Make sure if we refresh browser after entering values in fields and before placing order , all values must reset")
    public void REP_place_order_refresh_clean_field() {
    	
    	
    	String qty = "11";
    	 driver.navigate().refresh();
	    	Index_page ip = new Index_page(driver);
	    	
	    	
	    	 ip.select_pizza(PizzaTypes.LARE_NOTOPPINGS.getDisplayName());
	    	 ip.enter_pizza_qty(qty);
	    	 ip.enter_name("test user");
	    	 ip.enter_phone_number("9292929292");
	    	 ip.enter_email("test@gmail.com");
	    	 ip.click_cashpayment();
	    	
	
    	
    	
    	driver.navigate().refresh();
    	
    	 //Validating all values are reset.
    	Assert.assertEquals("", ip.get_name());
    	Assert.assertEquals("", ip.get_phone_number());
    	Assert.assertEquals("", ip.get_email());
    	Assert.assertEquals("0.00", ip.get_cost_value());
     	Assert.assertEquals("0", ip.get_pizza_qty());
    	
    	
    	
    }
    
    
    @Test(testName="Make sure if we click on reset after entering values in fields and before placing order , all values must reset")
    public void REP_place_order_reset_clean_field() {
    	 driver.navigate().refresh();
	    	Index_page ip = new Index_page(driver);
	    	String qty = "891";
	    	
	    	 ip.select_pizza(PizzaTypes.LARE_NOTOPPINGS.getDisplayName());
	    	 ip.enter_pizza_qty(qty);
	    	 ip.enter_name("test user");
	    	 ip.enter_phone_number("9292929292");
	    	 ip.enter_email("test@gmail.com");
	    	 ip.click_cashpayment();
	    	
	
 	
 	
 	ip.reset();
 	
 	 //Validating all values are reset.
 	Assert.assertEquals("", ip.get_name());
 	Assert.assertEquals("", ip.get_phone_number());
 	Assert.assertEquals("", ip.get_email());
 	Assert.assertEquals("0", ip.get_cost_value());
  	Assert.assertEquals("0", ip.get_pizza_qty());
  	
    	
    	
    	
    }

}
