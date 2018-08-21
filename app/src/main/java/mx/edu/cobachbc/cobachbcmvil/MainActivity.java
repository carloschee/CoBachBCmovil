package mx.edu.cobachbc.cobachbcmvil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sesion sesion = (Sesion) getIntent().getSerializableExtra(("objeto_sesion"));
        Alumno alumno = (Alumno) getIntent().getSerializableExtra(("objeto_alumno"));

        TextView datosAlumno = findViewById(R.id.datosAlumno);
        datosAlumno.setText(getResources().getString(R.string.main_id_alumno, String.valueOf(alumno.Matricula), alumno.NombreAlumno, String.valueOf(alumno.ClavePlantel), alumno.NombrePlantel, String.valueOf(alumno.Grupo)));

        Button btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        Button btnNoticias = findViewById(R.id.noticias);
        btnNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Noticias.class);
                startActivity(i);
            }
        });

        Button btnCalificaciones = findViewById(R.id.calificaciones);
        btnCalificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Calificaciones.class);
                startActivity(i);
            }
        });

        Button btnInasistencias = findViewById(R.id.inasistencias);
        btnInasistencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Inasistencias.class);
                startActivity(i);
            }
        });

        Button btnIncidencias = findViewById(R.id.incidencias);
        btnIncidencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Incidencias.class);
                startActivity(i);
            }
        });
    }
}
