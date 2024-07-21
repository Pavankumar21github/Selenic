/**
 * 
 */
package com.para;

import com.para.page.ParaBankAccountsOverviewPage;
import com.para.page.ParaBankBillPayPage;
import com.para.page.ParaBankBillPaymentCompletePage;
import com.para.page.ParaBankOpenAccountPage;
import com.para.page.ParaBankTransferFundsPage;
import com.para.page.ParaBankWelcomeOnlineBankingPage;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ParaBankTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANKV2_BASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANKV2_BASE_URL", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANKV2_BASE_URL = "https://parabank.parasoft.com";

	private WebDriver driver;


	@BeforeEach
	public void beforeTest() {
		//ChromeOptions opts = new ChromeOptions();
		FirefoxOptions firefoxOpts = new FirefoxOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.managed_default_content_settings.geolocation", 2);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		//opts.setExperimentalOption("prefs", prefs);
		firefoxOpts.addArguments("--start-maximized");
		firefoxOpts.addArguments("--incognito");
		firefoxOpts.addArguments("--enable-strict-powerful-feature-restrictions");
		//driver = new ChromeDriver(opts);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterEach
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Name: SelfHealing
	 * Recording file: SelfHealing.json
	 *
	 * Parasoft recorded Selenium test on Fri May 24 2024 09:41:47 GMT+0530 (India Standard Time)
	 */
	@Test
	public void testSelfHealing() throws Throwable {
		driver.get(
				System.getProperty("PARABANKV2_BASE_URL", PARABANKV2_BASE_URL) + "/parabankv2/index.htm?ConnType=JDBC");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameText("john");
		paraBankWelcomeOnlineBankingPage.setPassword("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInSubmit();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickOpenNewAccountLink();

		ParaBankOpenAccountPage paraBankOpenAccountPage = new ParaBankOpenAccountPage(driver);
		paraBankOpenAccountPage.selectFromAccountIdSelectOne("12456");
		paraBankOpenAccountPage.selectTypeSelectOne("SAVINGS");
		paraBankOpenAccountPage.clickOpenNewAccountButton();
		paraBankOpenAccountPage.clickTransferFundsLink();

		ParaBankTransferFundsPage paraBankTransferFundsPage = new ParaBankTransferFundsPage(driver);
		paraBankTransferFundsPage.setInputText("200");
		paraBankTransferFundsPage.selectFromAccountIdSelectOne("12900");
		paraBankTransferFundsPage.selectToAccountIdSelectOne("12789");
		paraBankTransferFundsPage.clickTransferSubmit();
		paraBankTransferFundsPage.clickBillPayLink();

		ParaBankBillPayPage paraBankBillPayPage = new ParaBankBillPayPage(driver);
		paraBankBillPayPage.setPayeeNameText("chris");
		paraBankBillPayPage.clickTd();
		paraBankBillPayPage.setPayeeAddressStreetText("101 east huntington");
		paraBankBillPayPage.setPayeeAddressCityText("monrovia");
		paraBankBillPayPage.setPayeeAddressStateText("california");
		paraBankBillPayPage.setPayeeAddressZipCodeText("91016");
		paraBankBillPayPage.setPayeeContactInformationPhoneNumberText("09513087273");
		paraBankBillPayPage.setPayeeContactInformationEmailText("admin@admin.com");
		paraBankBillPayPage.setPayeeAccountNumberText("12345");
		paraBankBillPayPage.setVerifyAccountText("12345");
		paraBankBillPayPage.setAmountText("100");
		paraBankBillPayPage.selectFromAccountIdSelectOne("13566");
		paraBankBillPayPage.clickSendPaymentButton();

		ParaBankBillPaymentCompletePage paraBankBillPaymentCompletePage = new ParaBankBillPaymentCompletePage(driver);
		paraBankBillPaymentCompletePage.clickLogOutLink();
	}

}