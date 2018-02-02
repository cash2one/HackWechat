package com.tencent.liteav.audio.impl;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;

class c$1 implements Runnable {
    final /* synthetic */ c a;

    c$1(c cVar) {
        this.a = cVar;
    }

    public void run() {
        if (c.a(this.a) == null) {
            c.a(this.a, new PhoneStateListener(this) {
                final /* synthetic */ c$1 a;

                {
                    this.a = r1;
                }

                public void onCallStateChanged(int i, String str) {
                    super.onCallStateChanged(i, str);
                    TXCLog.i("AudioCenter:TXCTelephonyMgr", "onCallStateChanged:" + i);
                    c.a(this.a.a, i);
                }
            });
            ((TelephonyManager) c.b(this.a).getSystemService("phone")).listen(c.a(this.a), 32);
        }
    }
}
