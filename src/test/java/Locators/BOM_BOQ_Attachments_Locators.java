package Locators;

import java.awt.AWTException;
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

public class BOM_BOQ_Attachments_Locators {

	WebDriver driver;
	WebDriverWait wait;
	
	
	 @FindBy(xpath = "//span[.='Attachments']")
	 private WebElement Attachments;
	
	 @FindBy(xpath = "//span[.='BOM/BOQ']")
	 private WebElement BOM_BOQ;
	 
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-bom-list/section/div/div[1]/div/div[2]/button")
	 private WebElement AddButton;

	 @FindBy(xpath = "//select[@formcontrolname='parentBomID']")
	 private WebElement ParentBOM;
	
	 @FindBy(xpath = "//input[@placeholder='Enter BOM item code']")
	 private WebElement EnterCode;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter BOM item name']")
	 private WebElement EnterName;
	 
	 @FindBy(xpath = "//select[@formcontrolname='reviewID']")
	 private WebElement Workflow;
	    
	 @FindBy(xpath = "//ejs-dropdownlist[@formcontrolname='priorityId']")
	 private WebElement Priority;
	
	 @FindBy(xpath = "//span[@formcontrolname='unitId']")
	 private WebElement Unit;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter estimated quantity']")
	 private WebElement EstimatedQuantity;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter estimated price total']")
	 private WebElement EstimatedPricePerUnit;
	 
	 @FindBy(xpath = "//input[@placeholder='Estimated total']")
	 private WebElement EstimatedTotal;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter ordered quantity']")
	 private WebElement OrderedQuantity;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter quoted price total']")
	 private WebElement QuotedPricePerUnit;
	 
	 @FindBy(xpath = "//input[@placeholder='Quoted total']")
	 private WebElement QuotedTotal;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter actual quantity']")
	 private WebElement ActualQuantity;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter actual price total']")
	 private WebElement ActualPricePerUnit;
	 
	 @FindBy(xpath = "//input[@placeholder='Actual total']")
	 private WebElement ActualTotal;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter remarks']")
	 private WebElement Remark;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter guid']")
	 private WebElement GUID;
	 
	 @FindBy(xpath = "//input[@id='file-upload']")
	 private WebElement AttachQRCode;
	 
	 @FindBy(xpath = "//button[.=' Add Properties ']")
	 private WebElement AddPropertiesButton;
	 
	 @FindBy(xpath = "//input[@id='propertyName']")
	 private WebElement PropertyName;
	 
	 @FindBy(xpath = "//input[@id='propertyValue']")
	 private WebElement PropertyValue;
	 
	 @FindBy(xpath = "//button[.='Submit']")
	 private WebElement SubmitButton;
	 
