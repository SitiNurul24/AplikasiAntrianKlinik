package com.example.doctorappoinment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class doctorDetailActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name : Dr. Milad Ibnu Harris", "Hospital Address : Sak", "Exp : 5yrs", "Mobile No:9128053575", "600"},
            {"Doctor Name : Dr. Tito Rizal Wahyudi", "Hospital Address : ra", "Exp : 15yrs", "Mobile No:9128053572", "300"},
            {"Doctor Name : Dr. Timy Tri Utami W", "Hospital Address : Sa", "Exp : 8yrs", "Mobile No:9128053570", "900"},
            {"Doctor Name : Drg. Aulia", "Hospital Address : Sak", "Exp : 3yrs", "Mobile No:9128053571", "500"},
            {"Doctor Name : Drg. Farida", "Hospital Address : Sak", "Exp : 2yrs", "Mobile No:9128053573", "400"},
    };

    private String[][] doctor_details2 = {
            {"Doctor Name : Dr. Milad Ibnu Harris", "Hospital Address : Sak", "Exp : 5yrs", "Mobile No:9128053575", "600"},
            {"Doctor Name : Dr. Tito Rizal Wahyudi", "Hospital Address : ra", "Exp : 15yrs", "Mobile No:9128053572", "300"},
            {"Doctor Name : Dr. Timy Tri Utami W", "Hospital Address : Sa", "Exp : 8yrs", "Mobile No:9128053570", "900"},
            {"Doctor Name : Drg. Aulia", "Hospital Address : Sak", "Exp : 3yrs", "Mobile No:9128053571", "500"},
            {"Doctor Name : Drg. Farida", "Hospital Address : Sak", "Exp : 2yrs", "Mobile No:9128053573", "400"},
    };

    private String[][] doctor_details3 = {
            {"Doctor Name : Dr. Milad Ibnu Harris", "Hospital Address : Sak", "Exp : 5yrs", "Mobile No:9128053575", "600"},
            {"Doctor Name : Dr. Tito Rizal Wahyudi", "Hospital Address : ra", "Exp : 15yrs", "Mobile No:9128053572", "300"},
            {"Doctor Name : Dr. Timy Tri Utami W", "Hospital Address : Sa", "Exp : 8yrs", "Mobile No:9128053570", "900"},
            {"Doctor Name : Drg. Aulia", "Hospital Address : Sak", "Exp : 3yrs", "Mobile No:9128053571", "500"},
            {"Doctor Name : Drg. Farida", "Hospital Address : Sak", "Exp : 2yrs", "Mobile No:9128053573", "400"},
    };

    private String[][] doctor_details4 = {
            {"Doctor Name : Dr. Milad Ibnu Harris", "Hospital Address : Sak", "Exp : 5yrs", "Mobile No:9128053575", "600"},
            {"Doctor Name : Dr. Tito Rizal Wahyudi", "Hospital Address : ra", "Exp : 15yrs", "Mobile No:9128053572", "300"},
            {"Doctor Name : Dr. Timy Tri Utami W", "Hospital Address : Sa", "Exp : 8yrs", "Mobile No:9128053570", "900"},
            {"Doctor Name : Drg. Aulia", "Hospital Address : Sak", "Exp : 3yrs", "Mobile No:9128053571", "500"},
            {"Doctor Name : Drg. Farida", "Hospital Address : Sak", "Exp : 2yrs", "Mobile No:9128053573", "400"},
    };

    private String[][] doctor_details5 = {
            {"Doctor Name : Dr. Milad Ibnu Harris", "Hospital Address : Sak", "Exp : 5yrs", "Mobile No:9128053575", "600"},
            {"Doctor Name : Dr. Tito Rizal Wahyudi", "Hospital Address : ra", "Exp : 15yrs", "Mobile No:9128053572", "300"},
            {"Doctor Name : Dr. Timy Tri Utami W", "Hospital Address : Sa", "Exp : 8yrs", "Mobile No:9128053570", "900"},
            {"Doctor Name : Drg. Aulia", "Hospital Address : Sak", "Exp : 3yrs", "Mobile No:9128053571", "500"},
            {"Doctor Name : Drg. Farida", "Hospital Address : Sak", "Exp : 2yrs", "Mobile No:9128053573", "400"},
    };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv = findViewById(R.id.textViewHATitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if (title.equals("Family Physicians"))
            doctor_details = doctor_details1;
        else if (title.equals("Dietician"))
            doctor_details = doctor_details2;
        else if (title.equals("Dentist"))
            doctor_details = doctor_details3;
        else if (title.equals("Surgeon"))
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(doctorDetailActivity.this, findDoctorActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        ListView lst = findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(doctorDetailActivity.this, bookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
                }
            });
        }
    }