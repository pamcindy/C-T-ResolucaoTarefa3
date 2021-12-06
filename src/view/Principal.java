package view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import controller.AddQuestion;
import controller.Cadastro;
import controller.Login;
import model.Question;
import model.User;

public class Principal {
	
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
			"Multiple Choice",
			"True or False"
				
	};
	

	private static String [] listaDifficulty = {
			"Easy",
			"Medium",
			"Hard"
				
	};



	public static void main(String[] args) {

		FirefoxOptions options = new FirefoxOptions();
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(options);

		User user = new User("aislan123", "titaniwm2021", "titaniwm3dstudio@gmail.com");
		Question question = new Question();
		question.setCategory(listaCategory[0]);
		question.setType(listaType[0]);
		question.setDifficulty(listaDifficulty[0]);
		question.setQuestion("Qual seu nome");
		question.setCorrect_answer("Aislan");
		question.setIncorrect_answer1("teste1");
		question.setIncorrect_answer2("teste2");
		question.setIncorrect_answer3("teste3");
		question.setReferences("nada não");

		

		Operacoes ops = new Operacoes(driver, user);
		ops.registrar();
		//ops.login();
		//ops.addQuestion(question);
	}

	public static class Operacoes {
		private WebDriver driver;
		private User user;

		public Operacoes(WebDriver driver,User user ) {
			this.driver = driver;
			this.user = user;
		}

		public void registrar() {

			Cadastro cadastro = new Cadastro(driver);
			boolean paginaAberta = cadastro.abrirPagina("https://opentdb.com/register.php");

			if (paginaAberta) {

				boolean preencherCampos = cadastro.preencharCampos(user);

				if (preencherCampos) {
					System.out.println("Campos Preenchidos!");

					if (cadastro.registrar()) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						String retorno = cadastro.getTexto();
						System.out.println("Retorno: " + retorno);

						if (retorno.contains("SUCCESS")) {
							System.out.println("Registro Feito! Check Seu Email");

						

						} else {
							System.out.println("Erro ao Registrar!");
						}
					} else {
						System.out.println("Erro ao Registrar!");
					}
				} else {
					System.out.println("Erro ao preencher Campos!");

				}

			} else {
				System.out.println("Erro");

			}
		}
		
		
		public void login() {
			// aguarda alguns segundos enquanto aguarda que o usuario confirme o email
			Login login = new Login(driver);
			boolean paginaLoginAberta = login.abrirPagina("https://opentdb.com/login.php");
			
			if (paginaLoginAberta) {

				boolean preencherCampos = login.preencharCampos(user);
				if (preencherCampos) {
					System.out.println("Campos Preenchidos!");

					if (login.logar()) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else {
						System.out.println("Erro ao Realizar login!");
					}
				} else {
					System.out.println("Erro ao preencher Campos!");

				}

			}else {
				System.out.println("Erro ao Realizar Login!");
			}
		}

		public void addQuestion(Question question) {
			// aguarda alguns segundos enquanto aguarda que o usuario confirme o email
			AddQuestion addquestion = new AddQuestion(driver);
			boolean paginaLoginAberta = addquestion.abrirPagina("https://opentdb.com/trivia_add_question.php");
			
			if (paginaLoginAberta) {

				boolean preencherCampos = addquestion.preencharCampos(question);
				if (preencherCampos) {
					System.out.println("Campos Preenchidos!");
					
					if (addquestion.adicionar()) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						String retorno = addquestion.getTexto();
						System.out.println("Retorno: " + retorno);

						if (retorno.contains("SUCCESS")) {
							System.out.println("Questão adicionada com sucesso");

						

						} else {
							System.out.println("Erro ao Adicionar Questão!");
						}

					} else {
						System.out.println("Erro ao Adicionar Questão!");
					}
					
				} else {
					System.out.println("Erro ao preencher Campos!");
				}
			}else {
				System.out.println("Erro ao Adicionar Questão!");
			}
		}
		
	}
}
