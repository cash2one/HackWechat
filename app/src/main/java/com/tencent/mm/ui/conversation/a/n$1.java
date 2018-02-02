package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.x;

class n$1 extends c<kc> {
    final /* synthetic */ n zby;

    n$1(n nVar) {
        this.zby = nVar;
        this.xen = kc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        kc kcVar = (kc) bVar;
        x.v("MicroMsg.NetWarnView", "diagnose callback, stage:%d, status:%d", Integer.valueOf(kcVar.fBr.fBs), Integer.valueOf(kcVar.fBr.status));
        n nVar;
        if (kcVar.fBr.fBs == 0) {
            this.zby.zbq = 33;
            nVar = this.zby;
            if (kcVar.fBr.status != 0) {
                z = false;
            }
            nVar.zbr = z;
        } else if (kcVar.fBr.fBs == 1) {
            this.zby.zbq = 66;
            nVar = this.zby;
            if (kcVar.fBr.status != 0) {
                z = false;
            }
            nVar.zbs = z;
        } else if (kcVar.fBr.fBs == 2) {
            nVar = this.zby;
            if (kcVar.fBr.status != 0) {
                z = false;
            }
            nVar.zbt = z;
        }
        if (kcVar.fBr.fBt) {
            this.zby.zbq = 0;
            this.zby.sfj = 0;
            this.zby.zbu = kcVar.fBr.fBu;
            this.zby.cwR();
            ag.y(new Runnable(this) {
                final /* synthetic */ n$1 zbz;

                {
                    this.zbz = r1;
                }

                public final void run() {
                    x.i("MicroMsg.NetWarnView", "curr top activity is: %s", m.by((Context) this.zbz.zby.voC.get()));
                    if (!m.by((Context) this.zbz.zby.voC.get()).endsWith("NetworkDiagnoseAllInOneUI")) {
                        int i;
                        if (this.zbz.zby.zbr) {
                            i = 2;
                        } else if (this.zbz.zby.zbs) {
                            i = 4;
                        } else if (this.zbz.zby.zbt) {
                            i = 5;
                        } else {
                            i = 3;
                        }
                        n.a(this.zbz.zby, i);
                    }
                }
            });
        }
        ag.y(new 2(this));
        return false;
    }
}
