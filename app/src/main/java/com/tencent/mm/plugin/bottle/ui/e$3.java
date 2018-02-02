package com.tencent.mm.plugin.bottle.ui;

import android.os.Message;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.n;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class e$3 extends af {
    final /* synthetic */ boolean kCv;
    final /* synthetic */ o kCw = null;

    e$3(boolean z, o oVar) {
        this.kCv = z;
    }

    public final void handleMessage(Message message) {
        int i;
        int i2;
        boolean z = this.kCv;
        int FW = q.FW();
        int Gd = q.Gd();
        if (z) {
            i = FW | Downloads.RECV_BUFFER_SIZE;
            i2 = Gd & -65;
            ar.Hg();
            c.EX().b(new g(11, 1));
        } else {
            i = FW & -4097;
            i2 = Gd | 64;
            ar.Hg();
            c.EX().b(new g(11, 2));
        }
        ar.Hg();
        c.CU().set(7, Integer.valueOf(i));
        ar.Hg();
        c.CU().set(34, Integer.valueOf(i2));
        ar.Hg();
        c.EX().b(new n("", "", "", "", "", "", "", "", i2, "", ""));
        if (!this.kCv) {
            i.arH();
        }
        if (this.kCw != null) {
            this.kCw.a(null, null);
        }
    }
}
