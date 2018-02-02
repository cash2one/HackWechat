package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.p.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

final class i extends ArrayList<com.tencent.mm.plugin.appbrand.appusage.i> {
    private final ArrayList<com.tencent.mm.plugin.appbrand.appusage.i> jQO = new ArrayList(10);
    private final ArrayList<com.tencent.mm.plugin.appbrand.appusage.i> jQP = new ArrayList(200);

    public final /* synthetic */ Object clone() {
        return alC();
    }

    public final /* synthetic */ Object get(int i) {
        return lD(i);
    }

    public final /* synthetic */ Object remove(int i) {
        return lE(i);
    }

    i() {
    }

    static i c(ArrayList<com.tencent.mm.plugin.appbrand.appusage.i> arrayList, ArrayList<com.tencent.mm.plugin.appbrand.appusage.i> arrayList2) {
        i iVar = new i();
        e.e(iVar.jQO, arrayList);
        e.e(iVar.jQP, arrayList2);
        return iVar;
    }

    final synchronized ArrayList<com.tencent.mm.plugin.appbrand.appusage.i> alA() {
        return this.jQO;
    }

    final synchronized ArrayList<com.tencent.mm.plugin.appbrand.appusage.i> alB() {
        return this.jQP;
    }

    public final boolean addAll(Collection<? extends com.tencent.mm.plugin.appbrand.appusage.i> collection) {
        boolean z = false;
        if (i.class.isInstance(collection)) {
            synchronized (this) {
                i iVar = (i) collection;
                this.jQO.addAll(iVar.jQO);
                this.jQP.addAll(iVar.jQP);
                z = true;
            }
        } else {
            Assert.assertTrue("collection type mismatch!!", false);
        }
        return z;
    }

    public final synchronized i alC() {
        i iVar;
        iVar = new i();
        iVar.jQO.addAll(this.jQO);
        iVar.jQP.addAll(this.jQP);
        return iVar;
    }

    public final synchronized int size() {
        return this.jQO.size() + this.jQP.size();
    }

    private synchronized com.tencent.mm.plugin.appbrand.appusage.i lD(int i) {
        com.tencent.mm.plugin.appbrand.appusage.i iVar;
        if (i < this.jQO.size()) {
            iVar = (com.tencent.mm.plugin.appbrand.appusage.i) this.jQO.get(i);
        } else {
            iVar = (com.tencent.mm.plugin.appbrand.appusage.i) this.jQP.get(i - this.jQO.size());
        }
        return iVar;
    }

    public final synchronized com.tencent.mm.plugin.appbrand.appusage.i lE(int i) {
        com.tencent.mm.plugin.appbrand.appusage.i iVar;
        if (i < this.jQO.size()) {
            iVar = (com.tencent.mm.plugin.appbrand.appusage.i) this.jQO.remove(i);
        } else {
            iVar = (com.tencent.mm.plugin.appbrand.appusage.i) this.jQP.remove(i - this.jQO.size());
        }
        return iVar;
    }

    public final synchronized void clear() {
        this.jQO.clear();
        this.jQP.clear();
    }

    public final Iterator<com.tencent.mm.plugin.appbrand.appusage.i> iterator() {
        Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
        return new 1(this);
    }
}
