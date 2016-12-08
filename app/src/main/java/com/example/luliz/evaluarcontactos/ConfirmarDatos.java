package com.example.luliz.evaluarcontactos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class ConfirmarDatos extends AppCompatActivity {
    TextView tvNombre, tvTelefono, tvEmail, tvDescripcion, tvFecha_Nac;
    Button btnSiguiente, btnConfirmar;
    EditText edNombre, edFecha_Nac, edTelefono, edMail, edDescrpcion;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha_Nac = (TextView) findViewById(R.id.tvFecha_Nac);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        btnConfirmar=(Button)findViewById(R.id.btnConfirmar);

        edFecha_Nac = (EditText) findViewById(R.id.edFecha);
        edNombre = (EditText) findViewById(R.id.edNombre);
        edTelefono = (EditText) findViewById(R.id.edTelefono);
        edMail = (EditText) findViewById(R.id.edEmail);
        edDescrpcion = (EditText) findViewById(R.id.edDescrpcion);

       btnConfirmar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent returnIntent = new Intent();
               returnIntent.putExtra("result",result);
               setResult(RESULT_OK,returnIntent);
               finish();
           }
       });
        

        Bundle bundle = this.getIntent().getExtras();
        edNombre.setText(bundle.getString("Nombre"));
        edFecha_Nac.setText(bundle.getString("Fecha"));
        edTelefono.setText(bundle.getString("Telefono"));
        edMail.setText(bundle.getString("Mail"));
        edDescrpcion.setText(bundle.getString("Descripcion"));
        
        
        
        

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ConfirmarDatos Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
