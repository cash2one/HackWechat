package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.plugin.record.b.k.d;
import com.tencent.mm.plugin.record.b.k.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class k$1 implements Runnable {
    final /* synthetic */ g pFu;
    final /* synthetic */ k pFv;

    k$1(k kVar, g gVar) {
        this.pFv = kVar;
        this.pFu = gVar;
    }

    public final void run() {
        if (this.pFu != null) {
            if (((e) this.pFv.pFd.get(this.pFu.field_localId)) == null) {
                x.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[]{Integer.valueOf(this.pFu.field_localId), Long.valueOf(this.pFu.field_msgId)});
                this.pFv.pFd.put(this.pFu.field_localId, new e((byte) 0));
            }
            this.pFv.b(this.pFu);
        }
        k kVar = this.pFv;
        if (kVar.pFa) {
            x.d("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
            return;
        }
        g gVar;
        e eVar;
        if (kVar.pFe.isEmpty()) {
            x.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
            for (g gVar2 : n.bmS().bmN()) {
                ar.Hg();
                if (c.Fa().dH(gVar2.field_msgId).getType() != 49) {
                    x.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[]{Integer.valueOf(gVar2.field_localId), Long.valueOf(gVar2.field_msgId)});
                    n.bmS().vq(gVar2.field_localId);
                } else {
                    eVar = (e) kVar.pFd.get(gVar2.field_localId);
                    if (eVar == null) {
                        kVar.pFd.put(gVar2.field_localId, new e((byte) 0));
                    } else if (eVar.ics >= 0 || SystemClock.elapsedRealtime() - eVar.pFh >= 300000) {
                        if (eVar.ics < 0) {
                            eVar.ics = 3;
                        }
                    }
                    x.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[]{Integer.valueOf(gVar2.field_localId), Long.valueOf(gVar2.field_msgId)});
                    kVar.b(gVar2);
                }
            }
        }
        if (kVar.pFe.isEmpty()) {
            x.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
            kVar.finish();
            return;
        }
        boolean z;
        gVar2 = (g) kVar.pFe.removeFirst();
        eVar = (e) kVar.pFd.get(gVar2.field_localId);
        if (eVar == null) {
            eVar = new e((byte) 0);
            kVar.pFd.put(gVar2.field_localId, eVar);
        }
        eVar.ics--;
        if (eVar.ics < 0) {
            if (300000 > SystemClock.elapsedRealtime() - eVar.pFh) {
                z = false;
                if (z) {
                    kVar.a(null);
                    return;
                }
                kVar.pFa = true;
                switch (gVar2.field_type) {
                    case 0:
                        com.tencent.mm.sdk.f.e.post(new d(kVar, gVar2), "RecordMsgSendService_normalDataCopy");
                        return;
                    case 1:
                        com.tencent.mm.sdk.f.e.post(new k.c(kVar, gVar2), "RecordMsgSendService_favDataCopy");
                        return;
                    case 2:
                        com.tencent.mm.sdk.f.e.post(new k$a(kVar, gVar2), "RecordMsgSendService_chatDataCopy");
                        return;
                    case 3:
                        com.tencent.mm.sdk.f.e.post(new k$b(kVar, gVar2), "RecordMsgSendService_chatDataDownLoad");
                        return;
                    default:
                        kVar.pFa = false;
                        return;
                }
            }
            eVar.ics = 2;
        }
        eVar.pFh = SystemClock.elapsedRealtime();
        z = true;
        if (z) {
            kVar.a(null);
            return;
        }
        kVar.pFa = true;
        switch (gVar2.field_type) {
            case 0:
                com.tencent.mm.sdk.f.e.post(new d(kVar, gVar2), "RecordMsgSendService_normalDataCopy");
                return;
            case 1:
                com.tencent.mm.sdk.f.e.post(new k.c(kVar, gVar2), "RecordMsgSendService_favDataCopy");
                return;
            case 2:
                com.tencent.mm.sdk.f.e.post(new k$a(kVar, gVar2), "RecordMsgSendService_chatDataCopy");
                return;
            case 3:
                com.tencent.mm.sdk.f.e.post(new k$b(kVar, gVar2), "RecordMsgSendService_chatDataDownLoad");
                return;
            default:
                kVar.pFa = false;
                return;
        }
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
