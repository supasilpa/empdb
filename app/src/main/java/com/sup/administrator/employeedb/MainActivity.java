package com.sup.administrator.employeedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b;
    String s1,s2,s3,s4,s5,s6,s7;
    dbemp emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.code);
        e2=(EditText)findViewById(R.id.name);
        e3=(EditText)findViewById(R.id.mobile);
        e4=(EditText)findViewById(R.id.email);
        e5=(EditText)findViewById(R.id.desig);
        e6=(EditText)findViewById(R.id.salary);
        e7=(EditText)findViewById(R.id.cn);
        b=(Button) findViewById(R.id.sub);
        emp=new dbemp(this);
        emp.getWritableDatabase();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                s7=e7.getText().toString();
                Log.d("code",s1);
                Log.d("name",s2);
                Log.d("mobile",s3);
                Log.d("email",s4);
                Log.d("desi",s5);
                Log.d("sal",s6);
                Log.d("cn",s7);
                boolean result=emp.insertemp(s1,s2,s3,s4,s5,s6,s7);
                if(result==true)
                {
                    Toast.makeText(getApplicationContext(),"successfull",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
