package br.com.engsoftsis.sorteiosaleatorios;

import java.util.Random;

import br.com.engsoftsis.sorteiosaleatorios.utils.Util;


class Globo extends Thread{
    private static final Random RANDOM = new Random();
    
    private Integer dezena = 0;
    private Boolean ligado = Boolean.TRUE;
    
    
    public Globo(final int globo)
    {
        super( Util.THREAD_GROUP_GLOBOS, "Globo" + globo );
        super.setDaemon( false );
    }

    @Override
    public void run()
    {
        do{
            synchronized( this.dezena ){
                this.dezena = Globo.RANDOM.nextInt( Util.MAIOR_DEZENA ) + 1;
            }
        }while( this.ligado );
    }
    
    public void desligar()
    {
        synchronized( this.ligado ){
            this.ligado = Boolean.FALSE;
        }
    }
    
    public int getDezena()
    {
        synchronized( this.dezena ){
            return this.dezena;
        }
    }
    
}