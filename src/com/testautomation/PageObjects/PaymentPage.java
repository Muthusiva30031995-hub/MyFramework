package com.testautomation.PageObjects;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.PaymentPageUI;

public class PaymentPage extends PageBase{

	public PaymentPage(InstanceContainer ic) {
		super(ic);		
	}
	
	
	//Standard Check payment
	public void standardCheckPayment(String paymentMethod, String reserveLine) throws Exception
	{
		String payeeName = excelData.getData("PayeeName");		
		String accountNumber = excelData.getCommonData("AccountNumber");
		String routingNumber = 	excelData.getCommonData("RoutingNumber");	
		String paymentType = excelData.getData("PaymentType");
		String lineItemsCategory = excelData.getData("LineItemsCategory") ;				
		String lineItemsAmount = excelData.getData("LineItemsAmount");		
		String invoice = excelData.getCommonData("Invoice");
		
		wh.clickElement(PaymentPageUI.financialLink, "Financial Link");
		wh.clickElement(PaymentPageUI.actionLink, "Action Link");
		wh.waitForElementPresent(PaymentPageUI.newTransaction);
		wh.clickElement(PaymentPageUI.standardCheckLink, "Standard check Link");
		
		//Entering details in Step 1 of 3 payment page
		if(wh.isElementPresent(PaymentPageUI.payeeNameList)) {		
		wh.selectDropDownValue(PaymentPageUI.payeeNameList, payeeName,"Payee name");
		
			if(paymentMethod.equalsIgnoreCase("Check"))
			{
				wh.waitForElementPresent(PaymentPageUI.paymentMethodList);
				wh.selectDropDownValue(PaymentPageUI.paymentMethodList, paymentMethod,"Payment Method");			
				
			}
			
			else if(paymentMethod.equalsIgnoreCase("Electronic funds transfer")) {
				wh.waitForElementPresent(PaymentPageUI.paymentMethodList);
				wh.selectDropDownValue(PaymentPageUI.paymentMethodList, paymentMethod,"Payment Method"); 				
				wh.clickWebButton(PaymentPageUI.accountType,"Checking Radio Button");
				wh.enterValue(PaymentPageUI.accountNumber, accountNumber,"Account Number");
				WebElement bankName = driver.findElement(By.xpath("//input[contains(@name,'EFTDataInputSet-BankName')]"));
				wh.clickElement(bankName);
//				int routingNumber = getRandomRoutingNum();
//				String routingNumb = String.valueOf(routingNumber);						
				wh.enterValue(PaymentPageUI.routingNumber, routingNumber,"Routing Number");			
				wh.clickElement(bankName);
			}
			
				//Clicking on Next button in Step 1 of 3
				for(int i=0;i<3;i++) {				
					if(wh.isElementExists(PaymentPageUI.nextBtn))	{			
						wh.clickElement(PaymentPageUI.nextBtn, "Step 1of 3 Next Button");
						Thread.sleep(2000);
					}
				}
			
			wh.waitForElementPresent(PaymentPageUI.reserveLineList); 			
			wh.selectDropDownValue(PaymentPageUI.reserveLineList, reserveLine,"Reserve line");			
			wh.waitForElementPresent(PaymentPageUI.paymentTypeList);
			wh.selectDropDownValue(PaymentPageUI.paymentTypeList, paymentType, invoice);			
			wh.waitForElementPresent(PaymentPageUI.lineItemsCategoryList);			
			wh.selectDropDownValue(PaymentPageUI.lineItemsCategoryList, lineItemsCategory,"Line item category");
			wh.waitForElementPresent(PaymentPageUI.lineItemsAmountList);	
			Random random = new Random();
			String lineItem = String.valueOf((random.nextInt(9)));			
			Float Amount = Float.parseFloat(lineItemsAmount)+Float.parseFloat(lineItem);
			String lineItemAmount = String.valueOf(Amount);
			wh.enterValue(PaymentPageUI.lineItemsAmountList, lineItemAmount,"Line Item amount");
			WebElement comments = driver.findElement(By.xpath("//input[contains(@name,'NewPaymentDetailDV-Transaction_Comments')]"));
			wh.clickElement(comments);
			
			////Clicking on Next button in Step 2 of 3
				for(int i=0;i<3;i++) {				
					if(wh.isElementExists(PaymentPageUI.step2of3NextBtn))	{			
						wh.clickElement(PaymentPageUI.step2of3NextBtn, "Step 2 of 3 Next Button");
						Thread.sleep(2000);
					}
				}
				
			wh.waitForElementPresent(PaymentPageUI.invoiceTxt);
			wh.enterValue(PaymentPageUI.invoiceTxt, invoice,"Invoice number");
			WebElement step3Of3Title = driver.findElement(By.xpath("//div[@id='NormalCreateCheckWizard-CheckWizard_CheckInstructionsScreen-ttlBar']"));
			wh.clickElement(step3Of3Title);
			
			//Clicking on Finish button
			for(int i=0;i<3;i++) {				
				if(wh.isElementExists(PaymentPageUI.finishLink))	{			
					wh.clickElement(PaymentPageUI.finishLink, "Finish button");
					Thread.sleep(2000);
				}
			}
			wh.waitForElementPresent(PaymentPageUI.checkScreen);
			
		
		}	
		
	}
	
