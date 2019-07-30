package cigniti.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;

import cigniti.pages.basic_form_validation_po;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class basic_form_validation_steps {
	basic_form_validation_po formValidation = new basic_form_validation_po();

	@Given("^user is already on the Demo Form$")
	public void user_is_already_on_Form() throws Throwable {
		formValidation.getWebDriver().get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
	}

	@When("^user inputs the text as \"([^\"]*)\"$")
	public void user_inputs_the_text_as(String message) throws Throwable {
		formValidation.getMessageInputField().sendKeys(message);
	}

	@Then("^user clicks on the Show Message button$")
	public void user_clicks_on_the_Show_Message_button() throws Throwable {
		formValidation.getBtnShowMessage().click();
	}

	@Then("^user verifies the entered message$")
	public void user_verifies_the_entered_message() throws Throwable {
		Assert.assertFalse(formValidation.getLblMessage().isDisplayed());
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String firstNum, String secNum) throws Throwable {
		formValidation.getFirstInuptText().sendKeys(firstNum);
		formValidation.getSecondInuptText().sendKeys(secNum);
	}

	@Then("^user clicks on Show Total button$")
	public void user_clicks_on_Show_Total_button() throws Throwable {
		formValidation.getBtnTotal().click();
	}

	@Then("^user confirms the total of the digits$")
	public void user_confirms_the_total_of_the_digits() throws Throwable {
		Assert.assertTrue(formValidation.getLblTotal().isDisplayed());
	}

	@AfterStep
	public void afterStep(Scenario scenario) {
		try {
			final byte[] screenshot = ((TakesScreenshot) formValidation.getWebDriver())
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (ScreenshotException se) {
			se.getMessage();
		}
	}
}
