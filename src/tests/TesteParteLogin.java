package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import controller.Cadastro;
import controller.Login;
import model.Question;
import model.User;

public class TesteParteLogin {

	static final String URL = "https://opentdb.com/login.php";

	static WebDriver driver;
	static Login login;
	static User user;
	static Question question;

	public TesteParteLogin() {
	}

	@BeforeAll
	public static void setUpClass() {
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver(options);

		login = new Login(driver);
		user = new User("aislan", "titaniwm2014", "titaniwm3dstudio3@gmail.com");

	}

	@AfterAll
	public static void tearDownClass() {
	}

	@BeforeEach
	public void setUp() {
	}

	@AfterEach
	public void tearDown() {
	}

	@Test
	public void testAbrirPagina() {

		assertTrue(login.abrirPagina(URL));
	}
	
	@Test
	public void testRetorno() {

		assertTrue(login.preencharCampos(user));
		assertTrue(login.logar());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
}
