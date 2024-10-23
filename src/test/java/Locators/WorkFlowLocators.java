package Locators;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkFlowLocators {

	WebDriver driver;
	WebDriverWait wait;
	
	
	
	@FindBy(xpath = "//span[.='Workflow']")
	private WebElement Workflow;
	
	 @FindBy(xpath = "//*[@id='approvalStep']")
	 private WebElement SelectTheCategoryDropdown;
	
	 
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-workflow-list/section/div/div[1]/div/div[2]/button")
	 private WebElement AddWorkflowButton;
	 
	//Adding of Steppers for Approval
	 
	 @FindBy(xpath = "//select[@formcontrolname='approvalSteps']")
	 private WebElement SelectSteppers;
	 
	 @FindBy(xpath = "//input[@formcontrolname='reviewName']")
	 private WebElement Name;
	 
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-document-review/section/div/div[2]/div/form/div[1]/div/div[2]/div[3]/textarea")
	 private WebElement Description;

	 @FindBy(xpath = "//select[@formcontrolname='category']")
	 private WebElement SelectCategory;
	 
	 @FindBy(xpath = "//select[@formcontrolname='status']")
	 private WebElement Status;
	 
	 @FindBy(xpath = "//input[@formcontrolname='nameForApproval']")
	 private WebElement NameForApproval;
	 
	 //Step1
	 
	 @FindBy(xpath = "//input[@id='stepName0']")
	 private WebElement StepName1;
	 
	 @FindBy(xpath = "//input[@id='stepName1']")
	 private WebElement StepName2;
	 
	 @FindBy(xpath = "//input[@id='stepName2']")
	 private WebElement StepName3;
	 
	 @FindBy(xpath = "//input[@id='stepName3']")
	 private WebElement StepName4;
	 
	 @FindBy(xpath = "//input[@id='stepName4']")
	 private WebElement StepName5;
	 
	 @FindBy(xpath = "//input[@id='stepName5']")
	 private WebElement StepName6;
	 
	 @FindBy(xpath = "//input[@id='stepName6']")
	 private WebElement StepName7;
	 
	 
	 //Select Users Tab
	 
	 @FindBy(xpath = "(//button[@id='user-tab'])[1]")
	 private WebElement Step1SlectUsers;
	 
	 @FindBy(xpath = "(//button[@id='user-tab'])[2]")
	 private WebElement Step2SlectUsers;
	 
	 @FindBy(xpath = "(//button[@id='user-tab'])[3]")
	 private WebElement Step3SlectUsers;
	 
	 @FindBy(xpath = "(//button[@id='user-tab'])[4]")
	 private WebElement Step4SlectUsers;
	 
	 @FindBy(xpath = "(//button[@id='user-tab'])[5]")
	 private WebElement Step5SlectUsers;
	 
	 @FindBy(xpath = "(//button[@id='user-tab'])[6]")
	 private WebElement Step6SlectUsers;
	 
	 @FindBy(xpath = "(//button[@id='user-tab'])[7]")
	 private WebElement Step7SlectUsers;
	 
	 //Select Users Group Tab
	 
	 
	   @FindBy(xpath = "(//button[@id='user-group-tab'])")
	    private List<WebElement> selectUserGroupTabs;
	 
	
	 @FindBy(xpath = "(//button[@id='user-group-tab'])[1]")
	 private WebElement Step1SlectUsersGroups;
	 
	 @FindBy(xpath = "(//button[@id='user-group-tab'])[2]")
	 private WebElement Step2SlectUsersGroups;
	 
	 @FindBy(xpath = "(//button[@id='user-group-tab'])[3]")
	 private WebElement Step3SlectUsersGroups;
	 
	 @FindBy(xpath = "(//button[@id='user-group-tab'])[4]")
	 private WebElement Step4SlectUsersGroups;
	 
	 @FindBy(xpath = "(//button[@id='user-group-tab'])[5]")
	 private WebElement Step5SlectUsersGroups;
	 
	 @FindBy(xpath = "(//button[@id='user-group-tab'])[6]")
	 private WebElement Step6SlectUsersGroups;
	 
	 @FindBy(xpath = "(//button[@id='user-group-tab'])[7]")
	 private WebElement Step7SlectUsersGroups;
	 
	 //Selecting search user Field under select users
	 
	    @FindBy(xpath = "(//input[@placeholder='Search user'])")
	    private List<WebElement> searchUserFields;
	 
	 
	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[1]")
//	 private WebElement SelectingSetp1SearchUserField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[2]")
//	 private WebElement SelectingSetp2SearchUserField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[3]")
//	 private WebElement SelectingSetp3SearchUserField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[4]")
//	 private WebElement SelectingSetp4SearchUserField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[5]")
//	 private WebElement SelectingSetp5SearchUserField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[6]")
//	 private WebElement SelectingSetp6SearchUserField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[7]")
//	 private WebElement SelectingSetp7SearchUserField;
	 
	//Selecting search user Field under select users
	    
	    
	    @FindBy(xpath = "//input[@placeholder='Search user']")
	    private List<WebElement> selectingStepSearchUserGroupFields;
	    
	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[1]")
//	 private WebElement SelectingSetp1SearchUserGroupField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[2]")
//	 private WebElement SelectingSetp2SearchUserGroupField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[3]")
//	 private WebElement SelectingSetp3SearchUserGroupField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[4]")
//	 private WebElement SelectingSetp4SearchUserGroupField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[5]")
//	 private WebElement SelectingSetp5SearchUserGroupField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[6]")
//	 private WebElement SelectingSetp6SearchUserGroupField;
//	 
//	 @FindBy(xpath = "(//input[@placeholder='Search user'])[7]")
//	 private WebElement SelectingSetp7SearchUserGroupField;
	 
	 //Description field in Steppers
	    
	    
	    @FindBy(xpath = "//textarea[@formcontrolname='description']")
	    private List<WebElement> stepDescriptionFields;
	 
	 @FindBy(xpath = "(//textarea[@formcontrolname='description'])[2]")
	 private WebElement Step1DescriptionField;
	 
	 @FindBy(xpath = "(//textarea[@formcontrolname='description'])[3]")
	 private WebElement Step2DescriptionField;
	 
	 @FindBy(xpath = "(//textarea[@formcontrolname='description'])[4]")
	 private WebElement Step3DescriptionField;
	 
	 @FindBy(xpath = "(//textarea[@formcontrolname='description'])[5]")
	 private WebElement Step4DescriptionField;
	 
	 @FindBy(xpath = "(//textarea[@formcontrolname='description'])[6]")
	 private WebElement Step5DescriptionField;
	 
	 @FindBy(xpath = "(//textarea[@formcontrolname='description'])[7]")
	 private WebElement Step6DescriptionField;
	 
	 @FindBy(xpath = "(//textarea[@formcontrolname='description'])[8]")
	 private WebElement Step7DescriptionField;
	 
	
	 @FindBy(xpath = "//button[.=' Create ']")
	 private WebElement Create;
	 
	
	public WorkFlowLocators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void ClickOnCreateButton() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Create));

			// Perform the click action
			Create.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Create));
			Create.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	//Steppers fields
	
	//Sending values to Description field
	public void enterValueInStepDescriptionField(String description, int stepIndex) {
	    switch (stepIndex) {
	        case 0:
	            Step1DescriptionField.sendKeys(description); 
	            break;
	        case 1:
	            Step2DescriptionField.sendKeys(description); 
	            break;
	        case 2:
	            Step3DescriptionField.sendKeys(description); 
	            break;
	        case 3:
	            Step4DescriptionField.sendKeys(description); 
	            break;
	        case 4:
	            Step5DescriptionField.sendKeys(description); 
	            break;
	        case 5:
	            Step6DescriptionField.sendKeys(description); 
	            break;
	        case 6:
	            Step7DescriptionField.sendKeys(description); 
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid step number: " + stepIndex);
	    }
	}
	
	
	
