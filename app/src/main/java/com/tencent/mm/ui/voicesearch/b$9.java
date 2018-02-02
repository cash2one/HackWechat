package com.tencent.mm.ui.voicesearch;

import android.database.Cursor;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

class b$9 implements Runnable {
    final /* synthetic */ b zqE;

    b$9(b bVar) {
        this.zqE = bVar;
    }

    public final void run() {
        int i = 0;
        b bVar;
        if (b.g(this.zqE) != null && b.g(this.zqE).length != 0) {
            List arrayList = new ArrayList();
            String[] g = b.g(this.zqE);
            int length = g.length;
            while (i < length) {
                String str = g[i];
                if (this.zqE.aai(str)) {
                    arrayList.add(str);
                }
                i++;
            }
            if (arrayList.size() > 0) {
                b bVar2 = this.zqE;
                ar.Hg();
                b.a(bVar2, c.EY().a((String[]) arrayList.toArray(new String[arrayList.size()]), b.h(this.zqE), b.a(this.zqE)));
                return;
            }
            bVar = this.zqE;
            ar.Hg();
            b.b(bVar, c.EY().aZs());
        } else if (b.i(this.zqE) == null) {
            bVar = this.zqE;
            ar.Hg();
            b.e(bVar, c.EY().aZs());
        } else if (b.h(this.zqE).equals("@all.chatroom.contact")) {
            Cursor a = ar.Hg().heA.a(b.i(this.zqE), "@micromsg.with.all.biz.qq.com", b.a(this.zqE), false);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            while (a.moveToNext()) {
                String string = a.getString(a.getColumnIndex("username"));
                if (string.endsWith("@chatroom")) {
                    arrayList3.add(string);
                } else {
                    arrayList2.add(string);
                }
            }
            if (!a.isClosed()) {
                a.close();
            }
            if (arrayList2.size() == 0 && arrayList3.size() == 0) {
                ar.Hg();
                a = c.EY().aZs();
            } else {
                a = ar.Hg().heA.a(b.i(this.zqE), arrayList2, null, arrayList3, b.a(this.zqE));
            }
            b.d(this.zqE, a);
        } else {
            b.c(this.zqE, ar.Hg().heA.a(b.i(this.zqE), b.h(this.zqE), b.a(this.zqE), true));
        }
    }
}
