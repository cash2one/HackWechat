package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.by.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ao;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bs.a;
import java.util.HashMap;

public final class g implements ap {
    private a kur = new 1(this);
    private f tOo = new f();
    private a tOp;
    private ao tOq = new 2(this);
    private c tOr = new 3(this);
    private q tOs = new 4(this);

    public static g bVr() {
        ar.Ha();
        g gVar = (g) bp.hY("plugin.webwx");
        if (gVar != null) {
            return gVar;
        }
        Object gVar2 = new g();
        ar.Ha().a("plugin.webwx", gVar2);
        return gVar2;
    }

    public final void onAccountRelease() {
        d.c.b(Integer.valueOf(51), this.tOo);
        ar.getSysCmdMsgExtension().b("pushloginurl", this.kur, true);
        ar.Hg();
        com.tencent.mm.z.c.b(this.tOq);
        com.tencent.mm.sdk.b.a.xef.c(this.tOr);
        bVs();
        if (this.tOp != null) {
            Object obj = this.tOp;
            o.TU().a(obj);
            com.tencent.mm.kernel.g.CG().b(221, obj);
        }
        s.a(this.tOs);
    }

    public final HashMap<Integer, h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        d.c.a(Integer.valueOf(51), this.tOo);
        ar.getSysCmdMsgExtension().a("pushloginurl", this.kur, true);
        ar.Hg();
        com.tencent.mm.z.c.a(this.tOq);
        com.tencent.mm.sdk.b.a.xef.b(this.tOr);
        this.tOp = null;
        s.a(5, this.tOs);
    }

    public final void br(boolean z) {
    }

    static void bVs() {
        ar.getNotification().cancel(38);
    }

    public final a bVt() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (this.tOp == null) {
            this.tOp = new a();
        }
        return this.tOp;
    }
}
