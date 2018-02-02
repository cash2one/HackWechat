package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

enum i {
    ;
    
    private static final a iWc = null;

    static {
        iWc = new a();
    }

    static void onCreate() {
        q.abY().a(iWc, c.Dm().oAt.getLooper());
    }

    static void onDestroy() {
        q.abY().j(iWc);
    }

    static List<com.tencent.mm.plugin.appbrand.appusage.i> adt() {
        List<com.tencent.mm.plugin.appbrand.appusage.i> linkedList = new LinkedList();
        if (f.Zm() != null) {
            Collection abb = f.Zm().abb();
            if (!bh.cA(abb)) {
                linkedList.addAll(abb);
            }
        }
        if (a.IT()) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((com.tencent.mm.plugin.appbrand.appusage.i) it.next()).Yz()) {
                    it.remove();
                }
            }
        }
        return linkedList;
    }

    static com.tencent.mm.plugin.appbrand.appusage.i rD(String str) {
        if (f.Zm() == null) {
            return null;
        }
        com.tencent.mm.plugin.appbrand.appusage.i qc = f.Zm().qc(str);
        if (qc == null) {
            return null;
        }
        if (qc.Yz() && a.IT()) {
            return null;
        }
        return qc;
    }

    static void d(j.a aVar) {
        if (f.Zm() != null) {
            f.Zm().c(aVar);
        }
    }

    static void e(j.a aVar) {
        if (f.Zm() != null) {
            f.Zm().j(aVar);
        }
    }
}
