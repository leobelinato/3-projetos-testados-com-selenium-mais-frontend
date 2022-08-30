package automatizado.Builder;
import automatizado.pages.ControleDeProdutoPO;


/** Classe que sabe construir ou adicionar um produto na tela */
public class ProdutoBuilder {

    public String codigo = "0001";
    public String nome = "Nome Padrão";
    public Integer quantidade = 1;
    public Double valor = 1.0;
    public String data = "01/01/1990";

    private ControleDeProdutoPO controleDeProdutoPO;

    /**Construtor do ProdutoBuilder que recebe a pagina de controle de produtos */

    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    /**
     * Método que sabe adicionar um código ao builder
     * @param codigo codigo que será adicionado
     * @return retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }
    

    /**
     * Método que sabe adicionar um nome ao builder
     * @param nome nome que será adicionado
     * @return retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }


    /**
     * Método que sabe adicionar um quantidade ao builder
     * @param quantidade quantidade que será adicionada
     * @return retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }


    /**
     * Método que sabe adicionar um valor ao builder
     * @param valor valor que será adicionado
     * @return retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor= valor;
        return this;
    }


    /**
     * Método que sabe adicionar uma data ao builder
     * @param data data que será adicionado
     * @return retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarData(String data){
        this.data= data;
        return this;
    }

/**
 * Método que constroi o produto, ou seja, adiciona o produto pela tela de cadastro de produto.
 */
    public void builder(){

        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);                      //inputando as strings nos campos
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        // NO INTERROGAÇÃO É O IF, NO : É ELSE, SE QUANTIDADE NAO FOR NULLA FAZ ISSO, SE NAO COLOCA ""
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.btnSalvar.click();  

        
    }
    
}
