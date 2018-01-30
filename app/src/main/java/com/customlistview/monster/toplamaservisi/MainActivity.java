package com.customlistview.monster.toplamaservisi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    IntentFilter intentFilter;
    EditText etSayi1, etSayi2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSayi1 = (EditText)findViewById(R.id.etSayi1);
        etSayi2 = (EditText)findViewById(R.id.etSayi2);

        intentFilter = new IntentFilter();
        intentFilter.addAction("TOPLAMA_SONUC_ACTION");
        registerReceiver(mIntentReceiver,intentFilter);

    }
    private BroadcastReceiver mIntentReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle b = intent.getExtras();
            String msg = b.getString("sonuc");
            Toast.makeText(MainActivity.this, msg,Toast.LENGTH_LONG).show();
        }
    };

    public void topla(View view){
        String s1 = etSayi1.getText().toString();
        String s2 = etSayi2.getText().toString();

        Intent intent = new Intent(this,ToplamaService.class);
        Bundle b = new Bundle();
        b.putString("sayi1",s1);
        b.putString("sayi2",s2);
        intent.putExtras(b);

        startService(intent);
    }
}
