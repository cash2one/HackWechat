package com.tencent.mm.plugin.gif;

import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class b$1 implements b<String, WeakReference<a>> {
    final /* synthetic */ b nyB;

    b$1(b bVar) {
        this.nyB = bVar;
    }

    public final /* synthetic */ void m(Object obj, Object obj2) {
        WeakReference weakReference = (WeakReference) obj2;
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null && (aVar instanceof c)) {
                x.i("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "recycle bitmap:%s", new Object[]{aVar.toString()});
                aVar.recycle();
            }
        }
    }
}
