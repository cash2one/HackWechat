package com.tencent.mm.modelgeo;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class c$3 implements Runnable {
    final /* synthetic */ c hyh;
    final /* synthetic */ a hyr;

    c$3(c cVar, a aVar) {
        this.hyh = cVar;
        this.hyr = aVar;
    }

    public final void run() {
        List<WeakReference> arrayList = new ArrayList();
        for (WeakReference weakReference : this.hyh.avD) {
            if (weakReference == null || weakReference.get() == null || ((a) weakReference.get()).equals(this.hyr)) {
                arrayList.add(weakReference);
            }
        }
        for (WeakReference weakReference2 : arrayList) {
            this.hyh.avD.remove(weakReference2);
        }
        x.i("MicroMsg.LocationGeo", "stop listeners size %d", new Object[]{Integer.valueOf(this.hyh.avD.size())});
        if (this.hyh.avD.size() == 0 && this.hyh.hxQ != null) {
            g.OT();
        }
    }
}
