Feature: Database testing
  Background:
    Given connect to database

  Scenario: Create an entry in the DB
    When create five records
    Then verify created records
