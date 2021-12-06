package tests;

import static org.junit.Assert.assertEquals;
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
import model.User;


public class TesteParteRegistro {

	static final String URL = "https://opentdb.com/register.php";

	static WebDriver driver;
	static Cadastro cadastro;
	static User user;


	public TesteParteRegistro() {
	}

	@BeforeAll
	public static void setUpClass() {
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver(options);

		cadastro = new Cadastro(driver);
		user = new User("aislan12345", "titaniwm2021", "titaniwm3dstudio3@gmail.com");

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

		assertTrue(cadastro.abrirPagina(URL));
	}
	
	@Test
	public void testRetorno() {

		assertTrue(cadastro.preencharCampos(user));
		assertTrue(cadastro.registrar());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertContains(cadastro.getTexto(),"BOBA");

	}
	
	
	
	public boolean assertContains(String expected, String actual) {
		if(expected.contains(actual)) {
			System.out.println("Registrado com Sucesso!");
			return true;
		}else {
			System.out.println("Erro ao registrar");
			return false;
		}
	}
	
}
