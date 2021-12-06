package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import model.User;

public class Cadastro {

	static WebDriver driver;

	public Cadastro(WebDriver driver) {
		Cadastro.driver = driver;
	}

	public boolean abrirPagina(String url) {

		boolean continuar = false;

		try {
			driver.get(url);
			Thread.sleep(2000);
			continuar = true;

		} catch (Exception e) {
			System.out.println("erro, sem conexão com o opentdb!");

			continuar = false;

			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

			driver.close();

			driver.switchTo().window(winHandleBefore);
			driver.close();

		}

		if (continuar) {

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return true;

		} else {
			// sem conexao com a internet, cancelar
			driver.close();
			return false;
		}

	}
	
	
	public boolean preencharCampos(User userRegister) {
		try {
			WebElement entUsername = driver.findElement(By.name("username"));
			entUsername.clear();
			entUsername.sendKeys(userRegister.getUsername());
			
			WebElement entPassword = driver.findElement(By.name("password"));
			entPassword.clear();
			entPassword.sendKeys(userRegister.getPassword());
			
			WebElement entPasswordAgain = driver.findElement(By.name("password_again"));
			entPasswordAgain.clear();
			entPasswordAgain.sendKeys(userRegister.getPassword());
			
			WebElement entEmail = driver.findElement(By.name("email"));
			entEmail.clear();
			entEmail.sendKeys(userRegister.getEmail());
			
			
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean registrar() {
		try {
			WebElement botaoPesquisar = driver.findElement(By.xpath("//*[@type='submit']"));
			botaoPesquisar.click();

			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String getTexto() {
		WebElement mensagem = driver.findElement(By.xpath("//*[@class='alert alert-success']"));
		return mensagem.getText();
	}

	
	public boolean login() {
		try {
			WebElement botaoPesquisar = driver.findElement(By.xpath("//*[@type='submit']"));
			botaoPesquisar.click();

			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
