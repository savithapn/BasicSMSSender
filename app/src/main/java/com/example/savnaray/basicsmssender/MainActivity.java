package com.example.savnaray.basicsmssender;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Button btnSendSms;
    EditText lMessage,lNumber ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         lMessage =(EditText)findViewById(R.id.textMessage);


        lNumber = (EditText)findViewById(R.id.textNumber);


        btnSendSms = (Button) findViewById(R.id.btnSendSMS);
        btnSendSms.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                String message= lMessage.getText().toString();
                String phoneNumber = lNumber.getText().toString();
                sendSMS(phoneNumber,message);

            }
        });
    }

    private void sendSMS(String phoneNumber,String message)
    {
        SmsManager sms= SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber,null,message,null,null);
        Toast.makeText(getApplicationContext(),"Sent successfully",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
