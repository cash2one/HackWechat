package com.tencent.mm.u;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.u.b.d;

public final class a {
    public static void a(d dVar, String str, a aVar) {
        if (bh.ov(str)) {
            aVar.fq("");
            return;
        }
        dVar.evaluateJavascript(str + String.format(";var ___result_return = function(){return %d;};___result_return();", new Object[]{Integer.valueOf(11111)}), new 1(aVar));
    }
}
