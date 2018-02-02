package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.booter.MMReceivers.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public class d$a implements a {
    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String stringExtra = intent.getStringExtra("exdevice_process_action_code_key");
            x.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, action %s", new Object[]{stringExtra});
            if (!bh.ov(stringExtra) && stringExtra.equals("action_reload_resources")) {
                String stringExtra2 = intent.getStringExtra("exdevice_language");
                x.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, language %s", new Object[]{stringExtra2});
                Locale UX = w.UX(stringExtra2);
                if ("language_default".equalsIgnoreCase(stringExtra2)) {
                    if (VERSION.SDK_INT >= 24) {
                        UX = w.xfc;
                        Locale.setDefault(UX);
                    } else {
                        UX = Locale.getDefault();
                    }
                }
                w.a(context.getApplicationContext(), UX);
                ac.a(com.tencent.mm.bw.a.a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
            }
        }
    }
}
