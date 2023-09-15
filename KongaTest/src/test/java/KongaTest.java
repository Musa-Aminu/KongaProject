import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaTest {

    //Import chromeDriver
    private WebDriver driver;
    @BeforeTest
    public void setup() throws InterruptedException {
        //Set chromedriver location
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");


        //1. Open chrome browser
        driver = new ChromeDriver();
        //2. Input your Konga Page URL
        driver.get("https://www.konga.com/");
        //3. Verify that the correct url is correct and user is on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong webpage");
        Thread.sleep(5000);
        //4. Maximize the browser driver
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }


        //Signing In
        @Test (priority = 0)
        public void SignIn() throws InterruptedException {

            //1. Click SignIn button to open the SignIn page
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(3000);
            //2. Enter email address
            driver.findElement(By.id("username")).sendKeys("musaaminu@mailinator.com");
            //3. Enter password
            driver.findElement(By.id("password")).sendKeys("musaaminu");
            Thread.sleep(3000);
            //4. Click Login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(5000);
            System.out.println("Signed in to Homepage Konga Successfully");
        }


        //Locating computers and accessories and adding a Macbook to the cart
        @Test (priority = 1)
        public void AddToCart() throws InterruptedException {

            //1. Click on Computers and accessories
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
            Thread.sleep(10000);
            //2. Click on Laptops subcategory
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
            Thread.sleep(7000);
            //3. Click on Apple macbooks
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
            Thread.sleep(7000);
            System.out.println("Located categories for Laptops");


            //4. Add a macbook to cart
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/div/div/div[2]/form/div[3]/button")).click();
            Thread.sleep(5000);

            System.out.println("Added a mac laptop to cart");
        }


        //Proceed to checkout
        @Test (priority = 2)
        public void Checkout() throws InterruptedException {

            //1. Click on the cart icon
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
            Thread.sleep(5000);
            //2. Click on checkout
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
            Thread.sleep(5000);

            System.out.println("Checked out an item in the cart");
        }


        //Proceed to selecting an Address
        @Test (priority = 3)
        public void selectAddress() throws InterruptedException {

            //1. Click on change
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
            Thread.sleep(5000);
            //2. Click on add delivery address
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
            Thread.sleep(5000);
            //3. Click on the address
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
            Thread.sleep(5000);
            //4. Click on Use this Address
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
            Thread.sleep(5000);

            System.out.println("Selected Payment Address");
        }

        //Continue to make payment
        @Test (priority = 4)
        public void makePayment() throws InterruptedException {


            //1. Click on pay now
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
            Thread.sleep(5000);
            //2. Click on continue to payment
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
            Thread.sleep(7000);

            System.out.println("Make Payment");

        }


        //Select Card as payment method on the iFrame
        @Test (priority = 5)
        public void SelectCard() throws InterruptedException  {

        WebElement iframe = driver.findElement(By.tagName("iframe"));

            //1. Switch to iframe
            driver.switchTo().frame("kpg-frame-component");


            //2. Locate the card button
            WebElement Cardbutton = driver.findElement(By.className("Card"));
            Cardbutton.click();
            Thread.sleep(3000);
            System.out.println("Opened card payment modal");


            //Enter card details

            //1.Locate the card number field and enter an invalid card number
            WebElement CardNumberField = driver.findElement(By.id("card-number"));
            CardNumberField.sendKeys("5199567841055678");
            Thread.sleep(2000);

            //2. Locate the date field and enter an invalid date
            WebElement DateField = driver.findElement(By.id("expiry"));
            DateField.sendKeys("0926");
            Thread.sleep(2000);

            //3. Locate the CVV field and enter an invalid CVV
            WebElement CVVField = driver.findElement(By.id("cvv"));
            CVVField.sendKeys("069");
            Thread.sleep(3000);

            System.out.println("Enter invalid card details");

            //Print Out the error message: Invalid Card Number

            //1. Locate the error message
            WebElement ErrorMessage = driver.findElement(By.id("card-number_unhappy"));
            Thread.sleep(3000);
            System.out.println("Print the error message");

            //2. Print out the error message
            System.out.println(ErrorMessage.getText());
            Thread.sleep(3000);

            //3. Close the iFrame that displays the input card Modal
            WebElement CloseiFrame = driver.findElement(By.className("data-card__close"));
            CloseiFrame.click();
            System.out.println("Switch out of iframe");

            //4. Switch out of iFrame
            driver.switchTo().defaultContent();
            Thread.sleep(3000);

    }

    @AfterTest
    public void closeBrowser() {
        //31. Close the browser
        System.out.println("Close browser");
        driver.quit();
    }
}



