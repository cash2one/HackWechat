package com.tencent.mm.booter.notification;

import com.tencent.mm.booter.notification.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    public e gAh;

    private f() {
        this.gAh = new e();
    }

    public final boolean a(String str, au auVar, int i, boolean z) {
        if (bh.ov(str)) {
            return false;
        }
        return c.a(str, auVar, i, z);
    }

    public final int a(NotificationItem notificationItem) {
        return this.gAh.a(notificationItem, null);
    }

    public final void n(int i, String str) {
        ArrayList arrayList;
        x.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", new Object[]{Integer.valueOf(i), str});
        if (i == -1) {
            i = com.tencent.mm.k.f.zU();
        }
        c.fn(i);
        if (str == null || str.length() <= 0) {
            arrayList = new ArrayList();
            List zT = com.tencent.mm.k.f.zT();
            if (zT == null) {
                zT = new ArrayList();
            }
            for (String str2 : r0) {
                a aVar = new a((byte) 0);
                aVar.userName = str2;
                aVar.gzM = com.tencent.mm.k.f.eT(str2);
                arrayList.add(aVar);
            }
        } else {
            a aVar2;
            ArrayList xe = c.xe();
            arrayList = xe == null ? new ArrayList() : xe;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar2 = (a) it.next();
                if (aVar2.userName.equals(str)) {
                    arrayList.remove(aVar2);
                    break;
                }
            }
            aVar2 = null;
            if (aVar2 == null) {
                aVar2 = new a((byte) 0);
            }
            aVar2.userName = str;
            aVar2.gzM = com.tencent.mm.k.f.eT(str);
            if (aVar2.gzM == 0 && arrayList.isEmpty()) {
                c.d(null);
                return;
            } else if (aVar2.gzM > 0) {
                arrayList.add(aVar2);
            }
        }
        c.d(arrayList);
    }
}
