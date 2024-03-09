package org.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.Accounts_Payment_Pom;
import org.pom.Login_Page_Pom;
import org.testng.annotations.Test;

import reusableComponents.Reusable_Methods;

public class Login_And_Payment_Page_Validate extends Reusable_Methods {

	@Test(priority = 1)
	public void browserSetup() throws IOException {
		launchChromeBrowser();
		maximizeWindow();
		implicitWait(15);
		launchUrl(readProperty("Login Credentials", "URL"));

	}

	@Test(priority = 2, dependsOnMethods = "browserSetup")
	public void login() throws IOException {

		Login_Page_Pom login = new Login_Page_Pom();

		passValue(login.getUserName(), readProperty("Login Credentials", "UserName"));
		passValue(login.getPassword(), readProperty("Login Credentials", "Password"));
		clickButton(login.getLoginButton());

	}

	@Test(priority = 3, dependsOnMethods = "login")
	public void navigateToAccountsPaymentsPage() {
		Accounts_Payment_Pom account = new Accounts_Payment_Pom();

		List<WebElement> sideToggleList = account.getSideToggleList();
		String toggleToBeSelect = "Accounts";
		String OpenedMenuItemToBeSelect = "Payments";

		for (int i = 0; i < sideToggleList.size(); i++) {

			String toggleName = fetchBackText(sideToggleList.get(i));

			if (toggleName.equalsIgnoreCase(toggleToBeSelect)) {

				clickButton(sideToggleList.get(i));

				System.out.println("\n" + toggleToBeSelect + " is Successfully Selected");

				List<WebElement> openedToggleList = account.getOpenedToggleList();

				for (int j = 0; j < openedToggleList.size(); j++) {

					String openedMenuItem = fetchBackText(openedToggleList.get(j));

					if (openedMenuItem.equalsIgnoreCase(OpenedMenuItemToBeSelect)) {

						clickButton(openedToggleList.get(j));

						System.out.println(toggleToBeSelect + " " + OpenedMenuItemToBeSelect + " Page is Displayed\n");
						break;

					} else {
						System.out.println("Opened Toggle doesn't contains the " + OpenedMenuItemToBeSelect);
					}

				}
			}

		}

	}

	@Test(priority = 4, dependsOnMethods = "navigateToAccountsPaymentsPage")

	public void paymentNumberAndPaymentDateValidation() {

		Accounts_Payment_Pom payment = new Accounts_Payment_Pom();
		String paymentNo = fetchBackAttributeValue(payment.getPaymentNumber(), "value");

		if (paymentNo.isEmpty()) {
			System.out.println("Payment Number is Not Displayed");

		} else {
			System.out.println("Payment Number is Displayed\nPayment Number : " + paymentNo + "\n");

		}

		String paymentDate = fetchBackAttributeValue(payment.getPaymentDate(), "value");

		if (paymentDate.isEmpty()) {
			System.out.println("Payment Date is Not Displayed");

		} else {
			System.out.println("Payment Date is Displayed\nPayment Date : " + paymentDate + "\n");

		}

	}

	@Test(priority = 5, enabled = true)
	public void paymentForValidation() {
		Accounts_Payment_Pom payment = new Accounts_Payment_Pom();
		clickButton(payment.getPaymentFor());

		List<WebElement> paymentForList = payment.getPaymentForList();

		String PaymentForToBeSelect = "General Expense";

		for (int i = 0; i < paymentForList.size(); i++) {

			String paymentFor = fetchBackText(paymentForList.get(i));

			if (paymentFor.contains(PaymentForToBeSelect)) {
				clickButton(paymentForList.get(i));

				if (payment.getPageLoader().isDisplayed()) {

					try {
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
						wait.until(ExpectedConditions.invisibilityOf(payment.getPageLoader()));
					} catch (Exception e) {
						System.err.println("Page is Loading More than 15 Seconds");
					}
				}

				System.out.println("Payment For - " + paymentFor + "\n");
				break;
			}

		}

		if (!fetchBackText(payment.getPaymentFor()).equalsIgnoreCase(PaymentForToBeSelect)) {
			System.out.println(
					"Payment For is InValid.Payment For must be one of the Following 'General Expense' , 'Employee Expense'\nGiven Parameter Value : "
							+ PaymentForToBeSelect + "\n");
		}

	}

	@Test(priority = 6, enabled = true)
	public void paymentModeValidation() {
		Accounts_Payment_Pom payment = new Accounts_Payment_Pom();
		clickButton(payment.getPaymentMode());

		List<WebElement> paymentModeList = payment.getPaymentModeList();

		String PaymentModeToBeSelect = "CASH";

		for (int i = 0; i < paymentModeList.size(); i++) {

			String paymentMode = fetchBackText(paymentModeList.get(i));

			if (paymentMode.contains(PaymentModeToBeSelect)) {
				clickButton(paymentModeList.get(i));

				if (payment.getPageLoader().isDisplayed()) {

					try {
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
						wait.until(ExpectedConditions.invisibilityOf(payment.getPageLoader()));
					} catch (Exception e) {
						System.err.println("Page is Loading More than 15 Seconds");
					}
				}

				System.out.println("Payment Mode - " + paymentMode + "\n");
				break;
			}

		}

		if (!fetchBackText(payment.getPaymentFor()).equalsIgnoreCase(PaymentModeToBeSelect)) {
			System.out.println(
					"Payment Mode is Invalid.Payment Mode must be one of the followings - 'CASH', 'CHEQUE', 'DD', 'NEFT', 'UPI', 'RTGS', 'CARD'\nGiven Parameter Value : "
							+ PaymentModeToBeSelect + "\n");
		}

	}

