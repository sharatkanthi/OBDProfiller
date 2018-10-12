package com.example.sharat.obdprofiller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ListUserforOTP extends AppCompatActivity
{
    List userlist;
    DBOpertion listobject = new DBOpertion();
    ListView userlistview = findViewById(R.id.listview);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_userfor_otp);
        userlist = listobject.getuserlist();
        int i=0;
        while(i<userlist.size())
        {
            
        }

    }
}
