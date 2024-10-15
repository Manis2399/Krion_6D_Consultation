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
	 
	 
	 
	 
	
	
	public WorkFlowLocators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
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
    	 String xpathExpression = "//*select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
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
	    	 String xpathExpression = "//*select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
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
