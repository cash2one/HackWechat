package com.tencent.liteav.audio.impl;

import android.telephony.TelephonyManager;

class c$2 implements Runnable {
    final /* synthetic */ c a;

    c$2(c cVar) {
        this.a = cVar;
    }

    public void run() {
        if (!(c.a(this.a) == null || c.b(this.a) == null)) {
            ((TelephonyManager) c.b(this.a).getApplicationContext().getSystemService("phone")).listen(c.a(this.a), 0);
        }
        c.a(this.a, null);
    }
}
