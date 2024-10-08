package POM;

import Base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectItems extends BaseClass {
    WebDriver driver;
    JavascriptExecutor js;

    public SelectItems(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@data-label='Add button']")
    private WebElement NoThanks;

    @FindBy(xpath = "//div[@class='mn-hdr active']")
    private WebElement vegPizza;

    @FindBy(xpath = "//div[@class='sc-bbmXgH hIcxaF']//div[@data-label='Veg Pizza']")
    private WebElement vegPizzaSec;

    @FindBy(xpath = "//div[@data-label='Veg Pizza']//span[text()='Margherita']//parent::div//parent::div//button")
    private WebElement margheritAddCartBtn;

    @FindBy(xpath = "//div[@class='crt-itms']//div[@data-label='quantity']//div[@data-label='increase']")
    private WebElement margheritaIncBtn;

    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Veg Pizza']//span[text()='Peppy Paneer']//parent::div//parent::div//button")
    private WebElement peppPannerAddCartBtn;

    @FindBy(xpath = "//button[@class='btn--gry']//span[text()='NO THANKS']")
    private WebElement noThanks;

    @FindBy(xpath = "//div[@data-label='Veg Pizza']//div[@data-label='Peppy Paneer']//div[@data-label='increase']")
    private WebElement peppPannerIncBtn;

    @FindBy(xpath = "//div[@data-label='Veg Pizza']//span[text()='Farmhouse']//parent::div//parent::div//button")
    private WebElement farmhouseAddCartBtn;

    @FindBy(xpath = "//div[@data-label='Veg Pizza']//span[text()='Farmhouse']//parent::div//parent::div//div[@data-label='increase']")
    private WebElement farmhouseIncBtn;

    @FindBy(xpath = "//span[text()='Margherita']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement margheritaTotalPrice;

    @FindBy(xpath = "//span[text()='Peppy Paneer']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement peppPannerTotalprice;

    @FindBy(xpath = "//span[text()='Farmhouse']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement farmhouseTotalPrice;

    @FindBy(xpath = "//span[@class='rupee sb-ttl']")
    private WebElement subTotalPrice;

    @FindBy(xpath = "//div[@data-label='Beverages']//span[text()='BEVERAGES']")
    private WebElement beverages;

    @FindBy(xpath = "//div[@data-label='Beverages']//span[text()='Pepsi 475ml']//parent::div//parent::div//button")
    private WebElement pepsiAddCartBtn;

    @FindBy(xpath = "//div[@data-label='Beverages']//span[text()='Pepsi 475ml']//parent::div//parent::div//div[@data-label='increase']")
    private WebElement pepsiIncBtn;

    @FindBy(xpath = "//span[text()='Pepsi 475ml']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement pepsiTotalprice;

    @FindBy(xpath = "//div[@data-label='Veg Pizza']//span[text()='Margherita']//parent::div//parent::div//div[@data-label='decrease']")
    private WebElement margheritaDecBtn;

    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Beverages']//span[text()='Pepsi 475ml']//parent::div//parent::div//div[@data-label='decrease']")
    private WebElement pepsiDecBtn;

    @FindBy(xpath = "//span[text()='Pepsi 475ml']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//div//div//span")
    private WebElement pepsiQtyNo;

    public void addMargherita() throws InterruptedException {
        vegPizza.click();
        Thread.sleep(5000);
        js.executeScript("arguments[0].click();",margheritAddCartBtn);
        js.executeScript("arguments[0].click();", noThanks);
        margheritaIncBtn.click();
    }
    public void addPeppyPanner() throws InterruptedException {
        Thread.sleep(3000);
        peppPannerAddCartBtn.click();
        peppPannerIncBtn.click();
    }
    public void addFarmHouse(){
        farmhouseAddCartBtn.click();
        farmhouseIncBtn.click();
    }
    public boolean totalofpizza(){
        String sub = subTotalPrice.getText();
        String marg = margheritaTotalPrice.getText();
        String peppPan = peppPannerTotalprice.getText();
        String farm = farmhouseTotalPrice.getText();

        double margPrice = Double.parseDouble(marg);
        double peppPanPrice = Double.parseDouble(peppPan);
        double farmPrice = Double.parseDouble(farm);
        double totalPrice = margPrice+peppPanPrice+farmPrice;
        double subPrice = Double.parseDouble(sub);
        boolean equals;

        if (totalPrice==subPrice){
            equals = true;
        }else {
            equals = false;
        }
        return equals;
    }
    public void addPepsi(){
        beverages.click();
        pepsiAddCartBtn.click();
        String pepsiQuantity = pepsiQtyNo.getText();

        int pepQty = Integer.parseInt(pepsiQuantity);
        int i=0;
        int targetQuantity = 12;

        while (pepQty<targetQuantity){
            pepsiIncBtn.click();
            i++;
            pepsiQuantity = pepsiQtyNo.getText();
            pepQty = Integer.parseInt(pepsiQuantity);
        }
    }
    public boolean allProductPrice(){
        String sub = subTotalPrice.getText();
        String marg = margheritaTotalPrice.getText();
        String peppPan = peppPannerTotalprice.getText();
        String farm = farmhouseTotalPrice.getText();
        String peps = pepsiTotalprice.getText();

        double margPrice = Double.parseDouble(marg);
        double peppPanPrice = Double.parseDouble(peppPan);
        double farmpPrice = Double.parseDouble(farm);
        double pepsPrice = Double.parseDouble(peps);
        double totalPrice = margPrice+peppPanPrice+farmpPrice+pepsPrice;
        double subPrice = Double.parseDouble(sub);

        boolean equals;

        if (totalPrice==subPrice){
            equals = true;
        }else {
            equals = false;
        }
        return equals;
    }
    public void remMargpizza(){
        vegPizza.click();
//        margheritaDecBtn.click();
        js.executeScript("arguments[0].click;",margheritaDecBtn);
    }
    public void remPepsi(){
        beverages.click();
        String pepsiQuantity = pepsiQtyNo.getText();

        int pepQty = Integer.parseInt(pepsiQuantity);
        int i=0;
        int targetQuantity = 6;

        while (pepQty>targetQuantity){
            pepsiDecBtn.click();
            i++;
            pepsiQuantity = pepsiQtyNo.getText();
            pepQty = Integer.parseInt(pepsiQuantity);
        }
    }

}
