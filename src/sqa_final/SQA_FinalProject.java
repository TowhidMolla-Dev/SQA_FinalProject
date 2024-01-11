package sqa_final;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SQA_FinalProject {

    private WebDriver driver;

    public SQA_FinalProject() {
        driver = new ChromeDriver();
    }

    public void launch() {
        driver.get("https://www.ebay.com/");
        System.out.println("The title of this page is: " + driver.getTitle());
    }

    
    
    
    
    public void search(String searchTerm) {
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys(searchTerm);
        driver.findElement(By.id("gh-btn")).click();
    }

    public void clickOnItem() {
        WebElement itemLink = driver.findElement(By.xpath("//*[@id=\"item59f8f4557b\"]/div/div[2]/a/div/span"));
        itemLink.click();
    }

    
    public void navigateToDailyDeals() {
        driver.findElement(By.linkText("Daily Deals")).click();
        System.out.println("The title of this page is: " + driver.getTitle());
    }

    public void navigateToHelpAndContact() {
        driver.findElement(By.linkText("Help & Contact")).click();
        System.out.println("The title of this page is: " + driver.getTitle());
    }

    public void navigateToSell() {
        driver.findElement(By.linkText("Sell")).click();
        System.out.println("The title of this page is: " + driver.getTitle());
    }

    public void navigateToProfile() {
        driver.navigate().to("https://profile.w3schools.com");
        System.out.println("The title of this page is: " + driver.getTitle());
    }

    public void login(String username, String password) {
        WebElement emailField = driver.findElement(By.id("modalusername"));
        emailField.sendKeys(username);
        WebElement passField = driver.findElement(By.id("current-password"));
        passField.sendKeys(password);
        emailField.submit();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result;
        if (driver.getTitle().matches("Log in")) {
            System.err.println("Not Successful");
            result = "Not Successful";
        } else {
            System.out.println("Successful");
            result = "Successful";
        }


        writeResultToCSV(result);


    }

    private void writeResultToCSV(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("login_results.csv", true))) {
            
            writer.append(result);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
        

     

     

    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        SQA_FinalProject obj = new SQA_FinalProject();
        obj.launch();
        obj.search("Dell D6000 Universal Docking Station - Black");
        obj.clickOnItem();
        obj.navigateToDailyDeals();
        obj.navigateToHelpAndContact();
        obj.navigateToSell();
        obj.navigateToProfile();
        obj.login("towhidm74@gmail.com", "jfjdjf");
        obj.closeBrowser();
    }
}
