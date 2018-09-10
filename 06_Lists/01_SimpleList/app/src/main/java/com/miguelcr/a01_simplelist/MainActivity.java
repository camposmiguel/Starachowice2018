package com.miguelcr.a01_simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get the listView reference
        lista = findViewById(R.id.listViewStudents);

        // 2. Create the list of elements
        students = new ArrayList();

        // 3. Fill the list with the student names.
        students.add("Lukasz");
        students.add("Kuba");
        students.add("Mateusz I");
        students.add("Kacper");
        students.add("Patryk I");
        students.add("Ola");
        students.add("Iga");
        students.add("Konrad");
        students.add("Mateusz II");
        students.add("Chris");
        students.add("Greg");
        students.add("Patryk II");
        students.add("Adam");
        students.add("Mihal");
        students.add("Bartek I");
        students.add("Bartek II");

        // 4. Create the Adapter component
        ArrayAdapter adapter = new ArrayAdapter(
            MainActivity.this,
                android.R.layout.simple_list_item_1,
                students
        );

        // 5. Connect the lista (ListView ) with adapter
        lista.setAdapter(adapter);

        // Click event on list items:
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, students.get(position), Toast.LENGTH_SHORT).show();

        view.animate().setDuration(2000).rotationX(360);
    }
}