//	public void EnterOnStep1DescriptionField(String values) {
//		Step1DescriptionField.sendKeys(values);
//	}
//	
//	public void EnterOnStep2DescriptionField(String values) {
//		Step2DescriptionField.sendKeys(values);
//	}
//	
//	public void EnterOnStep3DescriptionField(String values) {
//		Step3DescriptionField.sendKeys(values);
//	}
//	
//	public void EnterOnStep4DescriptionField(String values) {
//		Step4DescriptionField.sendKeys(values);
//	}
//	
//	public void EnterOnStep5DescriptionField(String values) {
//		Step5DescriptionField.sendKeys(values);
//	}
//	
//	public void EnterOnStep6DescriptionField(String values) {
//		Step6DescriptionField.sendKeys(values);
//	}
//	
//	public void EnterOnStep7DescriptionField(String values) {
//		Step7DescriptionField.sendKeys(values);
//	}
//	
	
	
	
	//Sending values to Search User Group Field under  Select user Group field
	
	  public void searchUserFromDropdownForSelectUserGroupTab(String userGroupName, int step) {
		  
		  if (step < 1 || step > selectingStepSearchUserGroupFields.size()) {
	            throw new IllegalArgumentException("Step must be between 1 and " + selectingStepSearchUserGroupFields.size());
	        }

	        // Construct the dynamic XPath for the user group option (visible elements only)
	        String userGroupOptionXPath = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
	                + userGroupName.toLowerCase() + "') and not(contains(@class, 'hidden'))]";

	        try {
	            // Open the user group dropdown for the specified step
	            WebElement userGroupTab = selectUserGroupTabs.get(step - 1);
	            wait.until(ExpectedConditions.visibilityOf(userGroupTab));
	            userGroupTab.click();

	            // Locate the search field for the specified step
	            WebElement searchField = selectingStepSearchUserGroupFields.get(step - 1); // Adjust for zero-based index
	            wait.until(ExpectedConditions.visibilityOf(searchField));
	            searchField.clear();
	            searchField.sendKeys(userGroupName);

	            // Wait for the dropdown option to be visible and clickable
	            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userGroupOptionXPath)));

	            // Scroll the option into view and click it
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	            optionElement.click();

	        } catch (TimeoutException e) {
	            System.out.println("The dropdown option '" + userGroupName + "' for step " + step + " is not found or not clickable within the timeout.");
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Element click intercepted for '" + userGroupName + "' on step " + step + ". Trying to click via JavaScript.");
	            WebElement optionElement = driver.findElement(By.xpath(userGroupOptionXPath));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	        }
	    }

	    // Method to enter values in the search user group fields dynamically
	    public void enterValueInSearchUserGroupField(String values, int step) {
	        if (step < 1 || step > selectingStepSearchUserGroupFields.size()) {
	            throw new IllegalArgumentException("Step must be between 1 and " + selectingStepSearchUserGroupFields.size());
	        }
	        WebElement searchField = selectingStepSearchUserGroupFields.get(step - 1); // Adjust for zero-based index
	        searchField.clear();
	        searchField.sendKeys(values);
	    }
	
	
	    
	    
	    
	    
	    
