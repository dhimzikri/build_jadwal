package id.dhimz.root.myapplicat;

/**
 * Created by root on 17/03/17.
 */
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class TabJadwal extends Activity {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    // ArrayList for Listview
    ArrayList<HashMap<String, String>> negaraList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_hari);

        // Data Array yang akan ditampilkan di list
        String negara[] = {"Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu"};
        // ambil list_view dan inputsearchnya di xml
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // proses menambahkan array kedalam listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item_filter,
                R.id.negara_name, negara);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama_negara = lv.getItemAtPosition(position).toString();
                Intent intent = new Intent(getApplicationContext(), DetailNegaraActivity.class);
                intent.putExtra("nama_negara", nama_negara);
                startActivity(intent);

            }
        });

        /**
         * Kode dibawah ini dipakai untuk memfilter/pencarian realtime
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                TabJadwal.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
}