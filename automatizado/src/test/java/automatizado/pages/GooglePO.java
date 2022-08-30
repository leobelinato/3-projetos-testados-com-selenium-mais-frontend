package automatizado.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{


    //#region-Regiao dos WebElements

    @FindBy(name = "q")  //procurando elemento com nome de Q
    public WebElement inputPesquisa; //salvando Resultado da pesquisa Q para variável WebElement inputPesquisa


    @FindBy(id = "result-stats") //procurando elemento com nome de result-stats
    public WebElement divResultadoPesquisa; //salvando Resultado da pesquisa Q para variável WebElement divResultadoPesquisa

    //#endregion-Regiao dos WebElements

    /**
     * Construtor para criação da pagina  do Google
     * @param driver Driver da pagina do Google.
     */
    public GooglePO(WebDriver driver) {
        super(driver);

    }

    //#region-Regiao dos Métodos

    /**
     * Método que efetua pesquisa no google baseando no texto informado e concluindo com Enter.
     * @param texto Texto a ser pesquisado
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Metodo que retorna o resultado aproximado da pesquisa
     * @return Retorna o resultado da pesquisa
     */
    public String obterResultadoDaPesquisa(){
        return divResultadoPesquisa.getText();  //Pega o texto no resultado da pesquisa
    }
    
    //#endregion-Regiao dos Métodos

    

}
