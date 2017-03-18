package id.dhimz.root.myapplicat;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BuatTgs extends Activity implements OnClickListener {
    protected Cursor cursor;
    DB_helper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text4, tglTgs, deadLtgs;
    private DatePickerDialog fromDate;
    private DatePickerDialog toDate;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buat_tgs);
        dateFormatter = new SimpleDateFormat("dd-MM-yyy", Locale.US);
        findViewsById();
        setDateTimeField();

        dbHelper = new DB_helper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        tglTgs = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        deadLtgs = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into tugas(no, nama_tugas, tgl, matkul, deadline) values('" +
                        text1.getText().toString()+"','"+
                        text2.getText().toString()+"','" +
                        tglTgs.getText().toString()+"','"+
                        text4.getText().toString()+"','" +
                        deadLtgs.getText().toString()+ "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                TabTugas.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    private void findViewsById() {
        tglTgs = (EditText) findViewById(R.id.editText3);
        tglTgs.setInputType(InputType.TYPE_NULL);
        tglTgs.requestFocus();
        deadLtgs = (EditText) findViewById(R.id.editText5);
        deadLtgs.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {
        tglTgs.setOnClickListener(this);
        deadLtgs.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDate = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tglTgs.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDate = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                deadLtgs.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == tglTgs) {
            fromDate.show();
        } else if (view == deadLtgs) {
            toDate.show();
        }
    }
}