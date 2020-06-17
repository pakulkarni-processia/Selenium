Feature: Validate creation of EBOM and Release of all parts

@AT-25 @AT-24
	Scenario: Login to 3DExperience for all users
		Given Experience url is Open
		When experience logo is displayed
		And Enter credentials in "admin_platform" and "enoviaV6" and click on Login button
		Then Verify Login is success
		And Click on Profile logo and update Credentials
		And Verify Credentials are updated for user	

	#Create New Part
	@AT-26 @AT-24
	Scenario: Create New Part
		Given User login to 3DExperience
		When Click on Add button and Navigate to Engineering, Part, Create Part
		And Enter details in Mandatory fields on create Part page
		And Click on Ok button
		Then Verify Part is Created successfully	

	#Insert as child, New Part
	@AT-28 @AT-24
	Scenario: Insert as child, New Part
		Given Parent part is created and properties page is open
		And navigate to categories EBOM
		And click on Insert Part Button, Insert as child New part
		And enter details in mandatory fields
		And click on OK button 
		Then verify part is created successfully under parent part	

	
	@AT-29 @AT-24
	Scenario: Create Change Order
		#------------Given part properties EBOM category page is open
		When select all part checkbox, click on Change, Change Order, Add To New
		And Enter mandatory fields on change order page
		Then navigate to categories Change management 
		And Verify Change Order is created successfully	

	
	@AT-30 @AT-24
	Scenario: Open Change Order
		#-----Given Change management page is open
		When click on Change order name
		#------Then verify all selected part is added under Content, Proposed Change.
		And navigate to categories, CO name
		And click on Edit and added Approver List
		And Click on Done button
		And Promote CO to In Work state
		#----------Then validate the Approval list is added	

	
	@AT-31 @AT-24
	Scenario: Open Change Action
		#---------Given change order page is open
		When navigate to Categories, Content
		And click on CA name under Related Change Action
		And navigate to categories , CA Name
		And click on Edit and add reviewer
		And Click on Done
		And Promote CA to In work state.
		Then validate CA is promoted to Inwork state	

	
	@AT-32 @AT-24
	Scenario: Promote BOM- Mass Promote
		#---------------Given CA page is open
		When navigate to Categories, Content
		And Select all parts check box
		And Click Tools- Mass Promote
		#-----------Then Verify all parts are promotes to Frozen state
		And Close - Success message displayed	

	
	@AT-33 @AT-24
	Scenario:  Promote CA And approve route
		Given Navigate to CA properties page
		And Click on Promote 
		Then verify CA is promoted to In Approval state
		When navigate to Messages (Icon)
		And Click on New Task Assignment Notice
		And Click on Inbox Task IT-XXX no
		And Click on Approve button from tool bar
		And enter comments and click on Approve button
		And Close the window and refresh CA page
		Then verify CA is promoted to Approved state	

	
	@AT-34 @AT-24
	Scenario: Promote CO to complete state
		#---Given CA page is open
		And click on CO name from CA properties page
		Then verify CO page is open
		And click on CO name from Categories, Properties page display
		And Click on Approvals then click on task ID
		And click on Approve from tool bar
		And enter comments, click on Approve
		And close the window
		Then verify CO is promoted to Complete state Automatically	

	
	@AT-35 @AT-24
	Scenario: CA promoted to complete state
		#Given CO page is open
		And navigate to categories, content
		And click on CA
		Then verify CA is promoted to Complete state and part are promoted to Released state.
		And Signout and close window