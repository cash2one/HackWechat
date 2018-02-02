package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.page.u.b;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class u$4 extends bc<Boolean> {
    final /* synthetic */ u jFr;

    u$4(u uVar, Boolean bool) {
        this.jFr = uVar;
        super(1000, bool);
    }

    protected final /* synthetic */ Object run() {
        return ajr();
    }

    private Boolean ajr() {
        try {
            u uVar = this.jFr;
            LinkedList linkedList = new LinkedList();
            for (b bVar : uVar.jFl) {
                linkedList.add(Integer.valueOf(bVar.id));
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                uVar.ll(((Integer) it.next()).intValue());
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandWebViewCustomViewContainer", "removeAll error " + e);
        }
        return Boolean.valueOf(false);
    }
}
