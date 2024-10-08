package POM;


import Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pincode extends BaseClass {
     WebDriver driver;

     public Pincode (WebDriver driver){
         this.driver = driver;
         PageFactory.initElements(driver,this);
     }
     @FindBy(xpath ="//button[text()='ORDER ONLINE NOW']")
     private WebElement orderOnlineBtn;

     @FindBy(xpath = "//button[@id='moe-dontallow_button']")
     private WebElement dontAllow;

     @FindBy(xpath = "//input[@placeholder='Enter your delivery address']")
     private WebElement addressField;

     @FindBy(xpath = "//input[@placeholder='Enter Area / Locality']")
     private WebElement pincodeField;

     @FindBy(xpath = "//div[@class='sc-fBuWsC eMOfwp']//ul//li[1]")
     private WebElement firstSuggestion;

     public void clickOrderOnBtn() throws InterruptedException {
         Thread.sleep(2000);
         orderOnlineBtn.click();
     }
     public void clickAddField() throws InterruptedException {
         Thread.sleep(2000);
         dontAllow.click();
         Thread.sleep(2000);
         addressField.click();
     }
     public void addPincode(String pin) throws InterruptedException {
         Thread.sleep(2000);
         pincodeField.sendKeys(pin);
     }
     public void clickOnFirstArea() throws InterruptedException {
         Thread.sleep(2000);
         firstSuggestion.click();
     }
}
