Link do PDF:
[Instruções Instalação.pdf](https://github.com/leobelinato/3-projetos-testados-com-selenium-mais-frontend/files/11379556/Instrucoes.Instalacao.pdf)



Criando um Projeto de testes automatizado
Nesta apostila segue um passo a passo de como você poderá criar um projeto de testes
automatizado utilizando as tecnologias Java e Selenium Webdriver.
Configurando o ambiente:
Instalando o JDK
Para que o nosso projeto seja criado e funcione sem problemas, precisamos utilizar uma
versão do JDK 1.8 ou superior. Abaixo seguiremos com a instalação e configuração do
ambiente utilizando a versão 1.8.
Link download JDK 1.8:
https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html
Link download JDK 11:
https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html
Instalando o Maven 3.8.x
O processo de configuração do Maven é similar ao do JAVA, porém o Maven não será
instalado, nós apenas iremos baixar e descompactar o seu diretório para aponta-lo no
sistema. Siga os passos abaixo para realizar o download e configurar o Maven em sua
máquina.
Para realizar o download do maven, acesse o link: https://maven.apache.org/download.cgi
Ao acessar o link acima você será direcionado para o site de download do maven, faça o
download do arquivo bin.zip conforme indicado em vermelho na imagem abaixo
Após realizar o download extraia o arquivo em um local de sua preferência, porém de fácil
acesso pois precisaremos utilizar o caminho onde o arquivo foi extraído para realizar as
configurações das variáveis de ambiente Maven.
Configurando as Variáveis de ambiente JAVA
No menu iniciar do Windows pesquise por “variáveis” , clique na opção “Editar as variáveis
de Ambiente” como no exemplo abaixo:
Em seguida clique em “Variáveis de Ambiente” como no exemplo abaixo:
Nessa tela temos 2 opções para configurar nossas variáveis. Configurando as variáveis, em
“Variáveis de Usuário ” na parte superior da tela, nossas configurações serão válidas
apenas para o usuário logado, ou seja, caso você possua mais usuários configurados em
sua máquina, as variáveis não serão visíveis para os demais. Se houver necessidade de
configurar as variáveis para todos os usuários existentes na máquina, então faça a
configuração em “Variáveis do sistema” na parte inferior da tela.
As configurações e passos realizados serão os mesmos, independentemente de serem
configurados apenas para um usuário ou para todo o sistema. Em nosso exemplo
seguiremos com a configuração das variáveis para todo o sistema. Em “Variáveis do
sistema” clique no botão “Novo”
Na opção “Nome da variável” coloque “JAVA_HOME”, na opção “Valor da variável”
coloque o caminho do diretório onde o JDK foi instalado, exemplo: “C:\Program
Files\Java\jdk-11.0.12”
Após clicar em ok e adicionar as variáveis, volte a tela de variáveis do sistema, localize a
variável “Path”, há selecione e clique no botão “Editar”, como mostra a imagem abaixo:
Clique na opção “Novo” e será permitido incluir um novo Path, inclua o caminho raiz da
pasta bin onde o JDK foi instalado e clique em “OK”.
Realizados os passos a cima, o ambiente Java deverá estar pronto. Para testar iremos abrir
o CMD e digitar o código “ java -version “, se tudo correu bem a seguinte tela será
apresentada:
Obs: O CMD deve ser aberto após o término das configurações, caso você o tenha aberto
antes de finalizar as configurações, feche e abra-o novamente.
Criando o projeto maven:
Para criar um projeto de testes maven bem estruturado e padronizado, iremos seguir alguns
passos que serão apresentados nesse projeto. É importante que os passos sejam seguidos
corretamente e que sejam aplicados os padrões e boas práticas aqui apresentados.
Iremos criar o nosso projeto maven por linha de comando, isso pode ser feito através do
terminal do próprio VSCode (IDE que iremos utilizar) ou através de algum outro terminal de
sua preferência como o CMD ou PowerShell.
Com o terminal aberto iremos utilizar o seguinte código: mvn archetype:generate
-DarchetypeArtifactId=maven-archetype-quickstart
Caso a versão do seu maven não entenda o comando acima, utilize o comando abaixo:
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes
-DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
Obs.: Este comando não tem quebra de linha, você deve copiar ele em uma única linha e
colar no seu CMD, caso queira garantir que o comando está na mesma linha, cole
primeiramente no bloco de notas, remova as quebras de linha caso tenha e em seguida
copie e cole no seu terminal.
Garanta que o comando não tenha quebra de linha entre nome meio dele, deve ser algo
parecido com isso:
Ao executar o código a cima, o projeto começará a ser criado, mas antes de finalizar
precisamos passar algumas informações para ele:
1º - groupID: exemplo de groupID: ” br.com.exemplo”
2º - artifactID: exemplo de artifactID: “automatizado”
3º - versão: caso não tenha pré-definido, deixe a versão padrão “1.0-SNAPSHOT”
4º - Package: exemplo de package: “automatizado”
5º - Confirmação das informações passadas, se estiver tudo ok digite “ Y “ e pressione
ENTER
Feito isso nosso projeto será criado com sucesso!
Segue algumas dependências que usaremos nos projetos, para isso, adicione as mesmas
no nosso arquivo pom.xml
<!-- Arquivo de propriedades do projeto -->
<properties>
<maven.compiler.source>1.8</maven.compiler.source>
<maven.compiler.target>1.8</maven.compiler.target>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
</properties>
<!-- Dependência para fazer o Senium funcionar no Chrome -->
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-chrome-driver</artifactId>
<version>3.141.59</version>
<scope>test</scope>
</dependency>
<!-- Dependência de ferramentas de suporte para selenium -->
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-support</artifactId>
<version>3.141.59</version>
<scope>test</scope>
</dependency>