	 @FindBy(xpath = "//button[.=' Create ']")
	 private WebElement CreateButton;
	 
	 
	 
	 
	public BOM_BOQ_Attachments_Locators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		PageFactory.initElements(driver, this);
	}

	
	
	
	
	public void ClickOnCreateButton() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(CreateButton));
  			CreateButton.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(CreateButton));
  			CreateButton.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	
	
	public void ClickOnSubmitButton() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
  			SubmitButton.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
  			SubmitButton.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	
	
	public void EnterOnPropertyValue(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement PropertyValues = wait.until(ExpectedConditions.elementToBeClickable(PropertyValue));
	    PropertyValues.sendKeys(value);
	}
	
	
	public void ClickOnPropertyValue() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(PropertyValue));
  			PropertyValue.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(PropertyValue));
  			PropertyValue.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	public void EnterOnPropertyName(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement PropertyNames = wait.until(ExpectedConditions.elementToBeClickable(PropertyName));
	    PropertyNames.sendKeys(value);
	}
	
	public void ClickOnPropertyName() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(PropertyName));
  			PropertyName.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(PropertyName));
  			PropertyName.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	
	
	
	
	
	public void ClickOnAddPropertiesButton() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AddPropertiesButton));
  			AddPropertiesButton.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AddPropertiesButton));
  			AddPropertiesButton.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	

	
	
	public void UploadingQRCode(String imageFilePath ) {
    	if (imageFilePath != null && !imageFilePath.isEmpty()) {
        System.out.println("QR Code image path from Excel: " + imageFilePath);
        AttachQRCode.sendKeys(imageFilePath);
        System.out.println("QR Code image uploaded successfully: " + imageFilePath);
    	} else {
        throw new RuntimeException("QR Code file path is not available in the Excel sheet or it's invalid.");
    	}
    }
	
	
	
	
	public void EnterOnGUID(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement GUIDs = wait.until(ExpectedConditions.elementToBeClickable(GUID));
	    GUIDs.sendKeys(value);
	}
	
	
	public void EnterOnRemarks(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement Remarks = wait.until(ExpectedConditions.elementToBeClickable(Remark));
	    Remarks.sendKeys(value);
	}
	
	
	
	
	public String getActualTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ActualTotal));
        return ActualTotal.getAttribute("value"); 
	}
	
	
	
	public void EnterOnActualPricePerUnit(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ActualPricePerUnits = wait.until(ExpectedConditions.elementToBeClickable(ActualPricePerUnit));
	    ActualPricePerUnits.sendKeys(value);
	}
	
	public void ClearOnActualPricePerUnit() {
		ActualPricePerUnit.clear();
	}
	
	
	
	
	
	public void EnterOnActualQuantity(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement ActualQuantitys = wait.until(ExpectedConditions.elementToBeClickable(ActualQuantity));
	    ActualQuantitys.sendKeys(value);
	}
	
	public void ClearOnActualQuantity() {
		ActualQuantity.clear();
	}
	
	
	
	
	public String getQuotedTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(QuotedTotal));
        return QuotedTotal.getAttribute("value"); // or .getText() if applicable
    }
	
	
	
	
	public void EnterOnQuotedPricePerUnit(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement QuotedPricePerUnits = wait.until(ExpectedConditions.elementToBeClickable(QuotedPricePerUnit));
	    QuotedPricePerUnits.sendKeys(value);
	}
	
	
	public void ClearOnQuotedPricePerUnit() {
		QuotedPricePerUnit.clear();
	}
	
	
	public void EnterOnOrderedQuantity(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement OrderedQuantitys = wait.until(ExpectedConditions.elementToBeClickable(OrderedQuantity));
	    OrderedQuantitys.sendKeys(value);
	}
	

	public void ClearOnOrderedQuantity() {
		OrderedQuantity.clear();
	}
	
	
	
	
	
	public String getEstimatedTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(EstimatedTotal));
        return EstimatedTotal.getAttribute("value"); // or .getText() if applicable
    }
	
	
	
	
	public void EnterOnEstimatedPricePerUnit(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement EstimatedPricePerUnits = wait.until(ExpectedConditions.elementToBeClickable(EstimatedPricePerUnit));
	    EstimatedPricePerUnits.sendKeys(value);
	}
	
	
	
	public void EnterOnEstimatedQuantity(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement EstimatedQuantitys = wait.until(ExpectedConditions.elementToBeClickable(EstimatedQuantity));
	    EstimatedQuantitys.sendKeys(value);
	}
	
	
	
	
	public void EnterOnUnit(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement Units = wait.until(ExpectedConditions.elementToBeClickable(Unit));
	    Unit.sendKeys(value);
	}
	
	
	 public void selectDropdownOptionForUnit(String optionText) {
		    String xpathExpression = "//mat-option//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
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
	
	 
	public void ClickOnUnit() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Unit));
  			Unit.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Unit));
  			Unit.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	
	
	
	public void selectDropdownOptionForPriority(String optionText) {
		 String xpathExpression = "//ul[contains(@class, 'e-list-parent')]//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                + optionText.toLowerCase() + "')]";
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 try {
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

	
	
	
	
	
	public void ClickOnPriority() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Priority));
  			Priority.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Priority));
  			Priority.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	
	public void selectDropdownOptionForWorkFlow(String optionText) throws InterruptedException {
	    // Construct the XPath for the option text in a case-insensitive manner
		 String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                 + optionText.toLowerCase() + "')]";

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        Thread.sleep(1000);
	        optionElement.click();
	    } catch (TimeoutException e) {
	        System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");

	        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	} 
	
	
	public void ClickOnWorkflow() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Workflow));
  			Workflow.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Workflow));
  			Workflow.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
	
	
	
	
	
	public void EnterOnName(String values) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(EnterName));
		    Name.sendKeys(values);
	}
	
	public void ClearOnName() {
		EnterName.clear();
	}
	
	
	
	public void EnterOnCode(String values) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement Code = wait.until(ExpectedConditions.elementToBeClickable(EnterCode));
		    Code.sendKeys(values);
	}
	
	public void ClearOnCode() {
		EnterCode.clear();
	}
	
	
	public void ClickOnCode() {
		 try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(EnterCode));
				EnterCode.click();
			} catch (ElementClickInterceptedException e) {
				System.err.println("Element click intercepted: " + e.getMessage());
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(EnterCode));
				EnterCode.click();
			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
	 }
	
	
	
	
	public void ClickOnParentBOM() {
		 try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(ParentBOM));
				ParentBOM.click();
			} catch (ElementClickInterceptedException e) {
				System.err.println("Element click intercepted: " + e.getMessage());
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(ParentBOM));
				ParentBOM.click();
			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
	 }
	
	
	
	
	public void selectDropdownOption(String optionText) {
	    // Construct the XPath for the option text in a case-insensitive manner
	    String xpathSelect = "//*[@id='task']"; // Replace with your actual select element XPath

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelect)));

	        selectElement.click();

	        // Construct the XPath for the option within the select element
	        String xpathOption = "//select[@id='task']//option[normalize-space(.)='" + optionText.trim() + "']";

	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOption)));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();
	    } catch (TimeoutException e) {
	        System.out.println("Timeout waiting for dropdown option '" + optionText + "' to be clickable.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for dropdown option '" + optionText + "'. Trying to click via JavaScript.");
	        String xpathOption = "//select[@id='task']//option[normalize-space(.)='" + optionText.trim() + "']";
	        WebElement optionElement = driver.findElement(By.xpath(xpathOption));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
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
	
	
	public void ClickOnBOM_BOQ() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(BOM_BOQ));
			BOM_BOQ.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(BOM_BOQ));
			BOM_BOQ.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	public void ClickOnAttachments() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Attachments));
			Attachments.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Attachments));
			Attachments.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
