package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.console.Shell.a;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class Shell$6 implements a {
    Shell$6() {
    }

    public final void m(Intent intent) {
        r.idt = intent.getIntExtra("key", 0);
        r.idu = intent.getIntExtra("val", 0);
        r.idv = intent.getStringExtra("str");
        x.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", new Object[]{Integer.valueOf(r.idt), Integer.valueOf(r.idu), r.idv});
        if (10009 == r.idt) {
            int i = r.idu;
            Shell.Aa();
        } else if (10014 == r.idt && ac.cfw()) {
            q.Qc().a(7, 1, "");
        } else if (10015 == r.idt && ac.cfx()) {
            b gkVar = new gk();
            gkVar.fwx.type = 13;
            com.tencent.mm.sdk.b.a.xef.m(gkVar);
        }
    }
}
