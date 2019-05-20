package br.com.engsoftsis.sorteiosaleatorios.vo;

import java.util.Set;
import java.util.TreeSet;

import br.com.engsoftsis.sorteiosaleatorios.enumerations.ENUM_TIPO_CONTAGEM;
import br.com.engsoftsis.sorteiosaleatorios.utils.Constantes;


public class ParametroVO{
    private int qtdTotal;
    private Set<String> erros;
    private ENUM_TIPO_CONTAGEM tipoContagem;
    
    public ParametroVO(){
        this( Constantes.QTD_MIN_RETIRADA, ENUM_TIPO_CONTAGEM.RETIRADAS);
    }
    
    public ParametroVO(final int qtdTotal){
        this( qtdTotal, ENUM_TIPO_CONTAGEM.RETIRADAS);
    }
    
    public ParametroVO(final int qtdTotal, final ENUM_TIPO_CONTAGEM tipoContagem){
        super();
        this.setQtdTotal( qtdTotal );
        this.setTipoContagem( tipoContagem );
    }
    
    public int getQtdTotal()
    {
        return qtdTotal;
    }
    public void setQtdTotal(final int qtdTotal)
    {
        this.qtdTotal = qtdTotal;
    }
    
    public ENUM_TIPO_CONTAGEM getTipoContagem()
    {
        return tipoContagem;
    }
    public void setTipoContagem(final ENUM_TIPO_CONTAGEM tipoContagem)
    {
        this.tipoContagem = tipoContagem;
    }
    
    public Set<String> getErros()
    {
        if( this.erros == null )
            this.erros = new TreeSet<>();
        return this.erros;
    }
    
    public void addErro(final String erro)
    {
        this.getErros().add( erro );
    }
    
    public boolean hasErros()
    {
        return !this.getErros().isEmpty();
    }
    
}