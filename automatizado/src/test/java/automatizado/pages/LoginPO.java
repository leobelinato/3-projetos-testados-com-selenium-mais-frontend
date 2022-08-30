package automatizado.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{ //herdando o arquivo basepo
      //#region-WebElements

        @FindBy(id = "email")
        public WebElement inputEmail;    
    
        @FindBy(id = "senha")
        public WebElement inputSenha;
     
        @FindBy (id="btn-entrar")
        public WebElement btnEntrar;
    
        @FindBy (id="mensagem")
        public WebElement spanMensagem;
    
        //#endregion-WebElements
        
      //#region-Contrutor

    /**
     * Construtor padrão para criação de uma nova instancia da pagina de login
     * @param driver Driver da pagina de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);

    }

    //#endregion-Contrutor

      //#region-Metodos


/**
 *  Método obter mensagem da tela de login
 * @return Mensagem de login
 */
        public String obterMensagemLogin(){
        return spanMensagem.getText();  //Pega o texto da mensagem
    }


        /**
         * Método que tenta executar a ação de logar no sistema
         * @param email Email para tentativa login  
         * @param senha Senha tentativa login
         */
        public void executarAcaoLogar(String email, String senha){

            escrever(inputEmail, email);   //USANDO METODO ESCREVER, PREENCHER EMAIL COM VAZIO
            escrever(inputSenha, senha);   //USANDO METODO ESCREVER, PREENCHER SENHA COM VAZIO
            btnEntrar.click();                        //clicando no botão entrar
          }

          
    //#endregion-Contrutor

}
