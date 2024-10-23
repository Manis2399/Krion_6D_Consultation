package Testcases;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class DesingProjectTestcases {

	
	 private WebDriver driver;
     private Locators.LoginLocators L;
     private Locators.Design_Projects_Locators D;
     private Locators.Roles_Locators R;
     private Locators.AssignRole_Locators AR;
     private Locators.WorkFlowLocators WF;
     private Locators.Review_Actions_Locators RVW;
     private Locators.Issue_Locators ISU;
     private Locators.RFA_Locators RFA;
     private Locators.Meeting_Share_Locators MET;
     private Locators.BOM_BOQ_Attachments_Locators BOM;
     private ExtentTest test;
     private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
     private List<List<String>> approvalSteps;
     private static final String EXCEL_FILE_PATH = "C:\\path\\to\\your\\excel\\file.xlsx";
     private static final String SHEET_NAME = "YourSheetName"; // Specify your sheet name
    
     
     
     @Before
     public void setUp() throws InvalidFormatException, IOException {
         excelDataManager.loadData("C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\Excel\\TigerKrionDataSheet.xlsx");
        // loadApprovalStepsFromExcel();
     }
     

     public DesingProjectTestcases() throws InterruptedException {
         System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
         System.setProperty("webdriver.chrome.verboseLogging", "true");
         this.driver = CustomWebDriverManager.getDriver();
         this.R = new Locators.Roles_Locators(driver);
         this.AR = new Locators.AssignRole_Locators(driver);
         this.WF = new Locators.WorkFlowLocators(driver);
         this.RVW = new Locators.Review_Actions_Locators(driver);
         this.ISU = new Locators.Issue_Locators(driver);
         this.RFA = new Locators.RFA_Locators(driver);
         this.MET = new Locators.Meeting_Share_Locators(driver);
         this.BOM = new Locators.BOM_BOQ_Attachments_Locators(driver);
         this.D = new Locators.Design_Projects_Locators(driver);
     }
     
     
     
     
     @Given("I visit the User Login for Design Projects using sheetname {string} and rownumber {int}")
     public void i_visit_the_user_login_for_Design_projects_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
     	try {
     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
           
           String email = testdata.get(rownumber).get("Login Email");
           String password = testdata.get(rownumber).get("Login Password");

           L = new Locators.LoginLocators(driver);
           L.EnterEmail(email);
           L.EnterPassword(password);
           
           LoginInputDatas("Email", email);
           LoginInputDatas("Password", password);
     	} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Login Page");
 		    throw e; 
 		}
     }
     
     @Given("I enter the credentials in login and click a login button")
     public void i_enter_the_credentials_in_login_and_click_a_login_button() {
 		try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 			L.ClickOnLogin();
 		} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Login Page");
 		    throw e; 
 		}
     }
     
     
     @Then("Clicking on Project module under Design section")
     public void clicking_on_project_module_under_design_section() throws Exception {
    	 try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
 			Thread.sleep(1000);
 			D.ClickOnDesignProject();
 		} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Main Page");
 		    throw e; 
 		}
     }
     
     @Then("Click on ADD Project button to create new project")
    public void Click_on_ADD_Project_button_to_create_new_project() {
    	 try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  			D.ClickOnAddProjectButton();
  		} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Add project Page");
  		    throw e; 
  		}
  }
     
     
     @Then("Clicking on Project template field and selecting the template using sheetname {string} and rownumber {int}")
     public void clicking_on_project_template_field_and_selecting_the_template_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
           
           String ProjectTemplate = testdata.get(rownumber).get("Project Template");
           Thread.sleep(1000);
           D.ClickOnProjectTemplate();
           D.EnterOnProjectTemplate(ProjectTemplate);
           D.selectDropdownOption(ProjectTemplate);
           performTabKeyPress();
           performTabKeyPress();
           LoginInputDatas("ProjectTemplate", ProjectTemplate);
			} catch (Exception e) {
   			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
   		   exceptionHandler.handleException(e, "Add project Page");
   		    throw e; 
   		}

     }
     
     
     @Then("Entering valid project code using sheetname {string} and rownumber {int}")
     public void entering_valid_project_code_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
    		   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

	        	  System.out.println("sheet name: " + testdata);
         
	        	  String ProjectCode = testdata.get(rownumber).get("Project code");
	        	  Thread.sleep(1000);
   			D.ClickOnProjectCode();
   			D.ClearOnProjectCode();
   			D.EnterOnProjectCode(ProjectCode);
   		    LoginInputDatas("ProjectCode", ProjectCode);
   		} catch (Exception e) {
   			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
   		   exceptionHandler.handleException(e, "Add project Page");
   		    throw e; 
   		}
     }
     
     
     @Then("Entering valid project name using sheetname {string} and rownumber {int}")
     public void entering_valid_project_name_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 		   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

	        	  System.out.println("sheet name: " + testdata);
      
	        	  String ProjectName = testdata.get(rownumber).get("Project name");
	        	  Thread.sleep(1000);
			D.ClickOnProjectName();
			D.ClearOnProjectName();
			D.EnterOnProjectName(ProjectName);
		    LoginInputDatas("ProjectName", ProjectName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		}
     }
     
     
     @Then("Entering valid project description using sheetname {string} and rownumber {int}")
     public void entering_valid_project_description_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
  		   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 	        	  System.out.println("sheet name: " + testdata);
       
 	        	  String ProjectDescrpt = testdata.get(rownumber).get("Project Description");
 	        	  Thread.sleep(1000);
 			D.ClickOnProjectDescrpt();
 			D.ClearOnProjectDescrpt();
 			D.EnterOnProjectDescrpt(ProjectDescrpt);
 		    LoginInputDatas("ProjectDescrpt", ProjectDescrpt);
 		} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add project Page");
 		    throw e; 
 		}
     }
     
     
     
     @Then("Entering Start Date of the project using sheetname {string} and rownumber {int}")
     public void entering_Start_Date_of_the_project(String sheetname, int rownumber) throws Exception {
    	 try {
   		   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

  	        	  System.out.println("sheet name: " + testdata);
        
  	        	  String ProjectStartDate = testdata.get(rownumber).get("start date");
  	        	String ProjectStartMonth = testdata.get(rownumber).get("start month");
  	        	String ProjectStartYear = testdata.get(rownumber).get("start year");
  	        	
  	        	if (ProjectStartYear != null && ProjectStartYear.matches("\\d+\\.0")) {
  	        		ProjectStartYear = ProjectStartYear.substring(0, ProjectStartYear.indexOf(".0"));
  	        	
  	        	  Thread.sleep(1000);
  			D.ClickOnStartDate();
  			D.ClearOnStartDate();
  			D.EnterOnStartDate(ProjectStartDate);
  			D.EnterOnStartDate(ProjectStartMonth);
  			D.EnterOnStartDate(ProjectStartYear);
  		    LoginInputDatas("ProjectStartDate", ProjectStartDate);
  		    LoginInputDatas("ProjectStartMonth", ProjectStartMonth);
  		    LoginInputDatas("ProjectStartYear", ProjectStartYear);
  	        	}
  		} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Add project Page");
  		    throw e; 
  		} 
     }
     
     

     @Then("Enter and select the project design type from drop-down using sheetname {string} and rownumber {int}")
     public void enter_and_select_the_project_design_type_from_drop_down_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
        
        String ProjectDesigntype = testdata.get(rownumber).get("Design type");
        Thread.sleep(1000);
        D.ClickOnProjectDesignType();
        D.EnterOnProjectDesignType(ProjectDesigntype);
        D.selectDropdownOption(ProjectDesigntype);
        performTabKeyPress();
        performTabKeyPress();
        LoginInputDatas("ProjectDesigntype", ProjectDesigntype);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		} 
     }
     
     
     @Then("Enter and select the project category type from drop-down using sheetname {string} and rownumber {int}")
     public void enter_and_select_the_project_category_type_from_drop_down_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
     
     String Projectcategory = testdata.get(rownumber).get("category");
     Thread.sleep(1000);
     D.EnterOnProjectCategory(Projectcategory);
     D.selectDropdownOption(Projectcategory);
     performTabKeyPress();
     performTabKeyPress();
     LoginInputDatas("Projectcategory", Projectcategory);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		} 
     }
     
     @Then("Enter and select the project owner type from drop-down using sheetname {string} and rownumber {int}")
     public void enter_and_select_the_project_owner_type_from_drop_down_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
  
			String ProjectOwner = testdata.get(rownumber).get("Owner");
			Thread.sleep(1000);
			D.ClickOnProjectOwnerSelection();
			D.EnterOnProjectOwnerSelection(ProjectOwner);
			D.selectDropdownOption(ProjectOwner);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("ProjectOwner", ProjectOwner);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		}  
     }
     
     
     @Then("Enter and select the project status type from drop-down using sheetname {string} and rownumber {int}")
     public void enter_and_select_the_project_status_type_from_drop_down_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Projectstatus = testdata.get(rownumber).get("status");
			Thread.sleep(1000);
			D.ClickOnProjectStatus();
			D.EnterOnProjectStatus(Projectstatus);
			D.selectDropdownOption(Projectstatus);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("Projectstatus", Projectstatus);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		} 
     }
     
     
     @Then("Entering address in address line one field using sheetname {string} and rownumber {int}")
     public void entering_address_in_address_line_one_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String AddressLine1 = testdata.get(rownumber).get("Address Line1");
			Thread.sleep(1000);
			D.EnterOnAddressLine1(AddressLine1);
			LoginInputDatas("AddressLine1", AddressLine1);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		} 
     }
     
     
     @Then("Entering address in address line two field using sheetname {string} and rownumber {int}")
     public void entering_address_in_address_line_two_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String AddressLine2 = testdata.get(rownumber).get("Address Line1");
			Thread.sleep(1000);
			D.EnterOnAddressLine2(AddressLine2);
			LoginInputDatas("AddressLine2", AddressLine2);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		} 
     }
     
     
     @Then("Entering City name in the field using sheetname {string} and rownumber {int}")
     public void entering_city_name_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String City = testdata.get(rownumber).get("city");
			Thread.sleep(1000);
			D.EnterOnCity(City);
			LoginInputDatas("City", City);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		}
     }
     
     
     @Then("Entering State name in the field using sheetname {string} and rownumber {int}")
     public void entering_state_name_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String State = testdata.get(rownumber).get("state");
			Thread.sleep(1000);
			D.EnterOnState(State);
			LoginInputDatas("State", State);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		}
     }
     
     
     @Then("Entering valid Pincode in the field using sheetname {string} and rownumber {int}")
     public void entering_valid_pincode_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Pincode = testdata.get(rownumber).get("postal code");
			
			if (Pincode != null && Pincode.matches("\\d+\\.0")) {
				Pincode = Pincode.substring(0, Pincode.indexOf(".0"));
				
			Thread.sleep(1000);
			D.EnterOnPincode(Pincode);
			LoginInputDatas("Pincode", Pincode);
			}
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		}
     }
     
     
     @Then("Entering Country name in the field using sheetname {string} and rownumber {int}")
     public void entering_country_name_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Country = testdata.get(rownumber).get("country");
			Thread.sleep(1000);
			D.EnterOnCountry(Country);
			LoginInputDatas("Country", Country);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add project Page");
		    throw e; 
		}
     }
     
     
     @Then("Click on Create button to create new project")
     public void Click_on_Create_button_to_create_new_project() {
    	 try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
 			R.ClickOnCreateButton();
     	} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add project Page");
 		    throw e; 
 		} 
     }
     
     
     //Assigning Role for the Created Project but First we need to find the created project from the list or from the table by searching in the search-box by its name
     

         
     
     
     
     
     @Then("filtering the required project and clickin on it using sheetname {string} and rownumber {int}")
     public void filtering_the_required_project_and_clickin_on_it_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws AWTException, InterruptedException {
     	 try {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    	 // Extract project name from Excel
         List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
         String projectName = testdata.get(rownumber).get("Project name");
         Thread.sleep(4000);
         // Enter project name in the search box
         AR.EnterOnSearchBox(projectName);
         Thread.sleep(2000);
         // Click the desired project
         AR.clickOnProject(projectName);
     	} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Assigning Role Page");
 		    throw e; 
 		} 
     }
     
     
     
     @Then("Clciking on Setting module in newly Created Project under Design module")
     public void clciking_on_setting_module_in_newly_created_project_under_design_module() {
    	 try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
  			AR.ClickOnSetting();
      	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Role Assigning Page");
  		    throw e; 
  		}
     }
     
     
     
     //Assign Module
     
     @Then("Clciking on Assign role sub-module under settings in newly Created Project under Design module")
     public void clciking_on_assign_role_sub_module_under_settings_in_newly_created_project_under_design_module() {
    	 try {
   			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
   			AR.ClickOnAssignRole();
       	} catch (Exception e) {
   			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
   		   exceptionHandler.handleException(e, "Role Assigning Page");
   		    throw e; 
   		}
     } 
     
     
     
     
     @Then("Clicking on Assign Role button to assigning the role to the user")
     public void clicking_on_assign_role_button_to_assigning_the_role_to_the_user() {
    	 try {
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    			AR.ClickOnAssignRoleButton();
        	} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Role Assigning Page");
    		    throw e; 
    		}
     }
     
     
     //Assign Role
     
     @Then("Clicking on Select role drop-down to select the required role from the list using sheetname {string} and rownumber {int}")
     public void clicking_on_select_role_drop_down_to_select_the_required_role_from_the_list_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String RoleName = testdata.get(rownumber).get("Role");
			Thread.sleep(1000);
			AR.ClickOnSelectTheRole();
			Thread.sleep(1000);
			AR.selectDropdownOptionForRole(RoleName);
			LoginInputDatas("RoleName", RoleName);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Role Assigning Page");
		    throw e; 
		}
     }
     
     
     @Then("Clicking on Add user drop-down to select the required number of users from the list sheetname {string} and rownumber {int}")
     public void clicking_on_add_user_drop_down_to_select_the_required_number_of_users_from_the_list_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	    
    	    // Fetch user data from Excel
    	    List<Map<String, String>> userData = excelDataManager.getCachedData(sheetname);
    	    Thread.sleep(1000);
    	    // Click on the Add User dropdown initially
    	    AR.ClickOnAddUser();
    	    
    	    for (Map<String, String> row : userData) {
    	        String userName = row.get("Add user"); // Adjust based on your Excel column header
    	        
    	        // Check if the user name is not empty
    	        if (userName != null && !userName.isEmpty()) {
    	            // Select the user from the dropdown
    	        	 Thread.sleep(1000);
    	            AR.selectUserFromDropdownForAddUser(userName);
    	            Thread.sleep(2000);
    	            // Wait or click the dropdown again to allow for the next user selection
    	            // Re-open the dropdown for selecting the next user
    	            AR.ClickOnAddUser(); // Click again to re-open the dropdown
    	            
    	            // Wait briefly to ensure the dropdown is ready for the next selection
    	            Thread.sleep(1000); // This can be optimized or replaced with explicit wait
    	        } else {
    	            // Stop the loop if there's no user left to select
    	            System.out.println("No more users to select, stopping the selection process.");
    	            break;
    	        }
    	    }
            performTabKeyPress();
	        Thread.sleep(1000);		
	        performTabKeyPress();
    	 } catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Role Assigning Page");
 		    throw e; 
 		}
     }
    	 
     
     
     @Then("Clicking on Assign button to assing the role for the desire number of users")
     public void Clicking_on_Assign_button_to_assing_the_role_for_the_desire_number_of_users() {
    	 try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 			AR.ClickOnAssignButton();
     	} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Role Assigning Page");
 		    throw e; 
 		}
     }
     
     
     //Assign Role For Group
     
     @Then("Clicking on Assign Role for Group tab")
     public void clicking_on_assign_role_for_group_tab() {
    	 try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  			AR.ClickOnAssignRoleForGroupTab();
      	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Role Assigning group Page");
  		    throw e; 
  		}
     }
     
     @Then("Clickingon Assign Role Group button to create a group")
     public void clickingon_assign_role_group_button_to_create_a_group() {
    	 try {
   			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   			AR.ClickOnAssignRoleForGroupButton();
       	} catch (Exception e) {
   			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
   		   exceptionHandler.handleException(e, "Role Assigning group Page");
   		    throw e; 
   		}
     }
     
     
     @Then("Clicking on Select role drop-down to select the required role from the list for Group using sheetname {string} and rownumber {int}")
     public void clicking_on_select_role_drop_down_to_select_the_required_role_from_the_list_for_group_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String RoleName = testdata.get(rownumber).get("Role For Group");
			Thread.sleep(1000);
			AR.ClickOnSelectTheRoleInGroup();
			Thread.sleep(1000);
			AR.selectDropdownOptionForRoleGroup(RoleName);
			LoginInputDatas("RoleName for Group", RoleName);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Role Assigning group Page");
		    throw e; 
		}
     }
     
     
     @Then("Clicking on Add group drop-down to select the required number of users from the list sheetname {string} and rownumber {int}")
     public void clicking_on_add_group_drop_down_to_select_the_required_number_of_users_from_the_list_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
        	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        	    
        	    // Fetch user data from Excel
        	    List<Map<String, String>> userData = excelDataManager.getCachedData(sheetname);
        	    Thread.sleep(1000);
        	    // Click on the Add User dropdown initially
        	    AR.ClickOnAddGroup();
        	    
        	    for (Map<String, String> row : userData) {
        	        String userName = row.get("Add group"); // Adjust based on your Excel column header
        	        
        	        // Check if the user name is not empty
        	        if (userName != null && !userName.isEmpty()) {
        	            // Select the user from the dropdown
        	        	 Thread.sleep(1000);
        	            AR.selectUserFromDropdownForAddGroup(userName);
        	            Thread.sleep(2000);
        	            // Wait or click the dropdown again to allow for the next user selection
        	            // Re-open the dropdown for selecting the next user
        	            AR.ClickOnAddGroup(); // Click again to re-open the dropdown
        	            
        	            // Wait briefly to ensure the dropdown is ready for the next selection
        	            Thread.sleep(1000); // This can be optimized or replaced with explicit wait
        	        } else {
        	            // Stop the loop if there's no user left to select
        	            System.out.println("No more users to select, stopping the selection process.");
        	            break;
        	        }
        	    }
                performTabKeyPress();
    	        Thread.sleep(1000);		
    	        performTabKeyPress();
        	 } catch (Exception e) {
     			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
     		   exceptionHandler.handleException(e, "Role Assigning Page");
     		    throw e; 
     		}
     }
     
     @Then("Clicking on Assign button to assing the role for the desire number of users users in group")
     public void clicking_on_assign_button_to_assing_the_role_for_the_desire_number_of_users_users_in_group() {
    	 try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  			AR.ClickOnAssignButton();
      	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Role Assigning Page");
  		    throw e; 
  		}
     }
     
     
     
     
     //Workflow Creation
     
     @Then("Clciking on Workflow sub-module under settings in newly Created Project under Design module")
     public void clciking_on_workflow_sub_module_under_settings_in_newly_created_project_under_design_module() {
    	 try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
  			WF.ClickOnWorkflow();
      	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Work Flow Page");
  		    throw e; 
  		}
     }
     
     
     @Then("Clicking on Select the category drop-down to select the required category from the list using sheetname {string} and rownumber {int}")
     public void clicking_on_select_the_category_drop_down_to_select_the_required_category_from_the_list_using_sheetname_and_rownumber(String sheetname, Integer rownumber) {
    	 try {
    	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

    	        // Fetch the category from Excel
    	        List<Map<String, String>> categoryData = excelDataManager.getCachedData(sheetname);
    	        String categoryName = categoryData.get(rownumber).get("SelectTheCategory"); // Replace "Category" with the actual header name in your Excel

    	        // Click on the dropdown to open it
    	        WF.ClickOnSelectTheCategoryDropdown();

    	        // Select the category from the dropdown
    	        WF.selectCategoryFromDropdown(categoryName);

    	    } catch (Exception e) {
    	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    	        exceptionHandler.handleException(e, "Work Flow Page");
    	        throw e; 
    	    }
     }
     
     
     @Then("Clicking on Add workflow button")
     public void clicking_on_add_workflow_button() throws Exception {
    	 try {
   			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
   			Thread.sleep(2000);
   			WF.ClickOnAddWorkflowButton();
       	} catch (Exception e) {
   			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
   		   exceptionHandler.handleException(e, "Work Flow Page");
   		    throw e; 
   		}
     }
     
     
     //General Info - Work flow
     
     
     @Then("Selecting the stepper selection from the drop down using sheetname {string} and rownumber {int}")
     public void selecting_the_stepper_selection_from_the_drop_down_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String SelectSteps = testdata.get(rownumber).get("Select Steps");
			Thread.sleep(1000);
			WF.ClickOnSelectSteppers();
			Thread.sleep(1000);
			WF.selectDropdownOptionSteppersSelection(SelectSteps);
			LoginInputDatas("Stepper Selection", SelectSteps);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Work Flow creation Page");
		    throw e; 
		}
     }



     @Then("Entering the valid Name in the field using sheetname {string} and rownumber {int}")
     public void entering_the_valid_name_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ReviewName = testdata.get(rownumber).get("Name"); 
			WF.EnterOnName(ReviewName);
			
			LoginInputDatas("Reviewer Name", ReviewName);
    		} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Work Flow creation Page");
    		    throw e; 
    		}
     }


     @Then("Entering the Description in the field using sheetname {string} and rownumber {int}")
     public void entering_the_description_in_the_field(String sheetname, int rownumber) throws Exception{
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Description = testdata.get(rownumber).get("Description");
			Thread.sleep(1000);
			WF.EnterOnDescription(Description);
			Thread.sleep(1000);
			LoginInputDatas("Workflow Category", Description);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Work Flow creation Page");
		    throw e; 
		}
     }
     
     

     @Then("selecting the workflow category drop down field using sheetname {string} and rownumber {int}")
     public void selecting_the_workflow_category_drop_down_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Workflowcategory = testdata.get(rownumber).get("Workflow category");
			Thread.sleep(1000);
			WF.ClickOnSelectCategory();
			Thread.sleep(1000);
			WF.selectDropdownOptionSelectCategory(Workflowcategory);
			LoginInputDatas("Workflow Category", Workflowcategory);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Work Flow creation Page");
		    throw e; 
		}
     }



     @Then("selecting the Status drop down field using sheetname {string} and rownumber {int}")
     public void selecting_the_status_drop_down_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Status = testdata.get(rownumber).get("Status");
			Thread.sleep(1000);
			WF.ClickOnStatus();
			Thread.sleep(1000);
			WF.selectDropdownOptionSelectStatus(Status);
			LoginInputDatas("Status", Status);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Work Flow creation Page");
		    throw e; 
		}
     }



     @Then("Entering the valid Name for Approval using sheetname {string} and rownumber {int}")
     public void entering_the_valid_name_for_approval_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
       	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String NameForApproval = testdata.get(rownumber).get("Name for approval");
			Thread.sleep(1000);
			WF.ClearOnNameForApproval();
			Thread.sleep(1000);
			WF.EnterOnNameForApproval(NameForApproval);
       	} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Work Flow creation Page");
		    throw e; 
		    }
     }
     
     
     
     
     
     
     
     
     
     
     //Workflow Steppers Fill
     
     @Then("I fill in the approval steps for using sheetname {string}")
     public void i_fill_in_the_approval_steps_for_using_sheetname(String sheetname) throws InterruptedException, AWTException {
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

         List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

         // Iterate over each entry (each row of data) and populate the approval steps
         for (int i = 0; i < testdata.size(); i++) {
             Map<String, String> stepData = testdata.get(i);

             String stepName = stepData.get("Step Name");
             String user = stepData.get("User");
             String userGroup = stepData.get("User Group");
             String description = stepData.get("Description");

             System.out.println(stepName);
             System.out.println(user);
             System.out.println(userGroup);
             System.out.println(description);

             // Skip steps where the step name is empty or null
             if (stepName == null || stepName.trim().isEmpty()) {
                 System.out.println("Step name is empty. Skipping step " + (i + 1));
                 continue; // Move to the next row
             }

             // Get the current step index
             int stepIndex = i + 1;

             WF.enterStepName(stepIndex, stepName);

             // Handle Select Users if the 'User' field is not empty
             if (user != null && !user.trim().isEmpty()) {
                 WF.clickOnSelectUsers(stepIndex);
                 Thread.sleep(1000);
                 WF.searchUserFromDropdownForSelectUsersTab(user, stepIndex);
                 Thread.sleep(3000);
             } else {
                 System.out.println("User is empty for step " + stepIndex);
             }

             // Handle Select User Groups if the 'User Group' field is not empty
        //     if (userGroup != null && !userGroup.trim().isEmpty()) {
         //        WF.clickOnStepSelectUsersGroups(stepIndex);
           //      Thread.sleep(1000);
          //       WF.searchUserFromDropdownForSelectUserGroupTab(userGroup, stepIndex);
         //    } else {
           //      System.out.println("User Group is empty for step " + stepIndex);
          //   }

             // Handle Description if the 'Description' field is not empty
             if (description != null && !description.trim().isEmpty()) {
                 WF.enterValueInStepDescriptionField(description, stepIndex);
             } else {
                 System.out.println("Description is empty for step " + stepIndex);
             }
         }
     }


     
