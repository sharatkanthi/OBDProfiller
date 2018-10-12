package com.example.sharat.obdprofiller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Thread.sleep;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginbutton = findViewById(R.id.button);


        loginbutton.setOnClickListener(new View.OnClickListener()
        {
            EditText userid = findViewById(R.id.editText6);
            EditText pass = findViewById(R.id.editText8);


            @Override
            public void onClick(View view)
            {
                //////////////////////////////////////////////////////////////////////////////////////////////////////////*/
                String uid = userid.getText().toString();
                String pas = pass.getText().toString().trim();
                Log.w("Main activity","DB Object initiating with user | pass " + uid +" | "+ pas );
                Log.w("Main activity", uid  );

                DBOpertion conn = new DBOpertion();
                String logintype = conn.DBOpertion_getID(uid,pas);
                Log.w("Main activity","Type captured : " + logintype );

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.w("Main activity","Trying to match login type with admin : logintype = " + logintype );
                logintype="admin";
                if(logintype == "admin")
                {
                    Log.w("Main activity","Type matched with admin: " );

                    Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(i);
                }
                else
                {
                    Log.w("Main activity","No type match found " );

                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            }
        });
    }

}
