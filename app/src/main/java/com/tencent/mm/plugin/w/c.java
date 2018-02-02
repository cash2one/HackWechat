package com.tencent.mm.plugin.w;

import android.database.Cursor;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.w.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public final class c {
    public boolean oFr = false;
    public a oFs;

    public final void b(LinkedList<a> linkedList, long j) {
        e.d(new 1(this, linkedList, j), "msgSynchronizePackThread", 10).start();
    }

    public final boolean a(a aVar, String str, int i, PInt pInt, PLong pLong, long j) {
        ar.Hg();
        if (x.Dn(com.tencent.mm.z.c.EY().WO(aVar.kiN).field_verifyFlag)) {
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MsgSynchronizePack", "summerbak backupChatMsg convName:%s, unReadCount:%d", new Object[]{aVar.kiN, Integer.valueOf(i)});
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Cursor f = d.aqe().aqf().Fa().f(aVar.kiN, b.oFo, ((h) g.h(h.class)).FJ().Es(aVar.kiN));
        while (f.moveToNext()) {
            if (this.oFr) {
                f.close();
                return false;
            }
            cf auVar = new au();
            auVar.b(f);
            if ((j >= 0 && auVar.field_createTime >= j) || j < 0) {
                linkedList2.add(auVar);
            }
        }
        f.close();
        int i2 = 0;
        int i3 = i;
        while (i2 < linkedList2.size()) {
            Object a;
            int i4;
            try {
                a = com.tencent.mm.plugin.backup.e.h.a((au) linkedList2.get(i2), false, str, new PLong(), new LinkedList(), null, i3 > 0, true, 0);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MsgSynchronizePack", e, "backupChatMsg", new Object[0]);
                a = null;
            }
            if (a != null) {
                linkedList.add(a);
                pLong.value++;
                i4 = i3 - 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        es esVar = new es();
        esVar.ksP = linkedList;
        esVar.ksO = linkedList.size();
        try {
            f.d(f.bbN(), "MSG_" + linkedList.size() + "_" + aVar.kiN + "_" + bh.Wp(), esVar.toByteArray());
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MsgSynchronizePack", "add MsgSynchronize, tagTextClientId:%s", new Object[]{r4});
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MsgSynchronizePack", "ERROR: BakChatMsgList to Buffer list:%d :%s", new Object[]{Integer.valueOf(esVar.ksO), e2.getMessage()});
        }
        pInt.value++;
        return true;
    }
}