	private int getRandomRoutingNum()
	{
		Random random = new Random();
		int routingNum = Math.round(Math.round(Math.random()*(Math.pow(10, 9))));
		return routingNum;
	}
	
	private int getRandomCheckNumber()
	{
		Random random = new Random();
		int check = Math.round(Math.round(Math.random()*(Math.pow(10, 10))));
		return check;
	}
	
	//Manual Check payment
	
	public void manualCheckPayment(String reserveLine) throws Exception
	{
				
		String payeeName = excelData.getData("ManualPayeeName");
		String payTo = excelData.getData("ManualPayToTheOrderOf");
		String bankAccount = excelData.getData("BankAccount");
		String manualPaymentType = excelData.getData("ManualPaymentType");
		String lineItemsCategory = excelData.getData("ManualLineItemsCategory");			
		String lineItemsAmount = excelData.getData("ManualLineItemsAmount");
		int checkNum = getRandomCheckNumber();
		String checkNumber = String.valueOf(checkNum);
		
		
		wh.clickElement(PaymentPageUI.financialLink, "Financial Link");
		wh.clickElement(PaymentPageUI.actionLink, "Action Link");
		wh.waitForElementPresent(PaymentPageUI.newTransaction);
		wh.moveToElement(PaymentPageUI.otherLink);
		wh.clickElement(PaymentPageUI.manualCheckLink, "Manaual Check Link");
		
		if(wh.isElementPresent(PaymentPageUI.manualCheckPayeeName))
		{
			wh.selectDropDownValue(PaymentPageUI.manualCheckPayeeName, payeeName,"Payee name");
			wh.enterValue(PaymentPageUI.manualCheckPayToOrderTxt, payTo,"Pay To Description");
			wh.clickWebButton(PaymentPageUI.specialCheckRadio,"Special Check Radio Button");
			wh.enterValue(PaymentPageUI.checkNumberTxt, checkNumber,"Check number");
			wh.waitForElementPresent(PaymentPageUI.bankAccountList);
			wh.selectDropDownValue(PaymentPageUI.bankAccountList, bankAccount,"Bank Account");
			
		}
		
		for(int i=0;i<3;i++) {				
			if(wh.isElementExists(PaymentPageUI.manualCheckNextBtn))	{			
				wh.clickElement(PaymentPageUI.manualCheckNextBtn, "Step 1of 3 Next Button");
				Thread.sleep(2000);
			}
		}
		
		
		wh.waitForElementPresent(PaymentPageUI.manualReserveLine);
		
			wh.selectDropDownValue(PaymentPageUI.manualReserveLine, reserveLine,"Reserve Line");
		
		wh.waitForElementPresent(PaymentPageUI.manualPaymentType);
		wh.enterValue(PaymentPageUI.manualPaymentType, manualPaymentType,"Payment type");
		wh.waitForElementPresent(PaymentPageUI.lineItemsCategoryList);
		wh.selectDropDownValue(PaymentPageUI.lineItemsCategoryList, lineItemsCategory,"Line ietm category");
		wh.waitForElementPresent(PaymentPageUI.manualLineItemAmount);
		wh.enterValue(PaymentPageUI.manualLineItemAmount, lineItemsAmount,"Line item amount");
		WebElement comments = driver.findElement(By.xpath("//input[contains(@name,'NewPaymentDetailDV-Transaction_Comments')]"));
		wh.clickElement(comments);
		
		for(int i=0;i<3;i++) {				
			if(wh.isElementExists(PaymentPageUI.manualStep2of3NextBtn))	{			
				wh.clickElement(PaymentPageUI.manualStep2of3NextBtn, "Step 2 of 3 Next Button");
				Thread.sleep(2000);
			}
		}
		
		wh.waitForElementPresent(PaymentPageUI.manualFinishBtn);
		
		for(int i=0;i<3;i++) {				
			if(wh.isElementExists(PaymentPageUI.manualFinishBtn))	{			
				wh.clickElement(PaymentPageUI.manualFinishBtn, "Finish button");
				Thread.sleep(2000);
			}
		}
		
		wh.waitForElementPresent(PaymentPageUI.checkScreen);
		
	}
	
