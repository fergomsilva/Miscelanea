package br.com.engsoftsis.sorteiosaleatorios.enumerations;

public enum ENUM_TIPO_CONTAGEM{
    RETIRADAS, JOGOS;
    
    
    public static final ENUM_TIPO_CONTAGEM valueOfByArgumento(final String argumento)
    {
        if( "retirada".equalsIgnoreCase( argumento ) || "retiradas".equalsIgnoreCase( argumento ) 
                || "dezena".equalsIgnoreCase( argumento ) || "dezenas".equalsIgnoreCase( argumento ) )
            return ENUM_TIPO_CONTAGEM.RETIRADAS;
        else if( "jogo".equalsIgnoreCase( argumento ) || "jogos".equalsIgnoreCase( argumento ) )
            return ENUM_TIPO_CONTAGEM.JOGOS;
        return null;
    }
    
}