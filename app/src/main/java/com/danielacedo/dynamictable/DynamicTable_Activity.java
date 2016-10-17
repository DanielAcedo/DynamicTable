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

/**
 * @author Daniel Acedo Calderón
 * @version 1.0
 * Activity that acts as an example of the using of custom shapes and dynamically created table rows
 */
public class DynamicTable_Activity extends AppCompatActivity {

    private TableLayout tbl_Header, tbl_Body;
    private TableRow.LayoutParams tbrLayoutId, tbrLayoutName;
    private TableRow.LayoutParams tbrLayoutHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_table_);

        tbl_Header = (TableLayout)findViewById(R.id.tbl_Header);
        tbl_Body = (TableLayout)findViewById(R.id.tbl_Body);
        tbrLayoutId = new TableRow.LayoutParams(100, TableRow.LayoutParams.MATCH_PARENT);
        tbrLayoutId.setMargins(0, 10, 0, 10);

        tbrLayoutName = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
        tbrLayoutName.setMargins(0, 10, 0, 10);

        tbrLayoutHeader = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
        tbrLayoutHeader.setMargins(0, 10, 0, 10);
        createHeader();
        createBody();
    }

    /**
     * @author Daniel Acedo Calderón
     * Creates the header part of the layout as a separate table
     */
    private void createHeader(){
        TableRow tbr_Header = new TableRow(this);
        tbr_Header.setLayoutParams(tbrLayoutHeader);
        tbr_Header.setPadding(5, 5, 5, 5);
        TextView txv_Id = new TextView(this);
        txv_Id.setText(R.string.txv_Id);
        txv_Id.setLayoutParams(tbrLayoutId);
        txv_Id.setBackgroundResource(R.drawable.shape_header);
        tbr_Header.addView(txv_Id);

        TextView txv_Name = new TextView(this);
        txv_Name.setText(R.string.txv_Name);
        txv_Name.setLayoutParams(tbrLayoutName);
        txv_Name.setBackgroundResource(R.drawable.shape_header);
        tbr_Header.addView(txv_Name);


        tbl_Header.addView(tbr_Header);
    }

    /**
     * @author Daniel Acedo Calderón
     * Creates the body of the layout, creating and adding rows for each entry in an string array
     */
    private void createBody(){
        TableRow tbr_Body;
        TextView txv_Id;
        TextView txv_Name;
        int id = 0;
        String[] names = getResources().getStringArray(R.array.listName);

        for(int i = 0; i<names.length; i++){
            tbr_Body = new TableRow(this);
            tbr_Body.setPadding(5, 5, 5, 5);
            txv_Id = new TextView(this);
            txv_Id.setText(String.valueOf(i+1));
            txv_Id.setLayoutParams(tbrLayoutId);
            txv_Id.setBackgroundResource(R.drawable.shape_body);
            tbr_Body.addView(txv_Id);

            txv_Name = new TextView(this);
            txv_Name.setText(names[i].toString());
            txv_Name.setLayoutParams(tbrLayoutName);
            txv_Name.setBackgroundResource(R.drawable.shape_body);
            tbr_Body.addView(txv_Name);

            tbl_Body.addView(tbr_Body);
        }

    }
}
