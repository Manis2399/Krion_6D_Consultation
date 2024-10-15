#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


Feature: Creating Projects and other functionalities realted to it
   This feature aims to test and create the Projects and other functionality in it under Design module within the application.

  @Run
Scenario: User Login for Design Projects
  Given I visit the User Login for Design Projects using sheetname "Credentials" and rownumber 0
  And I enter the credentials in login and click a login button


@Run
 Scenario: Verify by clicking on Project module Under Design section
 Then Clicking on Project module under Design section
# Then Click on ADD Project button to create new project
 
 
 Scenario: Verify by selecting the project template
 Then Clicking on Project template field and selecting the template using sheetname "Add Project" and rownumber 0
 
  
  Scenario: Verify by Entering the valid project code
  Then Entering valid project code using sheetname "Add Project" and rownumber 0
  
   
    Scenario: Verify by Entering the valid project name
  Then Entering valid project name using sheetname "Add Project" and rownumber 0
  
   
    Scenario: Verify by Entering the project description
  Then Entering valid project description using sheetname "Add Project" and rownumber 0
  
   
      Scenario: Verify by Entering the project Start Date
  		Then Entering Start Date of the project using sheetname "Add Project" and rownumber 0
  		
  		   
  		Scenario: Verify by Enter and select the project Design type from drop-down
  		Then Enter and select the project design type from drop-down using sheetname "Add Project" and rownumber 0
  		
  		  
  	Scenario: Verify by Enter and select the project category type from drop-down
  		Then Enter and select the project category type from drop-down using sheetname "Add Project" and rownumber 0	
  		  
  		 	Scenario: Verify by Enter and select the project owner type from drop-down
  		Then Enter and select the project owner type from drop-down using sheetname "Add Project" and rownumber 0	
  		  
  			 	Scenario: Verify by Enter and select the project status type from drop-down
  		Then Enter and select the project status type from drop-down using sheetname "Add Project" and rownumber 0		
  		
  		
  		 
  		 Scenario: Verify by Entering address in address line one field
  		 Then Entering address in address line one field using sheetname "Add Project" and rownumber 0
  		
  		 Scenario: Verify by Entering address in address line two field
  		 Then Entering address in address line two field using sheetname "Add Project" and rownumber 0
  		 
  		 Scenario: Verify by Entering City name in the field
  		 Then Entering City name in the field using sheetname "Add Project" and rownumber 0
  		 
  		Scenario: Verify by Entering State name in the field
  		Then Entering State name in the field using sheetname "Add Project" and rownumber 0
  		
  		Scenario: Verify by Entering valid Pincode in the field
  		Then Entering valid Pincode in the field using sheetname "Add Project" and rownumber 0
  		 
  		Scenario: Verify by Entering Country name in the field
  		Then Entering Country name in the field using sheetname "Add Project" and rownumber 0
  		 
  		Scenario: Verify by clicking on Create button to create new project
  		Then Click on Create button to create new project
  		
  		
  
  #Filtering the required project by using the search box field and creating a Assign role for the users#
  
  		 @Run
  		Scenario: Verify by filtering the required project and clicking on it
  		Then filtering the required project and clickin on it using sheetname "Add Project" and rownumber 0
  		
  				 @Run
  		Scenario: Verify by clicking the settings module in newly Created Project under Design module
  		Then Clciking on Setting module in newly Created Project under Design module
  		
  		#Assign Role#
  		
  		
  		#Scenario: verify by adding the assign role and assing role for group based on excel data#
  	#	Then Assign role or group based on the data in Excel using sheetname "Assign Role" and rownumber 0#
  		
  				@Run 
  		Scenario: Verify by clicking on Assign role sub-module under settings in newly Created Project under Design module
  		Then Clciking on Assign role sub-module under settings in newly Created Project under Design module
  		
  			@Run 	 
  		Scenario: Verify by clicking on Assign Role button to assigning the role to the user
  		Then Clicking on Assign Role button to assigning the role to the user
  		
  				@Run  
  		Scenario: Veriffy by Clicking on Select role drop-down to select the required role from the list
  		Then Clicking on Select role drop-down to select the required role from the list using sheetname "Assign Role" and rownumber 0
  			@Run 	 
  		Scenario: Veriffy by Clicking on Add user drop-down to select the required number of users from the list
  		Then Clicking on Add user drop-down to select the required number of users from the list sheetname "Assign Role" and rownumber 0
  			@Run  
  		Scenario: Veirfy by clicking on Assign button to assign the role for the desire number of users
  		Then Clicking on Assign button to assing the role for the desire number of users
  		
  		
  			#Assign Role For Group#
  		
  			@Run  
  		Scenario: verify by clicking on Assign Role for Group tab
  		Then Clicking on Assign Role for Group tab
  			@Run  
  		Scenario: Verify by clicking on Assign Role Group button to create a group
  		Then Clickingon Assign Role Group button to create a group
  			@Run  
  		Scenario: Veriffy by Clicking on Select role drop-down to select the required role from the list for Group
  		Then Clicking on Select role drop-down to select the required role from the list for Group using sheetname "Assign Role" and rownumber 0
  			@Run  
  		Scenario: Veriffy by Clicking on Add group drop-down to select the required number of users from the list
  		Then Clicking on Add group drop-down to select the required number of users from the list sheetname "Assign Role" and rownumber 0
  			@Run  
  		Scenario: Veirfy by clicking on Assign button to assign the role for the desire number of users in group
  		Then Clicking on Assign button to assing the role for the desire number of users users in group
  		
  		
  		
  		
  		#WorkFlow Creation#
  		 @Run 
  		Scenario: Verify by clicking on Workflow sub-module under settings in newly Created Project under Design module
  		Then Clciking on Workflow sub-module under settings in newly Created Project under Design module
  		
  			 @Run
  		Scenario: Veriffy by Clicking on Select the category drop-down to select the category from the list
  		Then Clicking on Select the category drop-down to select the required category from the list using sheetname "Workflow" and rownumber 0
  		
  		 @Run 
  		Scenario: Veirfy by clicking on Add workflow button
  		Then Clicking on Add workflow button
  		
  				 @Run
  		Scenario: Verify by selecting the stepper selection from the drop down in General info
  		Then Selecting the stepper selection from the drop down using sheetname "Workflow" and rownumber 0
  				 @Run
  		Scenario: verify by Entering the valid Name in the field in General info
  		Then Entering the valid Name in the field using sheetname "Workflow" and rownumber 0
  				 @Run 
  		Scenario: verify by Entering the Description in the field in General info
  		Then Entering the Description in the field using sheetname "Workflow" and rownumber 0
  		
  				 @Run 
  		Scenario: verify by selecting the workflow category drop down field in General info
  		Then selecting the workflow category drop down field using sheetname "Workflow" and rownumber 0
  		
  		 @Run
  		Scenario: verify by selecting the Status drop down field in General info
  		Then selecting the Status drop down field using sheetname "Workflow" and rownumber 0
  			 @Run 
  		 Scenario: verify by Entering the valid Name for Approval in General info
  		Then Entering the valid Name for Approval using sheetname "Workflow" and rownumber 0
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
 
 
