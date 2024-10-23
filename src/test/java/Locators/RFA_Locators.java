package Locators;

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

public class RFA_Locators {

	WebDriver driver;
	WebDriverWait wait;
	
	 @FindBy(xpath = "//span[.='RFA']")
	 private WebElement RFA;
	
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-rfa/section/div/div[1]/div/div[2]/button")
	 private WebElement AddButton;

	 @FindBy(xpath = "//input[@placeholder='Enter review code']")
	 private WebElement RFACode;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter review name']")
	 private WebElement RFAName;
	 
	 @FindBy(xpath = "//textarea[@formcontrolname='description']")
	 private WebElement Description;
	 
	 @FindBy(xpath = "//input[@formcontrolname='startDate']")
	 private WebElement StartDate; 
	 
	 @FindBy(xpath = "//input[@formcontrolname='targetDate']")
	 private WebElement EndDate;
	 
	 @FindBy(xpath = "//select[@formcontrolname='workflowStatusId']")
	 private WebElement WorkFlow;
	 
	 @FindBy(xpath = "//ejs-dropdownlist[@formcontrolname='priorityId']")
	 private WebElement Priority;
	 
	 
		public RFA_Locators(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
			PageFactory.initElements(driver, this);
		}
	
		
		
		 public void attachFile(String DocumentName, String FileName) {
		        try {
		            String fileXPath = "//ul//li//a[contains(text(), '" + DocumentName + "')]";
		            System.out.println(fileXPath);
		            WebElement fileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fileXPath)));
		            fileElement.click();
		            Thread.sleep(2000);
		            String Searchfield = "(//input[@placeholder='Search'])[1]";
		            WebElement SearchfieldBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Searchfield)));
		            SearchfieldBox.click();
		            Thread.sleep(2000);
		            SearchfieldBox.sendKeys(FileName);
		            Thread.sleep(2000);
			    	Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
		            System.out.println("DocumentName '" + DocumentName + "' attached successfully.");
		        } catch (Exception e) {
		            System.out.println("Error attaching file: " + e.getMessage());
		        }
		    }	
		
		
		
		
		public void selectDropdownOptionForPriority(String optionText) {
			 String xpathExpression = "//ul[contains(@class, 'e-list-parent')]//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
	                 + optionText.toLowerCase() + "')]";

			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			 try {
				 // Wait for the dropdown option to be visible and clickable
				 WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

				 // Scroll the element into view (if needed) and click
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
		
		public void ClickOnPriority() {
			try {
	  			// Wait for the loading spinner to disappear

	  			// Wait for the NextStep element to be clickable
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.elementToBeClickable(Priority));

	  			// Perform the click action
	  			Priority.click();
	  		} catch (ElementClickInterceptedException e) {
	  			// Handle the exception if the click is intercepted
	  			System.err.println("Element click intercepted: " + e.getMessage());

	  			// Optionally, wait again for the spinner to disappear and retry clicking
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.elementToBeClickable(Priority));
	  			Priority.click();
	  		} catch (Exception e) {
	  			// Handle other potential exceptions
	  			System.err.println("An unexpected error occurred: " + e.getMessage());
	  		}
		}
		
		 public void selectDropdownOption(String optionText) {
			    String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
			                              + optionText.toLowerCase() + "')]";
			    
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

			        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			        optionElement.click();
			    } catch (TimeoutException e) {
			        System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
			    } catch (ElementClickInterceptedException e) {
			        System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
			        
			        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
			        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
			    }
			}
		
		
		public void EnterOnWorkFlow(String values) {
			WorkFlow.sendKeys(values);
	    }
		
		
		public void ClickonWorkFlow() {
			try {
	  			// Wait for the loading spinner to disappear

	  			// Wait for the NextStep element to be clickable
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.elementToBeClickable(WorkFlow));

	  			// Perform the click action
	  			WorkFlow.click();
	  		} catch (ElementClickInterceptedException e) {
	  			// Handle the exception if the click is intercepted
	  			System.err.println("Element click intercepted: " + e.getMessage());

	  			// Optionally, wait again for the spinner to disappear and retry clicking
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.elementToBeClickable(WorkFlow));
	  			WorkFlow.click();
	  		} catch (Exception e) {
	  			// Handle other potential exceptions
	  			System.err.println("An unexpected error occurred: " + e.getMessage());
	  		}
		}

		
		
		 public void EnterOnEndDate(String values) {
			 EndDate.sendKeys(values);
		    }
		 
		  
		 public void ClearOnEndDate() {
			 EndDate.clear();
		 }
		
		public void ClickOnEndDate() {
	    	try {
	  			// Wait for the loading spinner to disappear

	  			// Wait for the NextStep element to be clickable
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.elementToBeClickable(EndDate));

	  			// Perform the click action
	  			EndDate.click();
	  		} catch (ElementClickInterceptedException e) {
	  			// Handle the exception if the click is intercepted
	  			System.err.println("Element click intercepted: " + e.getMessage());

	  			// Optionally, wait again for the spinner to disappear and retry clicking
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.elementToBeClickable(EndDate));
	  			EndDate.click();
	  		} catch (Exception e) {
	  			// Handle other potential exceptions
	  			System.err.println("An unexpected error occurred: " + e.getMessage());
	  		}
	    }
		
		
		
		 public void EnterOnStartDate(String values) {
		    	StartDate.sendKeys(values);
		    }
		 
		  
	    public void ClearOnStartDate() {
	    	StartDate.clear();
	    }
	    
	    
	    public void ClickOnStartDate() {
	    	try {
	  			// Wait for the loading spinner to disappear

	  			// Wait for the NextStep element to be clickable
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.elementToBeClickable(StartDate));

	  			// Perform the click action
	  			StartDate.click();
	  		} catch (ElementClickInterceptedException e) {
	  			// Handle the exception if the click is intercepted
	  			System.err.println("Element click intercepted: " + e.getMessage());

	  			// Optionally, wait again for the spinner to disappear and retry clicking
	  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  			wait.until(ExpectedConditions.elementToBeClickable(StartDate));
	  			StartDate.click();
	  		} catch (Exception e) {
	  			// Handle other potential exceptions
	  			System.err.println("An unexpected error occurred: " + e.getMessage());
	  		}
	    }
		
		public void EnterOnDescription(String values) {
			Description.sendKeys(values);
		}
		
		public void ClearOnDescription() {
			Description.clear();
		}
		
		public void EnterOnRFAName(String values) {
			RFAName.sendKeys(values);
		}
		
		public void ClearOnRFAName() {
			RFAName.clear();
		}
		
		
		public void EnterOnRFACode(String values) {
			RFACode.sendKeys(values);
		}
		
		public void ClearOnRFACode() {
			RFACode.clear();
		}
		
	
		public void ClickOnAddButton() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(AddButton));
				AddButton.click();
			} catch (ElementClickInterceptedException e) {
				System.err.println("Element click intercepted: " + e.getMessage());
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(AddButton));
				AddButton.click();
			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
		}
	
	
		public void ClickOnRFA() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(RFA));
				RFA.click();
			} catch (ElementClickInterceptedException e) {
				System.err.println("Element click intercepted: " + e.getMessage());
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(RFA));
				RFA.click();
			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
