package com.sample.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Index_page {
	WebDriver driver;
	 public Index_page(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	
 	@FindBy(id = "reset")
	private WebElement reset;
 	
	@FindBy(id = "pizza1Pizza")
	private WebElement elem_pizza;
	
	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
	private WebElement elem_topping1;
	
	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']")
	private WebElement elem_topping2;
	
	@FindBy(id = "pizza1Qty")
	private WebElement pizza_qty;
	
	@FindBy(id = "pizza1Cost")
	private WebElement pizza_cost;
	
	
	@FindBy(id = "name")
	private WebElement name;
	
	
	@FindBy(id = "email")
	private WebElement email;
	
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(xpath = "//div[@id='dialog']/p")
	private WebElement dialog_text;
	
	@FindBy(id = "placeOrder")
	private WebElement placeOrder;
	
	@FindBy(id = "ccpayment")
	private WebElement ccpayment;
	
	
	@FindBy(id = "ccpayment")
	private WebElement cashpayment;
	
	@FindBy(xpath = ".//*[@class='ui-button-icon ui-icon ui-icon-closethick']")
	private WebElement close;
	
	

  public void click_ccpayment() {
	  ccpayment.click();
  }
  
  public void click_cashpayment() {
	  cashpayment.click();
  }
  
  public void click_placeOrder() {
	  placeOrder.click();
  }
  
  public boolean isselected_ccpayment() {
	  return ccpayment.isSelected();
  }
  
  public boolean isselected_cashpayment() {
	  return cashpayment.isSelected();
  }
  
  public void enter_phone_number(String value) {
	  phone.sendKeys(value);
  }
  
  public String get_phone_number() {
	  return phone.getText();
  }
  
  public void enter_name(String value) {
	  name.sendKeys(value);
  }
  
  public String get_name() {
	  return name.getText();
  }
  
  public void enter_email(String value) {
	  email.sendKeys(value);
  }
  
  public String get_email() {
	  return email.getText();
  }
  
  public void enter_pizza_qty(String value) {
	  pizza_qty.sendKeys(value);
  }
  
  public String get_pizza_qty() {
	  return pizza_qty.getAttribute("value");
  }
  public void select_pizza(String value) {
	  Select select_p = new Select(elem_pizza);
	  select_p.selectByValue(value);
  }
  
  public void select_pizza_topping1(String value) {
	  Select select_top1 = new Select(elem_topping1);
	  select_top1.selectByValue(value);
  }
  
  public void select_pizza_topping2(String value) {
	  Select select_top2 = new Select(elem_topping2);
	  select_top2.selectByValue(value);
  }
  
  public String get_cost_value() {
	  return pizza_cost.getAttribute("value");
  }

  public String get_dialog_box_text() {
	  return dialog_text.getText();
  }

  public void close_dialog() {
	  close.click();
  }
  
  public void reset() {
	  reset.click();
  }
}
