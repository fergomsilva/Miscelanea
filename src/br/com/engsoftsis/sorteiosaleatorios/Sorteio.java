package br.com.engsoftsis.sorteiosaleatorios;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class Sorteio{
    private static final int QTD_SORTEIOS = 6;
    private static final int MAIOR_DEZENA = 60;
    private static final Random RANDOM = new Random();
    
    private Sorteio()
    {
        super();
    }
    
    public static final int[] sortear()
    {
        final Set<Integer> dezenas = new TreeSet<>();
        do{
            dezenas.add( ( Sorteio.RANDOM.nextInt( Sorteio.MAIOR_DEZENA ) + 1 ) );
        }while( dezenas.size() < Sorteio.QTD_SORTEIOS );
        final Integer[] dInteger = dezenas.toArray( new Integer[ 6 ] );
        final int[] dInt = new int[ 6 ];
        for( int index = 0; index < dInteger.length; index++ ){
            dInt[ index ] = dInteger[ index ].intValue();
        }
        return dInt;
    }
    
}