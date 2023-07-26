Feature: Career
  Background:
    Given The user should be on the scwaı page
    Then Validate the correct page

    Scenario: Applying for a job
      Given The user click the "About Us" menu
      When The user choose the "CAREERS" menu
      Then Validate the correct menu
      And The user should choose "Software Quality Engineer Intern" job
      And The user should apply for job
      And The user should fill the apply for this position list with "Seyma", "Dalkiran", "camdalkiran@gmail.com", "5051302666", "Yunusemre", "Manisa", "Izmir", "45125", "country", "08082023"
      And The user should add the resume
      And The user should add the github url "https://github.com/seymacamdalkiran/SCW.AI"
      And The user should add the linkedin profile url "https://www.linkedin.com/in/seyma-c/"
      And What has peeked your interest about this particular internship?
      And What is your availability for an internship experience (i.e. ideal start and duration)?
      And The user should chose "Yes"
      And The user should submit application
      Then The user should see "Your application was submitted successfully" message