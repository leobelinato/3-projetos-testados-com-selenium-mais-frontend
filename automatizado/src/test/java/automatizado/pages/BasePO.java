package automatizado.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

 
    /**
     * Esta classe tem como objetivo ser uma classe base para todas as outras classes de PageObject, ela contém o construtor principal que todas os demais PageObjects vão precisar ter.

Ela é uma classe que só deve ser herdada e não instanciada, por isso elá é abstract.
     */

    public abstract class BasePO { 

        /** Driver base que será usado pelas pages */
        public WebDriver driver;
        
        /** 
         * Construtor base para criação da fabrica de elementos (Page Factory).
         * @param driver Driver da página atual.
        */
        public BasePO(WebDriver driver){ // construtor padrão
            this.driver = driver; 
            PageFactory.initElements(driver, this);       //iniciando a fabrica para trabalhar com factory, passando o Driver e a página que ele estiver "this";

        }


        /**
         * Método que pode ser utilizado por qualquer pagina, qualquer teste
         * @return Retornará o nome da página atual
         */
        public String obterTituloPagina(){      
        return driver.getTitle();         //driver é sempre a pagina atual    
            
            }

            /**
             * metodo que sabe escrever em qualquer WebElement do tipo input e da um tab ao final
             * @param input Input a qual será escrito
             * @param texto Texto que será escrito no input.
             */
          public void escrever(WebElement input, String texto){  
            input.clear();                                      // antes de escrever limpa o campo
            input.sendKeys(texto + Keys.TAB);                  //inputa a string texto + um tab pra pular de campo
        }
    
    }