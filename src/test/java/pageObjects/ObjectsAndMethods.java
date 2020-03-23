package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.StepsForSearchKeyWord;

public class ObjectsAndMethods extends StepsForSearchKeyWord {

	public WebDriver ldriver;

	public ObjectsAndMethods(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@name='q']")
	WebElement txtGoogle;

	@FindBy(xpath = "//input[@name='btnK']")
	WebElement searchButtonGoogle;

	@FindBy(xpath = "//a[@aria-label='Page 2']")
	WebElement page2Google;

	@FindBy(xpath = "//div[@class='srg']//following-sibling::h3")
	List<WebElement> page2elements;

	@FindBy(xpath = "//input[@name='q']")
	WebElement txtBing;

	@FindBy(xpath = "//label[@class='search icon tooltip']")
	WebElement searchButtonBing;

	@FindBy(xpath = "//a[@aria-label='Page 2']")
	WebElement page2Bing;

	@FindBy(xpath = "//*[contains(@href,'www.bing.com/a')]")
	List<WebElement> page1elementsBing;

	@FindBy(xpath = "//input[@name='q']")
	WebElement txtDuck;

	@FindBy(xpath = "//input[@id='search_button_homepage]")
	WebElement searchButtonDuck;

	@FindBy(xpath = "//*[contains(@href,'www')]")
	List<WebElement> page1Duck;

	public void sendTxtG(String txt) {
		txtGoogle.sendKeys(txt);
	}

	public void sendTxtB(String txt) {
		txtBing.sendKeys(txt);
	}

	public void sendTxtD(String txt) {
		txtDuck.sendKeys(txt);
	}

	public void sendTxt(String title, String keyword) throws InterruptedException {

		if (title.equals("Google")) {
			sendTxtG(keyword);
			Thread.sleep(2000);
			searchButtonGoogle.click();
		} else if (title.equals("Bing")) {
			sendTxtB(keyword);
			Thread.sleep(2000);
			searchButtonBing.click();
		} else {
			sendTxtD(keyword);
			Thread.sleep(2000);
			txtGoogle.sendKeys(Keys.ENTER);
		}
		
	}

	public void to2ndPageG(String title) {
		
		if(title.equals("Google") || title.equals("Bing")) {
			page2Google.click();
		}
		
		else {
			System.out.println("Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !");
			System.out.println("Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !");
			System.out.println("Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !");
			System.out.println("Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !");
			System.out.println("Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !  Do Nothing !");
		}
	}

	public List<WebElement> listOfElements(String title) {
		
		if (title.equals("Google")) {
			return page2elements;
		} else if (title.equals("Bing")) {
			return page1elementsBing;
		} else {
			return page1Duck;
		}
	}

	public String[] wordsOfElement(String keyword, String title) {

		List <WebElement> listElements = listOfElements(title);
		
		int count = listElements.size();
		System.out.println("COUNT OF ELEMENTS  " + count);

		String[] ARRAY_ELEMENTS = new String[count];

		int i = 0;

		for (WebElement a : listElements) {
			ARRAY_ELEMENTS[i] = a.getText();
			i++;
		}

		String stringOf_myElements = Arrays.toString(ARRAY_ELEMENTS);

		String[] wordsInTheList = stringOf_myElements.split(" ");

		return wordsInTheList;

	}

	public int relevancyOfWord(String keyword , String title) {

		String[] wordsInTheList = wordsOfElement(keyword,title);

		int penCount = 0;
		for (String s : wordsInTheList) {
			if (s.toLowerCase().contains(keyword))
				penCount++;
			else
				penCount += 0;
		}

		if (penCount / (wordsOfElement(keyword,title).length) >= 0.7) {

			System.out.println(penCount + " " + wordsInTheList.length);

		} else {

			System.out.println(penCount + " " + wordsInTheList.length);

		}

		int relevancy = penCount / (wordsOfElement(keyword,title)).length;

		return relevancy;
	}

	public void testDoneMessage() {
		System.out.println("  TEST HAS BEEN DONE  //    TEST HAS BEEN DONE  //   TEST HAS BEEN DONE ");
		System.out.println("  TEST HAS BEEN DONE  //    TEST HAS BEEN DONE  //   TEST HAS BEEN DONE ");
		System.out.println("  TEST HAS BEEN DONE  //    TEST HAS BEEN DONE  //   TEST HAS BEEN DONE ");
		System.out.println("  TEST HAS BEEN DONE  //    TEST HAS BEEN DONE  //   TEST HAS BEEN DONE ");
		System.out.println("  TEST HAS BEEN DONE  //    TEST HAS BEEN DONE  //   TEST HAS BEEN DONE ");
		System.out.println("  TEST HAS BEEN DONE  //    TEST HAS BEEN DONE  //   TEST HAS BEEN DONE ");

	}

	public void successfullMessage() {

		System.out.println("SUCCESSFULL SUCCESSFULL  SUCCESSFULL  SUCCESSFULL  SUCCESSFULL  SUCCESSFULL");
		System.out.println("SUCCESSFULL SUCCESSFULL  SUCCESSFULL  SUCCESSFULL  SUCCESSFULL  SUCCESSFULL");
		System.out.println("SUCCESSFULL SUCCESSFULL  SUCCESSFULL  SUCCESSFULL  SUCCESSFULL  SUCCESSFULL");
		System.out.println("SUCCESSFULL SUCCESSFULL  SUCCESSFULL  SUCCESSFULL  SUCCESSFULL  SUCCESSFULL");

	}

	public void failedMessage() {

		System.out.println("FAILED FAILED FAILED FAILED FAILED FAILED FAILED FAILED");
		System.out.println("FAILED FAILED FAILED FAILED FAILED FAILED FAILED FAILED");
		System.out.println("FAILED FAILED FAILED FAILED FAILED FAILED FAILED FAILED");
		System.out.println("FAILED FAILED FAILED FAILED FAILED FAILED FAILED FAILED");
	}
}
