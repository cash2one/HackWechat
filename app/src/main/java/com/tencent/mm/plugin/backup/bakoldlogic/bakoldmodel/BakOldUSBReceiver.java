package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public class BakOldUSBReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if ("MMBakchatServiceStart".equalsIgnoreCase(action)) {
                context.startService(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)));
                x.d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
            } else if ("MMBakchatServiceStop".equalsIgnoreCase(action)) {
                b aaVar = new aa();
                aaVar.fnS.fnT = context;
                a.xef.m(aaVar);
                x.d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BakOldUSBReceiver", e, "onReceive:", new Object[0]);
        }
    }
}