//     private void loadApprovalStepsFromExcel() {
//    	 approvalSteps = new ArrayList<>();
//         try (FileInputStream fis = new FileInputStream("C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\Excel\\TigerKrionDataSheet.xlsx")) {
//             Workbook workbook = WorkbookFactory.create(fis);
//             Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
//
//             for (Row row : sheet) {
//                 List<String> stepData = new ArrayList<>();
//                 for (Cell cell : row) {
//                     stepData.add(cell.toString()); // Store each cell's value
//                 }
//                 approvalSteps.add(stepData); // Add the row data to the list
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
//     
     
     @Then("Click On Create button to create workflow")
     public void Click_On_Createbutton_to_create_workflow() throws Exception {
    	 try {
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
    			Thread.sleep(2000);
    			WF.ClickOnCreateButton();
        	} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Work Flow creation Page");
    		    throw e; 
    		}
      } 
     
  // Actions - > Review Creation flow
     
     

@Then("Clicking on Action module from sidebar")
public void clicking_on_action_module_from_sidebar() throws Exception {
	 try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(2000);
			RVW.ClickOnActions();
 	} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Work Flow creation Page");
		    throw e; 
		}
}


@Then("Clicking on Review sub-module from sidebar")
public void clicking_on_review_sub_module_from_sidebar() throws Exception {
	 try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(2000);
			RVW.ClickOnReview();
	} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Work Flow creation Page");
		    throw e; 
		}
}



