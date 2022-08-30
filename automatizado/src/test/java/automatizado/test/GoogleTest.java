package automatizado.test;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.pages.GooglePO;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)          // Ordenar os testes por ordem crescente
public class GoogleTest extends BaseTest {  //EXTENDS HERDA OS CONCEITOS DO BASETEST

      private static GooglePO googlePage;

      @BeforeClass
        public static void prepararTestes(){
          driver.get("https://www.google.com/");   ///Forçando abertura direto no before class só pra não parar de funcionar
        googlePage = new GooglePO(driver);
      }

    @Test  //CASO DE TESTE, DEVE MENCIONAR QUE É UM TESTE, IMPORTAR O ORG.JUNIT.TEST;
    public void TC001_devePesquisarNoGoogle(){

        //Todo caso de teste dedve conter:
        //Arange -- Preparação
        //Ação
        //Confirmação

        googlePage.pesquisar("Batata Frita"); // Rodando o método pesquisa dentro do GooglePO

        String resultado =  googlePage.obterResultadoDaPesquisa(); //rodando metodo obtr resultado dentro do GooglePO

        assertTrue(resultado, resultado.contains("Aproximadamente")); // 'TESTAR SE É VERDADE' QUE A VARIÁVEL RESULTADO CONTEM A PALAVRA "APROXIMADAMENTE"

        //Quem fecha o navegador é o Base que contém o AfterClass
         
    }


    @Test  //CASO DE TESTE, DEVE MENCIONAR QUE É UM TESTE, IMPORTAR O ORG.JUNIT.TEST;
    public void TC002_devePesquisarNoGoogle(){

        googlePage.pesquisar("Batata Frita"); // Rodando o método pesquisa dentro do GooglePO

        String resultado = googlePage.obterResultadoDaPesquisa(); //buscando os dados de resultado do google

        assertTrue(resultado, resultado.contains("resultados")); // 'TESTAR SE É VERDADE' QUE A VARIÁVEL RESULTADO CONTEM A PALAVRA "resultados"

        //Quem fecha o navegador é o Base que contém o AfterClass

        
    }

}
