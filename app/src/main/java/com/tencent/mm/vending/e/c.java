package com.tencent.mm.vending.e;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class c<_Target extends a> implements a, b<_Target> {
    private List<WeakReference<_Target>> zBV = new ArrayList();
    private boolean zBW = true;

    public final synchronized void keep(_Target _Target) {
        if (this.zBW) {
            this.zBV.add(new WeakReference(_Target));
        } else {
            Assert.assertNotNull(_Target);
            _Target.dead();
        }
    }

    public final synchronized void dead() {
        if (this.zBW) {
            for (WeakReference weakReference : this.zBV) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.dead();
                }
            }
            this.zBV.clear();
            this.zBW = false;
        }
    }
}
