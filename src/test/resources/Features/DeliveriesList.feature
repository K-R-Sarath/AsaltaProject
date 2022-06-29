Feature: DeliveriesList

Background: Login and navigate to Deliveries
	Given User is on login page
	When User enters email as "testra.j409@gmail.com" and password as "Cbsinf0."
	And User clicks login button
	And User is Dashboard page and clicks Deliveries from side menu
	
@Regression 
Scenario: Check whether system throws "Picked quantity updated successfully" when we update picked quantity
	And User clicks the Action icon
	And User clicks Item Pick List
	And User updates quantity
	And User clicks the submit button
	Then System throws "Picked quantity updated successfully"
	When User clicks outside
	Then Status should be changed to "Packed"

@Regression 
Scenario: Check whether clicking edit in picklist popup navigates to edit deliveries page
	And User clicks the Action icon
	And User clicks Item Pick List
	And User clicks Edit in picklist popup
	Then System should navigate to edit deliveries page
	
@Regression 
Scenario: Check whether packing slip can be viewed	
	And User clicks the Action icon
	And User clicks packing slip option
	Then Packing slip should be displayed
	
@Regression 
Scenario: Check whether clicking edit in packingslip popup navigates to edit deliveries page
	And User clicks the Action icon
	And User clicks packing slip option
	And User clicks edit in packing slip
	Then System should navigate to edit deliveries page	
	
@Regression	
Scenario: Check whether picklist popup closes when we click close
	And User clicks the Action icon
	And User clicks Item Pick List
	And User closes the picklist popup
	Then Verify picklist popup closed
	
@Regression 
Scenario: Check whether packing slip popup closes when we click close
	And User clicks the Action icon
	And User clicks packing slip option
	And User closes the packing slip option
	Then Verify packing slip popup closed	
	
@Regression	
Scenario: Check whether clicking PENDING in deliveries list page, displays deliveries which are PENDING
	And User clicks Pending in top of the page
	Then Paginate and get values for PENDING status	
	
@Regression
Scenario: Check whether clicking PACKED in deliveries list page, displays deliveries which are PACKED
	And User clicks Packed in top of the page
	Then Paginate and get values for PACKED status	
	
@Regression 
Scenario: Check whether clicking READY TO SHIP in deliveries list page, displays deliveries which are READY TO SHIP
	And User clicks Ready To Ship in top of the page
	Then Paginate and get values for READY TO SHIP status	
	
@Regression 	
Scenario: Check whether clicking SHIPPED in deliveries list page, displays deliveries which are SHIPPED
	And User clicks Shipped in top of the page
	Then Paginate and get values for SHIPPED status	
	
@Regression 
Scenario: Check whether clicking DELIVERED in deliveries list page, displays deliveries which are DELIVERED
	And User clicks Delivered in top of the page
	Then Paginate and get values for DELIVERED status
	
@Regression 
Scenario: Check whether clicking ONHOLD in deliveries list page, displays deliveries which are ONHOLD
	And User clicks Onhold in top of the page
	Then Paginate and get values for ONHOLD status
	
@Regression 
Scenario: Check whether clicking CANCELLED in deliveries list page, displays deliveries which are CANCELLED
	And User clicks Cancelled in top of the page in deliveries
	Then Paginate and get values for CANCELLED status	in deliveries	
	
@Regression 
Scenario: Check whether clicking ALL in deliveries list page, displays ALL deliveries 
	And User clicks ALL in top of the page in deliveries
	Then Paginate and get values for ALL status	in deliveries	
	
@Regression 
Scenario: Check whether pagination works in both forward and backward directions	 
	Then User paginates in forward direction and Verify whether NEXT button is disabled while on last page
	Then User paginates in backward direction and Verify whether PREVIOUS button is disabled while on first page	
	
@Regression 
Scenario: Check whether choosing Display 10 in display dropdown lists only 10 deliveries per page
	And User clicks display option in deliveries
	And User chooses Display10
	Then Verify only ten deliveries displayed per page
	And Only ten deliveries present in table	
	
@Regression
Scenario: Check whether choosing Display 25 in display dropdown lists only 25 deliveries per page
	And User clicks display option in deliveries
	And User chooses Display25
	Then Verify only twenty five deliveries displayed per page
	And Only twenty five deliveries present in table
	
@Regression 
Scenario: Check whether choosing Display 50 in display dropdown lists only 50 deliveries per page
	And User clicks display option in deliveries
	And User chooses Display50
	Then Verify only fifty deliveries displayed per page
	And Only fifty deliveries present in table
	
@Regression 
Scenario: Check whether choosing Display 100 in display dropdown lists only 100 deliveries per page
	And User clicks display option in deliveries
	And User chooses Display100
	Then Verify only hundred deliveries displayed per page
	And Only hundred deliveries present in table
	
@Regression
Scenario: Check whether status can be sorted in Ascending order in deliveries table
	And User clicks Status in deliveries
	Then User gets obtained list and sorts it in Ascending order and verify the sorted list with obtained list in deliveries
	
@Regression
Scenario: Check whether status can be sorted in Descending order in deliveries table
	And User clicks Status in deliveries
	And User clicks Status in deliveries
	Then User gets obtained list and sorts it in Descending order and verify the sorted list with obtained list in deliveries	
	
@Regression 
Scenario: Check whether DODate can be sorted in Ascending order in deliveries table
	And User clicks DOdate
	Then User gets obtained list of DOdate and sorts it in Ascending order and verify the sorted list with obtained list
	
