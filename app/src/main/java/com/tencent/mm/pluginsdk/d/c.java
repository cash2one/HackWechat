package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class c<T extends b> extends com.tencent.mm.sdk.b.c<T> implements e {
    private static HashMap<b, c<? extends b>> hxK = new HashMap();
    private static HashMap<k, b> vcQ = new HashMap();
    private int vcP = 0;

    public abstract b a(int i, k kVar, T t);

    public abstract int axw();

    public abstract k b(T t);

    public final void a(int i, int i2, String str, k kVar) {
        if (axw() == kVar.getType()) {
            b bVar = (b) vcQ.remove(kVar);
            if (bVar != null) {
                b kaVar = new ka();
                kaVar.fBm.fBn = a(i2, kVar, bVar);
                kaVar.fBm.errType = i;
                kaVar.fBm.errCode = i2;
                kaVar.fBm.fnL = str;
                a.xef.m(kaVar);
            }
        }
    }

    public static void k(b bVar) {
        k kVar;
        for (Entry entry : vcQ.entrySet()) {
            if (entry.getValue() == bVar) {
                kVar = (k) entry.getKey();
                break;
            }
        }
        kVar = null;
        if (kVar != null) {
            g.CG().c(kVar);
            vcQ.remove(kVar);
        }
    }

    public final void bYj() {
        if (this.vcP == 0) {
            g.CG().a(axw(), (e) this);
        }
        this.vcP++;
    }

    public final void aUT() {
        if (this.vcP != 0) {
            this.vcP--;
            if (this.vcP == 0) {
                g.CG().b(axw(), (e) this);
            }
        }
    }

    public final void l(T t) {
        k b = b(t);
        g.CG().a(b, 0);
        vcQ.put(b, t);
    }
}
