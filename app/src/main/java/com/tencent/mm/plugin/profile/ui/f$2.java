package com.tencent.mm.plugin.profile.ui;

import android.os.Message;
import com.tencent.mm.ay.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class f$2 extends af {
    final /* synthetic */ boolean kCv;
    final /* synthetic */ o kCw = null;

    f$2(boolean z, o oVar) {
        this.kCv = z;
    }

    public final void handleMessage(Message message) {
        int i;
        int Gd = q.Gd();
        if (this.kCv) {
            i = Gd & -8193;
        } else {
            i = Gd | 8192;
        }
        ar.Hg();
        c.CU().set(34, Integer.valueOf(i));
        ar.Hg();
        c.EX().b(new n("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.kCv) {
            com.tencent.mm.modelfriend.af.OE().NG();
            ar.Hg();
            c.CU().set(65828, "");
            ar.Hg();
            c.Fd().WX("facebookapp");
            ar.Hg();
            c.Fa().ED("facebookapp");
        }
        if (this.kCw != null) {
            this.kCw.a(null, null);
        }
    }
}