@Then("Clicking on ADD button to create Add review")
public void clicking_on_add_button_to_create_add_review() throws Exception {
	 try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(2000);
			RVW.ClickOnAddButton();
	} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Work Flow creation Page");
		    throw e; 
		}
}


@Then("Selecting Parent Review name from the drop-down using sheetname {string} and rownumber {int}")
public void selecting_parent_review_name_from_the_drop_down_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		 List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		 System.out.println("sheet name: " + testdata);

		 String ParentReview = testdata.get(rownumber).get("Parent Review");
		 Thread.sleep(1000);
         RVW.ClickOnParentReview();
         Thread.sleep(1000);
         RVW.selectDropdownOption(ParentReview);
         performTabKeyPress();
         //performTabKeyPress();
         LoginInputDatas("ParentReview", ParentReview);
	 } catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Review creation Page");
		    throw e; 
		}
}



@Then("Entering  valid code on Review Code field using sheetname {string} and rownumber {int}")
public void entering_valid_code_on_review_code_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		 List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		 System.out.println("sheet name: " + testdata);

		 String ReviewCode = testdata.get(rownumber).get("Review Code");
		 Thread.sleep(1000);
		 RVW.ClearOnReviewCode();
		 Thread.sleep(1000);
		 RVW.EnterOnReviewCode(ReviewCode);
		 LoginInputDatas("ReviewCode", ReviewCode);
	 } catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Review creation Page");
		    throw e; 
		}
}



@Then("Entering valid name on Review Name field using sheetname {string} and rownumber {int}")
public void entering_valid_name_on_review_name_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		 List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		 System.out.println("sheet name: " + testdata);

		 String ReviewName = testdata.get(rownumber).get("Review Name");
		 RVW.EnterOnReviewName(ReviewName);
		 LoginInputDatas("ReviewCode", ReviewName);
	 } catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Review creation Page");
		    throw e; 
		}
}



@Then("Entering Description on the field using sheetname {string} and rownumber {int}")
public void entering_description_on_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		 List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		 System.out.println("sheet name: " + testdata);

		 String Description = testdata.get(rownumber).get("Description");
		 RVW.ClearOnDescription();
		 Thread.sleep(1000);
		 RVW.EnterOnDescription(Description);
		 LoginInputDatas("Description", Description);
	 } catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Review creation Page");
		    throw e; 
		}
}



@Then("Entering valid start date on the field using sheetname {string} and rownumber {int}")
public void entering_valid_start_date_on_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	try {
		   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

	        	  System.out.println("sheet name: " + testdata);
    
	        	  String ReviewStartDate = testdata.get(rownumber).get("Start Date");
	        	String ReviewStartMonth = testdata.get(rownumber).get("Start Month");
	        	String ReviewStartYear = testdata.get(rownumber).get("Start Year");
	        	
	        	if (ReviewStartYear != null && ReviewStartYear.matches("\\d+\\.0")) {
	        		ReviewStartYear = ReviewStartYear.substring(0, ReviewStartYear.indexOf(".0"));
	        	
	        	  Thread.sleep(1000);
			RVW.ClickOnStartDate();
			RVW.ClearOnStartDate();
			RVW.EnterOnStartDate(ReviewStartDate);
			RVW.EnterOnStartDate(ReviewStartMonth);
			RVW.EnterOnStartDate(ReviewStartYear);
		    LoginInputDatas("ReviewStartDate", ReviewStartDate);
		    LoginInputDatas("ReviewStartMonth", ReviewStartMonth);
		    LoginInputDatas("ReviewStartYear", ReviewStartYear);
	        	}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Review Page");
		    throw e; 
		}
}



