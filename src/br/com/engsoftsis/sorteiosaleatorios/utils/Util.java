package br.com.engsoftsis.sorteiosaleatorios.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.engsoftsis.sorteiosaleatorios.vo.DezenaQtdVO;

public interface Util{
    
    int QTD_GLOBOS = 6;
    int MAIOR_DEZENA = 60;
    int QTD_MIN_RETIRADA = 100_000;
    ThreadGroup THREAD_GROUP_GLOBOS = new ThreadGroup( "THREAD_GROUP_GLOBOS" );
    
    static List<DezenaQtdVO> gerarVolanteBranco()
    {
        final List<DezenaQtdVO> volante = new ArrayList<>( Util.MAIOR_DEZENA );
        for( int i = 1; i <= Util.MAIOR_DEZENA; i++ )
            volante.add( new DezenaQtdVO( i ) );
        return volante;
    }
    
}