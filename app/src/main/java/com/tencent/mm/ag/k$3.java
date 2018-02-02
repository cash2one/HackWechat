package com.tencent.mm.ag;

import android.net.Uri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.util.Iterator;
import java.util.LinkedList;

class k$3 implements Runnable {
    final /* synthetic */ au heR;
    final /* synthetic */ k hpT;
    final /* synthetic */ String hpU;

    k$3(k kVar, au auVar, String str) {
        this.hpT = kVar;
        this.heR = auVar;
        this.hpU = str;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        l vL = ((a) g.h(a.class)).vL(this.heR.field_content);
        if (vL == null || bh.cA(vL.hdX)) {
            k.a(this.hpU, 10, 0.0f, 0.0f, 0, null);
            return;
        }
        Iterator it = vL.hdX.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            String str = mVar.url;
            if (!bh.ov(str)) {
                Uri parse = Uri.parse(str);
                try {
                    String queryParameter = parse.getQueryParameter("mid");
                    str = parse.getQueryParameter("idx");
                    oc ocVar = new oc();
                    ocVar.vXb = bh.getLong(queryParameter, 0);
                    ocVar.qhM = bh.getInt(str, 0);
                    ocVar.fFm = mVar.hem;
                    ocVar.path = mVar.hej;
                    linkedList.add(ocVar);
                } catch (UnsupportedOperationException e) {
                    x.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[]{e.getMessage()});
                }
            }
        }
        k.a(this.hpU, 10, 0.0f, 0.0f, 0, linkedList);
    }
}
