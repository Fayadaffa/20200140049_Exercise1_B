package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {

    FloatingActionButton fab;
    EditText edmt, edjt, edtt;
    String tugas, jenis, waktu;
    TextView textnama;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if (item.getItemId() == R.id.mnsubmit) {

        tugas = edmt.getText().toString();
        jenis = edjt.getText().toString();
        waktu = edtt.getText().toString();

        if (tugas.isEmpty() || jenis.isEmpty() || waktu.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Masukkan Semua Data",
                    Toast.LENGTH_SHORT).show();
        }
        if (edmt.getText().toString().length() == 0) {
            edmt.setError("Masukkan Task");
        }
        if (edjt.getText().toString().length() == 0) {
            edjt.setError("Masukkan Jenis Task");
        }
        if (edtt.getText().toString().length() == 0) {
            edtt.setError("Masukkan Lama Task");
        } else {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Berhasil", Toast.LENGTH_LONG);
            t.show();

            Bundle b = new Bundle();
            b.putString("a", tugas.trim());
            b.putString("b", jenis.trim());
            b.putString("c", waktu.trim());

            Intent i = new Intent(getApplicationContext(), Hasil.class);
            i.putExtras(b);
            startActivity(i);
        }
    }
    if (item.getItemId() == R.id.mnlogout)
        {
            Intent j = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(j);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edmt=findViewById(R.id.edMT);
        edjt=findViewById(R.id.edJT);
        edtt=findViewById(R.id.edTT);
        textnama=findViewById(R.id.edNT);
        fab=findViewById(R.id.fabadd);

        Bundle bundle = getIntent().getExtras();

        String username = bundle.getString("a");
        textnama.setText(username);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tugas = edmt.getText().toString();
                jenis = edjt.getText().toString();
                waktu = edtt.getText().toString();

                if (tugas.isEmpty() || jenis.isEmpty() || waktu.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Masukkan Semua Data",
                            Toast.LENGTH_SHORT).show();
                }
                if (edmt.getText().toString().length() == 0) {
                    edmt.setError("Masukkan Task");
                }
                if (edjt.getText().toString().length() == 0) {
                    edjt.setError("Masukkan Jenis Task");
                }
                if (edtt.getText().toString().length() == 0) {
                    edtt.setError("Masukkan Lama Task");
                }
                else
                {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Berhasil", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a", tugas.trim());
                    b.putString("b", jenis.trim());
                    b.putString("c", waktu.trim());

                    Intent h = new Intent(getApplicationContext(), Hasil.class);
                    h.putExtras(b);
                    startActivity(h);
                }
            }
        });
    }
}