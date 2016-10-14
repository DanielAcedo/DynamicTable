package com.danielacedo.dynamictable;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.danielacedo.dynamictable.R.string.txv_Id;

public class DynamicTable_Activity extends AppCompatActivity {

    private TableLayout tbl_Header, tbl_Body;
    private TableRow.LayoutParams tbrLayoutId, tbrLayoutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_table_);

        tbl_Header = (TableLayout)findViewById(R.id.tbl_Header);
        tbl_Body = (TableLayout)findViewById(R.id.tbl_Body);
        tbrLayoutId = new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT);
        tbrLayoutId.setMargins(0, 10, 0, 10);
        tbrLayoutName = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        tbrLayoutName.setMargins(0, 10, 0, 10);
        createHeader();
        createBody();
    }

    private void createHeader(){
        TableRow tbr_Header = new TableRow(this);
        TextView txv_Id = new TextView(this);
        txv_Id.setText(R.string.txv_Id);
        txv_Id.setLayoutParams(tbrLayoutId);
        tbr_Header.addView(txv_Id);

        TextView txv_Name = new TextView(this);
        txv_Name.setText(R.string.txv_Name);
        txv_Name.setLayoutParams(tbrLayoutName);
        tbr_Header.addView(txv_Name);


        tbl_Header.addView(tbr_Header);
    }

    private void createBody(){
        int id = 0;
        String[] names = getResources().getStringArray(R.array.listName);
        TableRow tbr_Body = new TableRow(this);

        for(int i = 0; i<names.length; i++){
            TextView txv_Id = new TextView(this);
            txv_Id.setText(id++);
            txv_Id.setLayoutParams(tbrLayoutId);
            tbr_Body.addView(txv_Id);

            TextView txv_Name = new TextView(this);
            txv_Name.setText(names[i]);
            txv_Name.setLayoutParams(tbrLayoutName);
            tbr_Body.addView(txv_Name);
        }




        tbl_Body.addView(tbr_Body);
    }
}
