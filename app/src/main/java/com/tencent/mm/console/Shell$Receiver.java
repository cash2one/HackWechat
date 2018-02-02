package com.tencent.mm.console;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.console.Shell.a;
import com.tencent.mm.sdk.platformtools.x;

public class Shell$Receiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        a aVar = (a) Shell.Ab().get(intent.getAction());
        if (aVar == null) {
            x.e("MicroMsg.Shell", "no action found for %s", new Object[]{r1});
            return;
        }
        x.e("MicroMsg.Shell", "shell action %s", new Object[]{r1});
        aVar.m(intent);
    }
}
