package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.f;

class a$1 implements Runnable {
    final /* synthetic */ String[] gIP;
    final /* synthetic */ a iSP;

    a$1(a aVar, String[] strArr) {
        this.iSP = aVar;
        this.gIP = strArr;
    }

    public final void run() {
        String str = "com.tencent.mm";
        if (this.gIP.length > 2 && !TextUtils.isEmpty(this.gIP[2])) {
            str = str + ":" + this.gIP[2];
        }
        f.a(str, null, a$a.class, null);
    }
}
