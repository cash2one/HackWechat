package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static volatile com.tencent.mm.cd.c<f> vaR;
    private final f vaS;

    public c() {
        if (vaR != null) {
            this.vaS = (f) vaR.get();
        } else {
            this.vaS = null;
        }
    }

    public final void bv(Object obj) {
        if (this.vaS != null) {
            this.vaS.bv(obj);
        }
    }

    public final boolean a(ol olVar, boolean z) {
        if (g.Dh().Cy()) {
            long Wp = bh.Wp();
            byte[] a = n.a(olVar.vXq);
            x.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[]{Long.valueOf(Wp), Integer.valueOf(olVar.vXp), Integer.valueOf(bh.bx(a)), Long.valueOf(Thread.currentThread().getId())});
            if (bh.bw(a)) {
                x.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
                return false;
            }
            try {
                if (this.vaS != null) {
                    this.vaS.a(olVar, a, z);
                }
                x.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[]{Long.valueOf(Wp), Integer.valueOf(olVar.vXp), Long.valueOf(bh.bz(Wp))});
                return true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", e, "", new Object[0]);
                return false;
            }
        }
        x.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
        return false;
    }

    public final void bw(Object obj) {
        if (this.vaS != null) {
            this.vaS.bw(obj);
        }
    }

    public final void bx(Object obj) {
        if (this.vaS != null) {
            this.vaS.bx(obj);
        }
    }
}
