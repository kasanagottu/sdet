@Jobs
Feature: Verify all Alchemy Jobs actvities

@CreateUser
Scenario:Create a new user
Given User Open WebBrowser and Navigate LoginPage
When User enters username and password
And Click User from Left section
And User Click AddNew button
And Fill all Neccesary data
And User Click the Add New User button
Then Verify that the user was created
And User Close the browser

@SearchJob
Scenario: Search a job for full time
Given User Open WebBrowser and Navigate JobsPage
When Find and Type the Keywords to search for jobs
And change the Job type to only Full Time jobs
And Find a job and to see job details
Then Find the title of the job and print it to the console
Then Find and Click on the Apply for job button
And Close the browser for Search

@PostingJob     
Scenario: Post a job from the Feature file
Given User Open WebBrowser and Navigate to Post a Job
When User enters "kvtest1@qa.com" and "SDET-QA" and "ktest1@ktest.com" and "Testing" and "IBM India"
Then Verify posted job "SDET-QA" on Jobs page
And Close the browser for Posting Job

@PostingJob_Examples
Scenario Outline: Post a job from Examples
Given User Open WebBrowser and Navigate to Post a JobEx
When User enter values "<Email>" and "<JobTitle>" and "<ApplicationURL>" and "<Desc>" and "<CompanyName>"
Then Verifying posted job "<JobTitle>" on Jobs page
And Close browser for Posting Job

Examples:
| Email				 		    | JobTitle				  	| ApplicationURL    | Desc 		| CompanyName |
| kvtest2@qa.com      | Functional QA     	|ktest2@ktest.com   | Testing | IBM 				|
| kvtest3@qa.com      | Perfomance QA       |ktest3@ktest.com"  | Testing | TCS 				|		


