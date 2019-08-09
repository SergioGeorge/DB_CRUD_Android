package com.playground.database_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EscuelaSQLiteHelper dataBase;
    private EditText tf_name, tf_age, tf_group;
    private Button btn_registrar, btn_consultar, btn_eliminar;
    private ArrayList<StudentPOJO> arrayStudent;
    private RecyclerView rv;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencia a los TextFields
        tf_name = findViewById(R.id.tf_name);
        tf_age = findViewById(R.id.tf_age);
        tf_group = findViewById(R.id.tf_group);
        //Referencia a los botones
        btn_registrar = findViewById(R.id.btn_registrar);
        btn_consultar = findViewById(R.id.btn_consultar);
        //Agregamos los listeners a los botones
        btn_registrar.setOnClickListener(this);
        btn_consultar.setOnClickListener(this);

        dataBase = new EscuelaSQLiteHelper(this);

        //Instanciamos el Adaptador y lo acoplamos al recyclerView

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_registrar) {
            boolean isRegistered = dataBase.registrarAlumno(
                    tf_name.getText().toString(),
                    tf_age.getText().toString(),
                    tf_group.getText().toString()
            );

            if(isRegistered)
                Toast.makeText(this, "Se hizo el registro", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Fallo en hacer el registro", Toast.LENGTH_SHORT).show();
        }else if(view.getId() == R.id.btn_consultar) {
            ArrayList<StudentPOJO> arrayStudent = dataBase.consultarAlumnos();
            Toast.makeText(this, "Has consultado", Toast.LENGTH_SHORT).show();
            rv = findViewById(R.id.recyclerView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            rv.setLayoutManager(linearLayoutManager);
            recyclerViewAdapter = new RecyclerViewAdapter(R.layout.list_item, arrayStudent);
            rv.setAdapter(recyclerViewAdapter);

        }
    }
}
