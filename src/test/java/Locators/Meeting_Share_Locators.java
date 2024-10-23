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

public class Meeting_Share_Locators {

	WebDriver driver;
	WebDriverWait wait;
	
	
	 @FindBy(xpath = "//span[.='Share']")
	 private WebElement Share;
	
	 @FindBy(xpath = "//span[.='Meeting']")
	 private WebElement Meeting;
	 
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-meeting-list/section/div/div[1]/div/div[2]/button")
	 private WebElement AddButton;

	 @FindBy(xpath = "//input[@placeholder='Enter title']")
	 private WebElement Name;
	 
	 @FindBy(xpath = "//input[@id='date_input']")
	 private WebElement Date;
	
	 @FindBy(xpath = "//input[@id='time_input']")
	 private WebElement Time;
	
	 @FindBy(xpath = "//input[@placeholder='Hours']")
	 private WebElement DurationHours;
	 
	 @FindBy(xpath = "//input[@placeholder='Minutes']")
	 private WebElement DurationMinutes;
	 
	 @FindBy(xpath = "//textarea[@formcontrolname='description']")
	 private WebElement Description;
	 
	 @FindBy(xpath = "//button[.=' Add Notes ']")
	 private WebElement AddNotes;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter notes']")
	 private WebElement EnterNotes;
	 
	 @FindBy(xpath = "//button[.=' Select users ']")
	 private WebElement SelectUsersTab;
	 
	 @FindBy(xpath = "//*[@id='user-group-tab']")
	 private WebElement SelectedUserGroupsTab;
	 
	 @FindBy(xpath = "//*[@id='multiUser']/div/div/span[3]/input")
	 private WebElement SearchUser;
	 
	 @FindBy(xpath = "//*[@id='multiUserGroup']/div/div/span[3]/input")
	 private WebElement SearchUserGroup;
	 
	 @FindBy(xpath = "(//input[@type='file'])[2]")
	 private WebElement UploadImages;
    
	 
	 
	 
	 
	public Meeting_Share_Locators(WebDriver driver) {
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
	
	
	
	
	
	 public void UploadingAnImage(String imageFilePath ) {
	    	if (imageFilePath != null && !imageFilePath.isEmpty()) {
	        System.out.println("Image path from Excel: " + imageFilePath);
	        UploadImages.sendKeys(imageFilePath);
	        System.out.println("Image uploaded successfully: " + imageFilePath);
	    	} else {
	        throw new RuntimeException("Image file path is not available in the Excel sheet or it's invalid.");
	    	}
	    }
	

	 
	 
	 public void EnterOnSearchUserGroup(String value)throws AWTException, InterruptedException  {
		 wait.until(ExpectedConditions.elementToBeClickable(SearchUserGroup));
		    SearchUserGroup.sendKeys(value);
		    Thread.sleep(2000);
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	
	 public void EnterOnSearchUser(String values) throws AWTException, InterruptedException {
		    wait.until(ExpectedConditions.elementToBeClickable(SearchUser));
		    SearchUser.sendKeys(values);
		    Thread.sleep(2000);
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		}

	 
	 
	 
	public void ClickOnSelectUsersTab() {
	    try {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectUsersTab));
	        SelectUsersTab.click();
	    } catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectUsersTab));
			SelectUsersTab.click();
	    } catch (Exception e) {
	        System.err.println("Error clicking Select Users tab: " + e.getMessage());
	    }
	}

	public void ClickOnSelectGroupUsersTab() {
	    try {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectedUserGroupsTab));
			SelectedUserGroupsTab.click();
	    	}catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectedUserGroupsTab));
			SelectedUserGroupsTab.click();
	    } catch (Exception e) {
	        System.err.println("Error clicking Select Group Users tab: " + e.getMessage());
	    }
	}

	public void SearchAndSelectUser(String userName) {
	    try {
	        SearchUser.sendKeys(userName);
	        // Wait for the dropdown to show results and select the user
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement userOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), '" + userName + "')]")));
	        userOption.click();
	    } catch (Exception e) {
	        System.err.println("Error searching/selecting user: " + e.getMessage());
	    }
	}

	public void SearchAndSelectGroupUser(String groupUserName) {
	    try {
	        SearchUserGroup.sendKeys(groupUserName);
	        // Wait for the dropdown to show results and select the group user
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement groupUserOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), '" + groupUserName + "')]")));
	        groupUserOption.click();
	    } catch (Exception e) {
	        System.err.println("Error searching/selecting group user: " + e.getMessage());
	    }
	}

	
	
	public void ClickOnSearchUserGroup() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchUserGroup));
			SearchUserGroup.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchUserGroup));
			SearchUserGroup.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void ClickOnSearchUser() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchUser));
			SearchUser.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchUser));
			SearchUser.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	

	
	
	public void EnterOnNotes(String note, int index) {
	    try {
	        // Use the index to locate the specific input field for entering notes
	        WebElement noteField = driver.findElement(By.xpath("(//input[@placeholder='Enter notes'])[" + (index + 1) + "]"));
	        
	        // Enter the note in the specific field
	        noteField.sendKeys(note);
	    } catch (Exception e) {
	        System.err.println("An error occurred while entering note: " + e.getMessage());
	    }
	}


	
	
	public void ClickOnEnterNotes() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(EnterNotes));
			EnterNotes.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddNotes));
			EnterNotes.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	public void ClickOnAddNotes() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddNotes));
			AddNotes.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddNotes));
			AddNotes.click();
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
	
	public void EnterOnDurationMinutes(String value) {
		DurationMinutes.sendKeys(value);
	}
	
	public void EnterOnDurationHours(String value) {
		DurationHours.sendKeys(value);
	}
	
	public void ClearOnDurationHours() {
		DurationHours.clear();
	}
	
	public void ClearOnDurationMinutes() {
		DurationMinutes.clear();
	}
	
	
	public void EnterOnTime(String value) {
		Time.sendKeys(value);
	}
	
	public void ClearOnTime() {
		Time.clear();
	}
	
	
	public void ClickOnTime() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Time));
			Time.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Time));
			Time.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void EnterOnDate(String value) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(Date));
	    dateElement.sendKeys(value);
	}
	
	public void ClearOnDate() {
		Date.clear();
	}
	
	
	public void ClickOnDate() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Date));
			Date.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Date));
			Date.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	public void EnterOnName(String value) {
		Name.sendKeys(value);
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

	public void ClickOnMeeting() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Meeting));
			Meeting.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Meeting));
			Meeting.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	public void ClickOnShare() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Share));
			Share.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Share));
			Share.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
