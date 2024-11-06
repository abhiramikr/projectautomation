package testpkg;

import java.io.IOException;

import org.testng.annotations.Test;

import Basepkg.Baseclass;
import Pagepkg.Pageautomation;

public class Testautomation extends Baseclass
{
	
@Test
public void textverify() throws IOException
{
	Pageautomation pa=new Pageautomation (driver);
	pa.Textverification();
	pa.Titleverification();
	pa.count();
	pa.alerthandle();
	pa.passvalues("anand", "anand@gmail.com", "98562314", "Govindhabavan");
	pa.shot();
	pa.elementshot();
	pa.dragdrop();
	pa.dropdown();
	pa.fetchcountry();
	pa.Mouse();
	pa.datepicker1();
	
}
}
