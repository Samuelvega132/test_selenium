package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistroUsuarioSeleniumTest {

    private WebDriver driver;

    private final String URL_PAGINA = "src/main/resources/registro.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_PAGINA);
    }

    @Test
    public void testCasoDePrueba1() {
        driver.findElement(By.id("registrar")).click(); // Uso de click() y id

        String mensaje = driver.findElement(By.id("mensaje")).getText(); // Uso de getText()
        assertEquals("Debe completar todos los campos", mensaje);
    }

    @Test
    public void testCasoDePrueba2() {
        driver.findElement(By.id("nombre")).sendKeys("Juan Pérez"); // Uso de sendKeys()
        driver.findElement(By.id("correo")).sendKeys("juan@test.com");
        driver.findElement(By.id("edad")).sendKeys("16");

        driver.findElement(By.id("registrar")).click();

        String mensaje = driver.findElement(By.id("mensaje")).getText();
        assertEquals("Usuario menor de edad", mensaje);
    }

    @Test
    public void testCasoDePrueba3() {
        driver.findElement(By.id("nombre")).sendKeys("Juan Pérez");
        driver.findElement(By.id("correo")).sendKeys("juan@test.com");
        driver.findElement(By.id("edad")).sendKeys("22");

        driver.findElement(By.id("registrar")).click();

        String mensaje = driver.findElement(By.id("mensaje")).getText();
        assertEquals("Registro exitoso", mensaje);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}