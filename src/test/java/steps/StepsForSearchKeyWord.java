package steps;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ObjectsAndMethods;


public class StepsForSearchKeyWord {
	
	public WebDriver driver;
	
	public ObjectsAndMethods o_m;
	
	String title;
	
@Given("User Launch Chrome browser")
public void user_Launch_Chrome_browser() {
	
	System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver1.exe");
	
	driver = new ChromeDriver();
	
	o_m = new ObjectsAndMethods(driver);
	
	driver.manage().window().maximize();
	
}

@When("User opens url {string}")
public void user_opens_url(String url) throws InterruptedException {
	
	driver.get(url);
	
	Thread.sleep(1500);
	
	this.title = driver.getTitle();
	
	
}

@And("Searches for {string} and clicks to search button")
public void searches_for_and_clicks_to_search_button(String keyword) throws InterruptedException {
	
	o_m.sendTxt(this.title, keyword );
	
}

@Then("sees {int}% of the words as {string}")
public void sees_of_the_words_as(Integer int1, String keyword) {

	o_m.to2ndPageG(this.title);
	 
	o_m.listOfElements(this.title);
	
	o_m.wordsOfElement(keyword, this.title);
	
	o_m.relevancyOfWord(keyword, this.title);
	
}

@And("close the bowser")
public void close_the_bowser() throws InterruptedException {
	
	o_m.testDoneMessage();
	
	Thread.sleep(3000);
	
	driver.close();
}


}
