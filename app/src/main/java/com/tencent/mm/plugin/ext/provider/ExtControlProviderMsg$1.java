package com.tencent.mm.plugin.ext.provider;

import android.database.MatrixCursor;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderMsg$1 implements Runnable {
    final /* synthetic */ String[] gIP;
    final /* synthetic */ b kvk;
    final /* synthetic */ int maw;
    final /* synthetic */ long may;
    final /* synthetic */ ExtControlProviderMsg maz;

    ExtControlProviderMsg$1(ExtControlProviderMsg extControlProviderMsg, int i, long j, b bVar, String[] strArr) {
        this.maz = extControlProviderMsg;
        this.maw = i;
        this.may = j;
        this.kvk = bVar;
        this.gIP = strArr;
    }

    public final void run() {
        if (this.maw == 1) {
            com.tencent.mm.plugin.ext.b.aFz();
            af cM = com.tencent.mm.plugin.ext.b.cM(this.may);
            if (cM == null || ((int) cM.gJd) <= 0) {
                this.maz.pp(3);
                this.kvk.countDown();
                return;
            }
            com.tencent.mm.sdk.b.b faVar = new fa();
            faVar.ftY.op = 1;
            faVar.ftY.username = cM.field_username;
            if (a.xef.m(faVar)) {
                ExtControlProviderMsg.a(this.maz, new MatrixCursor(ExtControlProviderMsg.aFP()));
                if (cM == null || ((int) cM.gJd) <= 0 || !faVar.ftZ.fpW) {
                    ExtControlProviderMsg.a(this.maz).addRow(new Object[]{this.gIP[1], Integer.valueOf(2), "0"});
                    this.maz.pp(3);
                } else {
                    ExtControlProviderMsg.a(this.maz).addRow(new Object[]{this.gIP[1], Integer.valueOf(1), "0"});
                    this.maz.pp(0);
                }
                x.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[]{Boolean.valueOf(faVar.ftZ.fpW), faVar.ftZ.fileName});
            } else {
                this.maz.pp(4);
                this.kvk.countDown();
                return;
            }
        } else if (this.maw == 2) {
            com.tencent.mm.sdk.b.b faVar2 = new fa();
            faVar2.ftY.op = 2;
            if (a.xef.m(faVar2)) {
                String str = faVar2.ftZ.fileName;
                ExtControlProviderMsg.a(this.maz, new MatrixCursor(ExtControlProviderMsg.aFP()));
                com.tencent.mm.sdk.b.b fgVar = new fg();
                fgVar.fuv.fileName = str;
                if (a.xef.m(fgVar)) {
                    x.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[]{Long.valueOf(fgVar.fuw.fqm)});
                    if (fgVar.fuw.fqm > 0) {
                        try {
                            if (!faVar2.ftZ.fpW) {
                                ExtControlProviderMsg.a(this.maz).addRow(new Object[]{this.gIP[1], Integer.valueOf(4), com.tencent.mm.plugin.ext.a.a.cO(r2)});
                                this.maz.pp(4);
                            } else if (ac.getContext() == null || !an.isConnected(ac.getContext())) {
                                ExtControlProviderMsg.a(this.maz).addRow(new Object[]{this.gIP[1], Integer.valueOf(6), com.tencent.mm.plugin.ext.a.a.cO(r2)});
                                this.maz.pp(4);
                            } else {
                                ExtControlProviderMsg.a(this.maz).addRow(new Object[]{this.gIP[1], Integer.valueOf(1), com.tencent.mm.plugin.ext.a.a.cO(r2)});
                                this.maz.pp(0);
                            }
                        } catch (Throwable e) {
                            x.w("MicroMsg.ExtControlProviderMsg", e.getMessage());
                            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                            this.maz.pp(4);
                        }
                    } else {
                        this.maz.pp(3);
                    }
                } else {
                    this.maz.pp(4);
                    ExtControlProviderMsg.a(this.maz).close();
                    this.kvk.countDown();
                    return;
                }
            }
            this.maz.pp(4);
            this.kvk.countDown();
            return;
        }
        this.kvk.countDown();
    }
}