@Then("Entering valid End date on the field using sheetname {string} and rownumber {int}")
public void entering_valid_end_date_on_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	try {
	   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

        	  System.out.println("sheet name: " + testdata);

        	  String ReviewEndDate = testdata.get(rownumber).get("End Date");
        	String ReviewEndMonth = testdata.get(rownumber).get("End Month");
        	String ReviewEndYear = testdata.get(rownumber).get("End Year");
        	
        	if (ReviewEndYear != null && ReviewEndYear.matches("\\d+\\.0")) {
        		ReviewEndYear = ReviewEndYear.substring(0, ReviewEndYear.indexOf(".0"));
        	
        	  Thread.sleep(1000);
		RVW.ClickOnEndDate();
		RVW.ClearOnEndDate();
		RVW.EnterOnEndDate(ReviewEndDate);
		RVW.EnterOnEndDate(ReviewEndMonth);
		RVW.EnterOnEndDate(ReviewEndYear);
	    LoginInputDatas("ReviewEndDate", ReviewEndDate);
	    LoginInputDatas("ReviewEndMonth", ReviewEndMonth);
	    LoginInputDatas("ReviewEndYear", ReviewEndYear);
        	}
	} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	   exceptionHandler.handleException(e, "Add Review Page");
	    throw e; 
	}
}



@Then("Selecting workflow on the field using sheetname {string} and rownumber {int}")
public void selecting_workflow_on_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		System.out.println("sheet name: " + testdata);
    
    String Workflow = testdata.get(rownumber).get("Workflow");
    Thread.sleep(1000);
    RVW.ClickonWorkFlow();
    Thread.sleep(1000);
    RVW.selectDropdownOptionForWorkFlow(Workflow);
    LoginInputDatas("Workflow", Workflow);
		} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	   exceptionHandler.handleException(e, "Add Review Page");
	    throw e; 
	}
}



@Then("Selecting priority from the drop-down using sheetname {string} and rownumber {int}")
public void selecting_priority_from_the_drop_down_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		System.out.println("sheet name: " + testdata);

		String Priority = testdata.get(rownumber).get("Priority");
		System.out.println(Priority);
		Thread.sleep(1000);
		RVW.ClickOnPriority();		
		Thread.sleep(1000);
		RVW.selectDropdownOptionForPriority(Priority);
		LoginInputDatas("Priority", Priority);
		} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	   exceptionHandler.handleException(e, "Add Review Page");
	    throw e; 
	} 
}

@Then("Entering valid Estimate cost in the field using sheetname {string} and rownumber {int}")
public void entering_valid_estimate_cost_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String EstimateCost = testdata.get(rownumber).get("Estimate Cost");
			RVW.ClickOnEstimateCost();
			RVW.ClearOnEstimateCost();
			Thread.sleep(1000);
			RVW.EnterOnEstimateCost(EstimateCost);
			LoginInputDatas("EstimateCost", EstimateCost);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Review Page");
		    throw e; 
		} 
}



@Then("Entering valid Actual cost in the field using sheetname {string} and rownumber {int}")
public void entering_valid_actual_cost_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ActualCost = testdata.get(rownumber).get("Actual Cost");
			RVW.ClickOnActualCost();
			RVW.ClearOnActualCost();
			Thread.sleep(1000);
			RVW.EnterOnActualCost(ActualCost);
			LoginInputDatas("ActualCost", ActualCost);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Review Page");
		    throw e; 
		}
}



@Then("Selecting checklist from the drop-down using sheetname {string} and rownumber {int}")
public void selecting_checklist_from_the_drop_down_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Attachfile = testdata.get(rownumber).get("Attachfile");
			String FileName = testdata.get(rownumber).get("File Name");
			Thread.sleep(1000);
			RVW.ClickOnAttachFiles();
			Thread.sleep(1000);
			RVW.attachFile(Attachfile,FileName);
			Thread.sleep(1000);
			RVW.clickOnRequiredFile(FileName);
			Thread.sleep(2000);
			RVW.ClickOnAttachButton();
			LoginInputDatas("Attachfile", Attachfile);
			LoginInputDatas("FileName", FileName);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Review Page");
		    throw e; 
		}
}

     
     @Then("Clicking on Create button to create a Review for the project")
     public void  Clicking_on_Create_button_to_create_a_Review_for_the_project() throws Exception {
    	 try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
 			Thread.sleep(2000);
 			RVW.ClickOnCreateButton();
 	} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Review Page");
 		    throw e; 
 		}
     }
     
     
     // Actions - > Issue page Creation
     
     @Then("Clicking on Issues sub-module from sidebar")
     public void Clicking_on_Issues_sub_module_from_sidebar() throws Exception {
    	 try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
  			Thread.sleep(2000);
  			ISU.ClickOnIssues();
  	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Add Issue Page");
  		    throw e; 
  		}
     }
     
     @Then("Clicking on ADD button to create Add Issues")
     public void Clicking_on_ADD_button_to_create_Add_Issues() throws Exception {
    	 try {
   			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
   			Thread.sleep(2000);
   			ISU.ClickOnAddButton();
   	} catch (Exception e) {
   			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
   		   exceptionHandler.handleException(e, "Add Issue Page");
   		    throw e; 
   		}
     }
     
     @Then("Entering valid code on Issue Code field using sheetname {string} and rownumber {int}")
     public void Entering_valid_code_on_Issue_Code_field(String sheetname, int rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String IssueCode = testdata.get(rownumber).get("Issue Code");
 			ISU.ClickOnIssueCode();
 			ISU.ClearOnIssueCode();
 			Thread.sleep(1000);
 			ISU.EnterOnIssueCode(IssueCode);
 			LoginInputDatas("IssueCode", IssueCode);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Issue Page");
 		    throw e; 
 		}
     }
     
     
     @Then("Entering valid name on Name field using sheetname {string} and rownumber {int}")
     public void Entering_valid_name_on_name_field(String sheetname, int rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String Name = testdata.get(rownumber).get("Name");
 			ISU.EnterOnName(Name);
 			LoginInputDatas("Name", Name);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Issue Page");
 		    throw e; 
 		}
     }
     
     
     @Then("Entering Description on the field in add issue using sheetname {string} and rownumber {int}")
     public void Entering_Description_on_the_field_in_add_issue(String sheetname, int rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String Description = testdata.get(rownumber).get("Description");
 			ISU.ClearOnDescription();
 			Thread.sleep(1000);
 			ISU.EnterOnDescription(Description);
 			LoginInputDatas("Description", Description);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Issue Page");
 		    throw e; 
 		}
     }
     
     
     
     @Then("Entering valid start date on the field in add issue using sheetname {string} and rownumber {int}")
     public void entering_valid_start_date_on_the_field_in_add_issue_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
     	try {
     		   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

     	        	  System.out.println("sheet name: " + testdata);
         
     	        	  String IssueStartDate = testdata.get(rownumber).get("Start Date");
     	        	String IssueStartMonth = testdata.get(rownumber).get("Start Month");
     	        	String IssueStartYear = testdata.get(rownumber).get("Start Year");
     	        	
     	        	if (IssueStartYear != null && IssueStartYear.matches("\\d+\\.0")) {
     	        		IssueStartYear = IssueStartYear.substring(0, IssueStartYear.indexOf(".0"));
     	        	
     	        	  Thread.sleep(1000);
     			ISU.ClickOnStartDate();
     			ISU.ClearOnStartDate();
     			ISU.EnterOnStartDate(IssueStartDate);
     			ISU.EnterOnStartDate(IssueStartMonth);
     			ISU.EnterOnStartDate(IssueStartYear);
     		    LoginInputDatas("IssueStartDate", IssueStartDate);
     		    LoginInputDatas("IssueStartMonth", IssueStartMonth);
     		    LoginInputDatas("IssueStartYear", IssueStartYear);
     	        	}
     		} catch (Exception e) {
     			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
     		   exceptionHandler.handleException(e, "Add Issue Page");
     		    throw e; 
     		}
     }



     @Then("Entering valid Due date on the field in add issue using sheetname {string} and rownumber {int}")
     public void entering_valid_due_date_on_the_field_in_add_issue_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
     	try {
     	   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
             	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

             	  System.out.println("sheet name: " + testdata);

             	  String IssueEndDate = testdata.get(rownumber).get("Due Date");
             	String IssueEndMonth = testdata.get(rownumber).get("Due Month");
             	String IssueEndYear = testdata.get(rownumber).get("Due Year");
             	
             	if (IssueEndYear != null && IssueEndYear.matches("\\d+\\.0")) {
             		IssueEndYear = IssueEndYear.substring(0, IssueEndYear.indexOf(".0"));
             	
             	  Thread.sleep(1000);
     		ISU.ClickOnDueDate();
     		ISU.ClearOnDueDate();
     		ISU.EnterOnDueDate(IssueEndDate);
     		ISU.EnterOnDueDate(IssueEndMonth);
     		ISU.EnterOnDueDate(IssueEndYear);
     	    LoginInputDatas("IssueEndDate", IssueEndDate);
     	    LoginInputDatas("IssueEndMonth", IssueEndMonth);
     	    LoginInputDatas("IssueEndYear", IssueEndYear);
             	}
     	} catch (Exception e) {
     		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
     	   exceptionHandler.handleException(e, "Add Issue Page");
     	    throw e; 
     	}
     }
 
     @Then("Selecting Type from the drop-down using sheetname {string} and rownumber {int}")
     public void Selecting_Type_from_the_drop_down(String sheetname, int rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
        
        String Type = testdata.get(rownumber).get("Type");
        Thread.sleep(1000);
        ISU.ClickOnType();
        ISU.EnterOnType(Type);
        ISU.selectDropdownOption(Type);
        Thread.sleep(1000);
        performTabKeyPress();
        performTabKeyPress();
        LoginInputDatas("Type", Type);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Issue Page");
		    throw e; 
		}

     }
     
     
     @Then("Selecting Placement from the drop-down using sheetname {string} and rownumber {int}")
     public void Selecting_Placement_from_the_drop_down(String sheetname, int rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
        
        String Placement = testdata.get(rownumber).get("Placement");
        Thread.sleep(1000);
        ISU.ClickOnPlacement();
        ISU.EnterOnPlacement(Placement);
        ISU.selectDropdownOption(Placement);
        Thread.sleep(1000);
        performTabKeyPress();
        performTabKeyPress();
        LoginInputDatas("Placement", Placement);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Issue Page");
		    throw e; 
		}
     }
     
     
     @Then("Selecting Root cause from the drop-down using sheetname {string} and rownumber {int}")
     public void Selecting_Root_cause_from_the_drop_down(String sheetname, int rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
        
        String Rootcause = testdata.get(rownumber).get("Root Cause");
        Thread.sleep(1000);
        ISU.ClickOnRootCause();
        ISU.EnterOnRootCause(Rootcause);
        ISU.selectDropdownOption(Rootcause);
        Thread.sleep(1000);
        performTabKeyPress();
        performTabKeyPress();
        LoginInputDatas("Rootcause", Rootcause);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Issue Page");
		    throw e; 
		}
     }
     
     @Then("Selecting Workflow from the drop-down in add issue using sheetname {string} and rownumber {int}")
     public void selecting_workflow_from_the_drop_down_in_add_issue_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
        
        String Workflow = testdata.get(rownumber).get("Workflow");
        Thread.sleep(1000);
        ISU.ClickOnWorkflow();
        ISU.EnterOnWorkflow(Workflow);
        ISU.selectDropdownOption(Workflow);
        Thread.sleep(1000);
        performTabKeyPress();
        performTabKeyPress();
        LoginInputDatas("Workflow", Workflow);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Issue Page");
		    throw e; 
		}
     }
     
     @Then("Entering Location in the field in add issue using sheetname {string} and rownumber {int}")
     public void Entering_Location_in_the_field_in_add_issue(String sheetname, int rownumber) throws Exception {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
     
			String Location = testdata.get(rownumber).get("Location");
			Thread.sleep(1000);
			ISU.EnterOnLocation(Location);
			LoginInputDatas("Location", Location);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Issue Page");
		    throw e; 
		}
     }
     

