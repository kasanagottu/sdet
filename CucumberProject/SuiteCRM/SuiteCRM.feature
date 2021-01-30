@CRM
Feature: Verify all CRM actvities

@CountingDashlets  
Scenario:Counting Dashlets on homepage
Given Open the browser to the ​CRM​ site and login
When Count number of Dashlets on homepage 
And Print number and title of each Dashlet into console
Then Close browser for Counting 
  
@CreateLeads
Scenario:Create leads using parameterization 
Given User Open WebBrowser and Navigate to Home Page
When Navigate to Create Lead
Then Fill all necessary details "Mr." and "Venkat" and "K" and "vktest@gmail.com" to create lead accounts and Click Save
And Navigate to View Leads page to see results as "MR." and "VENKAT" and "K"
Then Close browser for CreateLeads 

@ScheduleMeeting
Scenario Outline:Create Schedule a meeting and invite members 
Given User Open WebBrowser and Navigate to Schedule a Meeting
And Enter details of the meeting
And Search for members "<FirstName>" and "<LastName>" and "<Email>" add them to the meeting using example
And Navigate to View Meetings and confirm
And Close browser for meeting
    
Examples:
|FirstName	 |LastName  |Email           |
|Venkat      |K         |vktest@gmail.com|

@CreateProduct      
Scenario Outline: Creating a Product
Given User Open WebBrowser and Navigate to Create Product
And User enters product details "<ProductName>" and "<ProductPrice>" and Click Save button
Then User navigates to View Products page to Validate "<ProductName>" listed
And Close browser for Product

Examples: 
| ProductName		  |ProductPrice |
| MOBILE          | 9999  |
| HEADPHONE	      | 4999  |