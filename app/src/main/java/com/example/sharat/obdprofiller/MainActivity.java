package com.example.sharat.obdprofiller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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
            String uid = userid.getText().toString();
            String pas = pass.getText().toString().trim();

            @Override
            public void onClick(View view)
            {
                //////////////////////////////////////////////////////////////////////////////////////////////////////////*/
                Log.w("Main activity","DB Object initiating with user | pass" + uid +" | "+ pas );
                Log.w("Main activity", uid  );

                DBOpertion conn = new DBOpertion();
                String logintype = conn.DBOpertion_getID(uid,pas);
                Log.w("Main activity","Type captured : " + logintype );
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            }
        });
    }

}
