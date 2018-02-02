package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.e;
import com.tencent.mm.by.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.HashMap;

public final class w implements ap {
    private p ppV;
    private b ppW = new b();
    private v ppt;

    private static w bkr() {
        ar.Ha();
        w wVar = (w) bp.hY("plugin.qqmail");
        if (wVar != null) {
            return wVar;
        }
        Object wVar2 = new w();
        ar.Ha().a("plugin.qqmail", wVar2);
        return wVar2;
    }

    public static p bks() {
        g.Dh().Ct();
        if (bkr().ppV == null) {
            bkr().ppV = new p(d.vAz, d.DEVICE_TYPE);
        }
        return bkr().ppV;
    }

    public static v bkt() {
        g.Dh().Ct();
        if (bkr().ppt == null) {
            bkr().ppt = new v();
        }
        return bkr().ppt;
    }

    public final void onAccountRelease() {
        p pVar = bkr().ppV;
        if (pVar != null) {
            pVar.reset();
        }
        a.xef.c(this.ppW);
    }

    public final HashMap<Integer, h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
        if ((i & 1) != 0) {
            bku();
        }
    }

    public static void bku() {
        ba.hS("qqmail");
        ar.Hg();
        c.Fd().WX("qqmail");
        p bks = bks();
        ar.Hg();
        e.g(new File(c.Fq()));
        bks.reset();
    }

    public final void bq(boolean z) {
        a.xef.b(this.ppW);
        ar.Dm().F(new 1(this));
    }

    public final void br(boolean z) {
    }
}
