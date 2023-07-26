package com.scwa.stepDefs;

import com.scwa.pages.CareerPage;
import com.scwa.utilities.BrowserUtils;
import com.scwa.utilities.ConfigurationReader;
import com.scwa.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Career_StepDefs {
    CareerPage careerPage = new CareerPage();

    @Given("The user should be on the scwaı page")
    public void the_user_should_be_on_the_scwaı_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @Then("Validate the correct page")
    public void validate_the_correct_page() {
        String actualUrl = Driver.get().getCurrentUrl();
        String expectedUrl = ConfigurationReader.get("url");
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @Given("The user click the {string} menu")
    public void the_user_click_the_menu(String menu) {
        careerPage.chooseScwaMenu(menu);
    }

    @When("The user choose the {string} menu")
    public void the_user_choose_the_menu(String menu) {
        careerPage.chooseCareerMenu(menu);
    }
    @Then("Validate the correct menu")
    public void validate_the_correct_menu() {
        Assert.assertTrue(careerPage.openPozitions.isDisplayed());
    }
    @Then("The user should choose {string} job")
    public void the_user_should_choose_job(String job) {
        careerPage.chooseJob(job);
    }
    @Then("The user should apply for job")
    public void the_user_should_apply_for_job() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(careerPage.applyForThisJob);
    }
    @Then("The user should fill the apply for this position list with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_should_fill_the_apply_for_this_position_list_with(String firstname, String lastName, String email, String phone, String address, String city, String province, String postalCode, String country, String date) {
        careerPage.fillApplyForThisPositionList(firstname, lastName, email, phone, address, city, province, postalCode, country, date);
    }
    @Then("The user should add the resume")
    public void the_user_should_add_the_resume() {
        careerPage.addResume();
    }
    @And("The user should add the github url {string}")
    public void theUserShouldAddTheGithubUrl(String github) {
        careerPage.websiteUrl.sendKeys(github);
    }
    @Then("The user should add the linkedin profile url {string}")
    public void the_user_should_add_the_linkedin_profile_url(String linkedin) {
        careerPage.linkedinUrl.sendKeys(linkedin);
    }
    @Then("What has peeked your interest about this particular internship?")
    public void what_has_peeked_your_interest_about_this_particular_internship() {
        careerPage.whyInterest.sendKeys("The opportunity to gain practical experience and learn from industry experts.");
    }
    @Then("What is your availability for an internship experience \\(i.e. ideal start and duration)?")
    public void what_is_your_availability_for_an_internship_experience_i_e_ideal_start_and_duration() {
        careerPage.intershipExperience.sendKeys("Available for a 4-month internship starting immediately.");
    }
    @Then("The user should chose {string}")
    public void the_user_should_chose(String accept) {
        careerPage.yesOrNo(accept);
    }
    @Then("The user should submit application")
    public void the_user_should_submit_application() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(careerPage.submitApplication);
    }
    @Then("The user should see {string} message")
    public void the_User_Should_See_Message(String message) {
       careerPage.validateSucceedMessage(message);
    }
}
