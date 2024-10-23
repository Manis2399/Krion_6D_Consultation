package Testcases;
import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class WorkflowTestcases {
	WebDriverWait wait;
	 private WebDriver driver;
	 private Locators.WorkFlowLocators WF;
	 private ExtentTest test;
	 private Locators.AssignRole_Locators AR;
     private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
     private List<List<String>> approvalSteps;
     private static final String EXCEL_FILE_PATH = "C:\\path\\to\\your\\excel\\file.xlsx";
     private static final String SHEET_NAME = "YourSheetName"; // Specify your sheet name
     private Locators.LoginLocators L;
     private Locators.Design_Projects_Locators D;
     
	 @Before
     public void setUp() throws InvalidFormatException, IOException {
         excelDataManager.loadData("C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\Excel\\TigerKrionDataSheet.xlsx");
        // loadApprovalStepsFromExcel();
     }
	
	
	 public WorkflowTestcases() throws InterruptedException {
         System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
         System.setProperty("webdriver.chrome.verboseLogging", "true");
         this.driver = CustomWebDriverManager.getDriver();
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         this.WF = new Locators.WorkFlowLocators(driver);
         this.AR = new Locators.AssignRole_Locators(driver);
         this.D = new Locators.Design_Projects_Locators(driver);
     }
     
	 
	 
	 
	 @Given("I visit the User Login for Design Projects for wf using sheetname {string} and rownumber {int}")
     public void i_visit_the_user_login_for_Design_projects_for_wf_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
           
           String email = testdata.get(rownumber).get("Login Email");
           String password = testdata.get(rownumber).get("Login Password");

           L = new Locators.LoginLocators(driver);
           L.EnterEmail(email);
           L.EnterPassword(password);
           
     }
     
     @Given("I enter the credentials in login and click a login button for wf")
     public void i_enter_the_credentials_in_login_and_click_a_login_button_for_wf() {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 			L.ClickOnLogin();
     }
     
     
     @Then("Clicking on Project module under Design section for wf")
     public void clicking_on_project_module_under_design_section_for_wf() throws Exception {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
 			Thread.sleep(1000);
 			D.ClickOnDesignProject();
     }
	 
	 
     @Then("filtering the required project and clickin on it for wf using sheetname {string} and rownumber {int}")
     public void filtering_the_required_project_and_clickin_on_it_for_wf_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws AWTException, InterruptedException {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
         List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
         String projectName = testdata.get(rownumber).get("Project name");
         Thread.sleep(4000);
         AR.EnterOnSearchBox(projectName);
         Thread.sleep(2000);
         AR.clickOnProject(projectName);
     }
	 
	 
     @Then("Clciking on Setting module in newly Created Project under Design module for wf")
     public void clciking_on_setting_module_in_newly_created_project_under_design_module() {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
  			AR.ClickOnSetting();
     }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @Then("Creating workflow based on the type selected in the select category of the project using sheetname {string} and rownumber {int}")
	 public void creating_workflow_based_on_the_type_selected_in_the_select_category_of_the_project(String sheetname, Integer startRownumber) throws Exception {
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	         List<Map<String, String>> categoryData = excelDataManager.getCachedData(sheetname);
	         int rownumber = startRownumber;

	         // Continue to create workflows as long as there is data in the 'SelectTheCategory' column
	         while (rownumber < categoryData.size()) {
	             String categoryName = categoryData.get(rownumber).get("SelectTheCategory");

	             // Break the loop if "SelectTheCategory" is empty
	             if (categoryName == null || categoryName.isEmpty()) {
	                 break;
	             }

	             // Step 1: Click on Workflow sub-module under settings in the newly Created Project under Design module
	             WF.ClickOnWorkflow();

	             // Step 2: Click on Select the category drop-down and select the required category
	             WF.ClickOnSelectTheCategoryDropdown();
	             WF.selectCategoryFromDropdown(categoryName);

	             // Step 3: Click on Add Workflow button
	             Thread.sleep(2000);
	             WF.ClickOnAddWorkflowButton();

	             // Step 4: Select the stepper from the dropdown
	             String selectSteps = categoryData.get(rownumber).get("Select Steps");
	             if (selectSteps != null && !selectSteps.isEmpty()) {
	                 WF.ClickOnSelectSteppers();
	                 WF.selectDropdownOptionSteppersSelection(selectSteps);
	             }

	             // Step 5: Enter the valid Name
	             String reviewName = categoryData.get(rownumber).get("Name");
	             if (reviewName != null && !reviewName.isEmpty()) {
	                 WF.EnterOnName(reviewName);
	             }

	             // Step 6: Enter the Description
	             String description = categoryData.get(rownumber).get("Description");
	             if (description != null && !description.isEmpty()) {
	                 WF.EnterOnDescription(description);
	             }

	             // Step 7: Select Workflow Category
	             String workflowCategory = categoryData.get(rownumber).get("Workflow category");
	             if (workflowCategory != null && !workflowCategory.isEmpty()) {
	                 WF.ClickOnSelectCategory();
	                 WF.selectDropdownOptionSelectCategory(workflowCategory);
	             }

	             // Step 8: Select Status
	             String status = categoryData.get(rownumber).get("Status");
	             if (status != null && !status.isEmpty()) {
	                 WF.ClickOnStatus();
	                 WF.selectDropdownOptionSelectStatus(status);
	             }

	             // Step 9: Enter the valid Name for Approval
	             String nameForApproval = categoryData.get(rownumber).get("Name for approval");
	             if (nameForApproval != null && !nameForApproval.isEmpty()) {
	                 WF.ClearOnNameForApproval();
	                 WF.EnterOnNameForApproval(nameForApproval);
	             }

	             // Step 10: Fill in the approval steps from the sheet
	             fillApprovalSteps(sheetname);

	             // Step 11: Click on Create button to create the workflow
	             Thread.sleep(2000);
	             WF.ClickOnCreateButton();

	             // Move to the next row
	             rownumber++;
	         }
	 }


	
	
	 public void fillApprovalSteps(String sheetname) throws InterruptedException, AWTException {
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		    
		    List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		    for (int i = 0; i < testdata.size(); i++) {
		        Map<String, String> stepData = testdata.get(i);

		        String stepName = stepData.get("Step Name");
		        String user = stepData.get("User");
		        String usergroup = stepData.get("User Group");
		        String description = stepData.get("Description");

		        if (stepName == null || stepName.trim().isEmpty()) {
		            continue;
		        }

		        // Start stepIndex from i (i.e. 0 will map to multiUser0)
		        int stepIndex = i;

		        WF.enterStepName(stepIndex, stepName);

		        // Handle Select Users
		        if (user != null && !user.trim().isEmpty()) {
		          //  WF.clickOnSelectUsers(stepIndex);
		            searchUserFromDropdownForSelectUsersTab(user, stepIndex);
		            Thread.sleep(3000);
		        }

		        //Handle Select User Groups
//		        if (user != null && !user.trim().isEmpty()) {
//			            WF.clickOnStepSelectUsersGroups(stepIndex);
//			            searchUserFromDropdownForSelectUserGroupTab(usergroup, stepIndex);
//			            Thread.sleep(3000);
//			    }
		        
		        // Handle Description
		        if (description != null && !description.trim().isEmpty()) {
		            WF.enterValueInStepDescriptionField(description, stepIndex);
		        }
		    }
		}

	
	
	
	
	
	public void clickOnSelectUser(int stepNumber) {
	    try {
	        // Construct the dynamic XPath for the 'stepName' field based on the step number
	        String stepNameXPath = "//*[@id='stepName" + (stepNumber - 1) + "']";

	        System.out.println(stepNameXPath);
	        // Locate the WebElement using the dynamic XPath
	        WebElement stepNameInput = driver.findElement(By.xpath(stepNameXPath));

	        // Wait until the element is clickable and then perform the click
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(stepNameInput));
	            stepNameInput.click();
	        } catch (ElementClickInterceptedException e) {
	            System.err.println("Element click intercepted: " + e.getMessage());
	            // Optionally, you could retry the click or implement additional logic here if needed
	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	        }
	    } catch (NoSuchElementException e) {
	        System.err.println("StepName element for step " + stepNumber + " not found: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred while locating the element: " + e.getMessage());
	    }
	}

	
	
	
	
	
	public void searchUserFromDropdownForSelectUsersTab(String userName, int step) throws InterruptedException {

	    // Construct the dynamic XPath for the multi-user input field based on step number
	    String dynamicXPath = "//*[@id='multiUser" + step + "']/div/div/span[3]/input";
	    
	    System.out.println(dynamicXPath);
	    // Construct the dynamic XPath for the user option in the dropdown
	    String userOptionXPath = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
	            + userName.toLowerCase() + "')]";

	    try {
	        // Locate the search field for the specified step using the XPath
	        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));

	        searchField.click();
	        searchField.clear();
	        Thread.sleep(3000); 
	        searchField.sendKeys(userName);

	        // Optionally wait for dropdown options to load
	        Thread.sleep(500); // You can replace this with an explicit wait if needed

	      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li")));
	        
	        
	        // Wait for the dropdown option to be visible and clickable
	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userOptionXPath)));

	        // Scroll the option into view and click it
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();

	        // Optionally, locate and interact with the multi-user input field
	        WebElement multiUserInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
	        multiUserInput.click(); // Click on the multi-user input field

	    } catch (TimeoutException e) {
	        System.out.println("The dropdown option '" + userName + "' for step " + step + " is not found or not clickable within the timeout.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + userName + "' on step " + step + ". Trying to click via JavaScript.");
	        try {
	            WebElement optionElement = driver.findElement(By.xpath(userOptionXPath));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	        } catch (NoSuchElementException ex) {
	            System.out.println("The dropdown option '" + userName + "' could not be found after intercept.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Search field for step " + step + " is not found.");
	    }
	}

	
	
	
	
	
	
	
	
	
	
	public void searchUserFromDropdownForSelectUserGroupTab(String userName, int step) throws InterruptedException {
	    // Construct the dynamic XPath for the multi-user input field based on step number
	    String dynamicXPath = "//*[@id='multiUserGroup" + step + "']/div/div/span[3]/input";

	    // Construct the dynamic XPath for the user option in the dropdown
	    String userOptionXPath = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
	            + userName.toLowerCase() + "')]";

	    try {
	        // Locate the search field for the specified step using the XPath
	        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));

	        searchField.click();
	        searchField.clear();
	        Thread.sleep(3000); 
	        searchField.sendKeys(userName);

	        // Wait for the dropdown option to be visible and clickable
	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userOptionXPath)));

	        // Scroll the option into view and click it
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();

	        // Re-locate the multi-user input field
	        WebElement multiUserInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
	        multiUserInput.click(); // Click on the multi-user input field

	    } catch (TimeoutException e) {
	        System.out.println("The dropdown option '" + userName + "' for step " + step + " is not found or not clickable within the timeout.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + userName + "' on step " + step + ". Trying to click via JavaScript.");
	        try {
	            WebElement optionElement = driver.findElement(By.xpath(userOptionXPath));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	        } catch (NoSuchElementException ex) {
	            System.out.println("The dropdown option '" + userName + "' could not be found after intercept.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Search field for step " + step + " is not found.");
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
