package mislugares.example.jhon.misluguares;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by jhon on 17/04/15.
 */
public class LugarMainActivity extends ActionBarActivity {

    // variables de vistas
    private Button bAcercaDe;
    @Override
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

        // listener para la actividad de acerca de ..
        bAcercaDe = (Button) findViewById(R.id.acercade);
        bAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAcercaDe(null);
            }
        });
    }


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

    // método para lanzar la aplicación usando el metodo directo onClick que no es muy recomendable
    public void onAcercaDe(View view){
        Intent i = new Intent(this,AcercaDe.class);
        startActivity(i);
    }

    public void onCrearLugar(View view){
        Intent i = new Intent(this,EdicionLugarActivity.class);
        startActivity(i);
    }
}