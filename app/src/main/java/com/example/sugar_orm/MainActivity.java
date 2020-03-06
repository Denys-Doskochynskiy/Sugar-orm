package com.example.sugar_orm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnSave;

    EditText password;

    ListView mListView;

    ArrayAdapter<Login> adapter;

    Login login = new Login();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = (EditText) findViewById(R.id.t1);

        btnSave = (Button) findViewById(R.id.s1);

        mListView = (ListView) findViewById(R.id.l1);


        List<Login> list = Login.listAll(Login.class);

        adapter = new ArrayAdapter<Login>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, list);

        mListView.setAdapter(adapter);


        Toast.makeText(getApplicationContext(), ""+ list,Toast.LENGTH_LONG).show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                login = new Login(password.getText().toString());
                login.save();

                Toast.makeText(getApplicationContext(), ""+login,Toast.LENGTH_LONG).show();




            }
        });

    }
}
