@SampleList
Feature: Sample List page tests

  @NativeView
  Scenario: Native View check
    When User Login with username: "admin" and password: "admin" and press Login
    And User should be in the Native View page
    Then All Views are present
    And Back to Login Page

  @Slider
  Scenario: Move Slider
    When User Login with username: "admin" and password: "admin" and press Login
    And User should be in the Slider page
    Then User moving a slider
    And Back to Login Page

  @VerticalSwipe
  Scenario: Vertical swiping
    When User Login with username: "admin" and password: "admin" and press Login
    And User should be in the Vertical Swipe page
    Then User perform vertical swipe
    And Back to Login Page

  @DragAndDrop
  Scenario: Drag and drop verify success message
    When User Login with username: "admin" and password: "admin" and press Login
    And User should be in the Drag And Drop page
    Then User perform Drag And Drop and check message
    And Back to Login Page

  @DoubleTap
  Scenario: Double tap and verify success message
    When User Login with username: "admin" and password: "admin" and press Login
    And User should be in the Double Tap page
    Then User perform Double Tap and check message
    And Back to Login Page

  @LongPress
  Scenario: Long press and verify success message
    When User Login with username: "admin" and password: "admin" and press Login
    And User should be in the Long Press page
    Then User perform Long Press and check message
    And Back to Login Page

  @Carousel
  Scenario: Carousel swipe
    When User Login with username: "admin" and password: "admin" and press Login
    And User should be in the Carousel Page
    Then User perform Carousel swipe
    And Back to Login Page

  @WheelPicker
  Scenario: WheelPicker actions
    When User Login with username: "admin" and password: "admin" and press Login
    And User should be in the WheelPicker Page
    Then User perform WheelPicker color change
    And Back to Login Page