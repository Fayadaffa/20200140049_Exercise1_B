package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Pendaftaran extends AppCompatActivity {

    EditText edtNama, edtEmail, edtPassword, edtrepass;
    String username;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        edtNama = findViewById(R.id.edNama);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPass);
        edtrepass = findViewById(R.id.edrepass);
        btn = findViewById(R.id.btnre);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = edtNama.getText().toString();


                if (edtNama.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    edtNama.setError("Wajib di Isi");
                    edtEmail.setError("Wajib di Isi");
                    edtPassword.setError("Wajib di Isi");
                    edtrepass.setError("Wajib di Isi");

                    Toast.makeText(getApplicationContext(), "Wajib Isi Seluruh Data",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil",
                                Toast.LENGTH_LONG).show();

                        Bundle b = new Bundle();
                        b.putString("a",username.trim());


                        Intent a = new Intent(getApplicationContext(), Home.class);
                        a.putExtras(b);
                        startActivity(a);

                    }
                    else
                    {
                        Snackbar.make(view, "Password dan Repassword harus sama",
                                Snackbar.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}