//	public void searchUserFromDropdownForSelectUserGroupTab(String userGroupName, int step) {
//	    // Construct the dynamic XPath for the search user group field based on the step number
//	    String searchUserGroupFieldXPath = "(//input[@placeholder='Search user'])[" + step + "]";
//	    String userGroupOptionXPath = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
//	            + userGroupName.toLowerCase() + "')]";
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    try {
//	        // Locate the search user group field for the specified step and enter the group name
//	        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchUserGroupFieldXPath)));
//	        searchField.clear();
//	        searchField.sendKeys(userGroupName);
//
//	        // Wait for the dropdown option to be visible and clickable
//	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userGroupOptionXPath)));
//
//	        // Scroll the option into view and click it
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
//	        optionElement.click();
//	    } catch (TimeoutException e) {
//	        System.out.println("The dropdown option '" + userGroupName + "' for step " + step + " is not found or not clickable within the timeout.");
//	    } catch (ElementClickInterceptedException e) {
//	        System.out.println("Element click intercepted for '" + userGroupName + "' on step " + step + ". Trying to click via JavaScript.");
//	        WebElement optionElement = driver.findElement(By.xpath(userGroupOptionXPath));
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
//	    }
//	}
//
//	
//	
//	
//	
//	public void EnterOnSelectingSetp1SearchUserGroupField(String values) {
//		SelectingSetp1SearchUserGroupField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp2SearchUserGroupField(String values) {
//		SelectingSetp2SearchUserGroupField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp3SearchUserGroupField(String values) {
//		SelectingSetp3SearchUserGroupField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp4SearchUserGroupField(String values) {
//		SelectingSetp4SearchUserGroupField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp5SearchUserGroupField(String values) {
//		SelectingSetp5SearchUserGroupField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp6SearchUserGroupField(String values) {
//		SelectingSetp6SearchUserGroupField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp7SearchUserGroupField(String values) {
//		SelectingSetp7SearchUserGroupField.sendKeys(values);
//	}
	
	
	
	//Sending values to Search User field under select user tab
	
	    public void searchUserFromDropdownForSelectUsersTab(String userName, int step) throws InterruptedException {
	        // Determine the correct XPath based on the step
	        String searchFieldXPath;
	        if (step == 1) {
	            // For step 1, use the direct XPath
	            searchFieldXPath = "//input[@placeholder='Search user']";
	        } else {
	            // For subsequent steps, use the indexed XPath
	            searchFieldXPath = "(//input[@placeholder='Search user'])[" + (step - 1) + "]";
	        }

	        System.out.println("Using search field XPath: " + searchFieldXPath);

	        // Construct the dynamic XPath for the user option
	        String userOptionXPath = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
	                + userName.toLowerCase() + "')]";

	        try {
	            // Locate the search field for the specified step using the XPath
	            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchFieldXPath)));

	            // Clear the search field and enter the user name
	            searchField.clear();
	            Thread.sleep(3000);  // Adjust the wait time if necessary
	            searchField.sendKeys(userName);

	            // Optionally wait for dropdown options to load
	            Thread.sleep(500); // You can replace this with an explicit wait if needed

	            // Wait for the dropdown option to be visible and clickable
	            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userOptionXPath)));

	            // Scroll the option into view and click it
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	            optionElement.click();
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



	    // Method to enter values in the search fields dynamically
	    public void enterValueInSearchUserField(String values, int step) {
	        if (step < 1 || step > searchUserFields.size()) {
	            throw new IllegalArgumentException("Step must be between 1 and " + searchUserFields.size());
	        }
	        WebElement searchField = searchUserFields.get(step - 1); // Adjust for zero-based index
	        searchField.clear();
	        searchField.sendKeys(values);
	    }
	
	
	
	
	
	
	
	
	
	//
