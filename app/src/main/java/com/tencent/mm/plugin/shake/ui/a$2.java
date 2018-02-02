package com.tencent.mm.plugin.shake.ui;

import android.os.Message;
import com.tencent.mm.ay.n;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class a$2 extends af {
    final /* synthetic */ boolean kCv;
    final /* synthetic */ o kCw = null;

    a$2(boolean z, o oVar) {
        this.kCv = z;
    }

    public final void handleMessage(Message message) {
        int i;
        int Gd = q.Gd();
        if (this.kCv) {
            i = Gd & -257;
        } else {
            i = Gd | 256;
        }
        x.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", new Object[]{Boolean.valueOf(this.kCv), Integer.valueOf(Gd), Integer.valueOf(i)});
        ar.Hg();
        c.CU().set(34, Integer.valueOf(i));
        ar.Hg();
        c.EX().b(new n("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.kCv) {
            m.brF();
        }
        if (this.kCw != null) {
            this.kCw.a(null, null);
        }
    }
}
