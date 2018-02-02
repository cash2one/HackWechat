package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.modelvoice.RemoteController.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public class RemoteController$RemoteControlReceiver extends BroadcastReceiver {
    private static ak fhK;
    private static a hWJ;

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                if (fhK == null && hWJ != null) {
                    x.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
                    fhK = new ak(new 1(this), true);
                }
                if (fhK != null) {
                    fhK.J(1000, 1000);
                    return;
                }
                return;
            }
            x.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + intent.getAction());
        }
    }

    public static void Uv() {
        hWJ = null;
        if (fhK != null) {
            fhK.TG();
            fhK = null;
        }
    }
}
