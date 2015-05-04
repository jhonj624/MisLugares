package mislugares.example.jhon.misluguares;

/**
 * Created by jhon on 7/04/15.
 */
public enum TipoLugar {
    OTROS("Otros", R.drawable.otros),
    RESTAURANTE("Restaurante", R.drawable.restaurante),
    BAR("Bar", R.drawable.bar),
    COPAS("Copas", R.drawable.copas),
    ESPECTACULO("Espectáculo", R.drawable.espectaculos),
    HOTEL("Hotel", R.drawable.hotel),
    COMPRAS("Compras", R.drawable.compras),
    EDUCACION("Educación", R.drawable.educacion),
    DEPORTE("Deporte", R.drawable.educacion),
    NATURALEZA("Naturaleza", R.drawable.naturaleza),
    PARQUEADERO("Parqueadero", R.drawable.gasolinera),
    GASOLINERA("Gasolinera", R.drawable.gasolinera);


    private final String texto;
    private final int recurso;

    TipoLugar(String texto, int recurso){
        this.texto = texto;
        this.recurso = recurso;
    }

    public String getTexto(){ return texto;}

    public int getRecurso(){return recurso;}
}
