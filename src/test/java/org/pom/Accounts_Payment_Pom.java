package org.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.Reusable_Methods;

public class Accounts_Payment_Pom extends Reusable_Methods {

	public Accounts_Payment_Pom() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='pageloader']//child::img")
	private WebElement PageLoader;

	@FindBy(xpath = "//a[@class='menu-link  menu-toggle ']//child::div")
	private List<WebElement> sideToggleList;

	@FindBy(xpath = "//li[@class='menu-item open']//child::ul//child::li")
	private List<WebElement> openedToggleList;

	@FindBy(xpath = "//input[@id='txtPaymentCode']")
	private WebElement paymentNumber;

	@FindBy(xpath = "//input[@id='ddlPaymentDate']")
	private WebElement paymentDate;

	@FindBy(xpath = "//span[@id='select2-ddlPaymentFor-container']")
	private WebElement paymentFor;

	@FindBy(xpath = "//ul[@id='select2-ddlPaymentFor-results']//child::li")
	private List<WebElement> paymentForList;

	@FindBy(xpath = "//span[@id='select2-ddlPaymentMode-container']")
	private WebElement paymentMode;

	@FindBy(xpath = "//ul[@id='select2-ddlPaymentMode-results']//child::li")
	private List<WebElement> paymentModeList;

	@FindBy(xpath = "//span[@id='select2-ddlLedgerName-container']")
	private WebElement ledgerName;

	@FindBy(xpath = "//ul[@id='select2-ddlLedgerName-results']//child::li")
	private List<WebElement> ledgerNameList;

	@FindBy(xpath = "//span[@id='select2-ddlEmployeeName-container']")
	private WebElement employeeName;

	@FindBy(xpath = "//ul[@id='select2-ddlEmployeeName-results']//child::li")
	private List<WebElement> employeeNameList;

	@FindBy(xpath = "//span[@id='select2-ddlCompanyLedger-container']")
	private WebElement companyLedger;

	@FindBy(xpath = "//ul[@id='select2-ddlCompanyLedger-results']//child::li")
	private List<WebElement> companyLedgerList;

	@FindBy(xpath = "//input[@id='txtAmount']")
	private WebElement amount;

	@FindBy(xpath = "//span[@id='employeeClosingBalance']")
	private WebElement pendingBalance;

	@FindBy(xpath = "//input[@id='txtChequeNo']")
	private WebElement referenceNumber;

	@FindBy(xpath = "//input[@id='txtTransDate']")
	private WebElement transactionDate;

	@FindBy(xpath = "//input[@id='txtBranchName']")
	private WebElement BranchName;

	@FindBy(xpath = "//span[@id='select2-ddlBankName-container']")
	private WebElement BankName;

	@FindBy(xpath = "//ul[@id='select2-ddlBankName-results']//child::li")
	private List<WebElement> BankNameList;

	@FindBy(xpath = "//input[@id='txtRemarks']")
	private WebElement remarks;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancel;

	@FindBy(xpath = "//button[text()='Go to List']")
	private WebElement goToList;

	public WebElement getPageLoader() {
		return PageLoader;
	}

	public List<WebElement> getSideToggleList() {
		return sideToggleList;
	}

	public List<WebElement> getOpenedToggleList() {
		return openedToggleList;
	}

	public WebElement getPaymentNumber() {
		return paymentNumber;
	}

	public WebElement getPaymentDate() {
		return paymentDate;
	}

	public WebElement getPaymentFor() {
		return paymentFor;
	}

	public List<WebElement> getPaymentForList() {
		return paymentForList;
	}

	public WebElement getPaymentMode() {
		return paymentMode;
	}

	public List<WebElement> getPaymentModeList() {
		return paymentModeList;
	}

	public WebElement getReferenceNumber() {
		return referenceNumber;
	}

	
	public WebElement getBranchName() {
		return BranchName;
	}


	public WebElement getTransactionDate() {
		return transactionDate;
	}

	public WebElement getBankName() {
		return BankName;
	}

	public List<WebElement> getBankNameList() {
		return BankNameList;
	}

	public WebElement getLedgerName() {
		return ledgerName;
	}

	public List<WebElement> getLedgerNameList() {
		return ledgerNameList;
	}

	public WebElement getEmployeeName() {
		return employeeName;
	}

	public List<WebElement> getEmployeeNameList() {
		return employeeNameList;
	}

	public WebElement getCompanyLedger() {
		return companyLedger;
	}

	public List<WebElement> getCompanyLedgerList() {
		return companyLedgerList;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getPendingBalance() {
		return pendingBalance;
	}

	public WebElement getRemarks() {
		return remarks;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getCancel() {
		return cancel;
	}

	public WebElement getGoToList() {
		return goToList;
	}

}
