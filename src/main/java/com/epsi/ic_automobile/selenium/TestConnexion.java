package com.epsi.ic_automobile.selenium;
import com.epsi.ic_automobile.appli.service.HttpClientService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;


@SpringBootTest
public class TestConnexion {

    public String port = "8081";

    @Test
    public void testConnexionPage(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        TestConnexion testConnexion = new TestConnexion();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:"+port+"/");
        WebElement element_email = driver.findElement(By.id("email"));
        element_email.sendKeys("client1@ici.fr");
        WebElement element_mdp = driver.findElement(By.id("token"));
        element_mdp.sendKeys("token1");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:"+port+"/recap?id=1",URL);
        driver.quit();
    }


}
