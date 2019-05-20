package br.com.engsoftsis.sorteiosaleatorios.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import br.com.engsoftsis.sorteiosaleatorios.utils.Constantes;


public final class SorteioService{
    private static final int QTD_GLOBOS = 6;
    private static final SorteioService instance = new SorteioService();
    private static final List<GloboThread> GLOBOS = new ArrayList<>( 6 );
    static final ThreadGroup THREAD_GROUP_GLOBOS = new ThreadGroup( "THREAD_GROUP_GLOBOS" );
    
    static {
        for( int n = 1; n <= SorteioService.QTD_GLOBOS; n++ )
            SorteioService.GLOBOS.add( new GloboThread( n ) );
    }
    
    private SorteioService()
    {
        super();
    }
    
    public static final SorteioService getInstance()
    {
        return SorteioService.instance;
    }
    
    public static final void ligarGlobos()
    {
        for( GloboThread globo : SorteioService.GLOBOS )
            globo.start();
    }
    
    public static final int[] sortear()
    {
        int dezena = 0;
        final Set<Integer> dezenas = new TreeSet<>();
        for( int i = 1; i <= SorteioService.QTD_GLOBOS; i++ ) {
            do{
                dezena = 0;
                dezena = SorteioService.GLOBOS.get( i - 1 ).getDezena();
                if( dezena > 0 && dezena <= Constantes.MAIOR_DEZENA )
                    dezenas.add( dezena );
            }while( dezenas.size() < i );
        }
        final Integer[] dInteger = dezenas.toArray( new Integer[ SorteioService.QTD_GLOBOS ] );
        final int[] dInt = new int[ SorteioService.QTD_GLOBOS ];
        for( int index = 0; index < dInteger.length; index++ ){
            dInt[ index ] = dInteger[ index ].intValue();
        }
        return dInt;
    }
    
    public static final void desligarGlobos()
    {
        for( GloboThread globo : SorteioService.GLOBOS )
            globo.desligar();
        final LocalDateTime controle = LocalDateTime.now();
        do {
            if( controle.until( LocalDateTime.now(), ChronoUnit.SECONDS ) > 60 )
                return;
        }while( SorteioService.THREAD_GROUP_GLOBOS.activeCount() > 0 );
    }
    
}