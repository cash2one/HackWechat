package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mm.plugin.wear.model.e.a;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;

public class WearMessageLogic extends BroadcastReceiver {
    public WearMessageLogic() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.wear.message");
        ac.getContext().registerReceiver(this, intentFilter, "com.tencent.mm.wear.message", null);
    }

    public void onReceive(Context context, Intent intent) {
        byte b = (byte) 0;
        if (intent.getAction().equals("com.tencent.mm.wear.message")) {
            Bundle extras = intent.getExtras();
            int i = extras.getInt("key_connecttype");
            if (i == 1) {
                Runnable aVar = new a(this, (byte) 0);
                aVar.tio = i;
                aVar.tip = extras.getInt("key_funid");
                aVar.pSO = extras.getInt("key_sessionid");
                aVar.tiq = extras.getByteArray("key_data");
                a zE = a.bOt().thF.zE(aVar.tip);
                if (zE != null) {
                    b = zE.zD(aVar.tip);
                }
                if (b != (byte) 0) {
                    ag.y(aVar);
                } else {
                    e.post(aVar, "WearHttpMessageTask_" + aVar.tip);
                }
            } else if (i == 2) {
                d bVar = new b(this, (byte) 0);
                bVar.tio = i;
                bVar.tip = extras.getInt("key_funid");
                bVar.pSO = extras.getInt("key_sessionid");
                bVar.tiq = extras.getByteArray("key_data");
                a.bOt().thN.a(bVar);
            } else if (i == 3) {
                a.bOt().thN.a(new c(this, (byte) 0));
            }
        }
    }
}
