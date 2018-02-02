package com.tencent.mm.plugin.w;

import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.k;
import com.tencent.mm.plugin.backup.h.l;
import com.tencent.mm.plugin.w.c.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

class c$1 implements Runnable {
    final /* synthetic */ LinkedList oFt;
    final /* synthetic */ long oFu;
    final /* synthetic */ c oFv;

    c$1(c cVar, LinkedList linkedList, long j) {
        this.oFv = cVar;
        this.oFt = linkedList;
        this.oFu = j;
    }

    public final void run() {
        long Wp = bh.Wp();
        if (this.oFt == null) {
            x.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizeSessionList is null.");
            if (this.oFv.oFs != null) {
                this.oFv.oFs.onCancel();
                return;
            }
            return;
        }
        e.g(new File(f.bbO()));
        e.g(new File(f.bbP()));
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        e.g(new File(stringBuilder.append(c.FC()).append("msgsynchronize/").toString()));
        stringBuilder = new StringBuilder();
        ar.Hg();
        e.g(new File(stringBuilder.append(c.FC()).append("msgsynchronize.zip").toString()));
        LinkedList linkedList = new LinkedList();
        String str = (String) d.aqe().aqf().CU().get(2, null);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PLong pLong = new PLong();
        Iterator it = this.oFt.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aj WY = d.aqe().aqf().Fd().WY(aVar.kiN);
            int i = WY != null ? WY.field_unReadCount : 0;
            if (pInt2.value >= b.oFp) {
                break;
            }
            k kVar = new k();
            kVar.ksU = aVar.kiN;
            kVar.ksS = (int) (d.aqe().aqf().Fa().ES(aVar.kiN) / 1000);
            kVar.ksT = i;
            linkedList.add(kVar);
            pInt2.value++;
            if (pInt.value < b.oFn) {
                this.oFv.a(aVar, str, i, pInt, pLong, this.oFu);
            }
            if (this.oFv.oFr) {
                break;
            }
        }
        if (this.oFv.oFr) {
            x.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
            return;
        }
        l lVar = new l();
        lVar.ksV = linkedList;
        lVar.ksW = com.tencent.mm.bf.l.Tx().Tl();
        try {
            f.d(f.bbN(), "sessionlist", lVar.toByteArray());
            x.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
        } catch (Exception e) {
            x.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[]{Integer.valueOf(lVar.ksV.size()), e.getMessage()});
        }
        p.a(new File(f.bbO()), false, f.bbP());
        x.i("MicroMsg.MsgSynchronizePack", "synchronize finish, backupCostTime[%d]", new Object[]{Long.valueOf(bh.bz(Wp))});
        long bN = (long) e.bN(f.bbP());
        if (this.oFv.oFs != null) {
            this.oFv.oFs.a(f.bbP(), this.oFt.size(), str, pInt.value, pLong.value, bN / 1024);
        }
    }
}
