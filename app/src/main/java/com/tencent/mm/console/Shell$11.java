package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.g.a.if;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class Shell$11 implements Shell$a {
    Shell$11() {
    }

    public final void m(Intent intent) {
        b ifVar = new if();
        ifVar.fyD.fyI = intent.getExtras().getString("path", "/data/local/tmp/test.apk");
        x.w("MicroMsg.Shell", "hotpatch test [%s]", new Object[]{ifVar.fyD.fyI});
        a.xef.m(ifVar);
    }
}
