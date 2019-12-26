package com.example.esempiosearchbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.esempiosearchbar.model.Categoria;
import com.example.esempiosearchbar.model.Materia;

import java.util.ArrayList;
import java.util.List;

import io.realm.ObjectServerError;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.SyncConfiguration;
import io.realm.SyncCredentials;
import io.realm.SyncUser;

import static com.example.esempiosearchbar.MyApplication.AUTH_URL;
import static com.example.esempiosearchbar.MyApplication.REALM_URL;
import static com.example.esempiosearchbar.MyApplication.createUser;
import static com.example.esempiosearchbar.MyApplication.password;
import static com.example.esempiosearchbar.MyApplication.username;

public class MainActivity extends AppCompatActivity {

    //Elements
    TextView txtResults;
    SearchView searchBar;
    ListView listViewQuery;

    //Authentication variables
    Realm realm;
    SyncConfiguration config;

    //Arrays
    Materia[] materie;
    String[] nomiMaterie;
    Categoria[] categoria;

    //Lists
    RealmList<Categoria> catList;
    RealmList<String> listaNomiMaterie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm.init(this);

        txtResults = findViewById(R.id.txtResults);
        searchBar = findViewById(R.id.searchBar);
        listViewQuery = findViewById(R.id.listViewQuery);

        //Login
        SyncCredentials credentials = SyncCredentials.usernamePassword(username, password, createUser);
        SyncUser.logInAsync(credentials, AUTH_URL, new SyncUser.Callback<SyncUser>() {
            @Override
            public void onSuccess(SyncUser user) {

                // Create the configuration
                user = SyncUser.current();
                //String url = REALM_URL;
                config = user.createConfiguration(REALM_URL).fullSynchronization().build();

                // Open the remote Realm
                realm = Realm.getInstance(config);

                //I set the default configuration so that i can retrieve it in other classes
                Realm.setDefaultConfiguration(config);

                //This log instruction is useful to debug
                Log.i("Login status: ", "Successful");
            }

            @Override
            public void onError(ObjectServerError error) {
                Log.e("Login error - ", error.toString());
            }
        });

        /*
        Ho bisogno di prelevare tutte le materie
         */
        queryMaterie();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomiMaterie);
        listViewQuery.setAdapter(adapter);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                /*
                Eseguo una query per vedere se esiste il valore inserito e in caso negativo do
                un messaggio di errore, in caso positivo eseguo la ricerca
                 */
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                /*
                Mostro gli elementi che contengono la stringa inserita
                 */
                if(newText != null && !newText.isEmpty()){
                    listViewQuery.setVisibility(View.VISIBLE);
                    /*
                    Ora che la list view è visibile bisogna mostrare le materie che contengono il
                    testo inserito.
                    Selezionando una di queste materie si imposta il testo della searchview.
                    Avviando la ricerca bisogna visualizzare le categorie inerenti alla materia
                    scelta.

                    Se la materia non esiste all'interno del database bisogna visualizzare un toast
                    con un messaggio di errore.
                     */
                }
                return true;
            }

        });
    }

    private void queryMaterie(){
        //I run the query to display the content of the table Esempio1
        try {

            //I refer to the class
            RealmQuery<Materia> query = realm.where(Materia.class);
            //Execute the query
            RealmResults<Materia> resMateria  = query.findAllAsync();
            for (Materia m: resMateria){
                listaNomiMaterie.add(m.getNome());
            }
            nomiMaterie = (String[]) listaNomiMaterie.toArray();

        } catch (Exception e) {
            Log.e("Query error: ", e.getMessage());
        }
    }
}
