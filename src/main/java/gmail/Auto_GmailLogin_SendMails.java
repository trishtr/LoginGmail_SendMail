package gmail;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auto_GmailLogin_SendMails {
	public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","C:/driverservers/chromedriver_win32/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//disables the driver to install other chrome extensions
			options.setExperimentalOption("useAutomationExtension", false);
			//disables the automation bar
	        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
	        
	        WebDriver driver =  new ChromeDriver(options); 
	        driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	        
	        //Login Gmail Account
	        //fill in email
	        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys("reonatr123");
	        driver.findElement(By.id("identifierNext")).click();
	        //fill in password
	        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys("Aa12345678Bb");
	        driver.findElement(By.id("passwordNext")).click();
	        String title = driver.getTitle();
	        System.out.println(title);
	        
	        //Compose new mail and send to another email address
	        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Compose')]"))).click();
	        
	        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@role='combobox']"))).sendKeys("trantrang.ip@gmail.com");
	        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("testing");
	        driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Testing mail");
	        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button'][contains(@aria-label,'Send')]"))).click();
	        
	          
	        //Check inbox
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//div[@data-tooltip='Inbox']")).click();
	        String inboxNo = driver.findElement(By.xpath("//div[@data-tooltip='Inbox']//div[@class='bsU']")).getText();
	        System.out.println("Inbox has " + inboxNo + " mails");
	        Thread.sleep(3000);
	      
	        driver.quit();
		
	}
	
}
