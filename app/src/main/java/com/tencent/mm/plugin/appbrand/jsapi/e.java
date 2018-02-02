package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public abstract class e extends b {
    public String jbZ;

    public final String e(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", getName() + ":" + str);
        if (map != null) {
            if (b.ceK() && map.containsKey("errMsg")) {
                Assert.assertTrue("api " + getName() + ": Cant put errMsg in res!!!", false);
            }
            hashMap.putAll(map);
        }
        c.m(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public final String a(j jVar, String str, Map<String, ? extends Object> map) {
        if (l.a(jVar, map, this)) {
            return e(str, map);
        }
        return e(this.jbZ, null);
    }

    public MMActivity a(j jVar) {
        n nVar = jVar.irP.iqC;
        if (nVar == null) {
            return null;
        }
        Context context = nVar.getContext();
        if (context instanceof MMActivity) {
            return (MMActivity) context;
        }
        return null;
    }

    public static p b(j jVar) {
        n nVar = jVar.irP.iqC;
        if (nVar == null || nVar.aiT() == null) {
            return null;
        }
        return nVar.aiT().aex();
    }
}
