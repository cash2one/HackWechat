package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.d;

class x$1 implements ValueCallback<Boolean> {
    final /* synthetic */ String icE;
    final /* synthetic */ Context rkw;
    final /* synthetic */ String vdY;

    x$1(String str, String str2, Context context) {
        this.icE = str;
        this.vdY = str2;
        this.rkw = context;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            x.access$000(this.icE, this.vdY);
        } else if (d.isTbsCoreInited()) {
            x.fd(this.icE, this.vdY);
        } else {
            x.i("MicroMsg.TBSHelper", "tbs preInit");
            d.a(this.rkw, new 1(this));
        }
    }
}
