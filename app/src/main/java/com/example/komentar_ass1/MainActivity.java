package com.example.komentar_ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText komentarText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentarText= findViewById(R.id.komentar_text);
    }

    @Override
    protected void onStart() {
        Toast.makeText(this,"OnStart", Toast.LENGTH_SHORT);
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this,"OnStart", Toast.LENGTH_SHORT);
        saveDataKomentar(komentarText.getText().toString());
        super.onStop();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this,"OnPause", Toast.LENGTH_SHORT);
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this,"OnResume", Toast.LENGTH_SHORT);
        String datakomentar = ambilDataKomentar();
        komentarText.setText(datakomentar);
        super.onResume();
    }

    private void saveDataKomentar(String value){
        SharedPreferences.Editor editor=this.getSharedPreferences("komentar", Context.MODE_PRIVATE).edit();
        editor.putString("keykomentar", value);
        editor.commit();
    }

    private String ambilDataKomentar(){
        String result = this.getSharedPreferences("komentar", Context.MODE_PRIVATE).getString("keykomentar", null);

        return result;
    }
}