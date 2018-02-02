package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends l {
    public abstract void a(j jVar, JSONObject jSONObject, String str);

    protected abstract String agB();

    protected abstract String agC();

    public final String a(j jVar, JSONObject jSONObject) {
        String agB = agB();
        Map hashMap = new HashMap();
        hashMap.put(agC(), agB);
        jVar.irQ.iTB.post(new 1(this, jVar, jSONObject, agB));
        return e("ok", hashMap);
    }
}
