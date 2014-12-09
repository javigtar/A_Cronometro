package dam.org.cronometro;

import android.app.Activity;
import android.net.http.AndroidHttpClient;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends Activity {

    Chronometer cronometro;
    Button bEmpezar;
    Button bParar;
    Button bReset;
    long tiempoTranscurrido; //Variable que guarda el tiempo transcurrido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cronometro = (Chronometer)findViewById(R.id.cronometro);
        bEmpezar = (Button)findViewById(R.id.bEmpezar);
        bParar = (Button)findViewById(R.id.bParar);
        bReset = (Button)findViewById(R.id.bReset);
        tiempoTranscurrido = 0;

        bEmpezar.setOnClickListener(new View.OnClickListener() {
            //Se ejecutará cuando apretemos el boton de empezar
            @Override
            public void onClick(View view) {
                cronometro.setBase(SystemClock.elapsedRealtime() + tiempoTranscurrido);
                cronometro.start();
            }
        });

        bParar.setOnClickListener(new View.OnClickListener() {
            //Se ejecutará cuando apretemos el boton de parar
            @Override
            public void onClick(View view) {
                tiempoTranscurrido = cronometro.getBase() - SystemClock.elapsedRealtime();
                cronometro.stop();
            }
        });

        bReset.setOnClickListener(new View.OnClickListener() {
            //Se ejecutará cuando apretemos el boton de reset
            @Override
            public void onClick(View view) {
                cronometro.setBase(SystemClock.elapsedRealtime());
                tiempoTranscurrido = 0;
            }
        });

    }

}
