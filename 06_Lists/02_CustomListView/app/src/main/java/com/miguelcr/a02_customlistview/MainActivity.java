package com.miguelcr.a02_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewStudents);

        // Create the student list
        students = new ArrayList<>();

        // Add students to the list
        students.add(new Student("Lukasz","computer 1", 18, "https://s3.amazonaws.com/uifaces/faces/twitter/ashleyford/128.jpg"));
        students.add(new Student("Kuba","computer 2", 18, "https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"));
        students.add(new Student("Mateusz I","computer 3", 18, "https://s3.amazonaws.com/uifaces/faces/twitter/chadengle/128.jpg"));
        students.add(new Student("Kacper","computer 4", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/dancounsell/128.jpg"));
        students.add(new Student("Patryk I","computer 5", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/vladzima/128.jpg"));
        students.add(new Student("Ola","computer 6", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/adellecharles/128.jpg"));

        // Adapter
        StudentAdapter adapter = new StudentAdapter(
                MainActivity.this,
                R.layout.student_item,
                students
        );

        lista.setAdapter(adapter);

    }
}
