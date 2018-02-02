package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;

class g$1 extends z<String, n> {
    final /* synthetic */ g qTk;

    g$1(g gVar, int i) {
        this.qTk = gVar;
        super(i);
    }

    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        return (n) super.create((String) obj);
    }

    protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        String str = (String) obj;
        n nVar = (n) obj2;
        n nVar2 = (n) obj3;
        super.entryRemoved(z, str, nVar, nVar2);
        if (!(nVar == null || nVar.isRecycled() || nVar.equals(nVar2))) {
            nVar.EE();
        }
        int i = 0;
        if (nVar2 != null) {
            i = nVar2.getAllocationByteCount();
        }
        x.d("MicroMsg.LazyerImageLoader2", "evicted: " + z + " key: " + str + " result:" + i + " " + (nVar.bitmap.getRowBytes() * nVar.bitmap.getHeight()) + " " + nVar.bitmap.getWidth() + " " + nVar.bitmap.getHeight() + " oldValue " + (nVar == null ? "NULL" : nVar.EG()) + " newValue: " + (nVar2 == null ? "NULL" : nVar2.EG()));
    }

    protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
        String str = (String) obj;
        n nVar = (n) obj2;
        int allocationByteCount = nVar != null ? nVar.getAllocationByteCount() : 0;
        x.d("MicroMsg.LazyerImageLoader2", "key: %s, size: %s", new Object[]{str, Integer.valueOf(allocationByteCount)});
        if (allocationByteCount != 0 || (nVar != null && !nVar.isRecycled())) {
            return allocationByteCount;
        }
        x.i("MicroMsg.LazyerImageLoader2", "size of error  " + nVar);
        return 0;
    }

    public final void trimToSize(int i) {
        try {
            super.trimToSize(i);
        } catch (Exception e) {
            x.e("MicroMsg.LazyerImageLoader2", "trimToSize error: %s", new Object[]{e.getMessage()});
        }
    }
}
