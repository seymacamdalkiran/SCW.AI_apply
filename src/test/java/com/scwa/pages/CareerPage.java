package com.scwa.pages;

import com.scwa.utilities.BrowserUtils;
import com.scwa.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage{
    @FindBy(xpath = "//h2[contains(text(),'Open Positions')]")
    public WebElement openPozitions;
    @FindBy(xpath = "//span[text()='Apply for This Job']")
    public WebElement applyForThisJob;
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement eMail;
    @FindBy(id = "phone")
    public WebElement phone;
    @FindBy(id = "streetAddress")
    public WebElement address;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "state")
    public WebElement province;
    @FindBy(id = "zip")
    public WebElement postalCode;
    @FindBy(xpath = "//div[@class='fab-SelectToggle__content']")
    public WebElement country;
    /* */
    @FindBy(xpath = "(//input[@type='file'])[2]")
    public WebElement addResume;
    @FindBy(css = "#dateAvailable")
    public WebElement dataAvailable;
    @FindBy(css = "#linkedinUrl")
    public WebElement linkedinUrl;
    @FindBy(css = "#websiteUrl")
    public WebElement websiteUrl;
    @FindBy(xpath = "//textarea[@id='customQuestions[338]']")
    public WebElement whyInterest;
    @FindBy(xpath = "//textarea[@id='customQuestions[339]']")
    public WebElement intershipExperience;
    @FindBy(xpath = "//span[text()='Submit Application']")
    public WebElement submitApplication;
    @FindBy(xpath = "//p[@class='jss-e94']")
    public WebElement succeedMessage;

    public void chooseCareerMenu(String menu){
        Driver.get().findElement(By.xpath("(//a[text()='"+menu+"'])[1]")).click();
    }
    public void chooseJob(String job){
        BrowserUtils.waitFor(3);
        JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
        jse.executeScript("window.scrollBy(0,3000)");
        WebElement jobb = Driver.get().findElement(By.xpath("//a[contains(text(),'" + job + "')]"));
        BrowserUtils.clickWithJS(jobb);
    }
    public void fillApplyForThisPositionList(String firstname,String lastname,String email,String phoone,String adress,String cityy,String provincee,String postalcode,String countryy,String date){
        Actions actions=new Actions(Driver.get());
        firstName.click();
        actions
                .sendKeys(firstname+Keys.TAB)
                .sendKeys(lastname+Keys.TAB)
                .sendKeys(email+Keys.TAB)
                .sendKeys(phoone+Keys.TAB)
                .sendKeys(adress+Keys.TAB)
                .sendKeys(cityy+Keys.TAB)
                .sendKeys(provincee+Keys.TAB)
                .sendKeys(postalcode+Keys.TAB)
                .perform();
        actions.click(country)
                .sendKeys(countryy)
                .click().perform();
        BrowserUtils.clickWithJS(dataAvailable);
        dataAvailable.sendKeys(date);
    }
    public void addResume(){
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/SeymaDalkiranCam.pdf";
        String fullPath = projectPath + "/" + filePath;
        addResume.sendKeys(fullPath);
    }
    public void yesOrNo(String accept){
        WebElement element = Driver.get().findElement(By.xpath("//label[text()='" + accept + "']"));
        BrowserUtils.clickWithJS(element);
    }
    public void validateSucceedMessage(String message){
        BrowserUtils.waitFor(5);
        Assert.assertEquals(succeedMessage.getText(), message);
    }
}
