package br.com.engsoftsis.sorteiosaleatorios.vo;

import java.util.Comparator;
import java.util.Objects;

public class DezenaQtdVO implements Comparable<DezenaQtdVO>, Comparator<DezenaQtdVO> {
    private int dezena;
    private int quantidade;
    private double porcentagem;
    
    public DezenaQtdVO(final int dezena)
    {
        super();
        this.quantidade = 0;
        this.dezena = dezena;
    }
    
    public int getDezena()
    {
        return this.dezena;
    }
    
    public int getQuantidade()
    {
        return this.quantidade;
    }
    
    public double getPorcentagem()
    {
        return this.porcentagem;
    }
    
    public void addQuantidade()
    {
        ++this.quantidade;
    }
    
    public void calcularPorcentagem(final int qtdTotal)
    {
        this.porcentagem = ( this.getQuantidade() / (double)qtdTotal * 100.0 );
    }
    
    @Override
    public int hashCode(){
        return Objects.hash( this.getDezena() );
    }

    @Override
    public boolean equals(final Object obj){
        if( this == obj )
            return true;
        if( obj == null )
            return false;
        if( !( obj instanceof DezenaQtdVO ) )
            return false;
        final DezenaQtdVO other = (DezenaQtdVO)obj;
        return this.getDezena() == other.getDezena();
    }

    @Override
    public int compare(final DezenaQtdVO o1, final DezenaQtdVO o2)
    {
        return o1.compareTo( o2 );
    }

    @Override
    public int compareTo(final DezenaQtdVO o)
    {
        return Integer.compare( this.getDezena(), o.getDezena() );
    }

}