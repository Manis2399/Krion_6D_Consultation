package Testcases;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;

public class DesingProjectTestcases {

	
	 private WebDriver driver;
     private Locators.LoginLocators L;
     private Locators.Design_Projects_Locators D;
     private Locators.Roles_Locators R;
     private Locators.AssignRole_Locators AR;
     private Locators.WorkFlowLocators WF;
     private ExtentTest test;
     private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
     
     @Before
     public void setUp() throws InvalidFormatException, IOException {
         excelDataManager.loadData("C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\Excel\\TigerKrionDataSheet.xlsx");
     }
     

     public DesingProjectTestcases() throws InterruptedException {
         System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
         System.setProperty("webdriver.chrome.verboseLogging", "true");
         this.driver = CustomWebDriverManager.getDriver();
         this.R = new Locators.Roles_Locators(driver);
         this.AR = new Locators.AssignRole_Locators(driver);
         this.WF = new Locators.WorkFlowLocators(driver);
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
			WF.ClickOnWorkflow();
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
