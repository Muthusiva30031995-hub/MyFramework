package com.testautomation.PageUI;

import org.openqa.selenium.By;

public class PaymentPageUI {
	
	public static final By financialLink = By.xpath("(//div[contains(@id,'Claim-MenuLinks-Claim_ClaimFinancialsGroup')]/div[1])[1]");
	public static final By financialSummary = By.xpath("//div[@id='ClaimFinancialsSummary-ClaimFinancialsSummaryScreen-ttlBar']");
	public static final By actionLink = By.xpath("(//div[contains(@id,'Claim-ClaimMenuActions')])[1]");
	public static final By newTransaction = By.xpath("//div[@id='Claim-ClaimMenuActions-ClaimMenuActions_NewTransaction']");
	public static final By standardCheckLink = By.xpath("//div[contains(@id,'ClaimMenuActions_NewTransaction_CheckSet')]");
	public static final By payeeNameList = By.xpath("//select[contains(@name,'NewCheckPayeeBooleanDV-PrimaryPayee_Name')]");
	public static final By paymentMethodList = By.xpath("//select[contains(@name,'NewCheckPayeeBooleanDV-PaymentMethod')]");
	public static final By payTo = By.xpath("//div[@id='NormalCreateCheckWizard-CheckWizard_CheckPayeesScreen-NewCheckPayeeBooleanDV-PayTo']");
	public static final By accountType = By.xpath("//input[contains(@id,'EFTDataInputSet-BankAccountType_0')]");
	public static final By bankName = By.xpath("//input[contains(@name,'EFTDataInputSet-BankName')]");
	public static final By accountNumber = By.xpath("//input[contains(@name,'NormalCreateCheckWizard-CheckWizard_CheckPayeesScreen-NewCheckPayeeBooleanDV-EFTDataInputSet-BankAccountNumber')]");
	public static final By routingNumber = By.xpath("//input[contains(@name,'EFTDataInputSet-BankRoutingNumber')]");
	public static final By nextBtn = By.xpath("(//div[text()='Step 1 of 3: Enter payee information'])[2]/../../../div[2]/div[3]/div");
	public static final By reserveLineList = By.xpath("//select[contains(@name,'NewPaymentDetailDV-Transaction_ReserveLine')]");
	public static final By paymentTypeList = By.xpath("//select[contains(@name,'NewPaymentDetailDV-Payment_PaymentType')]");
	public static final By lineItemsCategoryList = By.xpath("//select[contains(@name,'NewPaymentDetailDV-EditablePaymentLineItemsLV-0-LineCategory')]");
	public static final By lineItemsAmountList = By.xpath("//input[contains(@name,'NewPaymentDetailDV-EditablePaymentLineItemsLV-0-Amount')]");
	public static final By step2of3NextBtn = By.xpath("(//div[text()='Step 2 of 3: Enter payment information'])[2]/../../../div[2]/div[4]/div");
	public static final By invoiceTxt = By.xpath("//input[contains(@name,'Check_InvoiceNumber')]");
	public static final By finishLink = By.xpath("//div[contains(@id,'NormalCreateCheckWizard-Finish')]");
	public static final By otherLink = By.xpath("//div[text()='Other']/..");
	public static final By manualCheckLink = By.xpath("//div[text()='Manual Check']/..");
	public static final By manualCheckPayeeName = By.xpath("//select[contains(@name,'NewManualCheckPayeeDV-PrimaryPayee_Name')]");
	public static final By manualCheckPayToOrderTxt = By.xpath("//textarea[contains(@name,'NewManualCheckPayeeDV-Check_PayTo')]");
	public static final By specialCheckRadio = By.xpath("//input[contains(@id,'NewManualCheckPayeeDV-SpecialManualCheck_0')]");
	public static final By bankAccountList = By.xpath("//select[contains(@name,'NewManualCheckPayeeDV-ManualChecks_BankAccount')]");
	public static final By manualCheckNextBtn = By.xpath("(//div[contains(text(),'Step 1 of 3: Enter payee information')])[2]/../../../div[2]/div[3]/div");
	public static final By manualReserveLine = By.xpath("//select[contains(@name,'ManualCreateCheckWizard-ManualCheckWizard_CheckPaymentsScreen-NewCheckPaymentPanelSet-NewPaymentDetailDV-Transaction_ReserveLine')]");
	public static final By manualPaymentType = By.xpath("//select[contains(@name,'ManualCreateCheckWizard-ManualCheckWizard_CheckPaymentsScreen-NewCheckPaymentPanelSet-NewPaymentDetailDV-Payment_PaymentType')]");
	public static final By manualLineItemsCategory = By.xpath("//select[contains(@name,'ManualCreateCheckWizard-ManualCheckWizard_CheckPaymentsScreen-NewCheckPaymentPanelSet-NewPaymentDetailDV-EditablePaymentLineItemsLV-0-LineCategory')]");
	public static final By manualLineItemAmount = By.xpath("//input[contains(@name,'ManualCreateCheckWizard-ManualCheckWizard_CheckPaymentsScreen-NewCheckPaymentPanelSet-NewPaymentDetailDV-EditablePaymentLineItemsLV-0-Amount')]");
	public static final By manualStep2of3NextBtn = By.xpath("(//div[text()='Step 2 of 3: Enter payment information'])[2]/../../../div[2]/div[4]/div");
	public static final By manualFinishBtn = By.xpath("//div[contains(@id,'ManualCreateCheckWizard-Finish')]");
	public static final By checkScreen = By.xpath("//div[@id='ClaimFinancialsChecks-ClaimFinancialsChecksScreen-ttlBar']");
	public static final By checkNumberTxt = By.xpath("//input[contains(@name,'NewManualCheckPayeeDV-Check_CheckNumber')]");
	public static final By transactionsLink = By.xpath("//div[contains(@id,'ClaimFinancialsGroup_ClaimFinancialsTransactions')]");
	public static final By checksLink = By.xpath("//div[contains(@id,'ClaimFinancialsGroup_ClaimFinancialsChecks')]");
	public static final By transactionsType = By.xpath("//select[contains(@name,'ClaimFinancialsTransactions-ClaimFinancialsTransactionsScreen-TransactionsLVRangeInput')]");
	public static final By financialsTransactionsTitle = By.xpath("//div[@id='ClaimFinancialsTransactions-ClaimFinancialsTransactionsScreen-ttlBar']");
	public static final By financiclCheckTitle = By.xpath("//div[@id='ClaimFinancialsChecks-ClaimFinancialsChecksScreen-ttlBar']");
	public static final By TransactionsManualChkAmnt1Link = By.xpath("//div[contains(@id,'ClaimFinancialsTransactions-ClaimFinancialsTransactionsScreen-TransactionsLV-0-Amount')]/div/div");
	public static final By ChecksGrossAmount1Link = By.xpath("(//div[contains(@id,'ChecksLV-0-GrossAmount')]/div/div)[1]");
	public static final By paymentRecodeBtn = By.xpath("//div[contains(@id,'TransactionDetailToolbarButtonSet-TransactionDetailToolbarButtonSet_RecodeButton')]");
	public static final By recodeReserveList = By.xpath("//select[contains(@name,'RecodePayment-RecodePaymentScreen-RecodePaymentPanelSet-RecodePaymentDV-EditTransactionInputSet-ReserveLineInputSet-ReserveLine')]");
	public static final By recodeCategory = By.xpath("//select[contains(@name,'RecodePaymentDV-EditableRecodeLineItemsLV-0-LineCategory')]");
	public static final By recodeRecodeBtn = By.xpath("//div[contains(@id,'RecodePayment-RecodePaymentScreen-RecodePayment_RecodeButton')]");
	public static final By checkTransferCheckBtn = By.xpath("//div[contains(@id,'ClaimFinancialsChecksDetail_TransferButton')]//div/div[2]");
	public static final By searchImage = By.xpath("//div[contains(@id,'CheckTransfer-CheckTransferScreen-CheckTransferDV-Claim-SelectClaim')]");
	public static final By claimNoTxt = By.xpath("//input[contains(@name,'ClaimSearchDV-ClaimSearchRequiredInputSet-ClaimNumber')]");
	public static final By searchClaimBtn = By.xpath("//div[contains(@id,'ClaimSearchDV-ClaimSearchAndResetInputSet-Search')]");
	public static final By selectClaimBtn = By.xpath("//div[contains(@id,'ClaimSearchPopup-ClaimSearchScreen-ClaimSearchResultsLV-0-_Select')]/div");
	public static final By transferCheckExposureLink = By.xpath("//div[contains(@id,'CheckTransfer-CheckTransferScreen-CheckTransferDV-CheckTransferPaymentsLV-0-ExposureLink_button')]");
	public static final By transferCheckReserve = By.xpath("//select[contains(@name,'PaymentTransferPopup-PaymentTransferPopupScreen-PaymentTransferDV-EditTransactionInputSet-ReserveLineInputSet-ReserveLine')]");
	public static final By transferCheckCategory = By.xpath("//select[contains(@name,'PaymentTransferPopup-PaymentTransferPopupScreen-PaymentTransferDV-PaymentTransferLineItemsLV-0-LineCategory')]");
	public static final By transferOkBtn = By.xpath("//div[contains(@id,'PaymentTransferPopup-PaymentTransferPopupScreen-Update')]");
	public static final By transferTransferCheckBtn = By.xpath("//div[contains(@id,'CheckTransfer-CheckTransferScreen-CheckTransfer_TransferButton')]");
	public static final By checkDetailsTitle = By.cssSelector("#ClaimFinancialsChecksDetail-ClaimFinancialsChecksDetailScreen-ttlBar");
			
}
