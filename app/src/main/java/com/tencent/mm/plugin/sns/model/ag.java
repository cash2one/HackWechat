package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ag implements g {
    HashMap<String, k> qWU = new HashMap();

    static /* synthetic */ void a(ag agVar, int i) {
        if (agVar.qWU == null || agVar.qWU.size() == 0) {
            x.i("MicroMsg.SnsExtCache", "nothing need to pushto snsext");
            return;
        }
        Object obj;
        long dz;
        long currentTimeMillis = System.currentTimeMillis();
        if (ae.EV() != null) {
            obj = 1;
            dz = ae.EV().dz(Thread.currentThread().getId());
        } else {
            obj = null;
            dz = 0;
        }
        x.d("MicroMsg.SnsExtCache", "writeNums " + i + " " + dz);
        LinkedList linkedList = new LinkedList();
        for (String add : agVar.qWU.keySet()) {
            String add2;
            linkedList.add(add2);
            if (linkedList.size() >= i) {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            add2 = (String) it.next();
            if (agVar.qWU.containsKey(add2) && !ae.bve()) {
                ae.bvz().b((k) agVar.qWU.get(add2));
                agVar.qWU.remove(add2);
            }
        }
        if (obj != null) {
            ae.EV().fS(dz);
        }
        x.d("MicroMsg.SnsExtCache", "wirtes times : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final k Kk(String str) {
        return (k) this.qWU.get(str);
    }

    public final boolean bvM() {
        ae.bvf().post(new 1(this));
        return true;
    }

    public final boolean bvN() {
        ae.bvf().post(new 2(this));
        return true;
    }

    public final boolean a(k kVar) {
        if (kVar == null || bh.ov(kVar.field_userName)) {
            return false;
        }
        ae.bvf().post(new 3(this, kVar));
        return true;
    }
}
