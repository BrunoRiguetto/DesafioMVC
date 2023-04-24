
## DesafioMVC
Desafios propostos de MVC, para o desenvolvimento de um sistema de receitas culinárias com os conceitos de MVC.

## Installation

Primeiros passos importantes para a correta iniciação do projeto na IDE.

Aplicação desenvolvida e testada com Java na versão 11 instalada e configurada as variáveis de ambiente no Windows, embora o projeto foi setado com Java 8 no pom.xml.

O programa foi testado com o Java 17, porém houveram falhas quando foi iniciado, portanto não é recomendavel essa versão.

Após o clone do projeto e import Maven feito no Spring Tools Suite 4, verificar os seguintes itens antes de dar start no projeto:

1 - Acesso à internet;

2 - VPN GFT ativada; 

(Passos 1 e 2 necessários para a utilização de envio de email para validação de usuário e recuperação de senha.)

3 - Configurar do username e password do spring.datasource no application.properties, por default estão root, é necessário então colocar o usuário e senha do seu banco de dados MySQL. Item importante para criar o banco de dados, tabelas e inserir os respectivos dados, realizados através do arquivo import.sql localizado no src/main/resources. Para que fosse possível essa aplicação foi necessario inserir a configuração "debub=true" no application.properties, por essa razão a aplicação rodará em modo debug no console, mas isso não afeta a usabilidade do sistema.

4 - Rodar a aplicação.

## Usage

Acessar o sistema através do localhost:8080.

A página Home de Receitas da Palmirinha será iniciado.

No canto superior direito há o login, clicando nele será redirecionado para a página de login onde poderão ser feitos os acessos de Admin e Usuario.

Para o login de Admin usar o email: admin@gft.com e a senha: Gft@1234.

Para o login de Usuário usar o email: usuario@gft.com e a senha: Gft@1234.

Ainda na página Home também há no canto superior direito o botão "Cadastrar-se", clicando nele será redirecionado para a pagina de primeiro cadastro, ao inserir seu email pessoal e colocar uma senha, um email real será enviado para confirmação do cadastro.

Modo Admin:
 Com o login com o usuário Admin é possível acessar todos os CRUDS desenvolvidos, no menu "Administrador" é possível ainda cadastrar e listar novos usuários.

Modo Usuário:
 Com o login de usuário, sendo com o email usuario@gft.com ou com o email real cadastrado é possível cadastrar os dados do usuário (Nome, data de nascimento e senha), editar a senha e visualizar as receitas.

Há ainda a função logout e a função "Remember-me" para que não seja necessário fazer o login do mesmo usuário várias vezes.

## Support

Qualquer dúvida ou problema favor entrar em contato pelo e-mail bruno.riguetto@gft.com ou pelo Teams @BrunoRiguetto.

## Contributing

Quaquer feedback será muito bem aceito, é necessário saber quais os pontos devem ser melhorados.

## License

- IDE Spring Tool Suite 4
- Spring Boot Starter 2.7.0
- Java 8
- Maven 4.0
- JPA
- Hibernate
- Thymeleaf