@Regression 
Scenario: Check whether DODate can be sorted in Descending order in deliveries table
	And User clicks DOdate
	And User clicks DOdate
	Then User gets obtained list of DOdate and sorts it in Descending order and verify the sorted list with obtained list
	
@Regression 
Scenario: Check whether DRDate can be sorted in Ascending order in deliveries table
	And User clicks DRDate
	Then User gets obtained list of DRDate and sorts it in Ascending order and verify the sorted list with obtained list
	
@Regression 
Scenario: Check whether DRDate can be sorted in Descending order in deliveries table
	And User clicks DRDate
	And User clicks DRDate
	Then User gets obtained list of DRDate and sorts it in Descending order and verify the sorted list with obtained list	
	
@Regression 
Scenario: Check whether Delivered Date can be sorted in Ascending order in deliveries table
	And User clicks Delivered Date
	Then User gets obtained list of Delivered Date and sorts it in Ascending order and verify the sorted list with obtained list
	
@Regression 
Scenario: Check whether Delivered Date can be sorted in Descending order in deliveries table
	And User clicks Delivered Date
	And User clicks Delivered Date
	Then User gets obtained list of Delivered Date and sorts it in Descending order and verify the sorted list with obtained list	
	
@Regression 
Scenario: Check whether channels can be sorted in Ascending order in deliveries table
	And User clicks Channels in deliveries table
	Then User gets obtained list of channels in deliveries table and sorts it in Ascending order and verify the sorted list with obtained list											
	
@Regression 
Scenario: Check whether channels can be sorted in Descending order in deliveries table
	And User clicks Channels in deliveries table
	And User clicks Channels in deliveries table
	Then User gets obtained list of channels in deliveries table and sorts it in Descending order and verify the sorted list with obtained list	

@Regression 
Scenario: Check whether channel order number can be sorted in Ascending order in deliveries table
	And User clicks channel order no in deliveries table
	Then User gets obtained list of channel order number in deliveries table and sorts in in ascending order and verify the sorted list with obtained list
	
@Regression 
Scenario: Check whether channel order number can be sorted in Descending order in deliveries table
	And User clicks channel order no in deliveries table
	And User clicks channel order no in deliveries table
	Then User gets obtained list of channel order number in deliveries table and sorts in in Descending order and verify the sorted list with obtained list	
	
@Regression 
Scenario: Check whether Delivery number can be sorted in Ascending order in deliveries table
	And User clicks Delivery number
	Then User gets obtained list of delivery number and sorts it in Ascending order and verify the sorted list with obtained list
	
@Regression 
Scenario: Check whether customer can be sorted in Ascending order in deliveries table
	And User clicks customers in deliveries 
	Then User gets obtained list of customers and sorts it in Ascending order and verify the sorted list with obtained list	
	
@Regression 
Scenario: Check whether customer can be sorted in Descending order in deliveries table
	And User clicks customers in deliveries 
	And User clicks customers in deliveries 
	Then User gets obtained list of customers and sorts it in Descending order and verify the sorted list with obtained list	
	
@Regression 
Scenario: Check whether postal code can be sorted in Ascending order in deliveries table
	And User clicks postal code
	Then User gets obtained list of postal codes and sorts it in Ascending order and verify the sorted list with obtained list

@Regression 
Scenario: Check whether postal code can be sorted in Descending order in deliveries table
	And User clicks postal code
	And User clicks postal code
	Then User gets obtained list of postal codes and sorts it in Descending order and verify the sorted list with obtained list	

@Regression	
Scenario: Check whether filtering deliveries by DOdate displays only deliveries of filtered date		
	And User clicks DOdate field
	And User clicks from DOdate field and enter date
	And User clicks to DOdate field and enter date
	And User clicks Apply button
	Then Verify deliveries date		
	
@Regression
Scenario: Check whether filtering deliveries by Delivery Request Date displays only deliveries of filtered date
	And User clicks DRDate
	And User clicks DRDate
	And User enters DRDate
	Then Verify DRDate of deliveries
	
@Regression	
Scenario: Check whether filtering deliveries by Delivered date displays only deliveries of filtered date
	And User clicks Delivered Date
	And User clicks Delivered Date
	And User clicks Delivered Date in deliveries table
	And User enters from DelDate
	And User enters to DelDate
	And User clicks Apply button in delivered date
	Then Verify Delivered Date
	
@Regression 	
Scenario: Check whether filtering deliveries by channels displays only deliveries of that channel
	And User enters channel
	Then Verify deliveries of the channel	
	
@Regression
Scenario: Check whether filtering deliveries by channel order no displays only deliveries of that channel order no
	And User clicks channel order no in deliveries table
	And User clicks channel order no in deliveries table
	And User enters channel order no
	Then Verify deliveries of that channel order no
	
@Regression 
Scenario: Check whether filtering deliveries by delivery no displays only delivery of that delivery no
	And User enters delivery no
	Then Verify delivery of that delivery no
	
@Regression 
Scenario: Check whether filtering deliveries by invoice no displays only delivery of that invoice no
	And User enters invoice no
	Then Verify delivery of that invoice no
	
@Regression 
Scenario: Check whether filtering deliveries by customer displays only delivery of that customer
	And User enters customer name
	Then Verify delivery of that customer	
	
@Regression
Scenario: Check whether filtering deliveries by postal code displays only delivery of that postal code
	And User enters postalcode
	Then Verify delivery of that postal code				
		
			
	
	
	