//	public void searchUserFromDropdownForSelectUsersTab(String userName, int step) {
//	    // Construct the dynamic XPath for the search field based on the step number
//	    String searchFieldXPath = "(//input[@placeholder='Search user'])[" + step + "]";
//	    String userOptionXPath = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
//	            + userName.toLowerCase() + "')]";
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    try {
//	        // Locate the search field for the specified step and enter the user name
//	        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchFieldXPath)));
//	        searchField.clear();
//	        searchField.sendKeys(userName);
//
//	        // Wait for the dropdown option to be visible and clickable
//	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userOptionXPath)));
//
//	        // Scroll the option into view and click it
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
//	        optionElement.click();
//	    } catch (TimeoutException e) {
//	        System.out.println("The dropdown option '" + userName + "' for step " + step + " is not found or not clickable within the timeout.");
//	    } catch (ElementClickInterceptedException e) {
//	        System.out.println("Element click intercepted for '" + userName + "' on step " + step + ". Trying to click via JavaScript.");
//	        WebElement optionElement = driver.findElement(By.xpath(userOptionXPath));
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
//	    }}
//	
//	
//	public void EnterOnSelectingSetp1SearchUserField(String values) {
//		SelectingSetp1SearchUserField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp2SearchUserField(String values) {
//		SelectingSetp2SearchUserField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp3SearchUserField(String values) {
//		SelectingSetp3SearchUserField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp4SearchUserField(String values) {
//		SelectingSetp4SearchUserField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp5SearchUserField(String values) {
//		SelectingSetp5SearchUserField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp6SearchUserField(String values) {
//		SelectingSetp6SearchUserField.sendKeys(values);
//	}
//	
//	public void EnterOnSelectingSetp7SearchUserField(String values) {
//		SelectingSetp7SearchUserField.sendKeys(values);
//	}
//	
	
	
	//Select Users Group Tab
	
	public void clickOnStepSelectUsersGroups(int stepNumber) {
	    WebElement buttonToClick = null;
	    switch (stepNumber) {
	        case 0:
	            buttonToClick = Step1SlectUsersGroups;
	            break;
	        case 1:
	            buttonToClick = Step2SlectUsersGroups;
	            break;
	        case 2:
	            buttonToClick = Step3SlectUsersGroups;
	            break;
	        case 3:
	            buttonToClick = Step4SlectUsersGroups;
	            break;
	        case 4:
	            buttonToClick = Step5SlectUsersGroups;
	            break;
	        case 5:
	            buttonToClick = Step6SlectUsersGroups;
	            break;
	        case 6:
	            buttonToClick = Step7SlectUsersGroups;
	            break;
	        default:
	            System.err.println("Invalid step number: " + stepNumber);
	            return; // Exit the method if step number is invalid
	    }
	    try {
	        // Wait for the element to be clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(buttonToClick));

	        // Perform the click action
	        buttonToClick.click();
	    } catch (ElementClickInterceptedException e) {
	        // Handle the exception if the click is intercepted
	        System.err.println("Element click intercepted: " + e.getMessage());

	        // Optionally, wait again for the spinner to disappear and retry clicking
	        wait.until(ExpectedConditions.elementToBeClickable(buttonToClick));
	        buttonToClick.click();
	    } catch (Exception e) {
	        // Handle other potential exceptions
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }}
	
	
	//Select user Tab 
	
	   public void clickOnSelectUsers(int stepNumber) {
	        WebElement userTab = null;

	        // Select the appropriate WebElement based on the step number
	        switch (stepNumber) {
	            case 1:
	                userTab = Step1SlectUsers;
	                break;
	            case 2:
	                userTab = Step2SlectUsers;
	                break;
	            case 3:
	                userTab = Step3SlectUsers;
	                break;
	            case 4:
	                userTab = Step4SlectUsers;
	                break;
	            case 5:
	                userTab = Step5SlectUsers;
	                break;
	            case 6:
	                userTab = Step6SlectUsers;
	                break;
	            case 7:
	                userTab = Step7SlectUsers;
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid step number: " + stepNumber);
	        }

	        // Click on the selected user tab
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(userTab));
	            userTab.click();
	        } catch (ElementClickInterceptedException e) {
	            System.err.println("Element click intercepted: " + e.getMessage());
	            // Optionally, you could retry the click or implement additional logic here
	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	        }
	    }
	
	//Step name 
	   public void enterStepName(int stepIndex, String value) {
	        switch (stepIndex) {
	            case 0: StepName1.sendKeys(value); break;
	            case 1: StepName2.sendKeys(value); break;
	            case 2: StepName3.sendKeys(value); break;
	            case 3: StepName4.sendKeys(value); break;
	            case 4: StepName5.sendKeys(value); break;
	            case 5: StepName6.sendKeys(value); break;
	            case 6: StepName7.sendKeys(value); break;
	            default: throw new IllegalArgumentException("Invalid step index: " + stepIndex);
	            }
	        }
	
	
	
	//General Info -  Workflow Steppers
	
	
	public void EnterOnNameForApproval(String values) {
		NameForApproval.sendKeys(values);
	}
	
	public void ClearOnNameForApproval() {
		NameForApproval.clear();
	}
	
	
	
	public void ClickOnStatus() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Status));

			// Perform the click action
			Status.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Status));
			Status.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void selectDropdownOptionSelectStatus(String optionText) {
        // Construct the XPath for the option text in a case-insensitive manner
		 String xpathExpression = "//select[@formcontrolname='status']/option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
		            + optionText.toLowerCase() + "')]";
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the dropdown options to become clickable
            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

            // Scroll the element into view and click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
            optionElement.click();
            
        } catch (TimeoutException e) {
            System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
            
            // Try clicking via JavaScript as a fallback
            WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
        }
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public void selectDropdownOptionSelectCategory(String optionText) {
	        // Construct the XPath for the option text in a case-insensitive manner
		 String xpathExpression = "//select[@formcontrolname='category']/option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
			        + optionText.toLowerCase() + "')]";
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        try {
	            // Wait for the dropdown options to become clickable
	            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

	            // Scroll the element into view and click
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	            optionElement.click();
	            
	        } catch (TimeoutException e) {
	            System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
	            
	            // Try clicking via JavaScript as a fallback
	            WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	        }
	    }
	
	public void ClickOnSelectCategory() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectCategory));

			// Perform the click action
			SelectCategory.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectCategory));
			SelectCategory.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	public void EnterOnDescription(String values) {
		Description.sendKeys(values);
	}
	
	
	public void EnterOnName(String values) {
		Name.sendKeys(values);
	}
	
	
	
	 public void selectDropdownOptionSteppersSelection(String optionText) {
	        // Construct the XPath for the option text in a case-insensitive manner
		 String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
			        + optionText.toLowerCase() + "')]";
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        try {
	            // Wait for the dropdown options to become clickable
	            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

	            // Scroll the element into view and click
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	            optionElement.click();
	            
	        } catch (TimeoutException e) {
	            System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
	            
	            // Try clicking via JavaScript as a fallback
	            WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	        }
	    }

	
	
	
	
	
	
	
	
	
	public void ClickOnSelectSteppers() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectSteppers));

			// Perform the click action
			SelectSteppers.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectSteppers));
			SelectSteppers.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	//workflow
	
	public void selectCategoryFromDropdown(String categoryName) {
	    // Construct the XPath for the category option
	    String xpathExpression = "//*[@id='approvalStep']//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
	            + categoryName.toLowerCase() + "')]"; // Adjust according to actual HTML structure

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        // Wait for the dropdown option to be visible and clickable
	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

	        // Scroll the option into view and click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();
	    } catch (TimeoutException e) {
	        System.out.println("The dropdown option '" + categoryName + "' is not found or not clickable within the timeout.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + categoryName + "'. Trying to click via JavaScript.");
	        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	    }	
	
	
	
	
	
	
	public void ClickOnAddWorkflowButton() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddWorkflowButton));

			// Perform the click action
			AddWorkflowButton.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddWorkflowButton));
			AddWorkflowButton.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	

	
	
	public void ClickOnSelectTheCategoryDropdown() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectTheCategoryDropdown));

			// Perform the click action
			SelectTheCategoryDropdown.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectTheCategoryDropdown));
			SelectTheCategoryDropdown.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	public void ClickOnWorkflow() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Workflow));

			// Perform the click action
			Workflow.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Workflow));
			Workflow.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
