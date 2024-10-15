package Locators;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignRole_Locators {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	private WebElement SearchBox;                                // search box to find the project
	
	
//    @FindBy(xpath = "//tbody//tr//td//a[contains(text(),'\" + projectName + \"')]")
//  	private WebElement FindTheRequiredProject;  
//  

    //Assing Role
    
    @FindBy(xpath = "//span[.='Setting']")
    private WebElement Setting; 
  
    @FindBy(xpath = "//span[.='Assign role']")
    private WebElement AssignRole; 
  
    @FindBy(xpath = "//*[@id='btnAssignProjectUser']")
    private WebElement assignRoleButton;

    @FindBy(xpath = "//select[@formcontrolname='roleId']")
    private WebElement SelectTheRole;
    
    @FindBy(xpath = "//input[@formcontrolname='selectedUsers']")
    private WebElement AddUser;
    
    @FindBy(xpath = "//button[.=' Assign ']")
    private WebElement AssignButton;
    
    
    //Assign Role for Group
    
    
    @FindBy(xpath = "//button[.=' Assign Role For Group ']")
    private WebElement AssignRoleForGroupTab;
    
    @FindBy(xpath = "//*[@id='btnAssignProjectUserGroup']")
    private WebElement AssignRoleForGroupButton;

    @FindBy(xpath = "//select[@formcontrolname='roleId']")
    private WebElement SelectTheRoleForGroup;
	
    @FindBy(xpath = "//input[@formcontrolname='selectedUserGroups']")
    private WebElement Addgroup;
    
    
    
    
    
    
    
    
	
    public AssignRole_Locators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
    
    
    
    
    
  public void selectUserFromDropdownForAddGroup(String userName) {
        
        // Construct the XPath for the user option
        String xpathExpression = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
                + userName.toLowerCase() + "')]"; // Adjust according to actual HTML structure

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the dropdown option to be visible and clickable
            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

            // Scroll the option into view and click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
            optionElement.click();
        } catch (TimeoutException e) {
            System.out.println("The dropdown option '" + userName + "' is not found or not clickable within the timeout.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element click intercepted for '" + userName + "'. Trying to click via JavaScript.");
            WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
        }
    }    
    
    
    
    
    public void ClickOnAddGroup() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Addgroup));

  			// Perform the click action
  			Addgroup.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Addgroup));
  			Addgroup.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    public void selectDropdownOptionForRoleGroup(String optionText) {
        // Construct the XPath for the option text in a case-insensitive manner
    	 String xpathExpression = "//*[@id='roleId']//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
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

    
    
    
    public void ClickOnSelectTheRoleInGroup() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SelectTheRoleForGroup));

  			// Perform the click action
  			SelectTheRoleForGroup.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SelectTheRoleForGroup));
  			SelectTheRoleForGroup.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}	
    }
    
    
    
    
    
    public void ClickOnAssignRoleForGroupButton() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRoleForGroupButton));

  			// Perform the click action
  			AssignRoleForGroupButton.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRoleForGroupButton));
  			AssignRoleForGroupButton.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    public void ClickOnAssignRoleForGroupTab() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRoleForGroupTab));

  			// Perform the click action
  			AssignRoleForGroupTab.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRoleForGroupTab));
  			AssignRoleForGroupTab.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Assign Role
    
    
    public void ClickOnAssignButton() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignButton));

  			// Perform the click action
  			AssignButton.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignButton));
  			AssignButton.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    
    
    public void selectUserFromDropdownForAddUser(String userName) {
        
        // Construct the XPath for the user option
        String xpathExpression = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
                + userName.toLowerCase() + "')]"; // Adjust according to actual HTML structure

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the dropdown option to be visible and clickable
            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

            // Scroll the option into view and click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
            optionElement.click();
        } catch (TimeoutException e) {
            System.out.println("The dropdown option '" + userName + "' is not found or not clickable within the timeout.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element click intercepted for '" + userName + "'. Trying to click via JavaScript.");
            WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
        }
    }
    
    
    
    
    
    
    
    
    public void EnterOnAddUser(String values) {
    	AddUser.sendKeys(values);
    }
    
    
    
    
    public void ClickOnAddUser() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AddUser));

  			// Perform the click action
  			AddUser.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AddUser));
  			AddUser.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}	
    }
    
    
    
    public void ClickOnSelectTheRole() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SelectTheRole));

  			// Perform the click action
  			SelectTheRole.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SelectTheRole));
  			SelectTheRole.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}	
    }
    
    
    
    
    public void ClickOnAssignRoleButton() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(assignRoleButton));

  			// Perform the click action
  			assignRoleButton.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(assignRoleButton));
  			assignRoleButton.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    } 
    
    
    
    
    public void ClickOnAssignRole() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRole));

  			// Perform the click action
  			AssignRole.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRole));
  			AssignRole.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    
    } 
    
    
	
    public void ClickOnSetting() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Setting));

  			// Perform the click action
  			Setting.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Setting));
  			Setting.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public WebElement findTheRequiredProject(String projectName) {
        String dynamicXpath = "//tbody//tr//td//a[contains(text(),'" + projectName + "')]";
        return driver.findElement(By.xpath(dynamicXpath));
    }
    
    
    public void clickOnProject(String projectName) throws InterruptedException {
        WebElement projectElement = findTheRequiredProject(projectName);
        wait.until(ExpectedConditions.elementToBeClickable(projectElement));
        Thread.sleep(2000);
        System.out.print(projectName);
        projectElement.click();
    } 
    
    
    
    
    public void EnterOnSearchBox(String values) throws AWTException, InterruptedException {
    	wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
    	SearchBox.sendKeys(values);
    	Thread.sleep(2000);
    	Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
    }
    
    
    public void ClickOnSearchBox() {
    	try {
	        // Wait for the loading spinner to disappear (if applicable)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(SearchBox));

	        // Perform the click action using JavaScript Executor
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", SearchBox);
	        
	    } catch (ElementClickInterceptedException e) {
	        // Handle the exception if the click is intercepted
	        System.err.println("Element click intercepted: " + e.getMessage());
	        
	        // Optionally, wait again for the spinner to disappear and retry clicking
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
	        
	        // Retry click with JavaScript Executor
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", SearchBox);
	        
	    } catch (Exception e) {
	        // Handle other potential exceptions
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
    }
    
    
    
    
    
    
    
    
    
    
    public void selectDropdownOptionForRole(String optionText) {
        // Construct the XPath for the option text in a case-insensitive manner
    	 String xpathExpression = "//*[@id='roleId']//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
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

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
