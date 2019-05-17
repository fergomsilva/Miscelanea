package br.com.engsoftsis.sorteiosaleatorios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.engsoftsis.sorteiosaleatorios.utils.Util;
import br.com.engsoftsis.sorteiosaleatorios.vo.DezenaQtdVO;

public class Principal{
    
    static final List<Globo> CONJUNTO_GLOBO = new ArrayList<>();
    static {
        for( int n = 1; n <= Util.QTD_GLOBOS; n++ ) {
            Principal.CONJUNTO_GLOBO.add( new Globo( n ) );
            Principal.CONJUNTO_GLOBO.get( n - 1 ).start();
        }
    }
    
    public static void main(final String... args)
    {
        final LocalDateTime inicio = LocalDateTime.now();
        
        int[] jogo = null;
        double qtdRetiradas = 0.0;
        final List<DezenaQtdVO> volante = Util.gerarVolanteBranco();
        do {
            jogo = Sorteio.sortear();
            for( int d : jogo )
                volante.get( d - 1 ).addQuantidade();
            qtdRetiradas += jogo.length;
        }while( qtdRetiradas < Util.QTD_MIN_RETIRADA );
        System.out.println( String.format( "%s%sQtd total retiradas: %,.0f%s", System.lineSeparator(), System.lineSeparator(), qtdRetiradas, 
            System.lineSeparator() ) );
        
        Collections.sort( volante );
        for( DezenaQtdVO dez : volante.subList( 0, 10 ) ){
            System.out.println( String.format( "%2d: %,d - %.4f %%", dez.getDezena(), dez.getQuantidade(), ( dez.getQuantidade() / qtdRetiradas * 100.0 ) ) );
        }
        
        for( Globo g : Principal.CONJUNTO_GLOBO )
            g.desligar();
        
        final LocalDateTime controle = LocalDateTime.now();
        do {
            if( controle.until( LocalDateTime.now(), ChronoUnit.SECONDS ) > 60 )
                System.exit( 0 );
        }while( Util.THREAD_GROUP_GLOBOS.activeCount() > 0 );
        
        final LocalDateTime fim = LocalDateTime.now();
        System.out.println( String.format( "%s%sFIM: %s - %s (%,d) segundos", System.lineSeparator(), System.lineSeparator(), inicio, fim, inicio.until( fim, ChronoUnit.SECONDS ) ) );
        System.exit( 0 );
    }
    
}