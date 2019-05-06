package com.example.projectuasmp_sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{
    //Deklarasi variabel pendukung
    private TextView Hasil;
    private EditText Masukan;
    private Button Eksekusi;

    //Deklarasi dan inisialisasi Shared Preferences
    private SharedPreferences preferences;

    //Digunakan untuk konfigurasi Shared Preferences
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Masukan =  (EditText) findViewById(R.id.input);
        Hasil = (TextView) findViewById(R.id.output);
        Eksekusi = (Button) findViewById(R.id.save);

        //Membuat file baru beserta modifiernya
        preferences = getSharedPreferences("Belajar_Shared Preferences", Context.MODE_PRIVATE);

        Eksekusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(getApplicationContext(), "Data tersimpan", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getData(){
        //Mendapatkan input dari user
        String getKonten = Masukan.getText().toString();

        //Digunakan untuk pengaturan konfigurasi Shared Preferences
        editor = preferences.edit();

        //Memasukkan data pada editor Shared Preferences dengan key (data_saya)
        editor.putString("data_saya", getKonten);

        //Menjalankan operasi
        editor.apply();

        //Menampilkan outputS
        Hasil.setText("Output Data : "+preferences.getString("data_saya", null) );

    }
}