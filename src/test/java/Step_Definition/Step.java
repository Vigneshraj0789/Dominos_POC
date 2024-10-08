package Step_Definition;


import Base.BaseClass;
import POM.CartPage;
import POM.Pincode;
import POM.SelectItems;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Step extends BaseClass {

    SelectItems selectItems;
    CartPage cartPage;
    Pincode pincode;

    @Given("Launch {string} Browser and URL {string}")
    public void launchBrowserAndURL(String browser, String url) {
      BaseClass.initiliazeBrowser(browser);
      BaseClass.windowMaximize();
      BaseClass.openApp(url);
      BaseClass.implicitWait();
      selectItems = new SelectItems(driver);
      cartPage = new CartPage(driver);
      pincode = new Pincode(driver);
    }
    @When("User Clicks on Order Online now Button")
    public void userClicksOnOrderOnlineNowButton() throws InterruptedException {
       pincode.clickOrderOnBtn();
    }
    @When("User Enter Pincode {string}")
    public void userEnterPincode(String pCode) throws InterruptedException {
       pincode.clickAddField();
       pincode.addPincode(pCode);
    }
    @When("User Selects the First Suggestion Area")
    public void userSelectsTheFirstSuggestionArea() throws InterruptedException {
       pincode.clickOnFirstArea();
    }
    @Then("User Should Navigate to Product Page")
    public void userShouldNavigateToProductPage() {
       String url = driver.getCurrentUrl();
       System.out.println(url);
    }
    @When("User Adds Two Quantity of Margherita Pizza")
    public void userAddsTwoQuantityOfMargheritaPizza() throws InterruptedException {
        selectItems.addMargherita();
    }
    @When("User Adds Two Quantity of Peppy Panner Pizza")
    public void userAddsTwoQuantityOfPeppyPannerPizza() throws InterruptedException {
        selectItems.addPeppyPanner();
    }
    @When("User Adds Two Quantity of Farmhouse Pizza")
    public void userAddsTwoQuantityOfFarmhousePizza() {
        selectItems.addFarmHouse();
    }
    @When("User Verifies Subtotal Value and Sum of all Pizza Value are same")
    public void userVerifiesSubtotalValueAndSumOfAllPizzaValueAreSame() {
        Assert.assertTrue(selectItems.totalofpizza());
    }
    @When("User Adds Twelve Quantities of Pepsi")
    public void userAddsTwelveQuantitiesOfPepsi() {
        selectItems.addPepsi();
    }
    @When("User Verifies Subtotal Value and Sum of all Product Value are same")
    public void userVerifiesSubtotalValueAndSumOfAllProductValueAreSame() throws InterruptedException {
        selectItems.allProductPrice();
        Thread.sleep(2000);
        Assert.assertTrue(selectItems.allProductPrice());

    }
    @When("User Removes One Quantity of Margherita Pizza")
    public void userRemovesOneQuantityOfMargheritaPizza() {
        selectItems.remMargpizza();
    }
    @When("User Removes Six Quantities of Pepsi")
    public void userRemovesSixQuantitiesOfPepsi() {
        selectItems.remPepsi();
    }
    @When("User Clicks on Checkout")
    public void userClicksOnCheckout() {
         cartPage.subPrice();
         cartPage.clickCheckOut();
    }
    @When("User Verifies The Checkout Subtotal and Place order Subtotal are same")
    public void userVerifiesTheCheckoutSubtotalAndPlaceOrderSubtotalAreSame() {
         Assert.assertTrue(cartPage.verifyAmount());
    }
    @Then("User Quit Browser")
    public void userQuitBrowser() {
         quitBrowser();
    }

}
