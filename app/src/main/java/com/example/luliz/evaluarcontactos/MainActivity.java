package com.example.luliz.evaluarcontactos;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    private int año;
    private int mes;
    private int dia;
    private Button btnFecha_nac;
    private static final int TIPO_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    public TextView getTvNombre() {
        return tvNombre;
    }

    public void setTvNombre(TextView tvNombre) {
        this.tvNombre = tvNombre;
    }

    public TextView getTvFecha_Nac() {
        return tvFecha_Nac;
    }

    public void setTvFecha_Nac(TextView tvFecha_Nac) {
        this.tvFecha_Nac = tvFecha_Nac;
    }

    public TextView getTvDescripcion() {
        return tvDescripcion;
    }

    public void setTvDescripcion(TextView tvDescripcion) {
        this.tvDescripcion = tvDescripcion;
    }

    public TextView getTvEmail() {
        return tvEmail;
    }

    public void setTvEmail(TextView tvEmail) {
        this.tvEmail = tvEmail;
    }

    TextView tvNombre;
    TextView tvFecha_Nac;
    TextView tvDescripcion;
    TextView tvEmail;

    public TextView getTvTelefono() {
        return tvTelefono;
    }

    public void setTvTelefono(TextView tvTelefono) {
        this.tvTelefono = tvTelefono;
    }

    TextView tvTelefono;
    Button btnSiguiente, btnFecha_Nac;

    EditText edNombre, edFecha_Nac, edTelefono, edMail, edDescrpcion;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtener una instancia de los controles


        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha_Nac = (TextView) findViewById(R.id.tvFecha_Nac);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        edFecha_Nac = (EditText) findViewById(R.id.edFecha);
        edNombre = (EditText) findViewById(R.id.edNombre);
        edTelefono = (EditText) findViewById(R.id.edTelefono);
        edMail = (EditText) findViewById(R.id.edEmail);
        edDescrpcion = (EditText) findViewById(R.id.edDescrpcion);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnFecha_Nac = (Button) findViewById(R.id.btnFecha_Nac);


        btnFecha_Nac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarCalendario(getVolumeControlStream());
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent siguiente =new Intent( MainActivity.this, ConfirmarDatos.class);
               Bundle b=new Bundle();
                b.putString("Nombre",edNombre.getText().toString());
                b.putString("Fecha",edFecha_Nac.getText().toString());
                b.putString("Telefono",edTelefono.getText().toString());
                b.putString("Mail",edMail.getText().toString());
                b.putString("Descripcion",edDescrpcion.getText().toString());
                siguiente.putExtras(b);
                startActivity(siguiente);

            }
        });

// clase de java para obtener la fecha del dispositivo calendar
        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH)+1;//le suma 1 al mes ya que enero vale 0
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mostrarFecha();
        oyenteSelectorFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                año = year;
                mes = month;
                dia = dayOfMonth;
                mostrarFecha();
            }
        };
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new DatePickerDialog(this, oyenteSelectorFecha, año, mes, dia);

        }
        return null;


    }




    public void mostrarCalendario(int control){
            showDialog(TIPO_DIALOGO);
            }



    public void mostrarFecha() {
        edFecha_Nac.setText(año + "/" + mes + "/" + dia);
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
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

