package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.g.a.sl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.File;

class d$4 extends c<sl> {
    final /* synthetic */ d rWp;

    d$4(d dVar) {
        this.rWp = dVar;
        this.xen = sl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = ((sl) bVar).fKh.path;
        if (str != null) {
            String aJ = h.aJ(str, false);
            if (!bh.ov(aJ)) {
                d.bEb().iF(aJ);
            }
            d.bEb().nU(str);
            new File(str).delete();
        }
        return false;
    }
}
