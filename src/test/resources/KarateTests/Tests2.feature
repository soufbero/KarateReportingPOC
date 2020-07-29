Feature: Tests 2 Feature

  Background:
    * def TestingUtil = Java.type('com.souf.karate.TestingUtil')

  @RunAlways
  Scenario: Test Url Invalid 1
    * match TestingUtil.validateURL(shouldValidateUrl,urlPassing,'sm 213132') == false

  @RunSometimes
  Scenario: Test Url Invalid 2
    * match TestingUtil.validateURL(shouldValidateUrl,urlPassing,'httpwwwyahoocom') == false
