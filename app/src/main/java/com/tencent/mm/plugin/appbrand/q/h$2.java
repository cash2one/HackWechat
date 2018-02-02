package com.tencent.mm.plugin.appbrand.q;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.q.h.a;

class h$2 implements ValueCallback<String> {
    final /* synthetic */ a jRZ;

    h$2(a aVar) {
        this.jRZ = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (str == null || !str.contains("11111")) {
            if (this.jRZ != null) {
                this.jRZ.fq(str);
            }
        } else if (this.jRZ != null) {
            this.jRZ.po(str);
        }
    }
}
