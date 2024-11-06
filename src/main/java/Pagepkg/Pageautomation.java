package Pagepkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pageautomation {
	
	WebDriver driver;
	
	@FindBy(tagName="a")
	List<WebElement> links;
	//alerthandleing
	@FindBy(id="alertBtn")
	WebElement simple;
	@FindBy(id="confirmBtn")
	WebElement confirm;
	@FindBy(id="promptBtn")
	WebElement prompt;
	//screnshot
	@FindBy(xpath="//*[@id=\"HTML5\"]/div[1]/button")
	WebElement srcelement;
	//dragand drop
	@FindBy (xpath="//*[@id=\"draggable\"]/p")
	WebElement drag;
	@FindBy(xpath="//*[@id=\"droppable\"]")
	WebElement drop;
	//dropdown
	@FindBy(id="female")
	WebElement radio;
	@FindBy(id="friday")
	WebElement day;
	@FindBy(id="country")
	WebElement scroll;
	//passvalues
	@FindBy(id="name")
	WebElement fullname;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="phone")
	WebElement phone;
	@FindBy(id="textarea")
	WebElement address;
	//fetchvalues
	@FindBy(xpath="//*[@id=\"country\"]")
	WebElement path;
	//mouseactions
	@FindBy(xpath="//*[@id=\"HTML3\"]/div[1]/div/button")
	WebElement move;
	@FindBy(xpath="//*[@id=\"HTML10\"]/div[1]/button")
	WebElement doclick;
	@FindBy(xpath="//*[@id=\"field1\"]")
	WebElement copy;
	@FindBy(xpath="//*[@id=\"field2\"]")
	WebElement paste;
	///datepicker
	@FindBy(id="datepicker")
	WebElement fieldbox;
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div")
	WebElement monthdetails;
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")
	WebElement arrow;
	@FindBy(xpath="/html/body/div[5]/table/tbody/tr/td/a")
	List<WebElement> datelist;

	
	public Pageautomation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void Textverification()
	{
		String text="Automation";
		String source=driver.getPageSource();
		if(source.contains(text))
		{
			System.out.println("The text is present");
		}
		else
		{
			System.out.println("Ths text is not present ");
		}
	}
	public void Titleverification()
	{
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		String exptitle="DEMOQA";
		if(actualtitle.equalsIgnoreCase(exptitle))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
	public void count()
	{
		System.out.println("total number of links "+links.size());
		
		for(WebElement ele : links)
		{
			String li=ele.getAttribute("href");
			String linktext=ele.getText();
			System.out.println(li+"----"+linktext);
		}
	}
	public void alerthandle()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		simple.click();
		Alert a=driver.switchTo().alert();
		a.accept();
		confirm.click();
		a.accept();
		prompt.click();
		a.accept();
	
	}
	public void passvalues(String name, String mailid, String num, String add)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		
		
		fullname.sendKeys(name);
		email.sendKeys(mailid);
		phone.sendKeys(num);
		address.sendKeys(add);
		
	}
	public void shot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshot/shot1.png"));
	
	}
	
	public void elementshot() throws IOException
	{
		File screlement=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screlement, new File("./Screenshot/shot3.png"));
	}
	public void dragdrop()
	{
		Actions act=new Actions (driver);
		act.dragAndDrop(drag, drop);
		act.perform();
	}
	public void dropdown()
	{
		radio.click();
		day.click();
		Select se=new Select(scroll);
		se.selectByValue("india");
		se.selectByIndex(4);
		se.selectByVisibleText("Germany");
	}

	
	public void fetchcountry()
	{
		Select se=new Select(path);
		
		List<WebElement> p=se.getOptions();
		
		int len=p.size();
		
		for (int i=1;i<len;i++)
		{
			String options=p.get(i).getText();
			System.out.println(options);
		}
	}
	public void Mouse()
	{
		Actions act =new Actions(driver);
		act.moveToElement(move);
		act.doubleClick(doclick);
		
		act.keyDown(copy,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(copy,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(paste,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		act.perform();
	}
	public void datepicker1() 
	{
		fieldbox.click();
		month("November 2025", "15");
	}
	private void month(String expmonth, String expdate) {
		
		while(true)
		{
			String mon=monthdetails.getText();
			
			if(expmonth.equals(mon))
			{
				System.out.println(mon);
				break;
			}
			else
			{
				arrow.click();
			}
		}
		
	
	for(WebElement ele:datelist)
	{
		
		String datetext=ele.getText();
		if(datetext.equals(expdate));
		{
			ele.click();
			break;
		}
	}
		
		
	}
	
	
	
	}
		
	
		


	
	


