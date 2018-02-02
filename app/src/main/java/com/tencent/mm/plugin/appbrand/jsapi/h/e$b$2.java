package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h.e.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.picker.d.b;
import java.util.HashMap;
import java.util.Map;

class e$b$2 implements b<int[]> {
    final /* synthetic */ e.b jpz;

    e$b$2(e.b bVar) {
        this.jpz = bVar;
    }

    public final /* synthetic */ void bd(Object obj) {
        int[] iArr = (int[]) obj;
        int i = iArr[0];
        int i2 = iArr[1];
        f aVar = new a((byte) 0);
        Map hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("column", Integer.valueOf(i));
        hashMap.put("current", Integer.valueOf(i2));
        aVar.v(hashMap);
        c cVar = this.jpz;
        if (cVar.mPageRef == null) {
            c cVar2 = null;
        } else {
            p pVar = (p) cVar.mPageRef.get();
        }
        if (cVar2 != null) {
            aVar.a(cVar2).f(new int[]{cVar2.hashCode()});
        }
    }
}
