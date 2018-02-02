package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class MMAutoMessageHeardReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String j = t.j(intent, "key_username");
        if (j != null) {
            x.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", new Object[]{j});
            ar.getNotification().cancelNotification(j);
            ar.Hg();
            c.Fd().Xa(j);
        }
    }
}