	//Recode the check amount
	public void recodePayment() throws Exception
	{
		String recodeReserveLine = excelData.getData("RecodeReserve");		
		String recodeCategory = excelData.getData("RecodeCategory");
		wh.clickElement(PaymentPageUI.financialLink, "Financial Link");
		wh.clickElement(PaymentPageUI.transactionsLink, "Transactions Link");
		wh.waitForElementPresent(PaymentPageUI.financialsTransactionsTitle);
		wh.selectDropDownValue(PaymentPageUI.transactionsType, "Payments","Transaction type");
		Thread.sleep(4000);
		wh.clickElement(PaymentPageUI.TransactionsManualChkAmnt1Link, "Manual Check amount");
		wh.clickElement(PaymentPageUI.paymentRecodeBtn, "Recode button in Payments page");		
		wh.waitForElementPresent(PaymentPageUI.recodeReserveList);		
		wh.selectDropDownValue(PaymentPageUI.recodeReserveList, recodeReserveLine,"Reserve Line");		
		wh.waitForElementPresent(PaymentPageUI.recodeCategory);		
		wh.selectDropDownValue(PaymentPageUI.recodeCategory, recodeCategory,"Category");
		
			
		for(int i=0;i<3;i++)
		{
			if(wh.isElementExists(PaymentPageUI.recodeRecodeBtn)) {
				wh.clickElement(PaymentPageUI.recodeRecodeBtn, "Recode button in Recode page");
				Thread.sleep(2000);
			}
		}
		wh.waitForElementPresent(PaymentPageUI.financialsTransactionsTitle);	
		
		
		
	}
	
	//Transfer Check
	public void transferCheck() throws Exception
	{
		
		String claimNo = excelData.getData("TransferCheckClaimNo");
		String transferCheckReserveLine = excelData.getData("TransferCheckReserve");		
		String transferCheckCategory = excelData.getData("TransferCheckCategory");
		boolean isNumericReserve = transferCheckReserveLine.matches("[0-9]+");
		boolean isNumericCategory = transferCheckCategory.matches("[0-9]+");
		
		wh.clickElement(PaymentPageUI.financialLink, "Financials link");
		wh.clickElement(PaymentPageUI.checksLink, "Checks Link");
		wh.waitForElementPresent(PaymentPageUI.financiclCheckTitle);
		
		if(wh.isElementPresent(PaymentPageUI.ChecksGrossAmount1Link))
		{
			wh.clickElement(PaymentPageUI.ChecksGrossAmount1Link, "Check amount link");
			wh.clickElement(PaymentPageUI.checkTransferCheckBtn, "Transfer check button");
			
			wh.waitForElementPresent(PaymentPageUI.searchImage);
			wh.clickElement(PaymentPageUI.searchImage, "Search Claim Image link");		
			
		}
		
		if(wh.isElementPresent(PaymentPageUI.claimNoTxt))
		{
			wh.enterValue(PaymentPageUI.claimNoTxt, claimNo,"Claim");
			wh.scrollToView(PaymentPageUI.searchClaimBtn);
			wh.clickElement(PaymentPageUI.searchClaimBtn, "Search Claim button");
			wh.clickElement(PaymentPageUI.selectClaimBtn, "Select claim button");
		}
		
		
		if(wh.isElementPresent(PaymentPageUI.transferCheckExposureLink))
		{
			wh.clickElement(PaymentPageUI.transferCheckExposureLink, "Exposure Link");
			wh.waitForElementPresent(PaymentPageUI.transferCheckReserve);			
			wh.selectDropDownValue(PaymentPageUI.transferCheckReserve, transferCheckReserveLine,"Reserve Line");
			wh.waitForElementPresent(PaymentPageUI.transferCheckCategory);
			wh.selectDropDownValue(PaymentPageUI.transferCheckCategory, transferCheckCategory,"Category"); 			
			wh.clickElement(PaymentPageUI.transferOkBtn, "Transfer Check Ok button");
		}
		
		
		if(wh.isElementPresent(PaymentPageUI.transferTransferCheckBtn))
		{
			for(int i =0;i<3;i++)
			{
				if(wh.isElementExists(PaymentPageUI.transferTransferCheckBtn))
				{
					wh.clickElement(PaymentPageUI.transferTransferCheckBtn, "Transfer Check button");
					Thread.sleep(4000);
				}
			}
		}
		wh.waitForElementPresent(PaymentPageUI.checkDetailsTitle);		
		
	}
	
	
	

}
