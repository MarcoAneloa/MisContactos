package ec.com.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ec.com.miscontactos.entidad.Contacto;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Ximena Mangia","1111111111","prueba@gmail.com"));
        contactos.add(new Contacto("Carlos Medina","3333333333","prueba@gmail.com"));
        contactos.add(new Contacto("Marco Aneloa","4444444444","maneloa89@gmail.com"));
        contactos.add(new Contacto("Patricio Betancourt","0999713688","prueba@gmail.com"));
        contactos.add(new Contacto("Jessica Paredes","2222222222","prueba@gmail.com"));

        ArrayList<String> nombreContacto =new ArrayList<>();
        for (Contacto contacto:contactos) {
            nombreContacto.add(contacto.getNombre());
        }
        ListView lstContactos=(ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(i).getEmail());
                startActivity(intent);
                finish();//finaliza la actividad
            }
        });

    }
}
