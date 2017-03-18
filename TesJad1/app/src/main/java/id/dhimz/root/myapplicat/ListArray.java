package id.dhimz.root.myapplicat;

/**
 * Created by root on 17/03/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ListArray extends Activity {

    String nama_negara;
    TextView namaNegara, infoNegara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // xml layoutnya activity_detail_negara
        setContentView(R.layout.activity_detail_negara);

        // ambil textview nama_negara dan info_negara
        namaNegara = (TextView) findViewById(R.id.nama_negara);
        infoNegara = (TextView) findViewById(R.id.info_negara);

        // ambil parameter nama_negara dari intent
        Intent intent = getIntent();
        nama_negara = intent.getStringExtra("nama_negara");

        // tampilkan nama negara di TextView nama negara
        namaNegara.setText(nama_negara);

        // panggil setInfo(String negara) dan tampilkan ibukotanya
        setInfo(nama_negara);

    }

    /*
     * fungsi setInfo dipakai untuk menambahkan
     * keterangan ibukota propinsi sesuai dengan nama negara
     * yang di klik, silahkan tambah if..else lagi jika ingin
     * info lengkap
     */
    public void setInfo(String negara) {
        if (negara.equalsIgnoreCase("indonesia")) {
            infoNegara.setText("Ibukota jakarta");
        } else if (negara.equalsIgnoreCase("malaysia")) {
            infoNegara.setText("ibukota Kuala lumpur");
        } else {
            infoNegara.setText("ibukota tidak diketahui");
        }
    }
}