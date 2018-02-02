package com.tencent.mm.plugin.setting.a;

import android.database.Cursor;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class a$1 implements Runnable {
    final /* synthetic */ a qgt;

    public a$1(a aVar) {
        this.qgt = aVar;
    }

    public final void run() {
        a aVar = this.qgt;
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        ar EY = ((h) g.h(h.class)).EY();
        String str = "@all.contact.without.chatroom";
        List arrayList = new ArrayList();
        arrayList.add("tmessage");
        arrayList.add("officialaccounts");
        arrayList.add("filehelper");
        arrayList.add("helper_entry");
        arrayList.add(q.FS());
        bc EY2 = ((h) g.h(h.class)).Fg().EY("@t.qq.com");
        if (EY2 != null) {
            arrayList.add(EY2.name);
        }
        arrayList.add("blogapp");
        Cursor a = EY.a(str, null, arrayList, null, false, false);
        if (a != null) {
            a.moveToFirst();
            while (!a.isAfterLast()) {
                af xVar = new x();
                xVar.b(a);
                linkedList.add(xVar.field_username);
                a.moveToNext();
            }
            a.close();
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UnfamiliarContactEngine", "[getQuery] cost:%sms list size:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(linkedList.size())});
        a.a(aVar, linkedList);
    }
}
