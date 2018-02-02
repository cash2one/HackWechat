package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    private static c nCo = new 1();

    static /* synthetic */ void ub() {
        try {
            if (ar.Hj()) {
                x.d("MicroMsg.IPCallAddressUpdater", "start updateAddressStorage");
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.plugin.ipcall.a.g.b bVar = new com.tencent.mm.plugin.ipcall.a.g.b();
                ArrayList aUg = i.aTD().aUg();
                if (aUg != null && aUg.size() > 0) {
                    HashMap aUf = com.tencent.mm.plugin.ipcall.a.g.b.aUf();
                    if (aUf != null && aUf.size() >= 0) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar;
                        long dz = i.aTD().dz(Thread.currentThread().getId());
                        x.d("MicroMsg.IPCallAddressUpdater", "start delete not exist address");
                        x.d("MicroMsg.IPCallAddressUpdater", "oldItemList.size: %d", new Object[]{Integer.valueOf(aUg.size())});
                        Iterator it = aUg.iterator();
                        while (it.hasNext()) {
                            cVar = (com.tencent.mm.plugin.ipcall.a.g.c) it.next();
                            if (!aUf.containsKey(cVar.field_contactId)) {
                                long j = cVar.xjy;
                                i.aTD().delete(j);
                                x.d("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord, id: %d", new Object[]{Long.valueOf(j)});
                                Cursor dB = i.aTE().dB(j);
                                if (dB != null) {
                                    try {
                                        if (dB.moveToFirst()) {
                                            while (!dB.isAfterLast()) {
                                                k kVar = new k();
                                                kVar.b(dB);
                                                kVar.field_addressId = -1;
                                                kVar.field_phoneType = -1;
                                                i.aTE().a(kVar);
                                                dB.moveToNext();
                                            }
                                        }
                                    } catch (Exception e) {
                                        x.e("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord error: %s", new Object[]{e.getMessage()});
                                        if (dB != null) {
                                            dB.close();
                                        } else {
                                            continue;
                                        }
                                    } catch (Throwable th) {
                                        if (dB != null) {
                                            dB.close();
                                        }
                                    }
                                }
                                if (dB != null) {
                                    dB.close();
                                } else {
                                    continue;
                                }
                            }
                        }
                        x.d("MicroMsg.IPCallAddressUpdater", "start update or insert address");
                        for (com.tencent.mm.plugin.ipcall.a.g.c cVar2 : aUf.values()) {
                            com.tencent.mm.plugin.ipcall.a.g.c CD = i.aTD().CD(cVar2.field_contactId);
                            if (CD == null || CD.xjy == -1) {
                                i.aTD().b(cVar2);
                            } else {
                                Object obj = (cVar2 != null && com.tencent.mm.plugin.ipcall.a.g.c.cV(CD.field_contactId, cVar2.field_contactId) && com.tencent.mm.plugin.ipcall.a.g.c.cV(CD.field_systemAddressBookUsername, cVar2.field_systemAddressBookUsername) && com.tencent.mm.plugin.ipcall.a.g.c.cV(CD.field_wechatUsername, cVar2.field_wechatUsername)) ? 1 : null;
                                if (obj == null) {
                                    i.aTD().a(CD.xjy, cVar2);
                                }
                            }
                        }
                        i.aTD().dA(dz);
                        x.d("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return;
                    }
                    return;
                }
                return;
            }
            x.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, acc not ready");
        } catch (Exception e2) {
            x.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage error:" + e2.getMessage());
        }
    }

    public static void init() {
        a.xef.b(nCo);
    }

    public static void release() {
        a.xef.c(nCo);
    }
}
