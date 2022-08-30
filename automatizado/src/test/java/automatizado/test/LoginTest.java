package automatizado.test;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.pages.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)           // Ordenar os testes por ordem crescente
public class LoginTest extends BaseTest{


    private static LoginPO loginPage;


      @BeforeClass
      public static void prepararTestes(){
        loginPage = new LoginPO(driver);
      }


    @Test  //CASO DE TESTE, DEVE MENCIONAR QUE É UM TESTE, IMPORTAR O ORG.JUNIT.TEST;
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){

        loginPage.executarAcaoLogar("", "");   //USANDO METODO LOGAR lá do loginpo
        
        String mensagem = loginPage.obterMensagemLogin();   // usando método pra puxar mensagem e salvando na variável

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos."); // VERIFICAR SE A VARIAVEL MENSAGEM É IGUAL A    
      
    }


    @Test  //CASO DE TESTE, DEVE MENCIONAR QUE É UM TESTE, IMPORTAR O ORG.JUNIT.TEST;
    public void TC002_naoDeveLogarNoSistemaComApenasSenhaVazia(){

      loginPage.executarAcaoLogar("teste", "");   //USANDO METODO LOGAR lá do loginpo

        String mensagem = loginPage.obterMensagemLogin();   // usando método pra puxar mensagem e salvando na variável

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos."); // VERIFICAR SE A VARIAVEL MENSAGEM É IGUAL A         
    }

    @Test  //CASO DE TESTE, DEVE MENCIONAR QUE É UM TESTE, IMPORTAR O ORG.JUNIT.TEST;
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){

      loginPage.executarAcaoLogar("", "teste");   //USANDO METODO LOGAR lá do loginpo

        String mensagem = loginPage.obterMensagemLogin();   // usando método pra puxar mensagem e salvando na variável

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos."); // VERIFICAR SE A VARIAVEL MENSAGEM É IGUAL A         
    }

    @Test  //CASO DE TESTE, DEVE MENCIONAR QUE É UM TESTE, IMPORTAR O ORG.JUNIT.TEST;
    public void TC004_naoDeveLogarNoSistemaComEmailESenhaErrados(){

      loginPage.executarAcaoLogar("teste", "teste");   //USANDO METODO LOGAR lá do loginpo

        String mensagem = loginPage.obterMensagemLogin();   // usando método pra puxar mensagem e salvando na variável

        assertEquals(mensagem, "E-mail ou senha inválidos"); // VERIFICAR SE A VARIAVEL MENSAGEM É IGUAL A         
    }

    @Test  //CASO DE TESTE, DEVE MENCIONAR QUE É UM TESTE, IMPORTAR O ORG.JUNIT.TEST;
    public void TC005_naoDeveLogarNoSistemaComEmailESenhaErrados2(){

      loginPage.executarAcaoLogar("admin@admin.com", "teste");   //USANDO METODO LOGAR lá do loginpo

        String mensagem = loginPage.obterMensagemLogin();   // usando método pra puxar mensagem e salvando na variável

        assertEquals(mensagem, "E-mail ou senha inválidos"); // VERIFICAR SE A VARIAVEL MENSAGEM É IGUAL A         
    }

    @Test  //CASO DE TESTE, DEVE MENCIONAR QUE É UM TESTE, IMPORTAR O ORG.JUNIT.TEST;
    public void TC006_naoDeveLogarNoSistemaComEmailESenhaErrados3(){

      loginPage.executarAcaoLogar("Aadmin@admin.com", "admin@123");   //USANDO METODO LOGAR lá do loginpo

        String mensagem = loginPage.obterMensagemLogin();   // usando método pra puxar mensagem e salvando na variável

        assertEquals(mensagem, "E-mail ou senha inválidos"); // VERIFICAR SE A VARIAVEL MENSAGEM É IGUAL A         
    }

    @Test  //CASO DE TESTE, DEVE MENCIONAR QUE É UM TESTE, IMPORTAR O ORG.JUNIT.TEST;
    public void TC007_deveLogarNoSistemaComEmailESenhaCorretos(){

      loginPage.executarAcaoLogar("admin@admin.com", "admin@123");   //USANDO METODO LOGAR lá do loginpo

        String mensagem = loginPage.obterMensagemLogin();   // usando método pra puxar mensagem e salvando na variável

        assertEquals(mensagem, ""); // VERIFICAR SE A VARIAVEL MENSAGEM É IGUAL A  

        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos"); //Rodando o método obter titulo, verificando se é igual ao esperado :"Controle de Produtos"

        

    }


    
}
