package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuantInstiTest1 {

	@Test
	public void QuantIntiTest() {
		try {
			WebDriverManager.chromedriver().setup();

			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get("https://quantra.quantinsti.com/");
			System.out.println( "Navigated to the quantinsti URL");
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			Actions action = new Actions(driver);
			JavascriptExecutor executor = (JavascriptExecutor) driver;

			executor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
			WebElement loginBtn = driver.findElement(
					By.xpath("//*[@role='button' and @class='vue-ui-button vue-ui-button btn secondary button']"));
			wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
			loginBtn.click();
			System.out.println( "Clicked on login button");

			WebElement email = driver.findElement(By.xpath("//*[@type='email']"));
			wait.until(ExpectedConditions.elementToBeClickable(email));
			email.sendKeys("rwayal7@gmail.com");
			System.out.println( "Entered email successfully");

			WebElement passWord = driver.findElement(By.xpath("//*[@type='password']"));
			wait.until(ExpectedConditions.elementToBeClickable(passWord));
			passWord.sendKeys("Passw0rd@1234");
			System.out.println( "Entered Password successfully");

			WebElement userLoginBtn = driver.findElement(By.xpath("//*[@type='submit']"));
			wait.until(ExpectedConditions.elementToBeClickable(userLoginBtn));
			userLoginBtn.click();
			System.out.println( "Clicked on login button successfully");

			Thread.sleep(4000);
			WebElement browseCourses = driver.findElement(By.xpath("(//*[@href='/courses'])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(browseCourses));

			action.moveToElement(browseCourses).build().perform();

			WebElement sentimentCourse = driver
					.findElement(By.xpath("(//*[@href='/learning-track/sentiment-analysis-trading'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(sentimentCourse));
			action.moveToElement(sentimentCourse).click().build().perform();
			Thread.sleep(3000);
			System.out.println( "Hovered over browse categories successfully");

			WebElement courseName = driver.findElement(By.xpath("(//*[@class='course-detail__left-view']/h1)"));
			wait.until(ExpectedConditions.visibilityOf(courseName));

			String getCourseName = courseName.getText();
			System.out.println("Course Name is: " + getCourseName);
			System.out.println( "fetched course name successfully");

			WebElement coursePrice = driver.findElement(By.xpath("(//*[@class='cd__data-unit__info']/span[2])"));
			wait.until(ExpectedConditions.visibilityOf(coursePrice));

			String getCoursePrice = coursePrice.getText();
			System.out.println("Course Prize is: " + getCoursePrice);
			System.out.println( "fetched course price successfully");

			WebElement enrollBtn = driver
					.findElement(By.xpath("//*[@class='vue-ui-button btn button tertiary' and @type='button']"));
			wait.until(ExpectedConditions.visibilityOf(enrollBtn));
			enrollBtn.click();
			System.out.println( "Clicked on enroll button successfully");

			List<WebElement> coursesInCart = driver.findElements(By.xpath("// *[@class='cart-item-title']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(coursesInCart));
			for (int i = 0; i < coursesInCart.size(); i++) {
				System.out.println("Course " + i + ": " + coursesInCart.get(i).getText());
			}
			int actualCourseCount = coursesInCart.size();
			System.out.println("Total Actual Courses in cart are: " + actualCourseCount);

			WebElement displayedCartCount = driver.findElement(By.xpath("(//*[@class='cart-count'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(displayedCartCount));
			int displayedCourseCount = Integer.parseInt(displayedCartCount.getText());
			System.out.println("Total displayed Courses in cart are: " + displayedCourseCount);

			Assert.assertEquals(actualCourseCount, displayedCourseCount);
			System.out.println( "Actual course count and displayed cart course count are same ");

			WebElement baseAmt = driver.findElement(By.xpath("(//*[@class='cart-summary-right'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(baseAmt));
			System.out.println("Base Amount:" + baseAmt.getText());
			System.out.println( "fetched base amount of course successfully");

			WebElement totalAmt = driver.findElement(By.xpath("(//*[@class='cart-summary-right'])[6]"));
			wait.until(ExpectedConditions.visibilityOf(totalAmt));
			System.out.println("Total Amount:" + totalAmt.getText());
			System.out.println( "fetched total amoubt of course successfully");

			String originalHandle = driver.getWindowHandle();

			WebElement viewDetails = driver
					.findElement(By.xpath("(//a[text()='View Details' and @target='_blank'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(viewDetails));
			viewDetails.click();
			System.out.println( "Clicked on view details button successfully");

			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(originalHandle)) {
					driver.switchTo().window(handle);
					driver.close();
				}
			}

			driver.switchTo().window(originalHandle);
			System.out.println( "Closed secong tab successfully");

			executor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 4000);");

			WebElement removeCourseBtn = driver.findElement(By.xpath("(//*[text()='Remove'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(removeCourseBtn));
			removeCourseBtn.click();
			System.out.println( "Clicked on remove button successfully");

			WebElement toasterMsg = driver.findElement(By.xpath("//*[@class='toasted-container top-center']"));
			System.out.println("Remove course toaster msg is:");
			System.out.println(toasterMsg.getText());
			executor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 4000);");
			System.out.println( "Fetched remove course message successfully");

			WebElement remindMeLater = driver
					.findElement(By.xpath("//*[@type='button' and @class='web-push-btn remind-btn']"));
			wait.until(ExpectedConditions.visibilityOf(remindMeLater));
			remindMeLater.click();

			executor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 4000);");

			WebElement applyCouponBtn = driver.findElement(By.xpath("//*[@type='button' and @ghostbtn='true']"));
			wait.until(ExpectedConditions.visibilityOf(applyCouponBtn));
			applyCouponBtn.click();
			System.out.println( "Clicked on apply coupon button successfully");

			WebElement modalContainer = driver.findElement(By.xpath("//*[@class='modal-dialog modal-900']"));
			driver.switchTo().activeElement();

			Thread.sleep(2000);
			System.out.println("Entering Coupon Code ABC");
			WebElement couponTextBox = modalContainer
					.findElement(By.xpath("//*[@class='form-control text-uppercase personal-coupon-input']"));

			wait.until(ExpectedConditions.visibilityOf(couponTextBox));
			couponTextBox.sendKeys("ABC");

			Thread.sleep(2000);
			System.out.println( "Entered ABC coupon code successfully");

			System.out.println("Clicking on apply button");
			WebElement applyBtn = modalContainer.findElement(
					By.xpath("(//*[@ghostbtn='true' and @class='vue-ui-button btn secondary ghost-button'])[2]"));
			wait.until(ExpectedConditions.elementToBeClickable(applyBtn));
			applyBtn.click();
			System.out.println( "Clicked on Apply button successfully");

			WebElement couponErrorMsg = modalContainer
					.findElement(By.xpath("//*[@class='coupon-modal-alert alert alert-danger']"));
			System.out.println("Apply coupon error  msg is:");

			System.out.println("Coupon error msg is: " + couponErrorMsg.getText());
			System.out.println( "Fetched apply coupon error message successfully");

			System.out.println("Closing apply coupon popup");
			WebElement closePopup = modalContainer.findElement(By.xpath("//*[@type='button' and @class='close']"));
			wait.until(ExpectedConditions.elementToBeClickable(closePopup));
			closePopup.click();

			System.out.println( "Closed coupon modal window successfully");

			System.out.println("Clicking on profile details button");
			WebElement profileIcon = driver.findElement(By.xpath("//*[@class='profile-pic-initials']"));
			wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
			profileIcon.click();
			System.out.println( "Clicked on profile icon successfully");

			System.out.println("Clicking on log out button");
			WebElement logOut = driver
					.findElement(By.xpath("(//li[@class='avatar-menu__list sub-nav-item logout'])[2]"));
			logOut.click();
			System.out.println( "Clicked on logout button successfully");

			executor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 4000);");
			driver.close();
		} catch (Exception e) {

			Assert.fail("Assignment 1 test scenario failed");
			System.out.println( "Assignment 1 test scenario failed");

		}
	}
}