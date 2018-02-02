package com.tencent.mm.plugin.exdevice.f.b;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public final class a {
    SparseArray<WeakReference<e>> lPC;

    public final void a(e eVar) {
        Assert.assertTrue(eVar != null);
        if (this.lPC == null) {
            this.lPC = new SparseArray();
        }
        this.lPC.put(eVar.hashCode(), new WeakReference(eVar));
    }

    public final void b(e eVar) {
        Assert.assertTrue(eVar != null);
        if (this.lPC == null) {
            x.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
        } else {
            this.lPC.remove(eVar.hashCode());
        }
    }

    public final void a(String str, d dVar) {
        Assert.assertTrue(true);
        if (this.lPC == null) {
            x.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
            return;
        }
        for (int i = 0; i < this.lPC.size(); i++) {
            e eVar = (e) ((WeakReference) this.lPC.get(this.lPC.keyAt(i))).get();
            if (eVar != null) {
                eVar.b(str, dVar);
            }
        }
        x.d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
    }
}
