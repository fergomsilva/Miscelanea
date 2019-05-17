package br.com.engsoftsis.sorteiosaleatorios;

import java.util.Set;
import java.util.TreeSet;

import br.com.engsoftsis.sorteiosaleatorios.utils.Util;


class Sorteio{
    
    private Sorteio()
    {
        super();
    }
    
    public static final int[] sortear()
    {
        int dezena = 0;
        final Set<Integer> dezenas = new TreeSet<>();
        for( int i = 1; i <= Util.QTD_GLOBOS; i++ ) {
            do{
                dezena = 0;
                dezena = Principal.CONJUNTO_GLOBO.get( i - 1 ).getDezena();
                if( dezena > 0 && dezena <= Util.MAIOR_DEZENA )
                    dezenas.add( dezena );
            }while( dezenas.size() < i );
        }
        final Integer[] dInteger = dezenas.toArray( new Integer[ Util.QTD_GLOBOS ] );
        final int[] dInt = new int[ Util.QTD_GLOBOS ];
        for( int index = 0; index < dInteger.length; index++ ){
            dInt[ index ] = dInteger[ index ].intValue();
        }
        return dInt;
    }
    
}