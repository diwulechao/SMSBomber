package com.example.wudi.sms;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.igexin.sdk.PushService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) this.findViewById(R.id.start);
        Button stopButton = (Button) this.findViewById(R.id.stop);

        final EditText number = (EditText) this.findViewById(R.id.number);
        number.setText(Utils.getNumber(MainActivity.this));

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mySharedPreferences = getSharedPreferences("test",
                        Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                editor.putString("number", number.getText().toString());
                editor.commit();

                AlarmManagerBroadcastReceiver.SetAlarm(MainActivity.this);


            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManagerBroadcastReceiver.CancelAlarm(MainActivity.this);
                SharedPreferences mySharedPreferences = getSharedPreferences("test",
                        Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                editor.putString("number", "");
                editor.commit();

            }
        });
    }
}
