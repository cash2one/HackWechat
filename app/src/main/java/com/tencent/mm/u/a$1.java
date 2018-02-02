package com.tencent.mm.u;

import android.webkit.ValueCallback;
import com.tencent.mm.u.a.a;

class a$1 implements ValueCallback<String> {
    final /* synthetic */ a gOA;

    a$1(a aVar) {
        this.gOA = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (str == null || !str.contains("11111")) {
            if (this.gOA != null) {
                this.gOA.fq(str);
            }
        } else if (this.gOA != null) {
            this.gOA.BU();
        }
    }
}
