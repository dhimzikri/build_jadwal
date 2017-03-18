package com.dhim.root.calcimt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class ActivityDua extends Activity implements View.OnClickListener {
    private AlertDialog.Builder setNegativeButton;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);
        View info = findViewById(R.id.info);
        info.setOnClickListener(this);
       }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.info:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Ini Hanya di buat untuk Menghitung berat badan" +
                        " Created by : " +
                        " Erwin Hermawan (065114006)"       +
                        " Yusuf Ardiansyah (065114008)"     +
                        " Dimas Zikri (065114028)"          +
                        " Riko Andrean (065114013)"         +
                        " Salistiyan Simanungkalit (065114001)" )
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                }
                        );
                AlertDialog judul = builder.create();
                judul.setTitle("CalcIMT");
                judul.show();
                break;
        }
    }


    public AlertDialog.Builder SetNegativeButton(AlertDialog.Builder setNegativeButton2) {
        // TODO Auto-generated method stub}

        AlertDialog.Builder getSetNegativeButton; {
            return setNegativeButton;
        }
    }

    public void setSetNegativeButton(AlertDialog.Builder setNegativeButton) {
        this.setNegativeButton = setNegativeButton;
    }
}
