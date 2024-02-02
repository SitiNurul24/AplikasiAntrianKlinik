package com.example.doctorappoinment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class buyMedicineActivity extends AppCompatActivity {
    private String[][] packages ={

            {"Itrabat Syrup.","","","","501"},
            {"Furosemidd.","","","","502"},
            {"Calortusin.","","","","503"},
            {"Aspilet.","","","","504"},
            {"Grafazol.","","","","505"},
            {"Dionicol.","","","","506"},
            {"Histigo.","","","","507"},
            {"Librozym.","","","","508"},
            {"Inamid.","","","","509"},

    };
    private String[] package_details ={
            "Itrabat Syrup digunakan untuk mengatasi batuk berdahak \n " +
                    "dengan cara mengencerkan dahak \n" +
                    " dan mempermudah mengeluarkan dahak dari saluran pernapasan.",
            "Obat ini dapat mengiritasi lambung, sebaiknya dikonsumsi setelah makan. \n" +

                    "Obat diuretik yang digunakan untuk menurunkan tekanan darah tinggi, mencegah stroke, serangan jantung, dan gangguan ginjal.\n" +
                    " Tak hanya itu, obat ini juga dapat digunakan untuk meredakan" ,
            "gejala seperti sesak napas serta bengkak pada lengan, kaki, dan perut.\n" +


                    "Obat ini untuk meringankan gejala flu seperti demam, ",
            "sakit kepala, hidung tersumbat, dan bersin-bersin yang disertai batuk., \n " +


                    "Obat ini untuk mencegah terjadinya serangan jantung, angina pekrotis,",
            "atau stroke berulang pada orang yang berisiko mengalaminya. \n" +
                    "Aspilet juga bisa digunakan untuk meredakan demam, sakit kepala, atau sakit gigi. \n" +

            "Grafazole merupakan jenis obat antimikroba yang digunakan untuk mengobati",
            "berbagai macam infeksi yang disebabkan oleh mikroorganisme protozoa dan bakteri anaerob. \n" +
                    "Dalam penggunaan obat ini HARUS SESUAI DENGAN PETUNJUK DOKTER. \n" +

                    "Dionicol merupakan obat antibiotik yang digunakan untuk mengobati infeksi bakteri",
            "pada saluran pernafasan, infeksi saluran pencernaan, \n" +
                    "dan infeksi saluran kemih yang peka terhadap thiamphenicol. \n" +

                    "Obat ini digunakan untuk mengobati Vertigo perifer,",
            "pusing yang berhubungan dengan gangguan keseimbangan yang terjadi pada gangguan sirkulasi darah  \n" +
                    "atau sindrom meniere, penyakit meniere. \n" +

                    "Librozym merupakan suplemen makan untuk memelihara kesehatan",
            "yang dapat digunakan untuk orang sehat. \n" +

                    "Inamid adalah obat yang digunakan untuk mengobati diare akut.",
            "Inamid mengandung loperamide merupakan agonis opioid reseptor yang mekanisme kerjanya mirip dengan morfin \n" +
                    "yaitu mengurangi aktivitas pleksus myentric usus besar sehingga memperlambat ritme kontraksi usus."


    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewHA);
        btnBack= findViewById(R.id.buttonHABack);
        btnGoToCart= findViewById(R.id.buttonBMCartBack);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(buyMedicineActivity.this,cartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(buyMedicineActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<packages.length;i++) {
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" +packages[i][4]+"/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(buyMedicineActivity.this,buyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}