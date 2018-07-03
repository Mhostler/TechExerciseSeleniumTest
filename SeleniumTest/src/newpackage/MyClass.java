package newpackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;

//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;

public class MyClass {
	public static void main(String[] args) {
		seleniumTutorial();
		
		viewTest();
		
		addDelTest();
	}
	
	private static void seleniumTutorial() {
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","C:\\selenium-java-3.13.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        //close Fire fox
        driver.close();
	}
	
	private static void viewTest() {
		System.setProperty("webdriver.chrome.driver","C:\\selenium-java-3.13.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseURL = "http://ec2-18-217-53-96.us-east-2.compute.amazonaws.com:8080/EventPage/Index.html";
		
		driver.get(baseURL);
		
		WebElement view = driver.findElement(By.name("view"));
		
		view.click();
		
		String currentUrl = driver.getCurrentUrl();

		if(currentUrl.equals("http://ec2-18-217-53-96.us-east-2.compute.amazonaws.com:8080/EventPage/ViewEvent")) {
			System.out.println("View Passed!");
		}
		else {
			System.out.println("View Failed!");
		}
		
		driver.close();
	}
	
	private static void addDelTest() {
		System.setProperty("webdriver.chrome.driver","C:\\selenium-java-3.13.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseURL = "http://ec2-18-217-53-96.us-east-2.compute.amazonaws.com:8080/EventPage/Index.html";
		
		driver.get(baseURL);
		
		WebElement nameField = driver.findElement(By.name("eName"));
		WebElement streetField = driver.findElement(By.name("sAddr"));
		WebElement cityField = driver.findElement(By.name("city"));
		WebElement stateField = driver.findElement(By.name("state"));
		WebElement zipField = driver.findElement(By.name("zip"));
		WebElement dateField = driver.findElement(By.name("edate"));
		WebElement timeField = driver.findElement(By.name("etime"));
		WebElement addButton = driver.findElement(By.name("Add"));
		
		nameField.sendKeys("SeleniumTest");
		streetField.sendKeys("123 Selenium rd.");
		cityField.sendKeys("Selenium");
		stateField.sendKeys("SE");
		zipField.sendKeys("12345");
		dateField.sendKeys("01012018");
		timeField.sendKeys("1010AM");
		addButton.click();
		
		WebElement remove = driver.findElement(By.id("SeleniumTest"));
		
		remove.click();
		
		String currentUrl = driver.getCurrentUrl();
		
		if(currentUrl.equals("http://ec2-18-217-53-96.us-east-2.compute.amazonaws.com:8080/EventPage/DelEvent")) {
			System.out.println("Add and Delete passed!");
		}
		else {
			System.out.println("Add and Delete failed!");
		}
		
		driver.close();
	}
	
}
