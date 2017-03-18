package com.dhim.root.calcimt;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        // Tab for kalkulasi
        TabSpec tabsatu = tabHost.newTabSpec("Kalkulasi");
        tabsatu.setIndicator("Kalkulasi");
        Intent satuIntent = new Intent(this, ActivitySatu.class);
        tabsatu.setContent(satuIntent);

        // Tab for keterangan
        TabSpec tabdua = tabHost.newTabSpec("Keterangan");
        // setting Title and Icon for the Tab
        tabdua.setIndicator("Keterangan");
        Intent duaIntent = new Intent(this, ActivityDua.class);
        tabdua.setContent(duaIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(tabsatu); // Adding photos tab
        tabHost.addTab(tabdua); // Adding songs tab

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}


