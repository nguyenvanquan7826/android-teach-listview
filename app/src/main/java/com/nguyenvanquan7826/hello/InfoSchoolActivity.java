package com.nguyenvanquan7826.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoSchoolActivity extends AppCompatActivity {

    private TextView tvSchoolName;
    private TextView tvSchoolAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_school);

        tvSchoolAddress = findViewById(R.id.tvSchoolAddress);
        tvSchoolName = findViewById(R.id.tvSchoolName);

        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");

        tvSchoolName.setText(name);
        tvSchoolAddress.setText(address);

    }
}
