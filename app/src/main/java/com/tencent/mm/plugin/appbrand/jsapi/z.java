package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public class z extends l {
    public static int CTRL_INDEX = 71;
    public static String NAME = "getCurrentRoute";

    public final String a(p pVar) {
        Map hashMap = new HashMap();
        hashMap.put(TencentExtraKeys.LOCATION_KEY_ROUTE, pVar.getURL());
        x.d("MicroMsg.JsApiGetCurrentRoute", "getCurrentRoute : %s", new Object[]{e("ok", hashMap)});
        return e("ok", hashMap);
    }
}
