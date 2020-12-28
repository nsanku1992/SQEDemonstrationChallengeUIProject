package com.sample.test.demo.tests;


import com.sample.test.demo.constants.*;
import org.testng.Assert;
import com.sample.page.Index_page;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;

public class Functional_NEG extends TestBase {
	

    @Test (testName="Selecting Cash / Credit Card radio button must be not allowed simulataneously.")
    public void NEG_select_both_payment() {
    	/*
    	 * Following test case is failing for now as Credit Card Payment selection does not disable Cash Payment Radio button. - Defect in application.
    	 */
    	driver.navigate().refresh();
    	Index_page ip = new Index_page(driver);
    	ip.click_ccpayment(); //Click Cash Payment radio button
    	ip.click_cashpayment(); //Click CC Payment radio button
    	Assert.assertEquals(ip.isselected_ccpayment(),false); //Credit Card Payment selection must disable Cash Payment Radio button. 
    	ip.close_dialog(); 
    	
    }
    

    
    @Test (testName="Enter invalid user details.")
    public void NEG_wrong_field_information() {
    	/*
    	 * Following test case is failing for now because Order is getting placed even if  user details are not appropriate.
    	 */
    	String qty = "75";
    	driver.navigate().refresh();
    	Index_page ip = new Index_page(driver);
    	
    	
    	ip.select_pizza(PizzaTypes.SMALL_ONETOPPINGS.getDisplayName()); //Select Pizza.
    	ip.select_pizza_topping1(PizzaToppings.ITALIANHAM.getDisplayName());//Select Pizza Topping.
    	ip.enter_pizza_qty(qty); //Enter Quantity 
    	 ip.enter_name("jj 4k4k4"); //Enter name of user - make sure it has digits / special character.
    	 ip.enter_phone_number("9292929dd292"); //Enter phone number of user - make sure it has alphabets / special character.
    	 ip.enter_email("dffdfdf");//Enter email of user - make sure it is not in email format.
    	 ip.click_cashpayment(); // Perform Cash  payment.
		 ip.click_placeOrder(); // Click on Place order.
    	
    	if(ip.get_dialog_box_text().split("!")[0].equals("Thank you for your order")) { // Order must not be placed as user details are not appropriate. 
    		Assert.assertEquals(true, false);
    	}
    	ip.close_dialog();

    	
    }
    	 @Test (testName="Enter 1 character in text box identifying minimum number of characters allowed.")
    	    public void NEG_boundary_value_test1() {
    		 /*
    	    	 * Following test case is failing for now because Order is getting placed even if  user details are not appropriate.
    	    	 */
    		 String qty = "15";
    		 driver.navigate().refresh();
    	    	Index_page ip = new Index_page(driver);
    	    	
    	    	
    	    	ip.select_pizza(PizzaTypes.LARE_NOTOPPINGS.getDisplayName());
    	    	ip.enter_pizza_qty(qty);
    	    	 ip.enter_name(" ");
    	    	 ip.enter_phone_number(" ");
    	    	 ip.enter_email(" ");
    	    	 ip.click_ccpayment();
    			 ip.click_placeOrder();
    	    	 
    	    	if(ip.get_dialog_box_text().split("!")[0].equals("Thank you for your order")) {
    	    		Assert.assertEquals(true, false);
    	    	}
    	    			
    	    	ip.close_dialog();

}
    	 
    	 @Test (testName="Enter n number of characters in text box identifying max number of characters allowed.")
 	    public void NEG_boundary_value_test2() {
    		 /*
    	    	 * Following test case is failing for now because Order is getting placed even if  user details are not appropriate.
    	    	 */
    		 String qty = "25";
    		 driver.navigate().refresh();
 	    	Index_page ip = new Index_page(driver);
 	    	
 	    	
 	    	ip.select_pizza(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName());
 	    	ip.enter_pizza_qty(qty);
 	    	 ip.enter_name("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhffhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhff ");
 	    	 ip.enter_phone_number(" 545435345435435345345435435534543534545435345435435345345435435534543534545435345435435345345435435534543534545435345435435345345435435534543534545435345435435345345435435534543534545435345435435345345435435534543534545435345435435345345435435534543534545435345435435345345435435534543534545435345435435345345435435534543534");
 	    	 ip.enter_email("dsfddgfdgdfgffffffffffffffffffffffffffffffffff@test.com");
 	    	 ip.click_ccpayment();
 			 ip.click_placeOrder();
 	    	
 	    	if(ip.get_dialog_box_text().split("!")[0].equals("Thank you for your order")) {
 	    		Assert.assertEquals(true, false);
 	    	}
 	    	ip.close_dialog();
}
}
