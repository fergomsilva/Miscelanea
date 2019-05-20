package br.com.engsoftsis.sorteiosaleatorios.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.engsoftsis.sorteiosaleatorios.utils.Constantes;


public class SimulacaoVO{
    private int qtdJogos;
    private int qtdRetiradas;
    private int qtdMinimaRetiradas;
    private List<DezenaQtdVO> dezenas;
    
    public SimulacaoVO(final int qtdMinimaRetiradas){
        super();
        this.qtdMinimaRetiradas = qtdMinimaRetiradas;
        if( this.qtdMinimaRetiradas < 1 )
            this.qtdMinimaRetiradas = Constantes.QTD_MIN_RETIRADA;
        this.dezenas = new ArrayList<>( Constantes.MAIOR_DEZENA );
        for( int i = 1; i <= Constantes.MAIOR_DEZENA; i++ )
            this.dezenas.add( new DezenaQtdVO( i ) );
    }
    
    public void contabilizarDezenasJogo(final int[] jogo)
    {
        for( int d : jogo )
            this.getDadosDezena( d ).addQuantidade();
        ++this.qtdJogos;
        this.qtdRetiradas += jogo.length;
        for( DezenaQtdVO dez : this.getDezenas() )
            dez.calcularPorcentagem( this.qtdRetiradas );
    }
    
    public List<DezenaQtdVO> getDezenas()
    {
        return Collections.unmodifiableList( this.dezenas );
    }
    
    public int getQtdJogos()
    {
        return this.qtdJogos;
    }
    
    public int getQtdRetiradas()
    {
        return this.qtdRetiradas;
    }
    
    public int getQtdMinimaRetiradas()
    {
        return this.qtdMinimaRetiradas;
    }
    
    public boolean isQtdRetiradasOK()
    {
        return this.getQtdRetiradas() >= this.getQtdMinimaRetiradas();
    }
    
    public DezenaQtdVO getDadosDezena(final int dezena)
    {
        if( dezena >= 1 && dezena <= 60 )
            return this.getDezenas().get( dezena - 1 );
        return null;
    }
    
    public void sortByDezena()
    {
        this.dezenas.sort( null );
    }
    
    public void sortByQuantidade(final boolean descendente)
    {
        if( descendente )
            this.dezenas.sort( (final DezenaQtdVO o1, final DezenaQtdVO o2) 
                -> ( -1 * Integer.compare( o1.getQuantidade(), o2.getQuantidade() ) ) );
        else
            this.dezenas.sort( (final DezenaQtdVO o1, final DezenaQtdVO o2) 
                -> ( Integer.compare( o1.getQuantidade(), o2.getQuantidade() ) ) );
    }
    
    public List<DezenaQtdVO> getPrimeiros(final int qtd)
    {
        if( qtd > 0 && qtd <= Constantes.MAIOR_DEZENA )
            return this.getDezenas().subList( 0, qtd );
        return Collections.unmodifiableList( new ArrayList<>() );
    }
    
}