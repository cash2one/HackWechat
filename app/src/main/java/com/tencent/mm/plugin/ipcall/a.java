package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements e {
    private static a nBW = null;
    private boolean hjs = false;
    private long nBS = -1;
    private long nBT = -1;
    private long nBU = -1;
    private long nBV = -1;

    static /* synthetic */ void a(a aVar) {
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "updateUsernameAfterGetMFriend");
        aVar.nBU = System.currentTimeMillis();
        ArrayList aUg = i.aTD().aUg();
        if (aUg != null && aUg.size() > 0) {
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "addressitemList.size: %d", new Object[]{Integer.valueOf(aUg.size())});
            long dz = i.aTD().dz(Thread.currentThread().getId());
            Iterator it = aUg.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                String Da = com.tencent.mm.plugin.ipcall.b.a.Da(cVar.field_contactId);
                if (cVar.xjy > 0 && !bh.ov(Da)) {
                    x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username for contactId: %s, newUsername: %s, oldUsername: %s", new Object[]{cVar.field_contactId, Da, cVar.field_wechatUsername});
                    if ((!bh.ov(cVar.field_wechatUsername) && !cVar.field_wechatUsername.equals(Da)) || bh.ov(cVar.field_wechatUsername)) {
                        cVar.field_wechatUsername = Da;
                        i.aTD().a(cVar.xjy, cVar);
                    }
                }
            }
            i.aTD().dA(dz);
        }
        aVar.nBV = System.currentTimeMillis();
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username use %dms", new Object[]{Long.valueOf(aVar.nBV - aVar.nBU)});
        aVar.hjs = false;
        aSO();
    }

    private a() {
    }

    public static a aSN() {
        if (nBW == null) {
            nBW = new a();
        }
        return nBW;
    }

    public final void Wa() {
        if (!com.tencent.mm.plugin.ipcall.b.a.NQ()) {
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
        }
        if (this.hjs) {
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        if (Math.abs(currentTimeMillis - ((Long) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xpf, Long.valueOf(0))).longValue()) >= 86400000) {
            this.hjs = true;
            this.nBS = -1;
            this.nBT = -1;
            this.nBU = -1;
            this.nBV = -1;
            ar.CG().a(32, this);
            com.tencent.mm.sdk.f.e.post(new 1(this), "IPCallAddressBookUpdater_updateUsername");
            return;
        }
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.hjs)});
        if (this.hjs) {
            ar.CG().b(32, this);
            this.nBT = System.currentTimeMillis();
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[]{Long.valueOf(this.nBT - this.nBS)});
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.f.e.post(new 2(this), "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
                return;
            }
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
            this.hjs = false;
            aSO();
        }
    }

    private static void aSO() {
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.xpf, Long.valueOf(currentTimeMillis));
    }
}
