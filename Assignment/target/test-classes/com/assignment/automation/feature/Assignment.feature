@OnlineShopping
Feature: Shopping
Scenario: Verify user is able to view the best seller items
          Given navigate to shopping site
          And   scroll to Best sellers
          And   validate Best sellers title
          
Scenario: Verify user is able to search the items
        
          Given enter the search item
          And validate search title
          
Scenario: Verify user is able to add a item to cart
          Given select a item
          Then  click on add to cart
          And click on proceed to checkout
          And validate your shopping cart title

Scenario: Verify user is able to contact customer service
          Given contact us
          Then validate title
          And  Select subject heading
          And Enter Email address
          And Enter order refference
          And Enter Message
          And Attach file
          And click on send
          And validate Success message
                    
 Scenario: Verify user is unable to Create a account  with invalid emailid
           Given click on sign in
           When User enter email
           Then click on create account
           And validate the message         
          
          
          
              
