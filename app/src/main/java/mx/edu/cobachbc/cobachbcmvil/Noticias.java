package mx.edu.cobachbc.cobachbcmvil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Noticias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        setTitle(getResources().getString(R.string.main_noticias));
    }
}
