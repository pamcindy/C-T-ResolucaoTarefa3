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

import controller.AddQuestion;
import controller.Login;
import model.Question;
import model.User;

public class TesteParteAddNovaQuestao {

	private static String [] listaCategory = {
			"General Knowledge",
			"Entertainment: Books",
			"Entertainment: Film",
			"Entertainment: Music",
			"Entertainment: Musicals & Theatres",
			"Entertainment: Television",
			"Entertainment: Video Games",
			"Entertainment: Board Games",
			"Science & Nature",
			"Science: Computers",
			"Science: Mathematics",
			"Mythology",
			"Sports",
			"Geography",
			"History",
			"Politics",
			"Art",
			"Celebrities",
			"Animals",
			"Vehicles",
			"Entertainment: Comics",
			"Entertainment: Cartoon & Animations",
			"Science: Gadgets",
			"Entertainment: Japanese Anime & Manga"
				
	};
	
	private static String [] listaType = {
			"Multiple Choice"
				
	};
	

	private static String [] listaDifficulty = {
			"Easy",
			"Medium",
			"Hard"
				
	};

	static final String URL = "https://opentdb.com/trivia_add_question.php";

	static WebDriver driver;
	static AddQuestion addQuestion;
	static Question question;
	static Login login;
	static User user;

	public TesteParteAddNovaQuestao() {
	}

	@BeforeAll
	public static void setUpClass() {
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver(options);

		//Preencha aqui com os parametros do usuário, Nome, Senha, e E-mail respectivamente	
		user = new User("", "", "");

		login = new Login(driver);

		
		question= new Question();
		question.setCategory(listaCategory[8]);
		question.setType(listaType[0]);
		question.setDifficulty(listaDifficulty[2]);
		question.setQuestion("Qual era a cor do cavalo branco de napoleão");
		question.setCorrect_answer("Marrron");
		question.setIncorrect_answer1("Branco");
		question.setIncorrect_answer2("Cinza");
		question.setIncorrect_answer3("Roxo");
		question.setReferences("Quero dos 100 anos");
		
		
		addQuestion = new AddQuestion(driver);

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
		assertTrue(login.abrirPagina("https://opentdb.com/login.php"));
		assertTrue(login.preencharCampos(user));
		assertTrue(login.logar());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(addQuestion.abrirPagina(URL));
	}
	
	
	
	@Test
	public void testRetorno() {

		assertTrue(addQuestion.preencharCampos(question));
		assertTrue(addQuestion.adicionar());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String retorno = addQuestion.getTexto();
		System.out.println("Retorno: " + retorno);

		if (retorno.contains("SUCCESS")) {
			System.out.println("Questão adicionada com sucesso");

		

		} else {
			System.out.println("Erro ao Adicionar Questão!");
		}


	}
	
	
	
}
