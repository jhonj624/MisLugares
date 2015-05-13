package mislugares.example.jhon.misluguares;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by jhon on 17/04/15.
 */
public class LugarMainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    public BaseAdapter adaptador;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_lugares);
        adaptador = new AdaptadorLugares(this);
        /*adaptador = new ArrayAdapter(this,
                R.layout.elemento_lista,
                R.id.nombre,
                Lugares.listaNombres());*/
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(this);
    }

    // variables de vistas
    private Button bAcercaDe;
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_lugares);

        //listener para el evento salir, se hace en el metodo onCreate
        Button bSalir = (Button) findViewById(R.id.salir);
        bSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // listener para la creación de nuevos lugares
        Button bCrearLugar = (Button) findViewById(R.id.crear_lugar);
        bCrearLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCrearLugar(null);
            }
        });

        Button bMostrarLugar = (Button) findViewById(R.id.mostrar_lugares);
        bMostrarLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarVistaLugar(null);
            }
        });

        // listener para la actividad de acerca de ..
        bAcercaDe = (Button) findViewById(R.id.acercade);
        bAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAcercaDe(null);
            }
        });
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            lanzarPreferencias(null);
            return true;
        }
        if (id == R.id.action_ver_preferencias){
            mostrarPreferencias();
            return true;
        }
        if(id == R.id.acerca_de){
            onAcercaDe(null);
            return true;
        }
        if(id == R.id.menu_buscar){
            onCrearLugar(null);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView parent,View vista,
                               int posicion, long id){
        Intent i = new Intent(this, VistaLugar.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    // método para lanzar la aplicación usando el metodo directo onClick que no es muy recomendable
    public void onAcercaDe(View view){
        Intent i = new Intent(this,AcercaDe.class);
        startActivity(i);
    }

    public void onCrearLugar(View view){
        Intent i = new Intent(this,EdicionLugarActivity.class);
        startActivity(i);
    }

    public void lanzarPreferencias(View view){
        Intent i = new Intent(this,Preferencias.class);
        startActivity(i);
    }

    public void mostrarPreferencias(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        //int km =  pref.getInt("distancia",0);
        //String distancia = Integer.toString(km);

        String s ="notificaciones: "+pref.getBoolean("notificaciones",true)
                + ", distancia mínima: "+pref.getString("distancia: ","?")
                + ", orden: "+ pref.getString("orden","1");
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();


    }

    public void lanzarVistaLugar(View view){
        Intent i = new Intent(this, VistaLugar.class);
        i.putExtra("id", (long)0);
        startActivity(i);
    }
}
