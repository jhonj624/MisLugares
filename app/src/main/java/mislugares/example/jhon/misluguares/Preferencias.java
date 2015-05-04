package mislugares.example.jhon.misluguares;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by jhon on 3/05/15.
 */
public class Preferencias extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle bu){
        super.onCreate(bu);
        addPreferencesFromResource(R.xml.preferencias);

    }
}
