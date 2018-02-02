package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.h.e.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class e$b$1 implements a<int[]> {
    final /* synthetic */ b jpz;

    e$b$1(b bVar) {
        this.jpz = bVar;
    }

    public final /* synthetic */ void f(boolean z, Object obj) {
        int[] iArr = (int[]) obj;
        b.a(this.jpz).hide();
        if (!z) {
            this.jpz.f("cancel", null);
        } else if (iArr == null || iArr.length <= 0) {
            this.jpz.f("fail error result", null);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (int put : iArr) {
                jSONArray.put(put);
            }
            Map hashMap = new HashMap(1);
            hashMap.put("current", jSONArray);
            this.jpz.f("ok", hashMap);
        }
    }
}
