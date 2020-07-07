package com.testautomation.StepDef;
import com.testautomation.PageObjects.ActivitiesPage;
import com.testautomation.PageObjects.AviationIncidentPage;
import com.testautomation.PageObjects.ClaimStatusPage;
import com.testautomation.PageObjects.CloseClaimPage;
import com.testautomation.PageObjects.CloseExposurePage;
import com.testautomation.PageObjects.CloseMatterPage;
import com.testautomation.PageObjects.DesktopAutomationPage;
import com.testautomation.PageObjects.DwellingIncidentPage;
import com.testautomation.PageObjects.ExposurePage;
import com.testautomation.PageObjects.FNOLPage;
import com.testautomation.PageObjects.GWCCTicketsPage;
import com.testautomation.PageObjects.InjuryIncidentPage;
import com.testautomation.PageObjects.LoginPage;
import com.testautomation.PageObjects.LossDetailsPage;
import com.testautomation.PageObjects.MSPDetailsPage;
import com.testautomation.PageObjects.MatterPage;
import com.testautomation.PageObjects.PartiesInvolvedPage;
import com.testautomation.PageObjects.PaymentPage;
import com.testautomation.PageObjects.PolicySearchPage;
import com.testautomation.PageObjects.PropertyIncidentPage;
import com.testautomation.PageObjects.RecoveryPage;
import com.testautomation.PageObjects.RentalDetailsPage;
import com.testautomation.PageObjects.RepairDetailsPage;
import com.testautomation.PageObjects.ReservePage;
import com.testautomation.PageObjects.RestAssuredAPI;
import com.testautomation.PageObjects.SalvageDetailsPage;
import com.testautomation.PageObjects.SearchContactPage;
import com.testautomation.PageObjects.VehicleIncidentPage;
import com.testautomation.TestRunner.TestRunnerAPI;
import com.testautomation.TestRunner.TestRunnerUI;


public class UIBaseStepDef extends TestRunnerUI {
	
	public  LoginPage loginPage = new LoginPage(ic);
	public PolicySearchPage policySearchPage = new PolicySearchPage(ic);
	public SearchContactPage searchContactPage = new SearchContactPage(ic);
	public FNOLPage fnolPage = new FNOLPage(ic);
	public InjuryIncidentPage injuryIncidentPage = new InjuryIncidentPage(ic);
	public PropertyIncidentPage propertyIncidentPage = new PropertyIncidentPage(ic);
	public DwellingIncidentPage dwellingIncidentPage = new DwellingIncidentPage(ic);
	public AviationIncidentPage aviationIncidentPage = new AviationIncidentPage(ic);
	public VehicleIncidentPage vehicleIncidentPage = new VehicleIncidentPage(ic);
	public ClaimStatusPage claimStatusPage = new ClaimStatusPage(ic);
	public LossDetailsPage lossDetailsPage = new LossDetailsPage(ic);
	public PartiesInvolvedPage partiesInvolvedPage = new PartiesInvolvedPage(ic);
	public ExposurePage exposurePage = new ExposurePage(ic);
	public RepairDetailsPage repairDetailsPage = new RepairDetailsPage(ic);
	public SalvageDetailsPage salvageDetailsPage = new SalvageDetailsPage(ic);
	public RentalDetailsPage rentalDetailsPage = new RentalDetailsPage(ic);
	public ReservePage reservePage = new ReservePage(ic);
	public MSPDetailsPage mspDetailsPage = new MSPDetailsPage(ic);
	public MatterPage matterPage = new MatterPage(ic);
	public PaymentPage paymentPage = new PaymentPage(ic);
	public RecoveryPage recoveryPage = new RecoveryPage(ic);
	public ActivitiesPage activitiesPage = new ActivitiesPage(ic);
	public CloseExposurePage closeExposurePage = new CloseExposurePage(ic);
	public CloseMatterPage closeMatterPage = new CloseMatterPage(ic);
	public CloseClaimPage closeClaimPage = new CloseClaimPage(ic);
	public GWCCTicketsPage gwccTicketsPage = new GWCCTicketsPage(ic);	
	
}
