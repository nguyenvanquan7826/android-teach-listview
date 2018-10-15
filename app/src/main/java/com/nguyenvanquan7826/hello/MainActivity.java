package com.nguyenvanquan7826.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvSchool;
    private List<School> schoolDataList = new ArrayList<>();
    private ArrayAdapter<School> adapter;

    private EditText editSchoolName;
    private EditText editSchoolAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSchoolName = findViewById(R.id.editSchoolName);
        editSchoolAddress = findViewById(R.id.editSchoolAddress);

        findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSchool();
            }
        });

        lvSchool = findViewById(R.id.lvSchool);

        adapter = new ArrayAdapter<School>(this, 0, schoolDataList) {

            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.school_item, null);

                TextView tvSchoolName = convertView.findViewById(R.id.tvSchoolName);
                TextView tvSchoolAddress = convertView.findViewById(R.id.tvSchoolAddress);

                School s = schoolDataList.get(position);
                tvSchoolName.setText(s.getName());
                tvSchoolAddress.setText(s.getAddress());

                return convertView;
            }
        };
        lvSchool.setAdapter(adapter);
        lvSchool.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showInfoSchool(position);
            }
        });
    }

    private void addSchool() {
        String name = editSchoolName.getText().toString();
        String address = editSchoolAddress.getText().toString();

        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(address)){
            Toast.makeText(this, "Please enter school name and address", Toast.LENGTH_SHORT).show();
            return;
        }

        School s = new School();
        s.setName(name);
        s.setAddress(address);
        schoolDataList.add(s);

        adapter.notifyDataSetChanged();
    }

    private void showInfoSchool(int position){
        School s = schoolDataList.get(position);

        Intent i = new Intent(this, InfoSchoolActivity.class);

        i.putExtra("name", s.getName());
        i.putExtra("address", s.getAddress());

        startActivity(i);
    }
}