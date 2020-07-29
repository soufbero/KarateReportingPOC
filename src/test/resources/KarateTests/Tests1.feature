Feature: Tests 1 Feature

  Background:
    * def TestingUtil = Java.type('com.souf.karate.TestingUtil')

  @RunAlways
  Scenario: Test Url Valid 1
    * match TestingUtil.validateURL(shouldValidateUrl,urlPassing,'http://www.google.com') == true

  @RunSometimes
  Scenario: Test Url Valid 2
    * match TestingUtil.validateURL(shouldValidateUrl,urlPassing,'http://www.yahoo.com') == true