@Then("Entering valid Estimate cost in the field in add issue using sheetname {string} and rownumber {int}")
public void entering_valid_estimate_cost_in_the_field_in_add_issue_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String EstimateCost = testdata.get(rownumber).get("Estimate Cost");
			ISU.ClickOnEstimateCost();
			ISU.ClearOnEstimateCost();
			Thread.sleep(1000);
			ISU.EnterOnEstimateCost(EstimateCost);
			LoginInputDatas("EstimateCost", EstimateCost);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Issue Page");
		    throw e; 
			}
		} 



@Then("Entering valid Actual cost in the field in add issue using sheetname {string} and rownumber {int}")
public void entering_valid_actual_cost_in_the_field_in_add_issue_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ActualCost = testdata.get(rownumber).get("Actual Cost");
			ISU.ClickOnActualCost();
			ISU.ClearOnActualCost();
			Thread.sleep(1000);
			ISU.EnterOnActualCost(ActualCost);
			LoginInputDatas("ActualCost", ActualCost);
			} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add Issue Page");
		    throw e; 
		}
}


	@Then("Uploading an Image in the field in add issue using sheetname {string} and rownumber {int}")
	public void Uploading_an_Image_in_the_field_in_add_issue(String sheetname, int rownumber) {
		 try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
	    System.out.println("Sheet data: " + testData);

	    String imageFilePath = testData.get(rownumber).get("Upload Images");

	    ISU.UploadingAnImage(imageFilePath);
	    LoginInputDatas("imageFilePath", imageFilePath);
		 } catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			   exceptionHandler.handleException(e, "Add Issue Page");
			    throw e; 
			}
	}

     
     @Then("Selecting Attach files from the drop-down in add issue using sheetname {string} and rownumber {int}")
     public void Selecting_Attach_files_from_the_drop_down_in_add_issue(String sheetname, int rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String Attachfile = testdata.get(rownumber).get("Attachfile");
 			String FileName = testdata.get(rownumber).get("File Name");
 			Thread.sleep(1000);
 			RVW.ClickOnAttachFiles();
 			Thread.sleep(1000);
 			ISU.attachFile(Attachfile,FileName);
 			Thread.sleep(1000);													
 			RVW.clickOnRequiredFile(FileName);
 			Thread.sleep(2000);
 			RVW.ClickOnAttachButton();
 			LoginInputDatas("Attachfile", Attachfile);
 			LoginInputDatas("FileName", FileName);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Issue Page");
 		    throw e; 
 		} 
     }
     
     @Then("Clicking on Create button to create a Issue in the project")
     public void Clicking_on_Create_button_to_create_a_Issue_in_the_project() throws Exception {
    	 try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
 			Thread.sleep(2000);
 			RVW.ClickOnCreateButton();
 	} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Issue Page");
 		    throw e; 
 		}
     }
     
      // Actions - > RFA page Creation
     
     @Then("Clicking on RFA sub-module from sidebar")
     public void Clicking_on_RFA_sub_module_from_sidebar() throws Exception {
    	 try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
  			Thread.sleep(2000);
  			RFA.ClickOnRFA();
  	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Add RFA Page");
  		    throw e; 
  		}
     }
     
     @Then("Clicking on ADD button to create Add RFA")
     public void Clicking_on_ADD_button_to_create_Add_RFA() throws Exception {
    	 try {
   			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
   			Thread.sleep(2000);
   			RFA.ClickOnAddButton();
   	} catch (Exception e) {
   			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
   		   exceptionHandler.handleException(e, "Add RFA Page");
   		    throw e; 
   		}
     }

     

     @Then("Entering valid code on RFA Code field using sheetname {string} and rownumber {int}")
     public void entering_valid_code_on_rfa_code_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		 List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		 System.out.println("sheet name: " + testdata);

		 String RFACode = testdata.get(rownumber).get("RFA Code");
		 Thread.sleep(1000);
		 RFA.ClearOnRFACode();
		 Thread.sleep(1000);
		 RFA.EnterOnRFACode(RFACode);
		 LoginInputDatas("RFACode", RFACode);
	 } catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add RFA creation Page");
		    throw e; 
		}
}



     @Then("Entering valid name on RFA Name field using sheetname {string} and rownumber {int}")
     public void entering_valid_name_on_RFA_name_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		 List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		 System.out.println("sheet name: " + testdata);

		 String RFAName = testdata.get(rownumber).get("RFA Name");
		 RFA.EnterOnRFAName(RFAName);
		 LoginInputDatas("RFAName", RFAName);
	 	} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add RFA creation Page");
		    throw e; 
		}
}



     @Then("Entering Description on the field in add RFA using sheetname {string} and rownumber {int}")
     public void entering_description_on_the_field_in_add_RFA_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		 List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		 System.out.println("sheet name: " + testdata);

		 String Description = testdata.get(rownumber).get("Description");
		 RFA.ClearOnDescription();
		 Thread.sleep(1000);
		 RFA.EnterOnDescription(Description);
		 LoginInputDatas("Description", Description);
	 } catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add RFA creation Page");
		    throw e; 
		}
}
     
     

     @Then("Entering valid start date on the field in add RFA using sheetname {string} and rownumber {int}")
     public void entering_valid_start_date_on_the_field_in_RFA_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
		   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

	        	  System.out.println("sheet name: " + testdata);
    
	        	  String RFAStartDate = testdata.get(rownumber).get("Start Date");
	        	String RFAStartMonth = testdata.get(rownumber).get("Start Month");
	        	String RFAStartYear = testdata.get(rownumber).get("Start Year");
	        	
	        	if (RFAStartYear != null && RFAStartYear.matches("\\d+\\.0")) {
	        		RFAStartYear = RFAStartYear.substring(0, RFAStartYear.indexOf(".0"));
	        	
	        	  Thread.sleep(1000);
			RFA.ClickOnStartDate();
			RFA.ClearOnStartDate();
			RFA.EnterOnStartDate(RFAStartDate);
			RFA.EnterOnStartDate(RFAStartMonth);
			RFA.EnterOnStartDate(RFAStartYear);
		    LoginInputDatas("RFAStartDate", RFAStartDate);
		    LoginInputDatas("RFAStartMonth", RFAStartMonth);
		    LoginInputDatas("RFAStartYear", RFAStartYear);
	        	}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Add RFA Page");
		    throw e; 
		}
}



     @Then("Entering valid End date on the field in add RFA using sheetname {string} and rownumber {int}")
     public void entering_valid_end_date_on_the_field_in_add_RFA_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
	   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

        	  System.out.println("sheet name: " + testdata);

        	  String RFAEndDate = testdata.get(rownumber).get("End Date");
        	String RFAEndMonth = testdata.get(rownumber).get("End Month");
        	String RFAEndYear = testdata.get(rownumber).get("End Year");
        	
        	if (RFAEndYear != null && RFAEndYear.matches("\\d+\\.0")) {
        		RFAEndYear = RFAEndYear.substring(0, RFAEndYear.indexOf(".0"));
        	
        	  Thread.sleep(1000);
		RFA.ClickOnEndDate();
		RFA.ClearOnEndDate();
		RFA.EnterOnEndDate(RFAEndDate);
		RFA.EnterOnEndDate(RFAEndMonth);
		RFA.EnterOnEndDate(RFAEndYear);
	    LoginInputDatas("RFAEndDate", RFAEndDate);
	    LoginInputDatas("RFAEndMonth", RFAEndMonth);
	    LoginInputDatas("RFAEndYear", RFAEndYear);
        	}
	} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	   exceptionHandler.handleException(e, "Add RFA Page");
	    throw e; 
	}
}  
     
     
     
     @Then("Selecting Workflow from the drop-down in add RFA using sheetname {string} and rownumber {int}")
     public void selecting_workflow_from_the_drop_down_in_add_RFA_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		System.out.println("sheet name: " + testdata);
   
		String Workflow = testdata.get(rownumber).get("Workflow");
		Thread.sleep(1000);
		RFA.ClickonWorkFlow();
		RFA.EnterOnWorkFlow(Workflow);
		RFA.selectDropdownOption(Workflow);
		Thread.sleep(1000);
		performTabKeyPress();
		performTabKeyPress();
		LoginInputDatas("Workflow", Workflow);
		} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	   exceptionHandler.handleException(e, "Add RFA Page");
	    throw e; 
	}
}
     
     @Then("Selecting priority from the drop-down in add RFA using sheetname {string} and rownumber {int}")
	 public void selecting_priority_from_the_drop_down_in_add_RFA_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		System.out.println("sheet name: " + testdata);

		String Priority = testdata.get(rownumber).get("Priority");
		System.out.println(Priority);
		Thread.sleep(1000);
		RFA.ClickOnPriority();		
		Thread.sleep(1000);
		RFA.selectDropdownOptionForPriority(Priority);
		LoginInputDatas("Priority", Priority);
		} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	   exceptionHandler.handleException(e, "Add RFA Page");
	    throw e; 
	} 
}    
     
     @Then("Selecting Attach files from the drop-down and attaching the files using sheetname {string} and rownumber {int}")
     public void Selecting_Attach_files_from_the_drop_down_and_attaching_the_files(String sheetname, int rownumber) throws Exception {
    	 try {
     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		System.out.println("sheet name: " + testdata);

		String Attachfile = testdata.get(rownumber).get("Attachfile");
		String FileName = testdata.get(rownumber).get("File Name");
		Thread.sleep(1000);
		RVW.ClickOnAttachFiles();
		Thread.sleep(1000);
		RFA.attachFile(Attachfile,FileName);
		Thread.sleep(1000);													
		RVW.clickOnRequiredFile(FileName);
		Thread.sleep(2000);
		RVW.ClickOnAttachButton();
		LoginInputDatas("Attachfile", Attachfile);
		LoginInputDatas("FileName", FileName);
		} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	   exceptionHandler.handleException(e, "Add RFA Page");
	    throw e; 
	} 
}   
     
     
	@Then("Clicking on Create button to create a RFA for the project")
	public void  Clicking_on_Create_button_to_create_a_RFA_for_the_project() throws Exception {
	 try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
		Thread.sleep(2000);
		RVW.ClickOnCreateButton();
	 } catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	   exceptionHandler.handleException(e, "Add RFA Page");
	    throw e; 
	}
}
     
	
	//Share - > Meeting module to create meeting for the project discussion
	
     
    @Then("Clicking on Share module from sidebar") 
    public void Clicking_on_Share_module_from_sidebar() throws Exception {
    	 try {
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
    			Thread.sleep(2000);
    			MET.ClickOnShare();
    	} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Add Meeting creation Page");
    		    throw e; 
    	}	
    }
     
    @Then("Clicking on Meeting sub-module")
    public void Clicking_on_Meeting_sub_module() throws Exception {
    	 try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
 			Thread.sleep(2000);
 			MET.ClickOnMeeting();
    	 } catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Meeting creation Page");
 		    throw e; 
    	 }
    }
     
     
     @Then("Clicking on Add button to create Meeting for the project")
     public void Clicking_on_Add_button_to_create_Meeting_for_the_project() throws Exception {
    	 try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
  			Thread.sleep(2000);
  			MET.ClickOnAddButton();
     	 } catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Add Meeting creation Page");
  		    throw e; 
     	 }
     }
     
     @Then("Entering meeting name on Name field in add Meeting using sheetname {string} and rownumber {int}")
     public void Entering_meeting_name_on_Name_field_in_add_Meeting(String sheetname, int rownumber) {
    	 try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String MeetingName = testdata.get(rownumber).get("Name"); 
			MET.EnterOnName(MeetingName);
			
			LoginInputDatas("MeetingName", MeetingName);
 		} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Meeting creation Page");
 		    throw e; 
 		} 
     }
     
     @Then("Entering Meeting Date on date field in add Meeting using sheetname {string} and rownumber {int}")
     public void Entering_Meeting_Date_on_date_field_in_add_Meeting(String sheetname, int rownumber) throws Exception {
    	 try {
    		   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
    	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

    	        	  System.out.println("sheet name: " + testdata);

    	        	  String MeetingStartDate = testdata.get(rownumber).get("Meeting Start Date");
    	        	String MeetingStartMonth = testdata.get(rownumber).get("Meeting Start Month");
    	        	String MeetingStartYear = testdata.get(rownumber).get("Meeting Start Year");
    	        	
    	        	if (MeetingStartYear != null && MeetingStartYear.matches("\\d+\\.0")) {
    	        		MeetingStartYear = MeetingStartYear.substring(0, MeetingStartYear.indexOf(".0"));
    	        	
    	        		System.out.println(MeetingStartYear);    	        		
    	        	  Thread.sleep(1000);
    			MET.ClickOnDate();
    			MET.ClearOnDate();
    			MET.EnterOnDate(MeetingStartDate);
    			MET.EnterOnDate(MeetingStartMonth);
    			performTabKeyPress();
    			MET.EnterOnDate(MeetingStartYear);
    		    LoginInputDatas("MeetingStartDate", MeetingStartDate);
    		    LoginInputDatas("MeetingStartMonth", MeetingStartMonth);
    		    LoginInputDatas("MeetingStartYear", MeetingStartYear);
    	        	}
    		} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Add Meeting Page");
    		    throw e; 
    		}
     }
     
     
     @Then("Entering Meeting Time on date field in add Meeting using sheetname {string} and rownumber {int}")
     public void Entering_Meeting_Time_on_date_field_in_add_Meeting(String sheetname, int rownumber) throws Exception {
    	 try {
    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
       	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

       	  System.out.println("sheet name: " + testdata);

       	  String Hour = testdata.get(rownumber).get("Hour");
       	String Minute = testdata.get(rownumber).get("Minute");
       	String AM_PM = testdata.get(rownumber).get("AM/PM");
       	
    	Thread.sleep(1000);
		MET.ClickOnTime();
		MET.ClearOnTime();
		MET.EnterOnTime(Hour);
		MET.EnterOnTime(Minute);
		MET.EnterOnTime(AM_PM);
	    LoginInputDatas("Hour", Hour);
	    LoginInputDatas("Minute", Minute);
	    LoginInputDatas("AM_PM", AM_PM);
    	 } catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Meeting Page");
 		    throw e; 
 		}
  }
     
     @Then("Entering Meeting Duration hours and minutes field in add Meeting using sheetname {string} and rownumber {int}")
     public void Entering_Meeting_Duration_hours_and_minutes_field_in_add_Meeting(String sheetname, int rownumber) throws Exception {
    	 try {
    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
       	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

       	  System.out.println("sheet name: " + testdata);

       	  String DurationHours = testdata.get(rownumber).get("Duration Hours");
       	String DurationMinutes = testdata.get(rownumber).get("Duration Minutes");
       	
    	Thread.sleep(1000);
		MET.ClearOnDurationHours();
		MET.EnterOnDurationHours(DurationHours);
		Thread.sleep(1000);
		MET.ClearOnDurationMinutes();
		MET.EnterOnDurationMinutes(DurationMinutes);
	    LoginInputDatas("DurationHours", DurationHours);
	    LoginInputDatas("DurationMinutes", DurationMinutes);
    	 } catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Meeting Page");
 		    throw e; 
 		}
     }
     
     @Then("Entering Description on the field in add Meeting using sheetname {string} and rownumber {int}")
     public void Entering_Description_on_the_field_in_add_Meeting(String sheetname, int rownumber) throws Exception {
    	 try {
    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
    		 List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

    		 System.out.println("sheet name: " + testdata);

    		 String Description = testdata.get(rownumber).get("Description");
    		 MET.ClearOnDescription();
    		 Thread.sleep(1000);
    		 MET.EnterOnDescription(Description);
    		 LoginInputDatas("Description", Description);
    	 } catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Add Meeting Page");
    		    throw e; 
    		} 
     }
     
     @Then("Entering Notes to the meeting in the Enter notes field if extra notes need to be add clicking on Add Notes button in add Meeting using sheetname {string} and rownumber {int}")
     public void Entering_Notes_to_the_meeting_in_the_Enter_notes_field_if_extra_notes_need_to_be_add_clicking_on_Add_Notes_button_in_add_Meeting(String sheetname, int rownumber) {
    	 try {
    		 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
    	        List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
    	        
    	        int i = rownumber;
    	        int notesEntered = 0; // To track the number of notes entered

    	        while (true) {
    	            String enterNoteData = testdata.get(i).get("Enter Notes");
    	            
    	            if (enterNoteData == null || enterNoteData.trim().isEmpty()) {
    	                break; // Exit if no more notes to enter
    	            }
    	            
    	            // Enter the note using the current notesEntered index
    	            MET.EnterOnNotes(enterNoteData, notesEntered);
    	            
    	            // Check if there's more data to enter
    	            String nextNoteData = null;
    	            if (i + 1 < testdata.size()) {
    	                nextNoteData = testdata.get(i + 1).get("Enter Notes");
    	            }
    	            
    	            if (nextNoteData == null || nextNoteData.trim().isEmpty()) {
    	                break; // No more notes to add
    	            } else {
    	                MET.ClickOnAddNotes(); // Click to add a new input field for the next note
    	            }
    	            
    	            notesEntered++; // Increment the index for the next note field
    	            i++; // Move to the next row
    	        }
    	    } catch (Exception e) {
    	        System.err.println("An error occurred: " + e.getMessage());
    	    }
     }
     
     @Then("Selecting the selected Participants from Select Users and Selected Group of Users in Add meeting using sheetname {string} and rownumber {int}")
     public void Selecting_the_selected_Participants_from_Select_Users_and_Selected_Group_of_Users_in_Add_meeting(String sheetname, int rownumber) {
    	 try {
    		 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
    	        List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
    	        int i = rownumber;
    	        while (i < testdata.size()) {
    	            String selectUsersData = testdata.get(i).get("Select users");

    	            if (selectUsersData != null && !selectUsersData.trim().isEmpty()) {
    	                MET.ClickOnSelectUsersTab();
    	                Thread.sleep(1000);
    	                MET.EnterOnSearchUser(selectUsersData);
    	                System.out.println(selectUsersData);
    	                
    	            } else {
    	                break;
    	            }
    	            i++; // Move to the next row
    	        }
    	        i = rownumber;

    	        while (i < testdata.size()) {
    	            String selectGroupUsersData = testdata.get(i).get("Select user groups");

    	            if (selectGroupUsersData != null && !selectGroupUsersData.trim().isEmpty()) {
    	            	Thread.sleep(1000);
    	                MET.ClickOnSelectGroupUsersTab();
    	                Thread.sleep(1000);
    	                MET.EnterOnSearchUserGroup(selectGroupUsersData);
    	                System.out.println(selectGroupUsersData);
    	            } else {
    	                break;
    	            }
    	            i++; // Move to the next row
    	        }
    	    } catch (Exception e) {
    	        System.err.println("An error occurred while selecting participants: " + e.getMessage());
    	    }
     }


     
     @Then("Uploading an Image in the field in add meeting using sheetname {string} and rownumber {int}")
 	public void Uploading_an_Image_in_the_field_in_add_meeting(String sheetname, int rownumber) {
 		 try {
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
 	    List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
 	    System.out.println("Sheet data: " + testData);

 	    String imageFilePath = testData.get(rownumber).get("Upload Images");

 	    ISU.UploadingAnImage(imageFilePath);
 	    LoginInputDatas("imageFilePath", imageFilePath);
 		 } catch (Exception e) {
 				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 			   exceptionHandler.handleException(e, "Add Meeting Page");
 			    throw e; 
 			}
 	}
     
     
     @Then("Selecting Attach files from the drop-down and attaching the files in Add Meeting using sheetname {string} and rownumber {int}")
     public void Selecting_Attach_files_from_the_drop_down_and_attaching_the_files_in_add_meeting(String sheetname, int rownumber) throws Exception {
    	 
     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		System.out.println("sheet name: " + testdata);

		String Attachfile = testdata.get(rownumber).get("Attachfile");
		String FileName = testdata.get(rownumber).get("File Name");
		Thread.sleep(1000);
		RVW.ClickOnAttachFiles();
		Thread.sleep(1000);
		MET.attachFile(Attachfile,FileName);
		Thread.sleep(1000);													
		RVW.clickOnRequiredFile(FileName);
		Thread.sleep(2000);
		RVW.ClickOnAttachButton();
		LoginInputDatas("Attachfile", Attachfile);
		LoginInputDatas("FileName", FileName);
	
}   
     
     
     @Then("Clicking on Create button to create a Meeting for the project")
 	public void  Clicking_on_Create_button_to_create_a_Meeting_for_the_project() throws Exception {
 	 try {
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
 		Thread.sleep(2000);
 		RVW.ClickOnCreateButton();
 	 } catch (Exception e) {
 		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 	   exceptionHandler.handleException(e, "Add Meeting Page");
 	    throw e; 
 	}
 }
     
     
     //Attachments - > BOM/BOQ Module Creation
     
     
     @Then("Clicking on Attachments module from sidebar")
     public void clicking_on_Attachments_module_from_sidebar() throws Exception {
    	 try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
 			Thread.sleep(1000);
 			BOM.ClickOnAttachments();
 		} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "BOM/BOQ Page");
 		    throw e; 
 		}
     }
     
     @Then("Clicking on BOM\\/BOQ sub-module")
     public void clicking_on_bom_boq_sub_module() throws Exception {
    	 try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
  			Thread.sleep(1000);
  			BOM.ClickOnBOM_BOQ();
  		} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "BOM/BOQ Page");
  		    throw e; 
  		}
     }
     
     @Then("Clicking on Add button to create BOM\\/BOQ for the project")
     public void clicking_on_add_button_to_create_bom_boq_for_the_project() throws Exception {
    	 try {
   			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
   			Thread.sleep(1000);
   			BOM.ClickOnAddButton();
   		} catch (Exception e) {
   			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
   		   exceptionHandler.handleException(e, "BOM/BOQ Page");
   		    throw e; 
   		}
     }
     
     

     @Then("Selecting Parent BOM\\/BOQ name from the drop-down in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void selecting_parent_bom_boq_name_from_the_drop_down_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	 try {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		 List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		 System.out.println("sheet name: " + testdata);

		 String ParentBOM = testdata.get(rownumber).get("Parent BOM");
		 System.out.println(ParentBOM);
		 Thread.sleep(1000);
         BOM.ClickOnParentBOM();
         Thread.sleep(1000);
         BOM.selectDropdownOption(ParentBOM);
         performTabKeyPress();
         //performTabKeyPress();
         LoginInputDatas("ParentBOM", ParentBOM);
	 } catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "BOM Page");
		    throw e; 
		}
}

     @Then("Entering valid code on BOM\\/BOQ Code field using sheetname {string} and rownumber {int}")
     public void entering_valid_code_on_bom_boq_code_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String Code = testdata.get(rownumber).get("Code");
 			BOM.ClickOnCode();
 			BOM.ClearOnCode();
 			Thread.sleep(1000);
 			BOM.EnterOnCode(Code);
 			LoginInputDatas("Code", Code);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "BOM Page");
 		    throw e; 
 		}
     }
     
     
     @Then("Entering valid name on Name field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void entering_valid_name_on_name_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String Name = testdata.get(rownumber).get("Name");
 			BOM.ClearOnName();
 			BOM.EnterOnName(Name);
 			LoginInputDatas("Name", Name);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "Add Issue Page");
 		    throw e; 
 		}
     }
     
     
     @Then("Selecting workflow on the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void selecting_workflow_on_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
     	 try {
          	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
          	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

     		System.out.println("sheet name: " + testdata);
         
         String Workflow = testdata.get(rownumber).get("Workflow");
         Thread.sleep(1000);
         BOM.ClickOnWorkflow();
         Thread.sleep(1000);
         BOM.selectDropdownOptionForWorkFlow(Workflow);
         LoginInputDatas("Workflow", Workflow);
     		} catch (Exception e) {
     		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
     	   exceptionHandler.handleException(e, "BOM Page");
     	    throw e; 
     	}
     }
     
     

     @Then("Selecting priority from the drop-down in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void selecting_priority_from_the_drop_down_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		System.out.println("sheet name: " + testdata);

		String Priority = testdata.get(rownumber).get("Priority");
		Thread.sleep(1000);
		BOM.ClickOnPriority();		
		Thread.sleep(1000);
		BOM.selectDropdownOptionForPriority(Priority);
		LoginInputDatas("Priority", Priority);
		} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	   exceptionHandler.handleException(e, "BOM Page");
	    throw e; 
	} 
}
     
     @Then("Entering valid unit field from the drop-down in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void entering_valid_unit_field_from_the_drop_down_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
    	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

    			System.out.println("sheet name: " + testdata);

    			String Unit = testdata.get(rownumber).get("Unit");
    			Thread.sleep(1000);
    			BOM.ClickOnUnit();	
    			BOM.EnterOnUnit(Unit);
    			Thread.sleep(1000);
    			BOM.selectDropdownOptionForUnit(Unit);
    			LoginInputDatas("Unit", Unit);
    			} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "BOM Page");
    		    throw e; 
    		} 
     }
     
     @Then("Entering valid Estimated Quantity in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void entering_valid_estimated_quantity_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String EstimatedQuantity = testdata.get(rownumber).get("Estimated Quantity");
 			Thread.sleep(1000);
 			BOM.EnterOnEstimatedQuantity(EstimatedQuantity);		
 			LoginInputDatas("EstimatedQuantity", EstimatedQuantity);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "BOM Page");
 		    throw e; 
 		} 
     }
     
     
     
     @Then("Entering valid Estimated Price per unit in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void entering_valid_estimated_price_per_unit_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String EstimatedPricePerUnit = testdata.get(rownumber).get("Estimated Price Per Unit");
 			Thread.sleep(1000);
 			BOM.EnterOnEstimatedPricePerUnit(EstimatedPricePerUnit);		
 			LoginInputDatas("EstimatedPricePerUnit", EstimatedPricePerUnit);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "BOM Page");
 		    throw e; 
 		} 
     }
     
     
     @Then("Verifying Estimated Total value in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void verifying_estimated_total_value_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);
 			String EstimatedQuantity = testdata.get(rownumber).get("Estimated Quantity");
 			String EstimatedPricePerUnit = testdata.get(rownumber).get("Estimated Price Per Unit");
 			String EstimatedTotal = testdata.get(rownumber).get("Estimated Total");
 			
 			Thread.sleep(1000);
 			String calculatedEstimatedTotal = BOM.getEstimatedTotal(); 			
 			double estimatedquantity = Double.parseDouble(EstimatedQuantity);
 	        double estimatedpricePerUnit = Double.parseDouble(EstimatedPricePerUnit);
 	        
 	        double estimatedTotalCalculated = estimatedquantity * estimatedpricePerUnit;
 	        
 	        
 	        String estimatedTotalCalculatedStr = String.valueOf(estimatedTotalCalculated);
 	        String estimatedTotalFieldValue = BOM.getEstimatedTotal();
 	        
 	       	Assert.assertEquals("Estimated Total value does not match!", estimatedTotalCalculatedStr, estimatedTotalFieldValue);
 	       	System.out.println(estimatedTotalCalculatedStr);
 	       	System.out.println(estimatedTotalFieldValue);
 			LoginInputDatas("EstimatedQuantity", EstimatedQuantity);
 			LoginInputDatas("EstimatedPricePerUnit", EstimatedPricePerUnit);
 			LoginInputDatas("Estimated Total", EstimatedTotal);
 			LoginInputDatas("estimatedTotalCalculatedStr", estimatedTotalCalculatedStr);
 			LoginInputDatas("estimatedTotalFieldValue", estimatedTotalFieldValue);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "BOM Page");
 		    throw e; 
 		} 
     }
     
     
     @Then("Entering valid Ordered Quantity in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void Entering_valid_Ordered_Quantity_in_the_field_in_bom_boq(String sheetname, Integer rownumber) throws Exception {
    	 try {	
    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String OrderedQuantity = testdata.get(rownumber).get("Ordered Quantity");
		
			BOM.ClearOnOrderedQuantity();		
			Thread.sleep(1000);
			BOM.EnterOnOrderedQuantity(OrderedQuantity);
			LoginInputDatas("OrderedQuantity", OrderedQuantity);
     
    	 } catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "BOM Page");
  		    throw e; 
  		} 
      }
     
     
     @Then("Entering valid Quoted Price per unit in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void entering_valid_Quoted_price_per_unit_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String QuotedPricePerUnit = testdata.get(rownumber).get("Quoted Price Per Unit");
 			BOM.ClearOnQuotedPricePerUnit();
 			Thread.sleep(1000);
 			BOM.EnterOnQuotedPricePerUnit(QuotedPricePerUnit);		
 			LoginInputDatas("QuotedPricePerUnit", QuotedPricePerUnit);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "BOM Page");
 		    throw e; 
 		} 
     }
     
     
     @Then("Verifying the Quoted Total value in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void verifying_Quoted_total_value_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);
 			String OrderedQuantity = testdata.get(rownumber).get("Ordered Quantity");
 			String QuotedPricePerUnit = testdata.get(rownumber).get("Quoted Price Per Unit");
 			String QuotedTotal = testdata.get(rownumber).get("Quoted Total");
 			
 			Thread.sleep(1000);
 			double orderedquantity = Double.parseDouble(OrderedQuantity);
 	        double quotedpricePerUnit = Double.parseDouble(QuotedPricePerUnit);
 	        
 	        double quotedTotalCalculated = orderedquantity * quotedpricePerUnit;
 	        
 	        
 	        String quotedTotalCalculatedStr = String.valueOf(quotedTotalCalculated);
 	        String quotedTotalFieldValue = BOM.getQuotedTotal();
 	        
 	       	Assert.assertEquals("Quoted Total value does not match!", quotedTotalCalculatedStr, quotedTotalFieldValue);
 	       	System.out.println(quotedTotalCalculatedStr);
 	       	System.out.println(quotedTotalFieldValue);
 	       	
 			LoginInputDatas("OrderedQuantity", OrderedQuantity);
 			LoginInputDatas("QuotedPricePerUnit", QuotedPricePerUnit);
 			LoginInputDatas("quotedTotalCalculatedStr", quotedTotalCalculatedStr);
 			LoginInputDatas("quotedTotalFieldValue", quotedTotalFieldValue);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "BOM Page");
 		    throw e; 
 		} 
     }
     
     @Then("Entering valid Actual Quantity in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void Entering_valid_Actual_Quantity_in_the_field_in_bom_boq(String sheetname, Integer rownumber) throws Exception {
    	 try {	
    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ActualQuantity = testdata.get(rownumber).get("Actual Quantity");
		
			BOM.ClearOnActualQuantity();		
			Thread.sleep(1000);
			BOM.EnterOnActualQuantity(ActualQuantity);
			LoginInputDatas("ActualQuantity", ActualQuantity);
     
    	 } catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "BOM Page");
  		    throw e; 
  		} 
      }
     
     
     @Then("Entering valid Actual Price per unit in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void entering_valid_Actual_price_per_unit_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);

 			String ActualPricePerUnit = testdata.get(rownumber).get("Actual Price Per Unit");
 			BOM.ClearOnActualPricePerUnit();
 			Thread.sleep(1000);
 			BOM.EnterOnActualPricePerUnit(ActualPricePerUnit);		
 			LoginInputDatas("ActualPricePerUnit", ActualPricePerUnit);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "BOM Page");
 		    throw e; 
 		} 
     }
     
     
     @Then("Verifying the Actual Total value in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void verifying_Actual_total_value_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	 try {
 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

 			System.out.println("sheet name: " + testdata);
 			String ActualQuantity = testdata.get(rownumber).get("Actual Quantity");
 			String ActualPricePerUnit = testdata.get(rownumber).get("Actual Price Per Unit");
 			String ActualTotal = testdata.get(rownumber).get("Actual Total");
 			
 			Thread.sleep(1000);
 			double actualquantity = Double.parseDouble(ActualQuantity);
 	        double actualpricePerUnit = Double.parseDouble(ActualPricePerUnit);
 	        
 	        double actualotalCalculated = actualquantity * actualpricePerUnit;
 	        
 	        
 	        String actualTotalCalculatedStr = String.valueOf(actualotalCalculated);
 	        String actualTotalFieldValue = BOM.getActualTotal();
 	        
 	       	Assert.assertEquals("Actual Total value does not match!", actualTotalCalculatedStr, actualTotalFieldValue);
 	       	System.out.println(actualTotalCalculatedStr);
 	       	System.out.println(actualTotalFieldValue);
 	       	
 			LoginInputDatas("ActualQuantity", ActualQuantity);
 			LoginInputDatas("ActualPricePerUnit", ActualPricePerUnit);
 			LoginInputDatas("actualTotalCalculatedStr", actualTotalCalculatedStr);
 			LoginInputDatas("actualTotalFieldValue", actualTotalFieldValue);
 			} catch (Exception e) {
 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 		   exceptionHandler.handleException(e, "BOM Page");
 		    throw e; 
 		} 
     }
     
     @Then("Entering valid Remarks in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void Entering_valid_Remarks_in_the_field_in_bom_boq(String sheetname, Integer rownumber) throws Exception {
    	 try {
  	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
  	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

  			System.out.println("sheet name: " + testdata);

  			String Remarks = testdata.get(rownumber).get("Remarks");
  			Thread.sleep(1000);
  			BOM.EnterOnRemarks(Remarks);		
  			LoginInputDatas("Remarks", Remarks);
  			} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "BOM Page");
  		    throw e; 
  		}  
     }
     
     
     
     @Then("Entering valid GUID in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void Entering_valid_GUID_in_the_field_in_bom_boq(String sheetname, Integer rownumber) throws Exception {
    	 try {
  	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
  	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

  			System.out.println("sheet name: " + testdata);

  			String GUID = testdata.get(rownumber).get("GUID");
  			Thread.sleep(1000);
  			BOM.EnterOnGUID(GUID);		
  			LoginInputDatas("GUID", GUID);
  			} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "BOM Page");
  		    throw e; 
  		}  
     }
     
     
     @Then("Uploading valid QR code file in the Attach QR code field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
     public void uploading_valid_qr_code_file_in_the_attach_qr_code_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname, Integer rownumber) {
    	 try {
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    		    List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
    		    System.out.println("Sheet data: " + testData);

    		    String QRCode = testData.get(rownumber).get("QR Code");

    		    BOM.UploadingQRCode(QRCode);
    		    LoginInputDatas("QRCode", QRCode);
    			 } catch (Exception e) {
    					ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    				   exceptionHandler.handleException(e, "BOM Page");
    				    throw e; 
    				}
    		}

     
     @Then("Clicking on Add Properties button and entering values in the field Property name and Property value using sheetname {string} and rownumber {int}")
     public void Clicking_on_Add_Properties_button_and_entering_values_in_the_field_Property_name_and_Property_value(String sheetname, int rownumber) throws Exception {
    	 try { 
    	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    	        List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
    	        System.out.println("Sheet data: " + testData);

    	        // Initialize the row number to 0 to start with the first row
    	        int rownumber1 = 0;

    	        // Loop through rows until an empty Property Name or Property Value is found
    	        while (rownumber1 < testData.size()) {
    	            String propertyName = testData.get(rownumber1).get("Property Name");
    	            String propertyValue = testData.get(rownumber1).get("Property Value");

    	            // Check if either Property Name or Property Value is empty
    	            if (propertyName == null || propertyName.isEmpty() || propertyValue == null || propertyValue.isEmpty()) {
    	                break; // Exit the loop when encountering empty data
    	            }

    	            BOM.ClickOnAddPropertiesButton();
    	            Thread.sleep(1000);
    	            BOM.ClickOnPropertyName();
    	            Thread.sleep(1000);
    	            BOM.EnterOnPropertyName(propertyName);
    	            Thread.sleep(1000);
    	            BOM.ClickOnPropertyValue();
    	            Thread.sleep(1000);
    	            BOM.EnterOnPropertyValue(propertyValue);
    	            Thread.sleep(1000);
    	            BOM.ClickOnSubmitButton();
    	            Thread.sleep(1000);
    	            rownumber1++;
    	        }

    	    } catch (Exception e) {
    	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    	        exceptionHandler.handleException(e, "BOM Page");
    	        throw e;
    	    }
     }
     
     
     @Then("Clicking on Create button to create BOM for the project")
     public void Clicking_on_Create_button_to_create_BOM_for_the_project() {
    	 try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25)); 
 			BOM.ClickOnCreateButton();
    	 } catch (Exception e) {
 	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 	        exceptionHandler.handleException(e, "BOM Page");
 	        throw e;
 	    }
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     private void takeScreenshot(int rowNumber) {
 		try {
 			// Take a screenshot
 			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 			String screenshotPath = "C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\screenshot\\" + rowNumber
 					+ ".png";

 			// Save the screenshot to the specified path
 			FileUtils.copyFile(screenshot, new File(screenshotPath));

 			// Attach the screenshot to the Allure report
 			Allure.addAttachment("Screenshot for Row " + rowNumber,
 					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

 			// Attach the screenshot to the Extent report
 			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

 		} catch (IOException e) {
 			e.printStackTrace();

 		}
 	}

 	private void takeScreenshotStr(String rowNumber) {
 		try {
 			// Take a screenshot
 			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 			String screenshotPath = "C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\screenshot\\" + rowNumber
 					+ ".png";

 			// Save the screenshot to the specified path
 			FileUtils.copyFile(screenshot, new File(screenshotPath));

 			// Attach the screenshot to the Allure report
 			Allure.addAttachment("Screenshot for Row " + rowNumber,
 					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

 			// Attach the screenshot to the Extent report
 			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

 		} catch (IOException e) {
 			e.printStackTrace();

 		}
 	}

 	private void performTabKeyPress() throws AWTException {
 		Robot robot = new Robot();
 		robot.keyPress(KeyEvent.VK_TAB);
 		robot.keyRelease(KeyEvent.VK_TAB);
 	}

 	private void LoginInputDatas(String fieldName, String fieldValue) {

 		test = ExtentCucumberAdapter.getCurrentStep();

 		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
 				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldName + "</td></tr>"
 				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldValue + "</td></tr>" + "</table>";

 		Allure.addAttachment("Input Data", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

 		String[][] data = { { fieldName }, { fieldValue }, };
 		Markup m = MarkupHelper.createTable(data);

 		// Log the table in Extent Report
 		test.log(Status.PASS, m);
 	}

     
     
     
 	
 	
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
