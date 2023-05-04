Feature: ClickUp API test feature

Scenario: Create a new folder in the ClickUp space and a list in the folder with one task
  Given I create a ClickUp folder and verify that the name is correct
  Then I create a new list in the folder
  And I check that the list name is correct
  And I check that the list is added to the correct folder
  Then I create one Task in the list
  And I check that the Task name is correct
  Then I remove the Task from the list
  And I fetch the List and verify that the Task can't be found there anymore
