package com.tencent.mm.u.c;

import com.tencent.mm.u.b.d;
import com.tencent.mm.u.d.a;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public final class f {
    public a gOH;
    public d gOS;
    public g gOV;

    public f(d dVar, g gVar, a aVar) {
        Assert.assertNotNull(dVar);
        Assert.assertNotNull(gVar);
        Assert.assertNotNull(aVar);
        this.gOS = dVar;
        this.gOV = gVar;
        this.gOH = aVar;
    }

    public static String Cc() {
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        return new JSONObject(hashMap).toString();
    }
}
