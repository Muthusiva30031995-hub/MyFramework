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
import com.testautomation.PageObjects.MobileAutomationPage;
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
import com.testautomation.TestRunner.TestRunnerMobile;
import com.testautomation.TestRunner.TestRunnerUI;


public class MobileBaseStepDef extends TestRunnerMobile {
	
	MobileAutomationPage mobileAutomationPage = new MobileAutomationPage(ic);
	
}
