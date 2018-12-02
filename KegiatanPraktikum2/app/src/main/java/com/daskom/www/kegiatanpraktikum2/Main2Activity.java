package com.daskom.www.kegiatanpraktikum2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        hasil = findViewById(R.id.hasil);

        hasil.setText(getIntent().getStringExtra("hasil")+"");
    }
}
