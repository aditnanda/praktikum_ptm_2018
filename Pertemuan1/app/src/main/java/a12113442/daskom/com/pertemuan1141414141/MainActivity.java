package a12113442.daskom.com.pertemuan1141414141;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit_nomor;
    Button btn_ok;
    TextView txt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_nomor = findViewById(R.id.nomor);
        btn_ok = findViewById(R.id.ok);
        txt_view = findViewById(R.id.txtView);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_view.setText(edit_nomor.getText());
                Toast.makeText(MainActivity.this, edit_nomor.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
