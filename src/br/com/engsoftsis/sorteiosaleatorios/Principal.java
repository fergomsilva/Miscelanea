package br.com.engsoftsis.sorteiosaleatorios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.com.engsoftsis.sorteiosaleatorios.services.SorteioService;
import br.com.engsoftsis.sorteiosaleatorios.utils.Constantes;
import br.com.engsoftsis.sorteiosaleatorios.vo.DezenaQtdVO;
import br.com.engsoftsis.sorteiosaleatorios.vo.SimulacaoVO;

public class Principal{
    
    public static void main(final String... args)
    {
        try{
            final LocalDateTime inicio = LocalDateTime.now();
            
            SorteioService.ligarGlobos();
            
            final SimulacaoVO resultado = new SimulacaoVO();
            do{
                resultado.contabilizarDezenasJogo( SorteioService.sortear() );
            }while( resultado.getQtdRetiradas() < Constantes.QTD_MIN_RETIRADA );
            System.out.println( String.format( "Qtd total retiradas: %,d%s", resultado.getQtdRetiradas(), System.lineSeparator() ) );
            
            resultado.sortByQuantidade( true );
            for( DezenaQtdVO dez : resultado.getPrimeiros( 10 ) )
                System.out.println( String.format( "%2d: %,d - %.4f %%", dez.getDezena(), dez.getQuantidade(), ( dez.getQuantidade() / (double)resultado.getQtdRetiradas() * 100.0 ) ) );
            
            SorteioService.desligarGlobos();
            
            final LocalDateTime fim = LocalDateTime.now();
            System.out.println( String.format( "%s%sFIM: %s - %s (%,d) segundos", System.lineSeparator(), System.lineSeparator(), inicio, fim, inicio.until( fim, ChronoUnit.SECONDS ) ) );
        }catch( Exception e ){
            SorteioService.desligarGlobos();
            e.printStackTrace();
        }finally{
            System.exit( 0 );
        }
    }
    
}