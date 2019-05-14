package br.com.engsoftsis.sorteiosaleatorios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.engsoftsis.sorteiosaleatorios.vo.DezenaQtdVO;

public class Principal{
    private static final double QTD_MIN_RETIRADA = 1_000_000;
    private static final List<DezenaQtdVO> VOLANTE = new ArrayList<>( 60 );
    static {
        for( int i = 1; i <= 60; i++ )
            Principal.VOLANTE.add( new DezenaQtdVO( i ) );
    }
    
    public static void main(final String... args)
    {
        int[] jogo = null;
        double qtdRetiradas = 0.0;
        do {
            jogo = Sorteio.sortear();
            for( int d : jogo )
                Principal.VOLANTE.get( d - 1 ).addQuantidade();
            qtdRetiradas += jogo.length;
        }while( qtdRetiradas < Principal.QTD_MIN_RETIRADA );
        System.out.println( String.format( "%s%sQtd total retiradas: %,.0f%s", System.lineSeparator(), System.lineSeparator(), qtdRetiradas, 
            System.lineSeparator() ) );
        
        Collections.sort( Principal.VOLANTE );
        for( DezenaQtdVO dez : Principal.VOLANTE.subList( 0, 10 ) ){
            System.out.println( String.format( "%2d: %,d - %.4f %%", dez.getDezena(), dez.getQuantidade(), ( dez.getQuantidade() / qtdRetiradas * 100.0 ) ) );
        }
    }
    
}