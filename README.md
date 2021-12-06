Para realizar corretamente a execução dos testes da Tarefa 3, o único requisito e que se preencha os dados
de usuário para que seja usado na plataforma

Exemplo:

//Preencha aqui com os parametros do usuário, Nome, Senha, e E-mail respectivamente	
		User user = new User("pammela", "pammela123", "pammela@pammela.com");

          Cenário de Teste Parte 3

                  Parte I

Funcionalidade: Se registrar no site

Cenário: Cadastro de Nova Conta

Dado que navego para a página de registro

E digito o “nome de usuário” no campo “Username”

E digito uma “senha”  no campo “Password”

E digito a mesma “senha” do campo “Password” no campo “Repeat Password”

E digito o “e-mail” no campo “Email Address”

Quando clico no botão “Register”

Então será enviando um e-mail de confirmação na caixa de mensagem do E-mail Informado

                Parte II

Funcionalidade: Adicionar Nova Questão

Cenário: Cadastro de Nova Questão

Dado que navego para a página de login

E digito o “nome de usuário” no campo “Sign In”

E digito a “senha”  no campo abaixo de “Sign In”

Quando clico no botão “SIGN IN”

Então será Redirecionado para a página inicial

Quando navego para a página de adicionar nova questão

E seleciono a categoria no SelectBox “Category”

E seleciono o tipo no SelectBox “Type”

E seleciono a dificuldade no SelectBox “Difficulty”

E digito a questão no campo “Question”

E digito a resposta correta no campo “Correct Answer”

E digito a resposta incorreta no campo “Incorret Answer #1”

E digito a resposta incorreta no campo “Incorret Answer #2”

E digito a resposta incorreta no campo “Incorret Answer #3”

E digito a referencias no campo “References”

Quando clico no botão “+SUBMIT”

 
