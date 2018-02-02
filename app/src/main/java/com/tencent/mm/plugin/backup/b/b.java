package com.tencent.mm.plugin.backup.b;

import android.database.Cursor;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.e.h;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.LinkedList;

public final class b {
    public boolean kjf = false;

    public interface a {
        void v(LinkedList<com.tencent.mm.plugin.backup.a.f.b> linkedList);
    }

    public final void cancel() {
        x.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[]{bh.cgy()});
        this.kjf = true;
    }

    public final void a(a aVar) {
        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
        long Wp = bh.Wp();
        LinkedList linkedList = new LinkedList();
        Cursor c = d.aqe().aqf().Fd().c(s.hfk, g.aox(), "*");
        if (c.getCount() == 0) {
            if (aVar != null) {
                ag.y(new 1(this, aVar, linkedList));
            }
            x.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
            c.close();
            return;
        }
        c.moveToFirst();
        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", new Object[]{Integer.valueOf(c.getCount())});
        while (!this.kjf) {
            aj aeVar = new ae();
            aeVar.b(c);
            if (!bh.ov(aeVar.field_username)) {
                if (d.aqe().aqf().Fa().EM(aeVar.field_username) <= 0) {
                    x.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[]{aeVar.field_username});
                } else {
                    ar.Hg();
                    if (com.tencent.mm.storage.x.Dn(c.EY().WO(aeVar.field_username).field_verifyFlag)) {
                        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[]{aeVar.field_username, Integer.valueOf(r5)});
                    } else {
                        com.tencent.mm.plugin.backup.a.f.b bVar = new com.tencent.mm.plugin.backup.a.f.b();
                        bVar.kiP = aeVar.field_username;
                        bVar.kiQ = d.aqe().aqf().Fa().ER(aeVar.field_username);
                        bVar.kiR = d.aqe().aqf().Fa().ES(aeVar.field_username);
                        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[]{bVar.kiP, Integer.valueOf(r5), Long.valueOf(bVar.kiQ), Long.valueOf(bVar.kiR)});
                        linkedList.add(bVar);
                    }
                }
            }
            if (!c.moveToNext()) {
                c.close();
                if (!(this.kjf || aVar == null)) {
                    ag.y(new 2(this, aVar, linkedList));
                }
                x.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[]{Long.valueOf(bh.bz(Wp))});
                return;
            }
        }
        x.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        c.close();
    }

    public final boolean a(com.tencent.mm.plugin.backup.a.f.b bVar, String str, long j) {
        if (bVar == null) {
            return false;
        }
        Cursor EG = d.aqe().aqf().Fa().EG(bVar.kiP);
        x.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[]{bVar.kiP, Integer.valueOf(EG.getCount())});
        if (EG.moveToFirst()) {
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            while (!EG.isAfterLast()) {
                if (this.kjf) {
                    x.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
                    EG.close();
                    return true;
                }
                au auVar = new au();
                auVar.b(EG);
                try {
                    h.a(auVar, true, str, pLong, null, null, false, false, j);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupCalculator", e, "packedMsg", new Object[0]);
                }
                pLong2.value++;
                EG.moveToNext();
            }
            bVar.kiS = pLong.value;
            bVar.kiT = pLong2.value;
            x.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[]{bVar.kiP, Long.valueOf(bVar.kiS), Long.valueOf(bVar.kiT)});
        }
        EG.close();
        return false;
    }
}
