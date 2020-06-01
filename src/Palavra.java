
public class Palavra {
    String palavra;
    DoubleLinkedListPaginas paginas;

    public Palavra(String palavra, Integer pagina){
        this.palavra = palavra;
        paginas = new DoubleLinkedListPaginas();
        paginas.add(pagina);
    }
    public String getPalavra(){return this.palavra;}

    public boolean addPagina(Integer pagina){
        paginas.add(pagina);
        return true;
    }

    public Integer ultimaPagina(){return paginas.getTail();}
    public Integer primeiraPagina(){return paginas.getHead();}
}
