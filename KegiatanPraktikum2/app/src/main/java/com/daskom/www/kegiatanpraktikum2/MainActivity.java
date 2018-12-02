package com.daskom.www.kegiatanpraktikum2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText angka1, nama;
    Button tambah, kurang;
    int a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1= findViewById(R.id.angka1);
        nama= findViewById(R.id.nama);

        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a= Integer.parseInt(angka1.getText().toString()) %100;
                b = Integer.parseInt(String.valueOf(nama.getText().toString().length()));

                c = a*b;

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("hasil",c+"");
                startActivity(intent);
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a= Integer.parseInt(angka1.getText().toString())%100;
                b = Integer.parseInt(String.valueOf(nama.getText().toString().length()));

                c = a*b/2;

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("hasil",c+"");
                startActivity(intent);
            }
        });
    }
}
