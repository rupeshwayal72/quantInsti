# quantInsti
QuantInsti Assignments 

Tools
--
Eclipse Java EE(oxygen recommended)
Java 7+
WebDriver 3.14
Apache Maven
TestNG


For step by step Selenium setup,Please go through
https://www.guru99.com/installing-selenium-webdriver.html

For step by step TestNG setup,Please go through
https://www.toolsqa.com/testng/install-testng/#:~:text=The%20following%20installation%20process%20uses,click%20the%20%E2%80%9CAdd%E2%80%9D%20button.

For importing project from git follow below steps:
1. Open eclipse and click on file(top left corner menu)
2. Click on import and search for git
3. Select project from git and click on next button
4. Click on clone URI and click on next
5. Now open this git repo in browser and click on code and copy it's https url
6. Now paste it into eclipse URI field and enter your git credentials.
7. click on finish.

8. Now after importing project into eclipse, Right click on project and click on build path-->configure build path
and click on add liabrary(liabraries tab) add jre system liabrary,maven dependencies,testng(only if any one of them is missing).

9. We used Apache maven for dependency management.
Just right click on the project and
go to maven-->download sources,
Then maven-->update project that's it.
 
10.After Successful TestNG insatllation,Right click on TestNG.xml file of this project and select execute as TestNG suite option(for assignment 2 only).
For HTML Test report,check  test-output(folder)-->emailable-report.html

Please Note: Original java code for all assignments is inside src-->main-->java folder



