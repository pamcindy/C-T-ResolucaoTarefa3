package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import model.User;

public class Login {
	static WebDriver driver;

	public Login(WebDriver driver) {
		Login.driver = driver;
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
			
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean logar() {
		try {
			WebElement botaoLogar = driver.findElement(By.xpath("//*[@type='submit']"));
			botaoLogar.click();

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


	
}
