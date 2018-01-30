package com.customlistview.monster.toplamaservisi;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class ToplamaService extends IntentService {

    public ToplamaService(){
        super("ToplamaService");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Bundle b = intent.getExtras();
        int s1 = Integer.parseInt(b.getString("sayi1"));
        int s2 = Integer.parseInt(b.getString("sayi2"));
        int res = s1+s2;
        String msg =s1+" + "+s2+" = "+res;

        Intent broadcastintent= new Intent();
        Bundle bsonuc = new Bundle();
        bsonuc.putString("sonuc", msg);
        broadcastintent.putExtras(bsonuc);

        broadcastintent.setAction("TOPLAMA_SONUC_ACTION");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getBaseContext().sendBroadcast(broadcastintent);




    }
}











