package com.wrstech.spotour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner sp1, sp2;
    Button btn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = (Spinner)findViewById(R.id.sp1);
        sp2 = (Spinner)findViewById(R.id.sp2);
        btn = (Button)findViewById(R.id.btnchk);

        ArrayAdapter<CharSequence> adp1 = ArrayAdapter.createFromResource(this, R.array.towns, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adp2 = ArrayAdapter.createFromResource(this, R.array.places, android.R.layout.simple_spinner_dropdown_item);

        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp1.setAdapter(adp1);
        sp2.setAdapter(adp2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("town", sp1.getSelectedItem().toString());
                intent.putExtra("place", sp2.getSelectedItem().toString());
                startActivity(intent);

            }
        });
    }


}
