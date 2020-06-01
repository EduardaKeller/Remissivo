
public class Palavra {
    String palavra;
    DoubleLinkedListPaginas paginas;
    int vezesQueAparece = 1;

    public Palavra(String palavra, Integer pagina){
        this.palavra = palavra;
        paginas = new DoubleLinkedListPaginas();
        paginas.add(pagina);
    }
    public String getPalavra(){return this.palavra;}
    public Integer getPagina(){return paginas.getTail();}
    public int getVezesQueAparece(){return vezesQueAparece+1;}

    public boolean addPagina(Integer pagina){
        paginas.add(pagina);
        return true;
    }

    public void addVezesQueApareceu(){
        vezesQueAparece++;
    }

    public Integer ultimaPagina(){return paginas.getTail();}
    public Integer primeiraPagina(){return paginas.getHead();}
    public String toString(){
            String aux = palavra +" - paginas: "+ paginas.toString();
        return aux;
    }
}

