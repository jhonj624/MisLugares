package mislugares.example.jhon.misluguares;

/**
 * Created by jhon on 6/04/15.
 */

public class GeoPunto {
    private double latitud, longitud;

    public GeoPunto(double latitud, double longitud){
        this.longitud = (int) (longitud * 1E6);
        this.latitud = (int) (latitud * 1E6);
    }

    public String toString(){
        return longitud + "+" + latitud + "l";
    }

    public double distancia(GeoPunto punto){

        final double RADIO_TIERRA = 6371000; // en metros

        double dLat = Math.toRadians(latitud - punto.latitud);
        double dLon = Math.toRadians(longitud - punto.longitud);

        double lat1 = Math.toRadians(punto.latitud);
        double lat2 = Math.toRadians(latitud);

        double a =    Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) *

                        Math.cos(lat1) * Math.cos(lat2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return c * RADIO_TIERRA;

    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
