package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class a$1 extends af {
    final /* synthetic */ a nCn;

    a$1(a aVar, Looper looper) {
        this.nCn = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        long currentTimeMillis = System.currentTimeMillis();
        d aTD = i.aTD();
        ArrayList<c> arrayList = (ArrayList) message.obj;
        if (arrayList != null && arrayList.size() > 0) {
            long dz = aTD.dz(Thread.currentThread().getId());
            x.i("MicroMsg.IPCallAddressStorage", "getContactIdMap start");
            Cursor a = aTD.gJP.a("IPCallAddressItem", new String[]{"contactId"}, null, null, null, null, null, 2);
            Map hashMap = new HashMap();
            if (a == null || !a.moveToFirst()) {
                if (a != null) {
                    a.close();
                }
                x.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                for (c cVar : arrayList) {
                    if (!hashMap.containsKey(cVar.field_contactId)) {
                        aTD.b(cVar);
                    }
                }
                aTD.dA(dz);
            } else {
                do {
                    String string = a.getString(0);
                    if (!hashMap.containsKey(string)) {
                        hashMap.put(string, Boolean.valueOf(true));
                    }
                } while (a.moveToNext());
                if (a != null) {
                    a.close();
                }
                x.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                for (c cVar2 : arrayList) {
                    if (!hashMap.containsKey(cVar2.field_contactId)) {
                        aTD.b(cVar2);
                    }
                }
                aTD.dA(dz);
            }
        }
        x.d("MicroMsg.IPCallAddressBookLoader", "batchInsert, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        a.a(this.nCn, System.currentTimeMillis());
        x.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, used: %dms", new Object[]{Long.valueOf(a.a(this.nCn) - a.b(this.nCn))});
        a.c(this.nCn);
        a.a(this.nCn, -1);
        a.d(this.nCn);
        Iterator it = this.nCn.nCl.iterator();
        while (it.hasNext()) {
            a$a com_tencent_mm_plugin_ipcall_a_a_a = (a$a) it.next();
            if (com_tencent_mm_plugin_ipcall_a_a_a != null) {
                com_tencent_mm_plugin_ipcall_a_a_a.ajQ();
            }
        }
        this.nCn.nCl.clear();
    }
}
