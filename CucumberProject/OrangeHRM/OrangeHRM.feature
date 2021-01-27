@HRM
Feature: Verify all Alchemy OrangeHRM actvities

@CreatingJobVacancy
Scenario:Creating a Job Vacancy
Given Open the OrangeHRM page and login with credentials 
When Navigate to Recruitment page and navigate to vacancies page
And Click on Add button to navigate to Add Job Vacancy form
And Fill out the necessary details "DevOps Engineer" and "IBM Employee 675" Click the Save button 
Then Verify that the vacancy "DevOps Engineer" and "IBM Employee 675" was created
And Close the browser for JobVacancy

@AddingCandidate
Scenario:Adding a candidate for recruitment
Given Open ​OrangeHRM​ page and login with credentials
When Navigate to Recruitment page and navigate to add candidate information
And Fill details of the candidate "Venkat" and "K" and "vktest@vktest.com"
And Upload a resume to the form and Click Save
Then Validate candidate entry "Venkat K"
And Close the browser for Candidate 

@CreatingMultipleVacancies 
Scenario Outline:Creating Multiple Vacancies from the Examples tables.
Given Open ​OrangeHRM​ page and Navigate to vacancies page
When Click on “Add” button to navigate “Add Job Vacancy” form
And Fill out the necessary details "<JobTitle>" and "<VacancyName>" and "<HiringManager>" Click on the Save button
Then Validate that all vacancies "<JobTitle>" and "<VacancyName>" and "<HiringManager>" have been created
And Close the browser multiple JobVacancy
 
Examples:
| JobTitle				 		     | VacancyName	  | HiringManager    | 
| Android Developer        | AndroidHyd    	|IBM Employee 675  | 
| Automation Test Engineer | AutomationHyd  |IBM Employee 675 |		

@AddingMultipleEmployees 
Scenario Outline:Creating Multiple Vacancies from the Examples tables.
Given Open ​OrangeHRM​ page and Navigate to PIM page
When Click on “Add” button to add a new Employee
And Make sure “Create Login Details” checkbox is checked
And Fill necessary emp details "<FirstName>" and "<LastName>" and "<UserName>" Click on the Save button
Then Validate that all employees have been created
And Close browser for multiple Employees

Examples:
| FirstName	| LastName	| UserName |  
| Suresh    | V       	| vsuresh  | 
| Pavan	    | K         | kpavan   |	
 