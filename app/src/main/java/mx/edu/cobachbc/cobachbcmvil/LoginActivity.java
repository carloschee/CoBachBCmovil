package mx.edu.cobachbc.cobachbcmvil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Crear las variables de las vistas UI para después poder extraer su contenido
        final EditText getNumCel = findViewById(R.id.numCel);
        final TextView textoErrorIngreso = findViewById(R.id.errorIngreso);
        final EditText getPass = findViewById(R.id.pass);
        Button btnIngresar = findViewById(R.id.btnIngresar);

        // Hacer INVISIBLE el mensaje de error de login
        textoErrorIngreso.setVisibility(View.INVISIBLE);

        // Listener onClick boton de ingreso
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Obtener los valores ingresados en los campos y switch por el usuario para ingresar
                String numCel = getNumCel.getText().toString();
                String pass = getPass.getText().toString();
                Switch getEsTutor = findViewById(R.id.esTutor);

                // Verificar que usuario y contraseña no estén vacíos
                if(numCel.equals("") || pass.equals("")){

                    // Si numCel o pass están en blanco mostrar el error
                    textoErrorIngreso.setVisibility(View.VISIBLE);
                }else{

                    // Verificar si getEsTutor es falso o verdadero
                    if(getEsTutor.isChecked()){

                        // Si getEsTutor es verdadro validar los datos en la tabla de tutores
                        if(numCel.equals("6869462551") && pass.equals("12345678")){
                            // ---- LOGIN EXITOSO DE TUTOR ---- //
                            Sesion sesion = new Sesion();
                            sesion.NumCel = Integer.valueOf(numCel);

                            Intent i = new Intent(LoginActivity.this, TutorSeleccActivity.class);
                            i.putExtra("objeto_sesion", sesion);
                            startActivity(i);


                        }else{

                            // Usuario y/o contraseña inválidos, mostrar error
                            textoErrorIngreso.setVisibility(View.VISIBLE);
                        }

                    }else{

                        // Si getEsTutor es falso validar los datos en la tabla de alumnos
                        if(numCel.equals("6869462551") && pass.equals("12345678")){
                            // ---- LOGIN EXITOSO DE ALUMNO ---- //

                            Sesion sesion = new Sesion();
                            //sesion.NumCel = Integer.valueOf(numCel);
                            sesion.NumCel = Long.parseLong(numCel);

                            Alumno alumno = new Alumno();
                            alumno.ClavePlantel = 101;
                            alumno.NombrePlantel = "Baja California";
                            alumno.Grupo = 101;
                            alumno.Matricula = 12345678;
                            alumno.NombreAlumno = "María Dolores Vázquez Espinoza";

                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            i.putExtra("objeto_sesion", sesion);
                            i.putExtra("objeto_alumno", alumno);
                            startActivity(i);

                        }else{

                            // Usuario y/o contraseña inválidos, mostrar error
                            textoErrorIngreso.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });
    }
}
