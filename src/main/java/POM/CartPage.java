package POM;


import Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass {
     WebDriver driver;


    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='chkot-ftr-prc']//span[@data-label='total-minicart']")
    private WebElement checkSubTotalPrice;

    @FindBy(xpath = "//button[@data-label='miniCartCheckout']")
    private WebElement checkOutBtn;

    @FindBy(xpath = "//div[@class='txt--wrpr']//span[@class='rupee']")
    private WebElement placeSubTotalPrice;

    private Double sub;

    public void subPrice(){
        String checkSubPrice = checkSubTotalPrice.getText();
        this.sub = Double.parseDouble(checkSubPrice);
    }
    public void clickCheckOut(){
        checkOutBtn.click();
    }
    public boolean verifyAmount(){
        String placeSubPrice = placeSubTotalPrice.getText();
        Double placePrice = Double.parseDouble(placeSubPrice);
        boolean priceEquals;

        if (sub==placePrice){
            priceEquals = false;
        }else {
            priceEquals = true;
        }
        return priceEquals;
    }
}
