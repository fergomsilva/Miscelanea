package br.com.engsoftsis.sorteiosaleatorios.utils;

public interface Constantes{
    
    int MAIOR_DEZENA = 60;
    int QTD_MIN_RETIRADA = 100_000;
    StringBuilder INSTRUCOES = new StringBuilder();
    
    static void carregarTextoInstrucoes()
    {
        Constantes.INSTRUCOES.append( "Par\u00E2metros permitidos: " );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "  1\u00BA CEN\u00C1RIO: " );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "    SorteiosAleatorios <qtd>" );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "      <qtd> - apenas valor num\u00E9rico. Representa a quantidade de retiradas de " );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "                                             dezenas m\u00EDnima para a simula\u00E7\u00E3o." );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        
        Constantes.INSTRUCOES.append( "  2\u00BA CEN\u00C1RIO: " );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "    SorteiosAleatorios <qtd> <tipoQtd>" );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "      <qtd> - apenas valor num\u00E9rico." );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "      <tipoQtd> - valores poss\u00EDveis [jogos|retiradas|dezenas]." );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "                - se informado 'jogos',  o programa considera  o valor num\u00E9rico " );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "                    informado no  par\u00E2metro anterior anterior  com a  quantidade " );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "                                                             de jogos simulados;" );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "                - se informado 'retiradas' ou 'dezenas', o programa considera o " );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "                    valor num\u00E9rico informado no par\u00E2metro anterior com a quanti-" );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
        Constantes.INSTRUCOES.append( "                           dade m\u00EDnima de retiradas de dezenas para a simula\u00E7\u00E3o;" );
        Constantes.INSTRUCOES.append( System.lineSeparator() );
    }
    
}