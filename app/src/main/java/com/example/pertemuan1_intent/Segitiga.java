package com.example.pertemuan1_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Segitiga extends AppCompatActivity {
    EditText input_alas , input_tinggi;
    Button btn_hitung;
    TextView output_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        input_alas = findViewById(R.id.input_alas);
        input_tinggi = findViewById(R.id.input_tinggi);
        output_hasil = findViewById(R.id.output_hasil);
        btn_hitung = findViewById(R.id.button2);
        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Alas = input_alas.getText().toString().trim();
                String Tinggi = input_tinggi.getText().toString().trim();
                boolean isEmpty = false;
                boolean isInvalid = false;
                if (TextUtils.isEmpty(Alas)) {
                    isEmpty = true;
                    input_alas.setError("HEM");
                }
                if (TextUtils.isEmpty(Tinggi)) {
                    isEmpty = true;
                    input_tinggi.setError("HAH");
                }
                Double a = toDouble(Alas);
                Double t = toDouble(Tinggi);
                if (a == null) {
                    isInvalid = true;
                    input_alas.setError("isi ");
                }
                if (t == null) {
                    isInvalid = true;
                    input_tinggi.setError("angka");
                }

                if (!isEmpty && !isInvalid) {
                    double luas = 0.5 * a * t;
                    output_hasil.setText(String.valueOf(luas));
                }
            }
        });
    }
            private Double toDouble(String alas) {
                try {
                    return Double.valueOf(alas);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }