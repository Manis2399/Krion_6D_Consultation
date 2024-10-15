package Locators;

import static org.junit.Assert.assertTrue;

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

public class Design_Projects_Locators {
	
	
	WebDriver driver;
    WebDriverWait wait;
	
	
    @FindBy(xpath = "//*[@id='sidebar-nav']/li[4]/a")
    private WebElement DesignProject;

	
    @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-list/section/div/div[1]/div/div[2]/button")
    private WebElement AddProjectButton;
    
    @FindBy(xpath = "//input[@formcontrolname='isIsoActive']")
    private WebElement ProjectWithoutISO;
    
    @FindBy(xpath = "//span[@formcontrolname='template']")
    private WebElement ProjectTemplate;
    
    @FindBy(xpath = "//input[@placeholder='Enter project code']")
    private WebElement ProjectCode;
    
    @FindBy(xpath = "//input[@placeholder='Enter project name']")
    private WebElement ProjectName;
    
    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    private WebElement ProjectDescription;
    
    @FindBy(xpath = "//input[@formcontrolname='start_date']")
    private WebElement StartDate; 
    
    @FindBy(xpath = "//span[@formcontrolname='design_type']")
    private WebElement ProjectDesignType; 
    
    @FindBy(xpath = "//span[@formcontrolname='category']")
    private WebElement ProjectCategory; 
    
    @FindBy(xpath = "//select[@formcontrolname='owner']")
    private WebElement ProjectOwnerSelection; 
    
    @FindBy(xpath = "//select[@formcontrolname='status']")
    private WebElement ProjectStatus; 
    
    @FindBy(xpath = "//input[@formcontrolname='addressLine_1']")
    private WebElement AddressLine1; 
  
    @FindBy(xpath = "//input[@formcontrolname='addressLine_2']")
    private WebElement AddressLine2; 
    
    @FindBy(xpath = "//input[@formcontrolname='city']")
    private WebElement City; 
  
    @FindBy(xpath = "//input[@formcontrolname='state']")
    private WebElement State; 
  
    @FindBy(xpath = "//input[@formcontrolname='postal_code']")
    private WebElement Pincode; 
 
    @FindBy(xpath = "//input[@formcontrolname='country']")
    private WebElement Country; 
    
    
    
    
    public Design_Projects_Locators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
    
    
    
    
    public void EnterOnCountry(String values) {
    	Country.sendKeys(values);
    }
    
    
    
    public void EnterOnPincode(String values) {
    	Pincode.sendKeys(values);
    }
    
    
    
    public void EnterOnState(String values) {
    	State.sendKeys(values);
    }
    
    
    
    public void EnterOnCity(String values) {
    	City.sendKeys(values);
    }
    
    
    
    
    
    public void EnterOnAddressLine2(String values) {
    	AddressLine2.sendKeys(values);
    } 
    
    
    
    public void EnterOnAddressLine1(String values) {
    	AddressLine1.sendKeys(values);
    }  
    

    public void EnterOnProjectOwnerSelection(String values) {
    	ProjectOwnerSelection.sendKeys(values);
    }
    
    
    public void ClickOnProjectOwnerSelection() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectOwnerSelection));

  			// Perform the click action
  			ProjectOwnerSelection.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectOwnerSelection));
  			ProjectOwnerSelection.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    } 
    
    
    
    
    
    
    
    public void EnterOnProjectCategory(String values) {
    	ProjectCategory.sendKeys(values);
    }
    
    
    public void ClickOnProjectCategory() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectCategory));

  			// Perform the click action
  			ProjectCategory.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectCategory));
  			ProjectCategory.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    } 
    
    
    
    
    
    
    
    
    
    
    public void EnterOnProjectStatus(String values) {
    	ProjectStatus.sendKeys(values);
    }
    
    
    public void ClickOnProjectStatus() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectStatus));

  			// Perform the click action
  			ProjectStatus.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectStatus));
  			ProjectStatus.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    } 
    
    
    
    
    
    
    
    
    public void EnterOnProjectDesignType(String values) {
    	ProjectDesignType.sendKeys(values);
    }
    
    
    public void ClickOnProjectDesignType() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectDesignType));

  			// Perform the click action
  			ProjectDesignType.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectDesignType));
  			ProjectDesignType.click();
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
    
    
    
    
    
    
    
    public void EnterOnProjectDescrpt(String values) {
    	ProjectDescription.sendKeys(values);
    }
    
    
    public void ClearOnProjectDescrpt() {
    	ProjectDescription.clear();
    }
    
    
    public void ClickOnProjectDescrpt() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectDescription));

  			// Perform the click action
  			ProjectDescription.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectDescription));
  			ProjectDescription.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    
    public void EnterOnProjectName(String values) {
    	ProjectName.sendKeys(values);
    }
    
    
    public void ClearOnProjectName() {
    	ProjectName.clear();
    }
    
    
    public void ClickOnProjectName() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectName));

  			// Perform the click action
  			ProjectName.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectName));
  			ProjectName.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    public void EnterOnProjectCode(String values) {
    	ProjectCode.sendKeys(values);
    }
    
    
    public void ClearOnProjectCode() {
    	ProjectCode.clear();
    }
    
    
    public void ClickOnProjectCode() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectCode));

  			// Perform the click action
  			ProjectCode.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectCode));
  			ProjectCode.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    public void EnterOnProjectTemplate(String values) {
    	ProjectTemplate.sendKeys(values);
    }
    
    
    
    public void ClickOnProjectTemplate() {
    	try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectTemplate));

  			// Perform the click action
  			ProjectTemplate.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ProjectTemplate));
  			ProjectTemplate.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    public void selectDropdownOption(String optionText) {
	    // Construct the XPath for the option text in a case-insensitive manner
	    String xpathExpression = "//mat-option//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
	                              + optionText.toLowerCase() + "')]";
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        // Wait for the overlay to disappear (if it exists)
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

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
	
    
    
  	public void ClickOnProjectWithoutISO() {
  		try {
  			// Wait for the loading spinner to disappear

  			// Wait for the NextStep element to be clickable
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AddProjectButton));

  			// Perform the click action
  			AddProjectButton.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AddProjectButton));
  			AddProjectButton.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
  	}
    
    
    
    
    
    
	public void ClickOnAddProjectButton() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddProjectButton));

			// Perform the click action
			AddProjectButton.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddProjectButton));
			AddProjectButton.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
    
    
	
	public void ClickOnDesignProject() {
		  try {
		        // Wait for the loading spinner to disappear (if applicable)
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		        wait.until(ExpectedConditions.elementToBeClickable(DesignProject));

		        // Perform the click action using JavaScript Executor
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        jsExecutor.executeScript("arguments[0].click();", DesignProject);
		        
		    } catch (ElementClickInterceptedException e) {
		        // Handle the exception if the click is intercepted
		        System.err.println("Element click intercepted: " + e.getMessage());
		        
		        // Optionally, wait again for the spinner to disappear and retry clicking
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.elementToBeClickable(DesignProject));
		        
		        // Retry click with JavaScript Executor
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        jsExecutor.executeScript("arguments[0].click();", DesignProject);
		        
		    } catch (Exception e) {
		        // Handle other potential exceptions
		        System.err.println("An unexpected error occurred: " + e.getMessage());
		    }
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	

}
