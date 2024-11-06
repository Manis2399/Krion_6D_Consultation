package Locators;

import static org.junit.Assert.assertTrue;

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

public class Issue_Locators {

	
	WebDriver driver;
    WebDriverWait wait;
	
    @FindBy(xpath = "//span[.='Issue']")
    private WebElement Issues;
    
    
//    @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-issue-list/section/div/div[1]/div/div[2]/div/div[2]/button/text()")
//  private WebElement AddButton;
    
    @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-issue-list/section/div/div[1]/div/div[2]/div/div[2]/button")
    private WebElement AddButton;


    @FindBy(xpath = "//input[@placeholder='Enter issue code']")
    private WebElement IssueCode;
    
    @FindBy(xpath = "//input[@placeholder='Enter issue title']")
    private WebElement Name;
    
    
   
    @FindBy(xpath = "//textarea[@placeholder='Enter description']")
	private WebElement Description;
 
    @FindBy(xpath = "//input[@placeholder='Enter Start Date']")
	private WebElement StartDate; 
    
    @FindBy(xpath = "//input[@placeholder='Enter Due Date']")
	private WebElement DueDate;
    
    @FindBy(xpath = "//input[@placeholder='Select the type']")
    private WebElement Type;
    
    
    
    @FindBy(xpath = "//input[@placeholder='Select the placement']")
    private WebElement Placement;
    
    @FindBy(xpath = "//input[@placeholder='Select the root cause']")
    private WebElement RootCause;
    
    @FindBy(xpath = "//input[@placeholder='Select the workflow']")
    private WebElement 	Workflow;
    
    @FindBy(xpath = "//input[@placeholder='Enter location']")
    private WebElement 	Location;
    
    @FindBy(xpath = "//input[@placeholder='Enter estimate cost']")
	 private WebElement EstimateCost;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter actual cost']")
	 private WebElement ActualCost;
    
	 @FindBy(xpath = "(//input[@type='file'])[2]")
	 private WebElement UploadImages;
    
    
	
    public Issue_Locators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
    
    
    public void UploadingAnImage(String imageFilePath ) {
    	if (imageFilePath != null && !imageFilePath.isEmpty()) {
        System.out.println("Image path from Excel: " + imageFilePath);
        UploadImages.sendKeys(imageFilePath);
        System.out.println("Image uploaded successfully: " + imageFilePath);
    	} else {
        throw new RuntimeException("Image file path is not available in the Excel sheet or it's invalid.");
    	}
    }
    
    
    public void attachFile(String DocumentName, String FileName) {
        try {
           // Wait for the list of file names to appear and click on the specific file
            String fileXPath = "//ul//li//a[contains(text(), '" + DocumentName + "')]";
            System.out.println(fileXPath);
            WebElement fileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fileXPath)));
            fileElement.click();
            
            Thread.sleep(2000);
            // After clicking the file, wait for the "Attach" button to appear and click it
            String Searchfield = "//input[@placeholder='Search']";
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
    
    public void EnterOnActualCost(String values) {
		ActualCost.sendKeys(values);
	}
	
	
	public void ClearOnActualCost() {
		ActualCost.clear();
	}
	
	
	
	public void ClickOnActualCost() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(ActualCost)); 
  			wait.until(ExpectedConditions.elementToBeClickable(ActualCost));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ActualCost);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActualCost);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(ActualCost));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ActualCost);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActualCost);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }

	
	
	public void EnterOnEstimateCost(String values) {
		EstimateCost.sendKeys(values);
	}
	
	
	public void ClearOnEstimateCost() {
		EstimateCost.clear();
	}
	
	
	public void ClickOnEstimateCost() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(EstimateCost)); 
  			wait.until(ExpectedConditions.elementToBeClickable(RootCause));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", EstimateCost);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", EstimateCost);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(EstimateCost));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", EstimateCost);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", EstimateCost);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }


    
    
    
    
    
    
    
    public void EnterOnLocation(String values) {
    	Location.sendKeys(values);
    } 
    
    
    
    public void EnterOnWorkflow(String values) {
    	Workflow.sendKeys(values);
    }
    
    
    
    public void ClickOnWorkflow() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Workflow)); 
  			wait.until(ExpectedConditions.elementToBeClickable(RootCause));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Workflow);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Workflow);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Workflow));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Workflow);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Workflow);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    public void EnterOnRootCause(String values) {
    	RootCause.sendKeys(values);
    }
    
    
    
    public void ClickOnRootCause() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(RootCause)); 
  			wait.until(ExpectedConditions.elementToBeClickable(RootCause));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", RootCause);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", RootCause);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(RootCause));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", RootCause);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", RootCause);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    
    public void EnterOnPlacement(String values) {
    	Placement.sendKeys(values);
    }
    
    
    
    public void ClickOnPlacement() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Placement)); 
  			wait.until(ExpectedConditions.elementToBeClickable(Placement));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Placement);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Placement);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Placement));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Placement);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Placement);
  		} catch (Exception e) {
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
    
    
    
    
    
    public void EnterOnType(String values) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement Types = wait.until(ExpectedConditions.elementToBeClickable(Type));
	    Types.sendKeys(values);
    }
    
    
    
    public void ClickOnType() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(Type)); 
  			wait.until(ExpectedConditions.elementToBeClickable(Type));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Type);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Type);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Type));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Type);
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Type);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    
    
    public void EnterOnDueDate(String values) {
    	DueDate.sendKeys(values);
    }
 
  
    public void ClearOnDueDate() {
    	DueDate.clear();
    }


    public void ClickOnDueDate() {
    	try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(DueDate));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", DueDate);
			DueDate.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(DueDate));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", DueDate);
			DueDate.click();
		} catch (Exception e) {
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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(StartDate));

			StartDate.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(StartDate));
			StartDate.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
    }


    
    
    
	
    public void EnterOnDescription(String values) {
		Description.sendKeys(values);
	}
	
	public void ClearOnDescription() {
		Description.clear();
	}
    
    public void EnterOnName(String values) {
    	Name.sendKeys(values);
    }
    
    public void EnterOnIssueCode(String values) {
    	IssueCode.sendKeys(values);
    }
    
    public void ClearOnIssueCode() {
    	IssueCode.clear();
    }
    
	public void ClickOnIssueCode() {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.elementToBeClickable(IssueCode));
		      //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", IssueCode);
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", IssueCode);
		        IssueCode.click();
		    } catch (ElementClickInterceptedException e) {
		        System.err.println("Element click intercepted: " + e.getMessage());
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", IssueCode);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", IssueCode);
		    } catch (Exception e) {
		        System.err.println("An unexpected error occurred: " + e.getMessage());
		    }
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
	 
	
	public void ClickOnIssues() {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.elementToBeClickable(Issues));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Issues);
		        Issues.click();
		    } catch (ElementClickInterceptedException e) {
		        System.err.println("Element click intercepted: " + e.getMessage());
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Issues);
		    } catch (Exception e) {
		        System.err.println("An unexpected error occurred: " + e.getMessage());
		    }
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
