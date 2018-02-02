package com.tencent.mm.plugin.masssend.ui;

import android.os.Message;
import com.tencent.mm.ay.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class a$3 extends af {
    final /* synthetic */ boolean kCv;
    final /* synthetic */ o kCw = null;

    a$3(boolean z, o oVar) {
        this.kCv = z;
    }

    public final void handleMessage(Message message) {
        int i;
        int Gd = q.Gd();
        if (this.kCv) {
            i = Gd & -65537;
        } else {
            i = Gd | 65536;
        }
        ar.Hg();
        c.CU().set(34, Integer.valueOf(i));
        ar.Hg();
        c.EX().b(new n("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.kCv) {
            a.aaS();
        }
        if (this.kCw != null) {
            this.kCw.a(null, null);
        }
    }
}
