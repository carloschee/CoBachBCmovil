package mx.edu.cobachbc.cobachbcmvil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TutorSeleccActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_selecc);

        ListView listaAlumnos = findViewById(R.id.listaAlumnos);

        // Popular la lista de alumnos disponibles para el tutor
        final HashMap<String, String> alumnos = new HashMap<>();
        alumnos.put("01234567", "María Dolores Vázquez Espinoza");
        alumnos.put("87654321", "Martha Leticia Gámez Vázquez");

        final List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.matricula, R.id.nombre});

        final Iterator it = alumnos.entrySet().iterator();
        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }

        listaAlumnos.setAdapter(adapter);

        listaAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nombre = listItems.get(i).toString();
                String matricula = listItems.get(i).toString();

                Alumno alumno = new Alumno();
                alumno.ClavePlantel = 101;
                alumno.NombrePlantel = "Baja California";
                alumno.Grupo = 101;
                alumno.Matricula = Integer.parseInt(matricula.substring(matricula.lastIndexOf(",")+13,matricula.length()-1));
                alumno.NombreAlumno = nombre.substring(13,nombre.lastIndexOf(","));

                Intent ii = new Intent(TutorSeleccActivity.this, MainActivity.class);
                ii.putExtra("objeto_alumno", alumno);
                startActivity(ii);
            }
        });
    }
}
