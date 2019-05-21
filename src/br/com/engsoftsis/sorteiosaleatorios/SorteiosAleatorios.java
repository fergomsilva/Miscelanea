package br.com.engsoftsis.sorteiosaleatorios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

import br.com.engsoftsis.sorteiosaleatorios.enumerations.ENUM_TIPO_CONTAGEM;
import br.com.engsoftsis.sorteiosaleatorios.services.SorteioService;
import br.com.engsoftsis.sorteiosaleatorios.utils.Constantes;
import br.com.engsoftsis.sorteiosaleatorios.vo.ParametroVO;
import br.com.engsoftsis.sorteiosaleatorios.vo.SimulacaoVO;

public class SorteiosAleatorios{
    
    private static final SimulacaoVO gerarSimulacao(final ParametroVO param) throws Exception
    {
        final SimulacaoVO resultado = new SimulacaoVO( param );
        do{
            resultado.contabilizarDezenasJogo( SorteioService.sortear() );
        }while( !resultado.isQtdRetiradasOK() );
        System.out.println( String.format( "Qtd total retiradas: %,d%s", resultado.getQtdRetiradas(), System.lineSeparator() ) );
        return resultado;
    }
    
    private static final void processarSimulacao(final SimulacaoVO simulacao) throws Exception
    {
        simulacao.sortByQuantidade( true );
        simulacao.getPrimeiros( 10 ).forEach( dez 
            -> System.out.println( String.format( "%2d: %,d - %.4f %%", dez.getDezena(), dez.getQuantidade(), dez.getPorcentagem() ) ) );
    }
    
    private static final void mostrarInstrucoes()
    {
        System.out.println( Constantes.INSTRUCOES );
    }
    
    private static final ParametroVO validarArgumentos(final String... args)
    {
        final ParametroVO param = new ParametroVO();
        if( args != null && args.length > 0 ) {
            int qtd = 0;
            try {
                qtd = Integer.parseInt( args[ 0 ] );
                if( qtd < 1 )
                    param.addErro( "ERRO: O par\u00E2metro '<qtd>' necessita de valor maior ou igual a 1." );
                else
                    param.setQtdTotal( qtd );
            }catch( NumberFormatException nfe ){
                param.addErro( "ERRO: Valor n\u00E3o num\u00E9rico informado para o par\u00E2metro '<qtd>'." );
            }
            if( args.length == 2 ){
                if( !( ( "jogo".equalsIgnoreCase( args[ 1 ] ) || "jogos".equalsIgnoreCase( args[ 1 ] ) ) 
                        || ( "retirada".equalsIgnoreCase( args[ 1 ] ) || "retiradas".equalsIgnoreCase( args[ 1 ] ) ) 
                        || ( "dezena".equalsIgnoreCase( args[ 1 ] ) || "dezenas".equalsIgnoreCase( args[ 1 ] ) ) ) )
                    param.addErro( "ERRO: Valor inv\u00E1lido para o par\u00E2metro '<tipoQtd>'. Os valores poss\u00EDveis s\u00E3o 'jogos', "
                        + "'retiradas' e 'dezenas'." );
                else
                    param.setTipoContagem( ENUM_TIPO_CONTAGEM.valueOfByArgumento( args[ 1 ] ) );
            }
        }
        if( param.hasErros() ) {
            final StringBuilder mensagens = new StringBuilder();
            System.out.println( "\n" );
            param.getErros().forEach( e -> {
                mensagens.append( e );
                mensagens.append( System.lineSeparator() );
                System.out.println( e );
            } );
            
            mensagens.append( System.lineSeparator() );
            mensagens.append( "INSTRU\u00C7\u00D5ES: " );
            mensagens.append( System.lineSeparator() );
            mensagens.append( Constantes.INSTRUCOES );
            JOptionPane.showMessageDialog( null, mensagens, "ERRO", JOptionPane.ERROR_MESSAGE );
        }
        return param;
    }
    
    public static void main(final String... args)
    {
        Constantes.carregarTextoInstrucoes();
        SorteiosAleatorios.mostrarInstrucoes();
        
        final ParametroVO param = SorteiosAleatorios.validarArgumentos( args );
        if( param.hasErros() )
            System.exit( -1 );
        try{
            final LocalDateTime inicio = LocalDateTime.now();
            System.out.println( String.format( "%s%sINICIO: %s", System.lineSeparator(), System.lineSeparator(), inicio ) );
            
            SorteioService.ligarGlobos();
            
            SorteiosAleatorios.processarSimulacao( SorteiosAleatorios.gerarSimulacao( param ) );
            
            SorteioService.desligarGlobos();
            
            final LocalDateTime fim = LocalDateTime.now();
            System.out.println( String.format( "%sFIM: %s - %s (%,d) segundos", System.lineSeparator(), inicio, fim, inicio.until( fim, 
                ChronoUnit.SECONDS ) ) );
        }catch( Exception e ){
            e.printStackTrace();
            SorteioService.desligarGlobos();
        }finally{
            System.exit( 0 );
        }
    }
    
}