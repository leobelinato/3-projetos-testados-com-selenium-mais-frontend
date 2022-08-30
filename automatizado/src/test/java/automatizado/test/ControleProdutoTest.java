package automatizado.test;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.Builder.ProdutoBuilder;
import automatizado.pages.ControleDeProdutoPO;
import automatizado.pages.LoginPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)    //ordenando por ordem acsendente 
public class ControleProdutoTest extends BaseTest{

    private static LoginPO loginPage;                       //instanciando o login
    private static ControleDeProdutoPO controleProdutoPage; //estanciando controle de produto


    @BeforeClass
    public static void prepararTestes(){
        
        loginPage = new LoginPO(driver);                        //instanciando o login
        loginPage.executarAcaoLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleDeProdutoPO(driver);  //estanciando controle de produto

        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos"); //verifica se está na página correta, validando o titulo da pagina
             
    }


    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){

        controleProdutoPage.btnAdicionar.click();
        controleProdutoPage.btnAdicionar.click(); //TODO> REMOVER ESSE CLIQUE ASSIM QUE O SISTEMA FOR CORRIGIDO
               
                String titulo = controleProdutoPage.TituloCriarProduto.getText();
        assertEquals(titulo, "Produto"); //verifica se está na página correta, validando o titulo da pagina
        
        controleProdutoPage.btnSair.click();
        controleProdutoPage.btnSair.click();     //TODO> REMOVER ESSE CLIQUE ASSIM QUE O SISTEMA FOR CORRIGIDO
               
    }


    @Test
    public void TC002_deveManterNaPaginaDeProdutosAoClicarNoTituloControleDeProdutos(){
 
        controleProdutoPage.tituloControleProdutos.click();  //Clicando no titulo da tela, CONTROLE DE PRODUTOS    
               
       String tituloHomeproduto = controleProdutoPage.tituloControleProdutos.getText();
       assertEquals(tituloHomeproduto, "Controle de produtos"); //verifica se continua na tela de controle de produtos
             
    }

    @Test
    public void TC007_deveFecharATelaDeCadastroDeProdutoAoClicarNoX(){
 
        controleProdutoPage.btnAdicionar.click();

        String titulo = controleProdutoPage.TituloCriarProduto.getText();
        assertEquals(titulo, "Produto"); //verifica se está na tela de cadastro produto

        controleProdutoPage.btnXProduto.click(); //Fecha a tela cadastro produto

        String tituloHomeproduto = controleProdutoPage.tituloControleProdutos.getText();        
       assertEquals(tituloHomeproduto, "Controle de produtos"); //verifica se retornou para a listagem produtos

    }

    @Test
    public void TC008_deveFecharATelaDeCadastroDeProdutoAoClicarNoBotaoSair(){
 
        controleProdutoPage.btnAdicionar.click();

        String titulo = controleProdutoPage.TituloCriarProduto.getText();
        assertEquals(titulo, "Produto"); //verifica se está na tela de cadastro produto

        controleProdutoPage.btnSair.click(); 

        String tituloHomeproduto = controleProdutoPage.tituloControleProdutos.getText();        
       assertEquals(tituloHomeproduto, "Controle de produtos"); //verifica se retornou para a listagem produtos

    }

   
    @Test
    public void TC009_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){

        String mensagem = "Todos os campos são obrigatórios para o cadastro!"; //setando a menssagem em uma variável pois a mensagem deve ser igual para todas as validações

        controleProdutoPage.btnAdicionar.click();


        //criando o construtor
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

              
        produtoBuilder  //CADASTRANDO PRODUTO PORÉM PASSANDO CODIGO VAZIO
        .adicionarCodigo("")
        .builder();
        assertEquals(mensagem, controleProdutoPage.msgCadastroProduto.getText());

        
        produtoBuilder  //CADASTRANDO OUTRO PRODUTO PORÉM PASSANDO NOME VAZIO
        .adicionarNome("")
        .adicionarCodigo("10")
        .builder();
        assertEquals(mensagem, controleProdutoPage.msgCadastroProduto.getText());


        produtoBuilder //CADASTRANDO OUTRO PRODUTO PORÉM PASSANDO QUANTIDADE VAZIA
        .adicionarQuantidade(null)
        .adicionarNome("Teste123")
        .builder(); 
        assertEquals(mensagem, controleProdutoPage.msgCadastroProduto.getText());


        produtoBuilder //CADASTRANDO OUTRO PRODUTO PORÉM PASSANDO DATA VAZIA
        .adicionarValor(null)
        .adicionarQuantidade(999)
        .builder();
        assertEquals(mensagem, controleProdutoPage.msgCadastroProduto.getText());


        produtoBuilder //CADASTRANDO OUTRO PRODUTO PORÉM PASSANDO DATA VAZIA
        .adicionarData("")
        .adicionarValor(20.0)
        .builder();
        assertEquals(mensagem, controleProdutoPage.msgCadastroProduto.getText());
        
        controleProdutoPage.btnSair.click();

        //  String mensagem = controleProdutoPage.msgCadastroProduto.getText(); //criando variavel mensagem, puxando valor do webelement.
        
                 
    }

    
     @Test
   public void TC011_DeveSerPossivelCadastrarUmProdutoComTodosOsCamposPreenchidos(){

       controleProdutoPage.btnAdicionar.click();
              
      String titulo = controleProdutoPage.TituloCriarProduto.getText();
      assertEquals(titulo, "Produto"); //verifica se está na página correta, validando o titulo da pagina

      ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
      produtoBuilder.builder();        
   
       controleProdutoPage.btnSair.click(); //sai da tela de cadastro

       String nomeproduto = controleProdutoPage.clnNomeProduto.getText(); //joga o texto do webelment para uma string
       assertEquals(nomeproduto, "Nome Padrão"); //valida se o produto realmente foi cadastrado.
 
      
   }


   

    

}
