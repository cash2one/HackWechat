package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.u.b.b;
import com.tencent.mm.z.u;
import org.json.JSONObject;

public final class i extends a {
    public i() {
        super("openApp", 326);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        u.b Cb = aVar.Cb();
        b bVar = new b();
        bVar.id = Cb.getString("__page_view_id", "");
        bVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
        XIPCInvoker.a(Cb.getString("__process_name", ac.Br()), bVar, a.class, new 1(this, aVar2));
    }
}