	@Test(priority = 7, enabled = true)
	public void paymentModeType() {

		Accounts_Payment_Pom payment = new Accounts_Payment_Pom();

		String paymentMode = fetchBackText(payment.getPaymentMode());

		if (!paymentMode.equalsIgnoreCase("CASH")) {

			passValue(payment.getReferenceNumber(), "Test12323");

			if (paymentMode.equalsIgnoreCase("CHEQUE")) {
				passValue(payment.getBranchName(), "Test Branch Name");
			}

			clickButton(payment.getBankName());

			List<WebElement> bankNameList = payment.getBankNameList();

			String bankNameToBeSelect = "Hdfc";

			for (int j = 0; j < bankNameList.size(); j++) {

				String bankName = fetchBackText(bankNameList.get(j));

				if (bankName.contains(bankNameToBeSelect)) {
					clickButton(bankNameList.get(j));

					if (payment.getPageLoader().isDisplayed()) {

						try {
							WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
							wait.until(ExpectedConditions.invisibilityOf(payment.getPageLoader()));
						} catch (Exception e) {
							System.err.println("Page is Loading More than 15 Seconds");
						}
					}

				}

			}

		}

	}

	@Test(priority = 8, enabled = true)
	public void ledgerNameOrEmployeeNameValidate() {

		Accounts_Payment_Pom payment = new Accounts_Payment_Pom();

		if (fetchBackText(payment.getPaymentFor()).contains("General Expense")) {

			clickButton(payment.getLedgerName());

			List<WebElement> ledgerNameList = payment.getLedgerNameList();

			String ledgerToBeSelect = "Hosona";

			for (int i = 0; i < ledgerNameList.size(); i++) {

				String ledgerName = fetchBackText(ledgerNameList.get(i));

				if (ledgerName.contains(ledgerToBeSelect)) {
					clickButton(ledgerNameList.get(i));

					if (payment.getPageLoader().isDisplayed()) {

						try {
							WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
							wait.until(ExpectedConditions.invisibilityOf(payment.getPageLoader()));
						} catch (Exception e) {
							System.err.println("Page is Loading More than 15 Seconds");
						}
					}

					System.out.println("Ledger Name - " + ledgerName + "\n");
					break;
				}

			}

			if (!fetchBackText(payment.getLedgerName()).equalsIgnoreCase(ledgerToBeSelect)) {
				System.out.println("Ledger Name Data Mismatchs/ Not in List " + "\n" + "Given Parameter Value : "
						+ ledgerToBeSelect + "\n");
			}

		} else if (fetchBackText(payment.getPaymentFor()).contains("Employee Expense")) {

			clickButton(payment.getEmployeeName());

			List<WebElement> employeeNameList = payment.getEmployeeNameList();

			String employeeNameToBeSelect = "Rahul";

			for (int i = 0; i < employeeNameList.size(); i++) {

				String employeeName = fetchBackText(employeeNameList.get(i));

				if (employeeName.contains(employeeNameToBeSelect)) {
					clickButton(employeeNameList.get(i));

					if (payment.getPageLoader().isDisplayed()) {

						try {
							WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
							wait.until(ExpectedConditions.invisibilityOf(payment.getPageLoader()));
						} catch (Exception e) {
							System.err.println("Page is Loading More than 15 Seconds");
						}
					}

					System.out.println("Employee Name - " + employeeName + "\n");
					break;
				}

			}

			if (!fetchBackText(payment.getEmployeeName()).equalsIgnoreCase(employeeNameToBeSelect)) {
				System.out.println(
						"employee Name Data Mismatchs/ Not in List\nParameter Value :" + employeeNameToBeSelect);
			}

		}
	}

	@Test(priority = 9, enabled = true)
	public void companyLedgerValidate() {

		Accounts_Payment_Pom payment = new Accounts_Payment_Pom();

		clickButton(payment.getCompanyLedger());

		List<WebElement> companyLedgerList = payment.getCompanyLedgerList();

		String companyLedgerToBeSelect = "Global";

		for (int i = 0; i < companyLedgerList.size(); i++) {

			String companyLedger = fetchBackText(companyLedgerList.get(i));

			if (companyLedger.contains(companyLedgerToBeSelect)) {
				clickButton(companyLedgerList.get(i));

				if (payment.getPageLoader().isDisplayed()) {

					try {
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
						wait.until(ExpectedConditions.invisibilityOf(payment.getPageLoader()));
					} catch (Exception e) {
						System.err.println("Page is Loading More than 15 Seconds");
					}
				}

				System.out.println("Company Ledger - " + companyLedger + "\n");
				break;
			}

		}

		if (!fetchBackText(payment.getCompanyLedger()).equalsIgnoreCase(companyLedgerToBeSelect)) {
			System.out.println(
					"Company Ledger Data Mismatchs/Not in List\nParameter Value :" + companyLedgerToBeSelect + "\n");
		}

	}

	@Test(dependsOnMethods = "companyLedgerValidate", enabled = true)
	public void amountAndRemarks() {

		Accounts_Payment_Pom payment = new Accounts_Payment_Pom();

		String pendingBalance = fetchBackText(payment.getPendingBalance());

		if (pendingBalance.isEmpty()) {
			System.err.println("Employee / Ledger is Not Valid");

		} else {
			double pending = Double.parseDouble(pendingBalance);

			double amount = 75.20;

			if (amount > pending) {
				System.err.println("Input Amount is Greater than Pending Balance. So Amount Field as Empty\n"
						+ "Parameter Value : " + amount);
			} else {

				passValue(payment.getAmount(), amount);

			}

		}

		passValue(payment.getRemarks(), "No Remarks");
	}

}
