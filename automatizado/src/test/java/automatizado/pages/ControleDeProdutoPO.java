package automatizado.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.Builder.ProdutoBuilder;

public class ControleDeProdutoPO extends BasePO{

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }


    //#region-WebElements

    @FindBy(id = "btn-adicionar")
    public WebElement btnAdicionar;

    @FindBy(css = "ul>li>a.nav-link")  //Executado o comando queryselector: document.querySelector('ul>li>a.nav-link') no f12 do navegador
    public WebElement linkVoltar;

    @FindBy(css = "div.modal-header>h4")  //Executado o comando queryselector: document.querySelector('ul>li>a.nav-link') no f12 do navegador
    public WebElement TituloCriarProduto;

     @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement btnSalvar;

    @FindBy(id = "btn-sair")
    public WebElement btnSair;

    @FindBy(id = "mensagem")
    public WebElement msgCadastroProduto;

    @FindBy(css="nav>a.navbar-brand")
    public WebElement tituloControleProdutos;  //buscado atravées do F12 COMANDO > document.querySelector('nav>a.navbar-brand')

    @FindBy(css="div>.modal-header>button")  // query selector usada document.querySelector('div>.modal-header>button')
    public WebElement btnXProduto;

    @FindBy(css="body > div > div:nth-child(2) > table > tbody > tr > td:nth-child(2)") //botao direito no F12, COPIAR JS PATH
    public WebElement clnNomeProduto;

    //#endregion-Regiao dos WebElements

    //#region-Metodos


    public void cadastrarProduto(               //metodo cadastrar produto, com os parametros em string
        String codigo,
        String nome,
        Integer quantidade,
        Double valor,
        String data ){
        
            inputCodigo.clear();                //limpando todos os campos para que não ocorram erros durante os testes
            inputNome.clear();
            inputQuantidade.clear();
            inputValor.clear();
            inputData.clear();

            escrever(inputCodigo, codigo);                      //inputando as strings nos campos
            escrever(inputNome, nome);
            escrever(inputQuantidade, quantidade.toString());
            escrever(inputValor, valor.toString());
            escrever(inputData, data);

            btnSalvar.click();            
            
    }
    

    public void cadastrarProduto(ProdutoBuilder produtoBuilder){
        
            produtoBuilder.builder();    

            // escrever(inputCodigo, produtoBuilder.codigo);
            // escrever(inputNome, produtoBuilder.nome);
            // escrever(inputQuantidade, produtoBuilder.quantidade.toString());
            // escrever(inputValor, produtoBuilder.valor.toString());
            // escrever(inputData, produtoBuilder.data);                
            
    }

    //#endregion-Metodos
    
   
}
