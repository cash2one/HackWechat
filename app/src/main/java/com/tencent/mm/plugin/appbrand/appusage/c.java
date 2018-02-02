package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class c {
    private static volatile c iIT;
    public final Set<b> iIU = new HashSet();
    public volatile ait iIV = null;
    public final Object mLock = new Object();

    static /* synthetic */ void a(c cVar, ait com_tencent_mm_protocal_c_ait) {
        if (g.Dh().Cy()) {
            cVar.iIV = com_tencent_mm_protocal_c_ait;
            LinkedList linkedList = null;
            synchronized (cVar.mLock) {
                if (cVar.iIU.size() != 0) {
                    linkedList = new LinkedList(cVar.iIU);
                }
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).aaK();
                }
            }
        }
    }

    public static c aaJ() {
        if (iIT == null) {
            synchronized (c.class) {
                if (iIT == null) {
                    iIT = new c();
                }
            }
        }
        return iIT;
    }

    public static void release() {
        synchronized (c.class) {
            iIT = null;
        }
    }

    public final void refresh() {
        this.iIV = null;
        a aVar = new a();
        aVar.hmi = 1841;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxagame";
        aVar.hmj = new ais();
        aVar.hmk = new ait();
        u.a(aVar.JZ(), new 1(this));
    }

    public static boolean enabled() {
        if (g.Dh().Cy()) {
            com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100328");
            if (fn.isValid()) {
                a jC = a.jC(bh.getInt((String) fn.chI().get("isOpenGameEntry"), 0));
                if (jC != null && jC == a.iIY) {
                    return true;
                }
            }
        }
        return false;
    }
}
