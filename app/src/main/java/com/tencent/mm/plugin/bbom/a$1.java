package com.tencent.mm.plugin.bbom;

import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bc;

class a$1 implements Runnable {
    final /* synthetic */ a kvu;

    a$1(a aVar) {
        this.kvu = aVar;
    }

    public final void run() {
        bc.hV("ver" + d.vAz);
        an.bip().cv(a.bin().bYI());
        com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.xef;
        if (aVar == null) {
            x.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
            return;
        }
        b gzVar = new gz();
        gzVar.fxh.fxi = true;
        aVar.m(gzVar);
        gzVar = new rd();
        gzVar.fIS.fIT = true;
        aVar.m(gzVar);
        aVar.m(new db());
        aVar.m(new kv());
        q.Qc().id(3);
        x.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
    }

    public final String toString() {
        return super.toString() + "|onGYNetEnd2";
    }
}
