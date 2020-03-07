
package com.example.sugar_orm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
Button btnDelete;
    EditText password;

    ListView mListView;
TextView txt;
    ArrayAdapter<Login> adapter;

    Login login = new Login();
   // Login login1= new Login();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView2);
        password = (EditText) findViewById(R.id.t1);



        btnSave = (Button) findViewById(R.id.s12);

        btnDelete = (Button) findViewById(R.id.button3);

        mListView = (ListView) findViewById(R.id.l1);


        final List<Login> list = Login.listAll(Login.class);


        adapter = new ArrayAdapter<Login>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, list);


        mListView.setAdapter(adapter);


        Toast.makeText(getApplicationContext(), "" + list, Toast.LENGTH_LONG).show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                login = new Login(password.getText().toString());


                List<Login> allLogin = Login.listAll(Login.class);


                login.save();

                Toast.makeText(getApplicationContext(), "" + allLogin, Toast.LENGTH_LONG).show();


                txt.setText(allLogin.toString());

            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                List<Login> allLogin = Login.listAll(Login.class);

                Login.deleteAll(Login.class);


                Toast.makeText(getApplicationContext(), ""+allLogin,Toast.LENGTH_LONG).show();


                txt.setText(allLogin.toString());

            }
        });


    }
}