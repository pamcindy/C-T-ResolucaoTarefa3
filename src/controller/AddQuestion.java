package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import model.Question;
import model.User;

public class AddQuestion {
	
	
	
	static WebDriver driver;

	public AddQuestion(WebDriver driver) {
		AddQuestion.driver = driver;
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
	

	
	public boolean preencharCampos(Question questionRegister) {
		try {

			WebElement comboboxElementCategory = driver.findElement(By.id("trivia_category"));
			Select comboboxCategory = new Select(comboboxElementCategory);
			comboboxCategory.selectByVisibleText(questionRegister.getCategory());
			
			WebElement comboboxElementType = driver.findElement(By.id("trivia_type"));
			Select comboboxType = new Select(comboboxElementType);
			comboboxType.selectByVisibleText(questionRegister.getType());
			
			
			WebElement comboboxElementDifficulty = driver.findElement(By.id("trivia_difficulty"));
			Select comboboxDifficulty= new Select(comboboxElementDifficulty);
			comboboxDifficulty.selectByVisibleText(questionRegister.getDifficulty());
			
			WebElement entQuestion = driver.findElement(By.name("trivia_question"));
			entQuestion.clear();
			entQuestion.sendKeys(questionRegister.getQuestion());


			WebElement entAnswerCorrect = driver.findElement(By.name("correct_answer"));
			entAnswerCorrect.clear();
			entAnswerCorrect.sendKeys(questionRegister.getCorrect_answer());
			
			WebElement entAnswerIncorrect1 = driver.findElement(By.name("incorrect_answer_1"));
			entAnswerIncorrect1.clear();
			entAnswerIncorrect1.sendKeys(questionRegister.getIncorrect_answer1());

			WebElement entAnswerIncorrect2 = driver.findElement(By.name("incorrect_answer_2"));
			entAnswerIncorrect2.clear();
			entAnswerIncorrect2.sendKeys(questionRegister.getIncorrect_answer2());
			
			WebElement entAnswerIncorrect3 = driver.findElement(By.name("incorrect_answer_3"));
			entAnswerIncorrect3.clear();
			entAnswerIncorrect3.sendKeys(questionRegister.getIncorrect_answer3());
			
			WebElement entReferences = driver.findElement(By.name("trivia_reference"));
			entReferences.clear();
			entReferences.sendKeys(questionRegister.getReferences());
			
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean adicionar() {
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
