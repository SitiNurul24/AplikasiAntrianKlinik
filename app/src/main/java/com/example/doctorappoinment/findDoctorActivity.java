package com.example.doctorappoinment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class findDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(findDoctorActivity.this,HomeActivity.class));
            }
        });
        CardView familyphysician = findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(findDoctorActivity.this,doctorDetailActivity.class);
                it.putExtra("title","Dokter Umum Dr Harris");
                startActivity(it);
            }
        });
        CardView dietician = findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(findDoctorActivity.this,doctorDetailActivity.class);
                it.putExtra("title","Dokter Umum Dr Tito");
                startActivity(it);
            }
        });
        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(findDoctorActivity.this,doctorDetailActivity.class);
                it.putExtra("title","Dokter Gigi Aulia ");
                startActivity(it);
            }
        });
        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(findDoctorActivity.this, doctorDetailActivity.class);
                it.putExtra("title", "Dokter Gigi Putri");
                startActivity(it);
            }
        });
        CardView cardiologists = findViewById(R.id.cardFDCardiologists);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(findDoctorActivity.this, doctorDetailActivity.class);
                it.putExtra("title", "Dokter Gigi Farida");
                startActivity(it);
            }
        });
    }
}