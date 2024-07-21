/**
 * 
 */
package com.para.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.time.Duration;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankOpenAccountPage {

	@FindBy(id = "fromAccountId")
	private WebElement fromAccountIdSelectOne;

	@FindBy(id = "type")
	private WebElement typeSelectOne;

	@FindBy(css = "input[value='Open New Account']")
	private WebElement openNewAccountButton;

	@FindBy(linkText = "Transfer Funds")
	private WebElement transferFundsLink;

	private WebDriver driver;

	private static final Duration DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = Duration.ofSeconds(15);

	public ParaBankOpenAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebElement waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		return wait.until(elementToBeClickable(element));
	}

	private WebElement scrollTo(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		return element;
	}

	protected WebElement click(WebElement element) {
		WebElement webElement = scrollTo(waitFor(element));
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		return wait.ignoring(ElementClickInterceptedException.class).until(webDriver -> {
			webElement.click();
			return webElement;
		});
	}

	public void selectFromAccountIdSelectOne(String text) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(webdriver -> new Select(fromAccountIdSelectOne).getOptions().stream()
				.anyMatch(element -> text.equals(element.getText())));
		Select dropdown = new Select(fromAccountIdSelectOne);
		dropdown.selectByVisibleText(text);
	}

	public void selectTypeSelectOne(String text) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(webdriver -> new Select(typeSelectOne).getOptions().stream()
				.anyMatch(element -> text.equals(element.getText())));
		Select dropdown = new Select(typeSelectOne);
		dropdown.selectByVisibleText(text);
	}

	public void clickOpenNewAccountButton() {
		click(openNewAccountButton);
	}

	public void clickTransferFundsLink() {
		click(transferFundsLink);
	}

}