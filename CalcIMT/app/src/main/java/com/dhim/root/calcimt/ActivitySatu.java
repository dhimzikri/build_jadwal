package com.dhim.root.calcimt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by root on 24/12/15.
 */

public class ActivitySatu extends Activity implements View.OnClickListener {

    TextView txtBerat, txtTinggi, txtHasil, txtKeterangan1,txtKeterangan2;
    EditText edBerat, edTinggi;
    Button btHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        // TODO auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satu);
        txtBerat = (TextView) findViewById(R.id.txtBerat);
        edBerat = (EditText) findViewById(R.id.edBerat);
        txtTinggi = (TextView) findViewById(R.id.txtTinggi);
        edTinggi = (EditText) findViewById(R.id.edTinggi);
        btHitung = (Button) findViewById(R.id.btHitung);
        txtHasil = (TextView) findViewById(R.id.txtHasil);
        txtKeterangan1 = (TextView) findViewById(R.id.txtKeterangan1);
        txtKeterangan2 = (TextView) findViewById(R.id.txtKeterangan2);


        btHitung.setOnClickListener(this);

    }

    public void onClick(View v) {
        String hasil = " ";
        Double hitung = 0.0;
        if (v.getId() == btHitung.getId()) {
            try {
                Double x1 = Double.parseDouble(edBerat.getText().toString());
                Double x2 = Double.parseDouble(edTinggi.getText().toString());
                Double hitung1 = x2 / 100;
                hitung = (x1 / (hitung1 * hitung1));
                hasil = String.valueOf(hitung);
                // txtHasil = String.valueOf(hasil);


            } catch (Exception e) {
                e.printStackTrace();
            }

            if (hitung <= 18.5) {
                txtKeterangan1.setText(hasil.toString());
                txtKeterangan2.setText("Berat Dibawah Normal".toString());
            } else if (hitung <= 24.5) {
                txtKeterangan1.setText(hasil.toString());
                txtKeterangan2.setText("Normal".toString());
            } else if (hitung <= 29.5) {
                txtKeterangan1.setText(hasil.toString());
                txtKeterangan2.setText("Kelebihan Berat Badan".toString());
            } else if (hitung <= 34.5) {
                txtKeterangan1.setText(hasil.toString());
                txtKeterangan2.setText("Obesitas Tingkat 1".toString());
            } else if (hitung <= 39.5) {
                txtKeterangan1.setText(hasil.toString());
                txtKeterangan2.setText("Obesitas Tingkat 2".toString());
            } else if (hitung > 40) {
                txtKeterangan1.setText(hasil.toString());
                txtKeterangan2.setText("Obesitas Tingkat 3".toString());
            }

        }
    }


    public void hapus (View arg0) {
        edBerat.setText("");
        edTinggi.setText("");
        txtKeterangan1.setText("");
        txtKeterangan2.setText("");
        edTinggi.setFocusable(true);
    }

    public void keluar (View arg0) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        System.exit(0);
    }


    public boolean onCreateOptionMenu(Menu menu) {
        // inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
